package com.example.weddingplanner.model.serviceComponent;

import java.util.List;

public class Place extends BasicService {
    String location;
    int capacity;

    public Place(int ID, String name, String description, float rate, int cost, List<String> imgUrl,String location,int capacity) {
        super(ID, name, description, rate, cost, imgUrl);
        this.location=location;
        this.capacity=capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
