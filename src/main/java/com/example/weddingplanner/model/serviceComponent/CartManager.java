package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.ServiceDate;
import com.example.weddingplanner.model.viewComponent.Attribute;
import com.example.weddingplanner.model.viewComponent.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cartManagerSystem")
public class CartManager {
    private final ServiceDAO serviceDAO;
    private ServiceDate serviceDate;

    @Autowired
    public CartManager(ServiceDAO serviceDAO) {
        this.serviceDAO=serviceDAO;
        serviceDate=new ServiceDate();
    }

    public boolean addServiceToCart(int userID, int serviceID, Date dueDate){
        boolean state=false;
        List<Date>busy=serviceDAO.getBusyDates(serviceID);
        if (serviceDate.isDateFree(busy,dueDate)){
            //call the data base
            return state;
        }
        else
            return false;
    }
    public boolean deleteServiceFromCart(int userID,int serviceID){
        boolean state=false;
        //call the data base
        return state;
    }
    public cart loadCart(int userID){
        cart cart=null;
        //call the data base to get list of service id and list of dueDates
        //then call data base to git the BasicService s of these serves ids
        //make object cart contains all these information
        return cart;
    }
    public int pay(int userID){
        int orserID=0;
        //call the data base which will return the id of the placed order
        return orserID;
    }

}
