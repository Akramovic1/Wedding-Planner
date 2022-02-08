package com.example.weddingplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class WeddingPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeddingPlannerApplication.class, args);
        Random r = new Random();
    }

}
