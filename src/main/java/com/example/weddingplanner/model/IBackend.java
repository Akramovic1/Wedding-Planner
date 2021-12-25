package com.example.weddingplanner.model;

import com.example.weddingplanner.model.userComponent.User;

public interface IBackend {

    boolean checkValidAddress(String address);

    int logIn(String email, String password);

    String signUp(User user);//and any other information about the user taken in the signUp step
}
