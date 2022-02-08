package com.example.weddingplanner.daoTests;

import com.example.weddingplanner.dao.ServiceJdbcDAO;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class ServiceJdbcTests {

    @Autowired
    ServiceJdbcDAO dao;

    boolean placesMatches(Place place1,Place place2){
        return place1.getID()==place2.getID() &&
                place1.getName().equals(place2.getName()) &&
                place1.getDescription().equals(place2.getDescription()) &&
                place1.getRate() == place2.getRate() &&
                place1.getOwnerID() == place2.getOwnerID() &&
                place1.getCost() == place2.getCost() &&
                place1.getLocation().equals(place2.getLocation());
    }

    boolean personsMatches(Person person1, Person person2){
        return person1.getID()==person2.getID() &&
                person1.getName().equals(person2.getName()) &&
                person1.getDescription().equals(person2.getDescription()) &&
                person1.getRate() == person2.getRate() &&
                person1.getOwnerID() == person2.getOwnerID() &&
                person1.getCost() == person2.getCost() &&
                person1.getJob().equals(person2.getJob());
    }

    @Test
    @DisplayName("listServiceTest")
    void listServiceTest(){
        BasicService [] arr = new BasicService[]{
                new Place("Wedding Hall A","This is the first wedding hall",(float)9.6,6,
                200000,"alexandria",2000),
                new Place("Wedding Hall B","This is the second wedding hall",(float) 8.4,7,
                        150000,"cairo",1500),
                new Place("Wedding Hall C","This is the third wedding hall",(float)7.9,
                        8,100000,"dahab",1000),
                new Person("Photographer A", "I'm photographer A",(float)8.5,6
                        ,8000,"photographer"),
                new Person("Photographer B", "I'm photographer B",(float)9.7,7,10000,
                        "photographer"),
                new Person("Photographer C", "I'm photographer C",(float) 9,8,9000,
                        "photographer")};
        for (int i = 0 ; i < 6 ; i++)
            arr[i].setID(i);
        List <BasicService> expectedList = Arrays.asList(arr);
        List <BasicService> actualList = dao.list();
        if (actualList.size()!=expectedList.size())
            Assertions.fail();
        Iterator<BasicService> actualServiceIterator = actualList.listIterator();
        Iterator<BasicService> expectedServiceIterator = expectedList.listIterator();
        while(actualServiceIterator.hasNext()){
            BasicService actualService = actualServiceIterator.next();
            if(actualService instanceof Place)
                Assertions.assertTrue(placesMatches((Place)actualService,(Place)expectedServiceIterator.next()));
            else
                Assertions.assertTrue(personsMatches((Person)actualService,(Person)expectedServiceIterator.next()));
        }
    }

    @Test
    @DisplayName("Creation and Deletion services Test")
    void createDeleteServiceTest(){
        // Creating new person
        Person newPerson = new Person("new person","I'm a new person",(float)5.6
                ,6,10000,"new job");
        Assertions.assertEquals(1,dao.create(newPerson));
        Assertions.assertEquals(1,dao.delete(newPerson.getID()));

        // Creating new place
        Place newPlace = new Place("new place","new place description",(float)5.6,
                6,100000,"new place",1500);
        Assertions.assertEquals(1,dao.create(newPlace));
        Assertions.assertEquals(1,dao.delete(newPlace.getID()));
    }

    @Test
    @DisplayName("getServiceTest")
    void getServiceTest(){
        // Right place
        Place actualPlace = (Place) dao.get(0);
        Place expectedPlace = new Place("Wedding Hall A","This is the first wedding hall"
                ,(float)9.6,6,200000,"alexandria",2000);
        expectedPlace.setID(0);
        Assertions.assertTrue(placesMatches(expectedPlace, actualPlace));
        // Right person
        Person actualPerson = (Person) dao.get(3);
        Person expectedPerson = new Person("Photographer A", "I'm photographer A",
                (float)8.5,6,8000,"photographer");
        expectedPerson.setID(3);
        Assertions.assertTrue(personsMatches(actualPerson, expectedPerson));
        // Wrong service ID
        BasicService service = dao.get(-1);
        Assertions.assertNull(service);
    }

    @Test
    @DisplayName("getAllPlacesTest")
    void getAllPlacesTest() {
        List<Place> places = dao.getAllPlaces();
        Place[] arr = new Place[]{
            new Place("Wedding Hall A","This is the first wedding hall",(float)9.6,6,
                    200000,"alexandria",2000),
            new Place("Wedding Hall B","This is the second wedding hall",(float) 8.4,7,
                    150000,"cairo",1500),
            new Place("Wedding Hall C","This is the third wedding hall",(float)7.9,8,
                    100000,"dahab",1000)
        };
        for (int i= 0 ; i < 3 ; i++)
            arr[i].setID(i);
        List<Place> expectedPlaces = Arrays.asList(arr);
        if (places.size()!=expectedPlaces.size())
                Assertions.fail();
        Iterator<Place> placeIterator1 = places.listIterator();
        Iterator<Place> placeIterator2 = expectedPlaces.listIterator();
        while(placeIterator1.hasNext())
            Assertions.assertTrue(placesMatches(placeIterator1.next(), placeIterator2.next()));
    }
    @Test
    @DisplayName("getAllPersonsTest")
    void getAllPersonsTest() {
        List<Person> persons = dao.getAllPersons();
        Person[] arr = new Person[]{
                new Person("Photographer A", "I'm photographer A",
                        (float)8.5,6,8000,"photographer"),
                new Person("Photographer B", "I'm photographer B",
                        (float)9.7,7,10000,"photographer"),
                new Person("Photographer C", "I'm photographer C",
                        (float) 9,8,9000,"photographer")
        };
        for (int i = 0 ; i < 3 ; i++)
            arr[i].setID(i+3);
        List<Person> expectedPersons = Arrays.asList(arr);
        if (persons.size()!=expectedPersons.size())
            Assertions.fail();
        Iterator<Person> personIterator1 = persons.listIterator();
        Iterator<Person> personIterator2 = expectedPersons.listIterator();
        while(personIterator1.hasNext())
            Assertions.assertTrue(personsMatches(personIterator1.next(), personIterator2.next()));
    }

    @Test
    @DisplayName("Dates operations test")
    void datesTest() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newDate1 = dateFormat.parse("2022-1-5");
        Date newDate2 = dateFormat.parse("2022-1-6");
        Date newDate3 = dateFormat.parse("2022-1-7");
        Assertions.assertEquals(1,dao.addBusyDate(0,newDate1));
        Assertions.assertEquals(1,dao.addBusyDate(0,newDate2));
        Assertions.assertEquals(1,dao.addBusyDate(0,newDate3));
        List<Date> expectedDates = Arrays.asList(newDate1,newDate2,newDate3);
        List<Date> actualDates = dao.getBusyDates(0);
        Assertions.assertEquals(expectedDates, actualDates);
        Assertions.assertEquals(1,dao.removeBusyDate(0,newDate1));
        Assertions.assertEquals(1,dao.removeBusyDate(0,newDate2));
        Assertions.assertEquals(1,dao.removeBusyDate(0,newDate3));
    }

    @Test
    @DisplayName("Location operations test")
    void locationsTest() {
        String Location1 = "alexandria";
        String Location2 = "cairo";
        String Location3 = "dahab";
        Assertions.assertEquals(1,dao.addLocationOfPerson(4,Location1));
        Assertions.assertEquals(1,dao.addLocationOfPerson(4,Location2));
        Assertions.assertEquals(1,dao.addLocationOfPerson(4,Location3));
        List<String> expectedLocations = Arrays.asList(Location1,Location2,Location3);
        List<String> actualLocations = dao.getLocationsOfPerson(4);
        Assertions.assertEquals(expectedLocations, actualLocations);
        Assertions.assertEquals(1,dao.removeLocationOfPerson(4,Location1));
        Assertions.assertEquals(1,dao.removeLocationOfPerson(4,Location2));
        Assertions.assertEquals(1,dao.removeLocationOfPerson(4,Location3));
    }

    @Test
    @DisplayName("Searching on services by name")
    void searchServiceByName(){
        dao.searchPersonByName("Photographer A");
        dao.searchPlaceByName("wedding hall c");
    }
    @Test
    @DisplayName("Pictures operations test")
    void picturesTest() {
        String picture1 = "picture 1";
        String picture2 = "picture 2";
        String picture3 = "picture 3";
        Assertions.assertEquals(1,dao.addPictureToService(5,picture1));
        Assertions.assertEquals(1,dao.addPictureToService(5,picture2));
        Assertions.assertEquals(1,dao.addPictureToService(5,picture3));
        List<String> expectedPictures = Arrays.asList(picture1,picture2,picture3);
        List<String> actualPictures = dao.getPicturesOfService(5);
        Assertions.assertEquals(expectedPictures, actualPictures);
        Assertions.assertEquals(1,dao.removePictureToService(5,picture1));
        Assertions.assertEquals(1,dao.removePictureToService(5,picture2));
        Assertions.assertEquals(1,dao.removePictureToService(5,picture3));
    }
}