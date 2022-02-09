package com.example.weddingplanner.userComponentTests;

import com.example.weddingplanner.dao.UserJdbcDAO;
import com.example.weddingplanner.model.userComponent.Administrator;
import com.example.weddingplanner.model.userComponent.Customer;
import com.example.weddingplanner.model.userComponent.User;
import com.example.weddingplanner.services.UserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserProfileUpdate {
    @Autowired
    UserServices service;
    @Autowired
    UserJdbcDAO dao;

    @Test
    @DisplayName("Update user with invalid email-address")
    void invalidEmailAddress(){
        service.logIn("moemenibrahim@gmail.com","moemen");
         User newUser=new Administrator("kkffe@koepw","1234568","admin","moemen","012121212");
         newUser.setID(2);
         Assertions.assertEquals("Invalid email-address",service.updateUser(newUser));
    }
    @Test
    @DisplayName("Update user with invalid password")
    void invalidPassword(){
        service.logIn("moemenibrahim@gmail.com","moemen");
        User newUser=new Administrator("radwan@gmail.com","12348","admin","moemen","012121212");
        newUser.setID(2);
        Assertions.assertEquals("Password should have at least 8 characters",service.updateUser(newUser));
    }
    @Test
    @DisplayName("Update user with Already existent email-address")
    void invalidExistentEmail(){
        service.logIn("moemenibrahim@gmail.com","moemen");
        User newUser=new Administrator("mostafaahmed@gmail.com","12345678","admin","moemen","012121212");
        newUser.setID(2);
        Assertions.assertEquals("There's another account with tha same email",service.updateUser(newUser));
    }
    @Test
    @DisplayName("valid update")
    void validUpdate(){
        service.logIn("moemenibrahim@gmail.com","12345678");
        User newUser=new Administrator("moemenibrahim@gmail.com","12345678","admin","moemen","012121212");
        newUser.setID(2);
        Assertions.assertEquals("user Updated successfully",service.updateUser(newUser));
    }
}
