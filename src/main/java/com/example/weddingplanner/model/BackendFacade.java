package com.example.weddingplanner.model;

import com.example.weddingplanner.dao.DAO;
import com.example.weddingplanner.dao.UserJdbcDAO;
import com.example.weddingplanner.model.userComponent.*;

//treats with the database and the userRecord
public class BackendFacade implements IBackend{

    private DAO dao;

    public BackendFacade(DAO<User> dao){
        this.dao= (DAO) dao;
    }

    @Override
    public boolean checkValidAddress(String email) {
        return dao.checkEmailExists(email);
    }
    @Override
    public int logIn(String email, String password) {
        User user = dao.getByEmailAndPassword(email,password);
        if(user==null)
            return -1;
        return user.getID();
    }

    @Override
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
            return null;
        }
        return builder.getUser(dao);
    }


}
