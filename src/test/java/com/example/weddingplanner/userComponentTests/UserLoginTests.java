package com.example.weddingplanner.userComponentTests;

import com.example.weddingplanner.services.UserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserLoginTests {

    @Autowired
    UserServices service;

    @Test
    @DisplayName("Login with not existent user in database")
    void loginWitWrongMail(){
        Assertions.assertEquals(-1,service.logIn("wrongmail","valid"));
    }
    @Test
    @DisplayName("Login with wrong password")
    void loginWrongPassword(){
        Assertions.assertEquals(-1,service.logIn("amrmomtaz@gmail.com","notvalid"));
    }
    @Test
    @DisplayName("Valid Login")
    void ValidLogin(){
        Assertions.assertEquals(0,service.logIn("amrmomtaz@gmail.com","momtaz"));
    }

}