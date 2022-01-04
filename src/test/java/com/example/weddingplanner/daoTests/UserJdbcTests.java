package com.example.weddingplanner.daoTests;

import com.example.weddingplanner.dao.UserJdbcDAO;
import com.example.weddingplanner.model.userComponent.Administrator;
import com.example.weddingplanner.model.userComponent.Customer;
import com.example.weddingplanner.model.userComponent.ServiceProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserJdbcTests {

    @Autowired
    UserJdbcDAO dao;

    @Test
    @DisplayName("Creation and deletion Test")
    void creationDeletionListingTest(){
        Customer newCustomer = new Customer("testemail1","password","customer","test","0");
        ServiceProvider newSp = new ServiceProvider("testemail2","password","sp","test","0");
        Administrator newAdmin = new Administrator("testemail3","password","admin","test","0");
        Assertions.assertEquals(1,dao.create(newCustomer));
        Assertions.assertEquals(1,dao.create(newSp));
        Assertions.assertEquals(1,dao.create(newAdmin));
        Assertions.assertEquals(1,dao.delete(newCustomer.getID()));
        Assertions.assertEquals(1,dao.delete(newSp.getID()));
        Assertions.assertEquals(1,dao.delete(newAdmin.getID()));
    }
}
