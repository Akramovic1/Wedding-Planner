package com.example.weddingplanner.model.serviceComponent;

import java.util.List;

public class Place extends BasicService {
    String location;
    int capacity;

    public Place(String name, String description, float rate, int ownerID, int cost, List<String> imgUrl,
                 String location, int capacity) {
        super(name, description, rate, ownerID, cost, imgUrl);
        this.location = location;
        this.capacity = capacity;
    }

    public Place(String name, String description, float rate, int ownerID,
                 int cost, String location, int capacity) {
        super(name, description, rate, ownerID, cost);
        this.location = location;
        this.capacity = capacity;
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
