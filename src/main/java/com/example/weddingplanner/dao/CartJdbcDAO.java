package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.CartItem;
import com.example.weddingplanner.model.serviceComponent.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CartDAO")
public class CartJdbcDAO implements CartDAO {

    private final JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(UserJdbcDAO.class);

    @Autowired
    public CartJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addCartItem(int userID, CartItem cartItem) {
        return 0;
    }

    @Override
    public int removeCartItem(int userID, CartItem cartItem) {
        return 0;
    }

    @Override
    public int clearCart(int userID) {
        return 0;
    }

    @Override
    public List<CartItem> listCart(int userID) {
        return null;
    }

    @Override
    public int confirmPurchase(int userID) {
        return 0;
    }

    @Override
    public List<Integer> listOrdersID(int userID) {
        return null;
    }

    @Override
    public Order getOrder(int orderID) {
        return null;
    }
}
