package com.example.weddingplanner.dao;

import com.example.weddingplanner.model.serviceComponent.CartItem;
import com.example.weddingplanner.model.serviceComponent.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public int addCartItem(CartItem cartItem) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String sql = "INSERT INTO cart VALUES (?,?,?)";
        int insert = jdbcTemplate.update(sql,cartItem.getUserID(),cartItem.getServiceID(),
                dateFormat.format(cartItem.getDueDate()));
        if(insert == 1)
            log.info("New item added to cart for user : " + cartItem.getUserID());
        return insert;
    }

    @Override
    public int removeCartItem(CartItem cartItem) {
        String sql = "DELETE FROM cart WHERE User_ID = ? AND Service_ID = ?";
        int delete = jdbcTemplate.update(sql,cartItem.getUserID(),cartItem.getServiceID());
        if(delete==1)
            log.info("Item deleted from cart successfully (user id="+ cartItem.getUserID() + ")");
        return delete;
    }

    @Override
    public int clearCart(int userID) {
        String sql = "DELETE FROM cart WHERE User_ID = ?";
        int delete = jdbcTemplate.update(sql,userID);
        if(delete==1)
            log.info("Cart cleared (user id="+ userID + ")");
        return delete;
    }

    @Override
    public List<CartItem> listCartItems(int userID) {
        String sql = "SELECT * FROM cart WHERE User_ID = ?";
        return jdbcTemplate.query(sql,((rs, rowNum) -> new CartItem(
                rs.getInt("User_ID"),
                rs.getInt("Service_ID"),
                rs.getDate("Due_Date")
        )),userID);
    }

    @Override
    public int confirmPurchase(int userID, Date paymentDate, String paymentMethod) {
        
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
