package com.example.weddingplanner.model.facade;

import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.IPictures;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.IServiceDate;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.ServiceDate;
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
    public User returnUser(int userID){
        return dao.get(userID);
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
    public String updateUser(int userID,User user){
        UserBuilder builder = null;
        User oldUser=dao.get(userID);
        if(oldUser!=null){
            if(!oldUser.getType().equals(user.getType())){
                return "Type of user can't be changed";
            }
            if(user instanceof Administrator){
                if(!user.getType().equals("admin")){
                    return "Invalid user type";
                }
                builder=new UserBuilder((Administrator) user);
            }
            else if(user instanceof Customer){
                if(!user.getType().equals("customer")){
                    return "Invalid user type";
                }
                builder=new UserBuilder((Customer) user);
            }
            else if(user instanceof ServiceProvider){
                if(!user.getType().equals("sp")){
                    return "Invalid user type";
                }
                builder=new UserBuilder((ServiceProvider) user);
            }
            return builder.getUser(dao);
        }
        else {
            return "Invalid userID";
        }
    }


}
