package com.example.weddingplanner.controller;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.userComponent.Customer;
import com.example.weddingplanner.model.userComponent.Administrator;
import com.example.weddingplanner.model.userComponent.ServiceProvider;
import com.example.weddingplanner.model.viewComponent.Attribute;
import com.example.weddingplanner.model.viewComponent.Page;
import com.example.weddingplanner.services.ServiceProviderServices;
import com.example.weddingplanner.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api")
@RestController
public class Controller {

    private final UserServices userServices;
    private final ServiceProviderServices serviceProviderServices;
    private final Page pagingSystem;
    @Autowired
    public Controller(UserServices userServices, ServiceProviderServices serviceProviderServices, Page pagingSystem) {
        this.userServices = userServices;
        this.serviceProviderServices = serviceProviderServices;
        this.pagingSystem = pagingSystem;
    }

    @PostMapping("/signUpCustomer")
    public String signUpCustomer(@RequestBody Customer user) {
        return this.userServices.signUp(user);
    }

    @PostMapping("/signUpProvider")
    public String signUpProvider(@RequestBody ServiceProvider user) {
        return this.userServices.signUp(user);
    }

    @PostMapping("/signUpAdmin")
    public String signUpAdmin(@RequestBody Administrator user) {
        return this.userServices.signUp(user);
    }

    @GetMapping("/login")
    public int login(@RequestParam(value = "email")String email,
                     @RequestParam(value = "password")String password){
        return this.userServices.logIn(email,password);
    }

    @PostMapping("/setPersonPage")
    public void setPersonPage(@RequestBody ArrayList<Attribute>attributes) {
        pagingSystem.setPersonPage(attributes);
    }

    @PostMapping("/setPlacePage")
    public void setPlacePage(@RequestBody ArrayList<Attribute>attributes) {
        pagingSystem.setPlacePage(attributes);
    }

    @GetMapping("/getPlacePage")
    public ArrayList<Place> getPlacePage(@RequestParam(value = "pageNumber")int n)
    {
        return  pagingSystem.getPlacePage(n);
    }
    @GetMapping("/getPersonPage")

    public ArrayList<Person> getPersonPage(@RequestParam(value = "pageNumber")int n)
    {
        return  pagingSystem.getPersonPage(n);
    }
    @GetMapping("/setPicturesOfService")
    public int setPicturesOfService(@RequestParam(value = "serviceID")int serviceID
                                    ,@RequestParam(value = "pageNumber")String path){
      return serviceProviderServices.setPicturesOfService(serviceID,path);
    }
    @GetMapping("/removePicturesOfService")
    public int removePicturesOfService(@RequestParam(value = "serviceID")int serviceID
                                      ,@RequestParam(value = "imgURL")String imgURL){
        return serviceProviderServices.removePicturesOfService(serviceID,imgURL);
    }
    @GetMapping("/getPicturesOfService")
    public ArrayList<String> getPicturesOfService(@RequestParam(value = "serviceID")int serviceID)
    {
        return (ArrayList<String>) serviceProviderServices.getPicturesOfService(serviceID);
    }
    @GetMapping("/freeComingThirtyDays")
    public ArrayList<Date> freeComingThirtyDays(@RequestParam(value = "serviceID")int serviceID)
    {
        return (ArrayList<Date>) serviceProviderServices.freeComingThirtyDays(serviceID);
    }
    @GetMapping("/freeComingNDays")
    public ArrayList<Date> freeComingNDays(@RequestParam(value = "serviceID")int serviceID,
                                           @RequestParam(value = "n")int n)
    {
        return (ArrayList<Date>) serviceProviderServices.freeComingNDays(serviceID,n);
    }
    @GetMapping("/isFreeDate")
    public boolean freeComingNDays(@RequestParam(value = "serviceID")int serviceID,
                                   @RequestParam(value = "date")String date) throws ParseException {
        return serviceProviderServices.isFreeDate(serviceID,date);
    }
    @GetMapping("/searchPersonByName")
    public List<Person> searchPersonByName(@RequestParam(value = "name")String name){
        return serviceProviderServices.searchPersonByName(name);
    }
    @GetMapping("/searchPlaceByName")
    public List<Place> searchPlaceByName(@RequestParam(value = "name")String name){
        return serviceProviderServices.searchPlaceByName(name);
    }

}
