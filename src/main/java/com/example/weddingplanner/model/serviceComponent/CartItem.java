package com.example.weddingplanner.model.serviceComponent;

import java.util.Date;

public class CartItem {

    int userID;
    int serviceID;
    Date dueDate;

    public CartItem(int userID, int serviceID, Date dueDate) {
        this.userID = userID;
        this.serviceID = serviceID;
        this.dueDate = dueDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "userID=" + userID +
                ", serviceID=" + serviceID +
                ", dueDate=" + dueDate +
                '}';
    }
}
