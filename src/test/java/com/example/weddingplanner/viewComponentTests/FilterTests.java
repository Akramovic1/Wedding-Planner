package com.example.weddingplanner.viewComponentTests;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.viewComponent.Attribute;
import com.example.weddingplanner.model.viewComponent.Filter;
import com.example.weddingplanner.model.viewComponent.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
@SpringBootTest
public class FilterTests {
    /** Filter Person services Tests **/
    @Autowired
    ServiceDAO dao;
    @Test
    @DisplayName("Person Filters")
    void filterPersons() {
        Filter f=new Filter(dao);
        ArrayList<Attribute> allFilters=new ArrayList<>();
        Attribute a2=new Attribute("cost","52,9000");
        Attribute a3=new Attribute("rate","2.5,9");
        Attribute a4=new Attribute("job","photographer");
        allFilters.add(a2);allFilters.add(a3);allFilters.add(a4);
        ArrayList<Person>filteredServices= f.makePersonFilter(allFilters);
        for (Person p:filteredServices){
            Assertions.assertEquals(p.getJob(),"photographer");
            Assertions.assertTrue((p.getRate()>=2.5)&&(p.getRate()<=10));
            Assertions.assertTrue((p.getCost()>=52)&&(p.getRate()<=9000));
        }
    }
    /** Filter Place services Tests **/
    @Test
    @DisplayName("Place Filters")
    void filterPlaces() {
        Filter f=new Filter(dao);
        ArrayList<Attribute> allFilters=new ArrayList<>();
        Attribute a2=new Attribute("cost","5,900000");
        Attribute a3=new Attribute("rate","2.5,9");
        Attribute a4=new Attribute("location","cairo");
        allFilters.add(a2);allFilters.add(a3);allFilters.add(a4);
        ArrayList<Place>filteredServices= f.makePlacesFilter(allFilters);
        for (Place p:filteredServices){
            Assertions.assertEquals(p.getLocation(),"cairo");
            Assertions.assertTrue((p.getRate()>=2.5)&&(p.getRate()<=10));
            Assertions.assertTrue((p.getCost()>=2.5)&&(p.getCost()<=900000));
            System.out.println(p.getRate()+" "+p.getLocation());
        }
    }
}
