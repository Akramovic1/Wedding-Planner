package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.userComponent.Administrator;
import com.example.weddingplanner.model.userComponent.Customer;
import com.example.weddingplanner.model.userComponent.ServiceProvider;
import com.example.weddingplanner.model.userComponent.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDAO")
public class UserJdbcDAO implements UserDAO{

    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(UserJdbcDAO.class);

    @Autowired
    public UserJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userRowMapper = (rs,rowNum)-> {
        int ID = rs.getInt("id");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String type = rs.getString("type");
        String username = rs.getString("username");
        String phonenumber = rs.getString("phonenumber");
        switch (type) {
            case "admin":
                return new Administrator(ID, email, password, type, username,phonenumber);
            case "sp":
                return new ServiceProvider(ID, email, password, type, username,phonenumber);
            case "customer":
                return new Customer(ID, email, password, type, username,phonenumber);
            default:
                log.error("User type came from database is corrupted !");
                return null;
        }
    };

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM users;";
        return jdbcTemplate.query(sql,userRowMapper);
    }

    @Override
    public int create(User user) {
        int newID = DAO.getNewID("userIndex");
        user.setID(newID);
        String sql = "INSERT INTO users VALUES (?,?,?,?,?,?)";
        int insert = jdbcTemplate.update(sql,newID,user.getEmail(),
                user.getPassword(),user.getType(),user.getUsername(),user.getPhonenumber());
        if(insert == 1)
            log.info("New user added to DB: " + user);
        return insert;
    }

    @Override
    public User get(int id) {
        String sql = "SELECT * FROM users WHERE ID = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql,userRowMapper,id);
        }catch(DataAccessException dataAccessException) {
            log.error("User not found (id=" + id + ")");
        }
        return user;
    }

    @Override
    public int update(User user, int id) {
        String sql = "UPDATE users SET email = ? , password = ?" +
                " , type = ? , username = ? , phonenumber = ? WHERE id = ?";
        int update = jdbcTemplate.update(sql,user.getEmail(),user.getPassword(),
                user.getType(),user.getUsername(),user.getPhonenumber(),id);
        if(update==1)
            log.info("User updated successfully (id="+ id + ")");
        return update;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        int update = jdbcTemplate.update(sql,id);
        if(update==1)
            log.info("User deleted successfully (id="+ id + ")");
        return update;
    }

    @Override
    public boolean checkEmailExists(String email){
        String sql = "SELECT * FROM users WHERE email = ?";
        List<User> users = jdbcTemplate.query(sql,userRowMapper,email);
        return users.size() > 0;
    }

    @Override
    public User getByEmailAndPassword(String email,String password){
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        User user = null;
        try {
            user = jdbcTemplate.queryForObject(sql, userRowMapper,email,password);
        }catch(DataAccessException dataAccessException) {
            log.error("User not found (email=" +email+",password="+password+")");
        }
        return user;
    }
}
