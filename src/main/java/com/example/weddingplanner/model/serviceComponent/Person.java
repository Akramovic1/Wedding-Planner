package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.List;

public class Person extends BasicService {
    private String job;
    private List<String>location=new ArrayList<>();
    public Person(int ID, String name, String description, float rate, int cost, List<String> imgUrl,String job,List<String>location) {
        super(ID, name, description, rate, cost, imgUrl);
        this.job=job;
        this.location=location;
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
