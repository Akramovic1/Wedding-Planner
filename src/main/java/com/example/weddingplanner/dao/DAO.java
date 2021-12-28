package com.example.weddingplanner.dao;

import java.util.List;

public interface DAO <T>{

    List<T> list();

    void create(T t);

    T get(int id);

    void update(T t , int id);

    void delete(int id);

}
