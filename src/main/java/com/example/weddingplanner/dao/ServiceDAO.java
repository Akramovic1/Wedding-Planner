package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository("serviceDAO")
public interface ServiceDAO extends DAO<BasicService> {

    //Returns all places in the database
    List<Place> getAllPlaces();

    //Returns all persons in the database
    List<Person> getAllPersons();

    //Returns all the dates that a certain service is busy
    List<Date> getBusyDates(int serviceID);

    //Returns all the places that a service provider owns
    List<Place> getAllPlacesOfSP(int spID);

    //Returns all the persons who works for a service provider
    ArrayList<Person> getAllPersonsOfSP(int spID);

    //Returns all the locations of a person
    List<String> getLocationsOfPerson(int serviceID);

    //Returns all the pictures of a person
    List<String> getPicturesOfService(int serviceID);

    //Return all places with capacities in between left and right
    List<Place> getPlaceWithCapacity(int left,int right);

    //Return all places in location
    List<Place> getPlaceInLocation(String location);

    //Return all persons in location
    List<Person> getPersonsInLocation(String location);
    List<Person> getPersonsInLocation(String location,String job);

    //Return all places with cost in between left and right
    List<Place> getPlaceWithCost(int left,int right);

    //Return all persons with cost in between left and right
    List<Person> getPersonWithCost(int left,int right);
    List<Person> getPersonWithCost(int left,int right,String job);


    List<Person> performPersonSQL(String SQL);
    List<Place>performPlaceSQL(String SQl);
}
