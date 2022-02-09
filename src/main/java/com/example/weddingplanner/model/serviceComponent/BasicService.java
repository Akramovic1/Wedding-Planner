package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicService {
    private int ID;
    private String name;
    private  String description;
    private float rate;
    private int ownerID;
    private int cost;
    private List<String>imgUrl=new ArrayList<>();

    public BasicService(String name, String description, float rate, int ownerID, int cost, List<String> imgUrl) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.ownerID = ownerID;
        this.cost = cost;
        this.imgUrl = imgUrl;
    }

    public BasicService(String name, String description, float rate, int ownerID, int cost) {
        this.name = name;
        this.description = description;
        this.rate = rate;
        this.ownerID = ownerID;
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @Override
    public String toString() {
        return "BasicService{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rate=" + rate +
                ", ownerID=" + ownerID +
                ", cost=" + cost +
                '}';
    }
}
