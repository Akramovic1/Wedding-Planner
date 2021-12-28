package com.example.weddingplanner.services;

import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.facade.UserFacade;
import com.example.weddingplanner.model.userComponent.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service("userService")
public class UserServices {

    private final UserDAO userDAO;
    private UserFacade backend;
    private final HashSet<Integer> activeUsers=new HashSet();

    @Autowired
    public UserServices(UserDAO userDAO) {
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

    private UserFacade getSingleton(){
        if(backend==null)
            backend = new UserFacade(userDAO);
        return backend;
    }
}
