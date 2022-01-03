package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.serviceComponent.BasicService;

import java.util.Date;
import java.util.List;

public interface ServiceDAO extends DAO<BasicService> {

    //Returns all places in the database
    List<Place> getAllPlaces();

    //Returns all persons in the database
    List<Person> getAllPersons();

    //Add new busy date for a specific service
    int addBusyDate(int serviceID, Date busyDate);

    //remove busy date for a specific service
    int removeBusyDate(int serviceID, Date busyDate);

    //Returns all the dates that a certain service is busy
    List<Date> getBusyDates(int serviceID);

    //Returns all the places that a service provider owns
    List<Place> getAllPlacesOfSP(int spID);

    //Returns all the persons who works for a service provider
    List<Person> getAllPersonsOfSP(int spID);

    //Add new location to a person
    int addLocationOfPerson(int personID,String location);

    //remove location from a person
    int removeLocationOfPerson(int personID,String location);

    //Returns all the locations of a person
    List<String> getLocationsOfPerson(int personID);

    //Add new picture to a service
    int addPictureToService(int serviceID,String url);

    //Remove picture from a service
    int removePictureToService(int serviceID,String url);

    //Returns all the pictures of a person
    List<String> getPicturesOfService(int serviceID);

    //Performs certain SQL on specific table
    List<Person> performPersonSQL(String sql);
    List<Place>performPlaceSQL(String sql);
}
