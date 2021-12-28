package com.example.weddingplanner.services;

import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.BackendFacade;
import com.example.weddingplanner.model.userComponent.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service("userService")
public class UserService {

    private final UserDAO userDAO;
    private BackendFacade backend;
    private HashSet<Integer> activeUsers=new HashSet();

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public String signUp(User user){
        backend = getSingleton();
        return backend.signUp(user);
    }

    public int logIn(String email, String password){
        backend = getSingleton();
        int userId=backend.logIn(email,password);
        if (userId!=-1){
            activeUsers.add(userId);
        }
        return userId;
    }

    private BackendFacade getSingleton(){
        if(backend==null)
            backend = new BackendFacade(userDAO);
        return backend;
    }
}
