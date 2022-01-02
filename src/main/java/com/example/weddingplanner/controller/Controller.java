package com.example.weddingplanner.controller;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.userComponent.Customer;
import com.example.weddingplanner.model.userComponent.Administrator;
import com.example.weddingplanner.model.userComponent.ServiceProvider;
import com.example.weddingplanner.model.viewComponent.Attribute;
import com.example.weddingplanner.model.viewComponent.Page;
import com.example.weddingplanner.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("api")
@RestController
public class Controller {

    private final UserServices userServices;

    @Autowired
    public Controller(UserServices userServices) {
        this.userServices = userServices;
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
    @GetMapping("/setPersonPage")
    public void setPersonPage(@RequestParam(value = "attributes")ArrayList<Attribute>attributes)
    {
        Page.setPersonPage(attributes);
    }
    @GetMapping("/setPlacePage")
    public void setPlacePage(@RequestParam(value = "attributes")ArrayList<Attribute>attributes)
    {
        Page.setPlacePage(attributes);
    }
    @GetMapping("/getPlacePage")
    public ArrayList<Place> setPlacePage(@RequestParam(value = "pageNumber")int n)
    {
        return  Page.getPlacePage(n);
    }
    @GetMapping("/getPersonPage")
    public ArrayList<Person> setPersonPage(@RequestParam(value = "pageNumber")int n)
    {
        return  Page.getPersonPage(n);
    }




}
