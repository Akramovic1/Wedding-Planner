package com.example.weddingplanner.model.serviceComponent;

import java.util.ArrayList;
import java.util.List;

public class Person extends Service{
    private String job;

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }

    private List<String>location=new ArrayList<>();
    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
