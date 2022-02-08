package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.CartItem;
import com.example.weddingplanner.model.serviceComponent.Order;

import java.util.List;

public interface CartDAO{

    // Adds item to user cart
    int addCartItem(int userID, CartItem cartItem);

    // Remove item from user cart
    int removeCartItem(int userID,CartItem cartItem);

    // Remove all cart items
    int clearCart(int userID);

    // Returns list of user cart items
    List<CartItem> listCart(int userID);

    // Confirm user purchase
    int confirmPurchase(int userID);

    // Get user orders
    List<Integer> listOrdersID(int userID);

    // Get order by order ID
    Order getOrder(int orderID);

}