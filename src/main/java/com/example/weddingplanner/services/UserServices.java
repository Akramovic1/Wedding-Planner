package com.example.weddingplanner.services;

import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.facade.UserFacade;
import com.example.weddingplanner.model.userComponent.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service("UserService")
public class UserServices {

    private final UserFacade backend;
    private final HashSet<Integer> activeUsers=new HashSet();

    @Autowired
    public UserServices(UserDAO userDAO) {
        backend=new UserFacade(userDAO);
    }

    public String signUp(User user){
        return backend.signUp(user);
    }

    public int logIn(String email, String password){
        int userId=backend.logIn(email,password);
        if (userId!=-1){
            activeUsers.add(userId);
        }
        return userId;
    }
}
