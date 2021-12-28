package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.userComponent.User;

public interface UserDAO extends DAO<User> {

    boolean checkEmailExists(String email);

    User getByEmailAndPassword(String email,String password);

    int getNewUserID();
}
