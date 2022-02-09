package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.List;

public class Person extends BasicService {
    private String job;
    private List<String>location=new ArrayList<>();

    public Person(String name, String description,
                  float rate, int ownerID, int cost, List<String> imgUrl, String job, List<String> location) {
        super(name, description, rate, ownerID, cost, imgUrl);
        this.job = job;
        this.location = location;
    }

    public Person(String name, String description, float rate, int ownerID, int cost, String job) {
        super(name, description, rate, ownerID, cost);
        this.job = job;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
