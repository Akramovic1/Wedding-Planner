package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.List;

import com.example.weddingplanner.dao.CartDAO;
import com.example.weddingplanner.dao.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderManagerSystem")
public class OrderManager {
    private final ServiceDAO serviceDAO;
    private final CartDAO cartDAO;

    @Autowired
    public OrderManager(ServiceDAO serviceDAO, CartDAO cartDAO) {
        this.serviceDAO=serviceDAO;
        this.cartDAO=cartDAO;
    }

    public List<BasicService> getOrderServices(int orderID){
        Order order=cartDAO.getOrder(orderID);
        List<Integer> servicesID=order.getServicesID();
        List<BasicService> services=new ArrayList<>();
        for (int serviceID : servicesID) {
            BasicService service = serviceDAO.get(serviceID);
            service.setImgUrl(serviceDAO.getPicturesOfService(service.getID()));
            services.add(service);
        }
        return services;
    }

    public List<OrderDetailed> getUserOrders(int userID){
        List<Integer> ordersIDs=cartDAO.listOrdersID(userID);
        List<OrderDetailed> ordersDetailed=new ArrayList<>();
        for (int orderID : ordersIDs) {
            Order order=cartDAO.getOrder(orderID);
            List<BasicService> services=getOrderServices(orderID);
            ordersDetailed.add(new OrderDetailed(order.getID(),order.getUserID(),services,order.getDueDate(),order.getPaymentDate(),order.getPaymentMethod()));
        }
        return ordersDetailed;
    }
}
