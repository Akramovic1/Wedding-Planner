package com.example.weddingplanner.model.facade;

import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.userComponent.*;

//treats with the database and the userRecord
public class UserFacade{

    private final UserDAO dao;

    public UserFacade(UserDAO dao){
        this.dao= dao;
    }

    public boolean checkValidAddress(String email) {
        return dao.checkEmailExists(email);
    }

    public int logIn(String email, String password) {
        User user = dao.getByEmailAndPassword(email,password);
        if(user==null)
            return -1;
        return user.getID();
    }

    public String signUp(User user) {
        UserBuilder builder;
        if(user instanceof Administrator){
            builder=new UserBuilder((Administrator) user);
        }
        else if(user instanceof Customer){
            builder=new UserBuilder((Customer) user);
        }
        else if(user instanceof ServiceProvider){
            builder=new UserBuilder((ServiceProvider) user);
        }
        else {
            System.out.println("Unknown user type");
            return "Unknown user type";
        }
        return builder.getUser(dao);
    }


}
