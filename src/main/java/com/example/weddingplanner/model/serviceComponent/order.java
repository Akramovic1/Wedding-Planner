package com.example.weddingplanner.model.serviceComponent;

import java.util.Date;
import java.util.List;

public class order {
    List<BasicService> services;
    List<Date> dueDates;
    int userID;
    int orderID;
    Date paymentDate;
    String paymentMethod;
}
