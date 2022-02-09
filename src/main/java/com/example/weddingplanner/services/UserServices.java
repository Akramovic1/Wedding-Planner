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
    private static final HashSet<Integer> activeUsers=new HashSet();
    private User activeUser=null;
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
            activeUser=backend.returnUser(userId);
        }
        return userId;
    }
    public User returnUser(){
        return activeUser;
    }
    public String updateUser(User user){
        if(user.getID()!=activeUser.getID()){
            return "Invalid UserID";
        }
        String result=backend.updateUser(user.getID(),user);
        activeUser=backend.returnUser(activeUser.getID());
        return result;
    }

}
