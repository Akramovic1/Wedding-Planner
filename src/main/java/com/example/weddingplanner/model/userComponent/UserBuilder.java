package com.example.weddingplanner.model.userComponent;

import com.example.weddingplanner.dao.UserDAO;

import java.util.regex.Pattern;

public class UserBuilder {

    private final User user;

    public UserBuilder(Administrator adminUser) {
        this.user =  adminUser;
        user.setType("admin");
    }

    public UserBuilder(Customer customerUser) {
        this.user = customerUser;
        user.setType("customer");
    }

    public UserBuilder(ServiceProvider serviceProviderUser) {
        this.user = serviceProviderUser;
        user.setType("sp");
    }
    private boolean notFilled(String s){
        return s == null || s.isBlank();
    }
    // Function to detect emails that don't match correct pattern
    private boolean correctEmailAddress(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{3}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    private boolean correctPassword(String password){
        return password.length()>=8;
    }
    public String getUser(UserDAO dao) {
        String email=user.getEmail();
        String password=user.getPassword();
        String username=user.getUsername();
        if(notFilled(email)||notFilled(username)||notFilled(password)){
            return "Please Complete Empty fields";
        }
        else if(!correctEmailAddress(email)){
            return "Not valid email-address";
        }
        else if(!correctPassword(password)){
            return "Password should have at least 8 characters";
        }
        else {
            if(dao.checkEmailExists(email)){
                return "There's another account with tha same email";}
            else {
                dao.create(user);
                return "Successfully created";
            }
        }
    }
}
