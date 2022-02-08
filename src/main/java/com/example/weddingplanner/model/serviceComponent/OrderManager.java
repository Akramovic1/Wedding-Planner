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

@Component("orderManagerSystem")
public class OrderManager {
    private final ServiceDAO serviceDAO;
    private ServiceDate serviceDate;

    @Autowired
    public OrderManager(ServiceDAO serviceDAO) {
        this.serviceDAO=serviceDAO;
        serviceDate=new ServiceDate();
    }

    /*public order getOrderServices(int orderID){
        order order=null;
        //call the data base
        return order;
    }*/

    public List<Integer> getUserOrders(int userID){
        List<Integer> ordersIDs=null;
        //call the data base
        return ordersIDs;
    }
}
