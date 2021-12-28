package com.example.weddingplanner.controller;

import com.example.weddingplanner.model.userComponent.Customer;
import com.example.weddingplanner.model.userComponent.Administrator;
import com.example.weddingplanner.model.userComponent.ServiceProvider;
import com.example.weddingplanner.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
