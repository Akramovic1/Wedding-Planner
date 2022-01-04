package com.example.weddingplanner.viewComponentTests;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.viewComponent.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class PageTests {
    @Autowired
    Page p;
    @Test
    @DisplayName("Page tests")
    void getPersonPage() {
        p.setPersonPage(null);
        ArrayList<Person>person=p.getPersonPage(1);
        System.out.println(person.size());
    }
    @Test
    @DisplayName("Page tests")
    void getPlacePage() {
        p.setPlacePage(null);
        ArrayList<Place>places=p.getPlacePage(3);
        System.out.println(places.size());
    }

}
