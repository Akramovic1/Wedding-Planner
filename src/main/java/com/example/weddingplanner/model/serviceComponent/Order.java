package com.example.weddingplanner.model.serviceComponent;

import java.util.Date;
import java.util.List;

public class Order {
    int ID;
    int userID;
    List<Integer> servicesID;
    List<Date> dueDate;
    Date paymentDate;
    String paymentMethod;

    public Order(int ID, int userID, Date paymentDate, String paymentMethod) {
        this.ID = ID;
        this.userID = userID;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public List<Integer> getServicesID() {
        return servicesID;
    }

    public void setServicesID(List<Integer> servicesID) {
        this.servicesID = servicesID;
    }

    public List<Date> getDueDate() { return dueDate; }

    public void setDueDate(List<Date> dueDate) {
        this.dueDate = dueDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ID=" + ID +
                ", userID=" + userID +
                ", servicesID=" + servicesID +
                ", dueDate=" + dueDate +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
