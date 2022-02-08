package com.example.weddingplanner.daoTests;

import com.example.weddingplanner.dao.CartDAO;
import com.example.weddingplanner.model.serviceComponent.CartItem;
import com.example.weddingplanner.model.serviceComponent.Order;
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

    @Test
    @DisplayName("Confirm Purchase test")
    void confirmPurchaseTest() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CartItem cartItem1 = new CartItem(9,1,dateFormat.parse("2020-2-2"));
        CartItem cartItem2 = new CartItem(9,2,dateFormat.parse("2020-2-2"));
        CartItem cartItem3 = new CartItem(9,3,dateFormat.parse("2020-2-2"));
        CartItem cartItem4 = new CartItem(9,4,dateFormat.parse("2020-2-2"));
        CartItem cartItem5 = new CartItem(10,1,dateFormat.parse("2020-2-2"));
        CartItem cartItem6 = new CartItem(11,1,dateFormat.parse("2020-2-2"));
        CartItem cartItem7 = new CartItem(11,3,dateFormat.parse("2020-2-2"));
        Assertions.assertEquals(1,dao.addCartItem(cartItem1));
        Assertions.assertEquals(1,dao.addCartItem(cartItem2));
        Assertions.assertEquals(1,dao.addCartItem(cartItem3));
        Assertions.assertEquals(1,dao.addCartItem(cartItem4));
        Assertions.assertEquals(1,dao.addCartItem(cartItem5));
        Assertions.assertEquals(1,dao.addCartItem(cartItem6));
        Assertions.assertEquals(1,dao.addCartItem(cartItem7));
        dao.confirmPurchase(9,dateFormat.parse("1999-5-10"),"cash");
    }

    @Test
    @DisplayName("Order tests")
    void ordersTest() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //Order 1
        CartItem cartItem1 = new CartItem(9,1,dateFormat.parse("2020-1-1"));
        CartItem cartItem2 = new CartItem(9,2,dateFormat.parse("2020-2-2"));
        Assertions.assertEquals(1,dao.addCartItem(cartItem1));
        Assertions.assertEquals(1,dao.addCartItem(cartItem2));
        int orderID1 = dao.confirmPurchase(9,dateFormat.parse("1999-5-10"),"cash");
        System.out.println(dao.getOrder(orderID1));

        //Order 2
        CartItem cartItem3 = new CartItem(9,3,dateFormat.parse("2020-3-3"));
        CartItem cartItem4 = new CartItem(9,4,dateFormat.parse("2020-4-4"));
        Assertions.assertEquals(1,dao.addCartItem(cartItem3));
        Assertions.assertEquals(1,dao.addCartItem(cartItem4));
        int orderID2 = dao.confirmPurchase(9,dateFormat.parse("1999-5-10"),"cash");
        System.out.println(dao.getOrder(orderID2));

        //Order 3
        CartItem cartItem5 = new CartItem(9,5,dateFormat.parse("2020-5-5"));
        CartItem cartItem6 = new CartItem(9,1,dateFormat.parse("2020-1-11"));
        CartItem cartItem7 = new CartItem(9,2,dateFormat.parse("2020-2-22"));
        Assertions.assertEquals(1,dao.addCartItem(cartItem5));
        Assertions.assertEquals(1,dao.addCartItem(cartItem6));
        Assertions.assertEquals(1,dao.addCartItem(cartItem7));
        int orderID3 = dao.confirmPurchase(9,dateFormat.parse("1999-5-10"),"cash");
        System.out.println(dao.getOrder(orderID3));

    }
}
