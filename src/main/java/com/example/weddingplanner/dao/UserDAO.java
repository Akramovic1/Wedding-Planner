package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.userComponent.ServiceProvider;
import com.example.weddingplanner.model.userComponent.User;

import java.util.List;

public interface UserDAO extends DAO<User> {

    boolean checkEmailExists(String email);

    User getByEmailAndPassword(String email,String password);

    List<ServiceProvider> getServiceProvidersByName(String name);
}
