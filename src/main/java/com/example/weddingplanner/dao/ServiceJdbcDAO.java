package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Repository("ServiceDAO")
public class ServiceJdbcDAO implements ServiceDAO{

    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(UserJdbcDAO.class);

    @Autowired
    public ServiceJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Place> placesRowMapper = (rs, rowNum)-> {
        int ID = rs.getInt("ID");
        String name = rs.getString("name");
        String description = rs.getString("description");
        float rate = rs.getFloat("rate");
        int owner_ID = rs.getInt("owner_ID");
        int cost = rs.getInt("cost");
        String location = rs.getString("location");
        int capacity = rs.getInt("capacity");
        Place place =  new Place(name,description,rate,owner_ID,cost,location,capacity);
        place.setID(ID);
        return place;
    };

    private final RowMapper<Person> personsRowMapper = (rs, rowNum)-> {
        int ID = rs.getInt("ID");
        String name = rs.getString("name");
        String description = rs.getString("description");
        float rate = rs.getFloat("rate");
        int ownerID = rs.getInt("owner_ID");
        int cost = rs.getInt("cost");
        String job = rs.getString("job");
        Person person = new Person(name,description,rate,ownerID,cost,job);
        person.setID(ID);
        return person;
    };

    private final RowMapper<BasicService> serviceRowMapper = (rs, rowNum)-> {
        if(rs.getString("type").equals("person"))
            return personsRowMapper.mapRow(rs,rowNum);
        else
             return placesRowMapper.mapRow(rs,rowNum);
    };

    @Override
    public List<BasicService> list() {
        String sqlPlaces = "SELECT * FROM places;";
        String sqlPersons = "SELECT * FROM persons;";
        List<Place>allPlaces = jdbcTemplate.query(sqlPlaces,placesRowMapper);
        List<Person> allPersons = jdbcTemplate.query(sqlPersons,personsRowMapper);
        List<BasicService> result = new LinkedList<>();
        result.addAll(allPlaces);
        result.addAll(allPersons);
        return result;
    }

    @Override
    public int create(BasicService basicService) {
        int newID = DAO.getNewID("serviceIndex");
        basicService.setID(newID);
        String sqlService = "INSERT INTO services VALUES (?,?)";
        int insert = jdbcTemplate.update(sqlService,newID,basicService instanceof Place ? "place" : "person");
        if(insert != 1)
            log.error("Error in creating service record in services table in the database !");
        if(basicService instanceof Place){
            String mainSQL = "INSERT INTO places VALUES (?,?,?,?,?,?,?,?,?)";
            insert = jdbcTemplate.update(mainSQL,newID,basicService.getName(),basicService.getDescription()
                     ,basicService.getRate(),basicService.getOwnerID(),basicService.getCost(),
                    ((Place) basicService).getLocation(),((Place) basicService).getCapacity(),"wedding hall");
        } else if (basicService instanceof Person){
            String mainSQL = "INSERT INTO persons VALUES (?,?,?,?,?,?,?)";
            insert = jdbcTemplate.update(mainSQL,newID,basicService.getName(),basicService.getDescription()
                    ,basicService.getRate(),basicService.getOwnerID(),basicService.getCost(),
                    ((Person) basicService).getJob());
        }
        if(insert == 1)
            log.info("New service {} has been added to the system",basicService);
        else
            log.error("Error in creating the service {} in the DB" , basicService);
        return insert;
    }

    @Override
    public BasicService get(int id) {
        String sql = "Call get_service(?);";
        BasicService service = null;
        try {
            service = jdbcTemplate.queryForObject(sql,serviceRowMapper,id);
        }catch(DataAccessException dataAccessException) {
            log.error("User not found (id=" + id + ")");
        }
        return service;
    }

    @Override
    public int update(BasicService basicService, int id) {
        return 0;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM services WHERE id = ?";
        int update = jdbcTemplate.update(sql,id);
        if(update==1)
            log.info("User deleted successfully (id="+ id + ")");
        return update;
    }

    @Override
    public List<Place> getAllPlaces() {
        String sql = "SELECT * FROM places;";
        return jdbcTemplate.query(sql,placesRowMapper);
    }

    @Override
    public List<Person> getAllPersons() {
        String sql = "SELECT * FROM persons;";
        return jdbcTemplate.query(sql,personsRowMapper);
    }

    @Override
    public int addBusyDate(int serviceID, Date busyDate) {
        String sql = "INSERT INTO busy VALUES (?,?)";
        return jdbcTemplate.update(sql,serviceID,busyDate);
    }

    @Override
    public int removeBusyDate(int serviceID, Date busyDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "DELETE FROM busy WHERE ID = ? AND date = ?";
        return jdbcTemplate.update(sql,serviceID,dateFormat.format(busyDate));
    }

    @Override
    public List<Date> getBusyDates(int serviceID) {
        String sql = "SELECT * FROM busy WHERE ID = ?";
        return jdbcTemplate.query(sql,(rs, rowNum)-> rs.getDate("date"),serviceID);
    }

    @Override
    public List<Place> getAllPlacesOfSP(int spID) {
        String sql = "SELECT * FROM places WHERE ID = ?;";
        return jdbcTemplate.query(sql,placesRowMapper,spID);
    }

    @Override
    public List<Person> getAllPersonsOfSP(int spID) {
        String sql = "SELECT * FROM persons WHERE ID = ?;";
        return jdbcTemplate.query(sql,personsRowMapper,spID);
    }

    @Override
    public int addLocationOfPerson(int personID, String location) {
        String sql = "INSERT INTO person_locations VALUES (?,?)";
        return jdbcTemplate.update(sql,personID,location);
    }

    @Override
    public int removeLocationOfPerson(int personID,String location) {
        String sql = "DELETE FROM person_locations WHERE ID = ? AND location = ?";
        return jdbcTemplate.update(sql,personID,location);
    }

    @Override
    public List<String> getLocationsOfPerson(int personID) {
        String sql = "SELECT * FROM person_locations WHERE ID = ?";
        return jdbcTemplate.query(sql,(rs, rowNum)-> rs.getString("location"),personID);
    }

    @Override
    public int addPictureToService(int serviceID, String url) {
        String sql = "INSERT INTO pictures VALUES (?,?)";
        return jdbcTemplate.update(sql,serviceID,url);
    }

    @Override
    public int removePictureToService(int serviceID, String url) {
        String sql = "DELETE FROM pictures WHERE ID = ? AND URL = ?";
        return jdbcTemplate.update(sql,serviceID,url);
    }

    @Override
    public List<String> getPicturesOfService(int serviceID) {
        String sql = "SELECT * FROM pictures WHERE ID = ?";
        return jdbcTemplate.query(sql,(rs, rowNum)-> rs.getString("URL"),serviceID);
    }

    @Override
    public List<Person> searchPersonByName(String name) {
        String sql = "SELECT * FROM persons WHERE name LIKE ?";
        return jdbcTemplate.query(sql,personsRowMapper,"%"+name+"%");
    }

    @Override
    public List<Place> searchPlaceByName(String name) {
        String sql = "SELECT * FROM places WHERE name LIKE ?";
        return jdbcTemplate.query(sql,placesRowMapper,"%"+name+"%");
    }

    @Override
    public List<Person> performPersonSQL(String sql) {
        return jdbcTemplate.query(sql,personsRowMapper);
    }

    @Override
    public List<Place> performPlaceSQL(String sql) {
        return jdbcTemplate.query(sql,placesRowMapper);
    }
}
