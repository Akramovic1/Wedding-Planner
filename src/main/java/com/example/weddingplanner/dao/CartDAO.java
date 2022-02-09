package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.CartItem;
import com.example.weddingplanner.model.serviceComponent.Order;

import java.util.Date;
import java.util.List;

public interface CartDAO{

    // Adds item to user cart returns insertion state
    int addCartItem(CartItem cartItem);

    // Remove item from user cart returns deletion state
    int removeCartItem(CartItem cartItem);

    // Remove all cart items returns deletion state
    int clearCart(int userID);

    // Returns list of user cart items
    List<CartItem> listCartItems(int userID);

    // Confirm user purchase Returns Order ID returns order ID
    int confirmPurchase(int userID, Date paymentDate,String paymentMethod);

    // Get user orders
    List<Integer> listOrdersID(int userID);

    // Get order by order ID
    Order getOrder(int orderID);

}