package com.example.weddingplanner.services;

import com.example.weddingplanner.dao.DAO;
import com.example.weddingplanner.model.BackendFacade;
import com.example.weddingplanner.model.userComponent.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service("userService")
public class UserService {

    @Autowired
    private DAO<User> userDAO;
    BackendFacade backend;
    private HashSet<Integer> activeUsers=new HashSet();


    public String signUp(User user){
        initializeBackend();
        return backend.signUp(user);
    }

    public int logIn(String email, String password){
        initializeBackend();
        int userId=backend.logIn(email,password);
        if (userId!=-1){
            activeUsers.add(userId);
        }
        return userId;
    }

    private void initializeBackend(){
        if(backend==null)
            backend = new BackendFacade(userDAO);
    }
}
