package com.example.weddingplanner.model.serviceComponent;

import java.util.Date;
import java.util.List;

public class cart {

    int userID;
    List<BasicService> services;
    List<Date> dueDate;

    public cart(int userID, List<BasicService> services, List<Date> dueDate) {
        this.userID = userID;
        this.services = services;
        this.dueDate = dueDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<BasicService> getServices() {
        return services;
    }

    public void setServices(List<BasicService> services) {
        this.services = services;
    }

    public List<Date> getDueDate() {
        return dueDate;
    }

    public void setDueDate(List<Date> dueDate) {
        this.dueDate = dueDate;
    }
}
