package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.weddingplanner.dao.CartDAO;
import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.ServiceDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("cartManagerSystem")
public class CartManager {
    private final ServiceDAO serviceDAO;
    private final CartDAO cartDAO;
    private final ServiceDate serviceDate;

    @Autowired
    public CartManager(ServiceDAO serviceDAO, CartDAO cartDAO) {
        this.serviceDAO=serviceDAO;
        this.cartDAO=cartDAO;
        this.serviceDate=new ServiceDate();
    }

    public boolean addServiceToCart(int userID, int serviceID, Date dueDate){
        boolean state=false;
        List<Date>busy=serviceDAO.getBusyDates(serviceID);
        if (serviceDate.isDateFree(busy,dueDate)){
            CartItem c =new CartItem(userID,serviceID,dueDate);
            int stateIndicator=cartDAO.addCartItem(c);
            if (stateIndicator==1)state=true;
            return state;
        }
        else
            return false;
    }
    //delete the service from the cart with all its due dates
    public boolean deleteServiceFromCart(int userID,int serviceID){
        boolean state=false;
        CartItem c =new CartItem(userID,serviceID,null);
        int stateIndicator=cartDAO.removeCartItem(c);
        if (stateIndicator==1)state=true;
        return state;
    }
    //delete the service from the cart with all its due dates
    public boolean deleteServiceFromCartInSpecificDue(int userID,int serviceID,Date dueDate){
        boolean state=false;
        CartItem c =new CartItem(userID,serviceID,dueDate);
        int stateIndicator=cartDAO.removeCartItem(c);
        if (stateIndicator==1)state=true;
        return state;
    }
    //delete all the services from the cart
    public boolean clearCart(int userID){
        boolean state=false;
        int stateIndicator=cartDAO.clearCart(userID);
        if (stateIndicator==1)state=true;
        return state;
    }
    public cart loadCart(int userID){
        //call the data base to get list of service id and list of dueDates
        //then call data base to git the BasicService s of these serves ids
        //make object cart contains all these information
        List<CartItem> cartItems=cartDAO.listCartItems(userID);
        List<BasicService> services=new ArrayList<>();
        List<Date> dueDate=new ArrayList<>();
        for (CartItem c : cartItems) {
            BasicService service = serviceDAO.get(c.serviceID);
            service.setImgUrl(serviceDAO.getPicturesOfService(service.getID()));
            services.add(service);
            dueDate.add(c.dueDate);
        }
        return new cart(userID,services,dueDate);
    }
    public int pay(int userID,String paymentMethod){
        cart c = loadCart(userID);
        List<BasicService> services=c.getServices();
        List<Date> dueDates=c.getDueDate();
        for (int i = 0; i < services.size(); i++) {
            BasicService service = services.get(i);
            Date dueDate = dueDates.get(i);
            serviceDAO.addBusyDate(service.getID(),dueDate);
        }
        //call the data base which will return the id of the placed order
        return cartDAO.confirmPurchase(userID,new Date(),paymentMethod);
    }

}
