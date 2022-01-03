package com.example.weddingplanner.userComponentTests;

import com.example.weddingplanner.dao.UserJdbcDAO;
import com.example.weddingplanner.model.userComponent.*;
import com.example.weddingplanner.services.UserServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSignUpTests {

    @Autowired
    UserServices service;
    @Autowired
    UserJdbcDAO dao;

    @Test
    @DisplayName("Signup with incomplete fields")
    void signUpWithinCompleteFields() {
        //No mail
        User user = new Customer(-1,null,"123456","Customer","Mohamed Radwan",null);
        Assertions.assertEquals("Please Complete Empty fields",service.signUp(user));
        // No password
        user=new Customer(-1,"radwan@yahoo.com",null,"Customer","Mohamed Radwan",null);
        Assertions.assertEquals("Please Complete Empty fields",service.signUp(user));
        // No username
        user=new Customer(-1,"radwan@yahoo.com","password","Customer",null,null);
        Assertions.assertEquals("Please Complete Empty fields",service.signUp(user));
    }

    @Test
    @DisplayName("Signup with existent user email in database")
    void signUpWithExistentEmail(){
        User user = new Customer(-1,"amrmomtaz@gmail.com","12345678","Customer","trojan",null);
        Assertions.assertEquals("There's another account with tha same email",service.signUp(user));
    }

    @Test
    @DisplayName("Not valid Password")
    void notValidPassword(){
        User user = new Customer(-10,"newtestsssss@gmail.com","1415","Customer","trojan",null);
        Assertions.assertEquals("Password should have at least 8 characters",service.signUp(user));
    }
    @Test
    @DisplayName("Not valid email-address")
    void notValidEmail(){
        User user = new Customer(-10,"@gmail.com","12345678","Customer","trojan",null);
        Assertions.assertEquals("Not valid email-address",service.signUp(user));

        user = new Customer(-10,"@gmacccil.com","12345678","Customer","trojan",null);
        Assertions.assertEquals("Not valid email-address",service.signUp(user));

        user = new Customer(-10,"ahmed@gmacccil.cccom","12345678","Customer","trojan",null);
        Assertions.assertEquals("Not valid email-address",service.signUp(user));
    }

    @Test
    @DisplayName("Valid sign up")
    void signUpSuccessfully() {
        User user = new Customer(-10, "Mohamed@gmail.com", "12345678", "Customer", "trojan", null);
        Assertions.assertEquals("Successfully created", service.signUp(user));
        dao.delete(user.getID());
    }

}
