package com.example.weddingplanner.daoTests;

import com.example.weddingplanner.dao.CartDAO;
import com.example.weddingplanner.model.serviceComponent.CartItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootTest
public class CartJdbcTests {

    @Autowired
    CartDAO dao;

    @Test
    @DisplayName("Cart add remove clear list test")
    void cartManipulationTest() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CartItem cartItem1 = new CartItem(9,1,dateFormat.parse("2020-2-2"));
        CartItem cartItem2 = new CartItem(9,2,dateFormat.parse("2020-2-2"));
        CartItem cartItem3 = new CartItem(9,3,dateFormat.parse("2020-2-2"));
        CartItem cartItem4 = new CartItem(9,4,dateFormat.parse("2020-2-2"));
        Assertions.assertEquals(1,dao.addCartItem(cartItem1));
        Assertions.assertEquals(1,dao.addCartItem(cartItem2));
        Assertions.assertEquals(1,dao.addCartItem(cartItem3));
        Assertions.assertEquals(1,dao.addCartItem(cartItem4));
        for (CartItem cartItem : dao.listCartItems(9))
            System.out.println(cartItem);
        Assertions.assertEquals(1,dao.removeCartItem(cartItem2));
        Assertions.assertEquals(3,dao.clearCart(9));
    }
}
