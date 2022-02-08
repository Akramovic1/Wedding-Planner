package com.example.weddingplanner.model.serviceComponent;

import java.util.Date;
import java.util.List;

public class Order {
    int ID;
    int userID;
    List<Integer> servicesID;
    Date paymentDate;
    String paymentMethod;
}
