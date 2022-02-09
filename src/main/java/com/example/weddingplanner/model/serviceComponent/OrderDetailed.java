package com.example.weddingplanner.model.serviceComponent;

import java.util.Date;
import java.util.List;

public class OrderDetailed {
    int ID;
    int userID;
    List<BasicService> services;
    List<Date> dueDate;
    Date paymentDate;
    String paymentMethod;

    public OrderDetailed(int ID, int userID, List<BasicService> services, List<Date> dueDate,Date paymentDate, String paymentMethod) {
        this.ID = ID;
        this.userID = userID;
        this.services = services;
        this.dueDate=dueDate;
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

    public List<BasicService> getServices() {
        return services;
    }

    public void setServices(List<BasicService> services) {
        this.services = services;
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
}
