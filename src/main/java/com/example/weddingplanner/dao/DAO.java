package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.userComponent.User;
import java.util.List;

public interface DAO <T>{

    List<T> list();

    void create(T t);

    User get(int id);

    void update(T t , int id);

    void delete(int id);

    boolean checkEmailExists(String email);

    User getByEmailAndPassword(String email,String password);

    int getNewUserID();
}
