package com.example.weddingplanner.serviceCompenentTests;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.ServiceBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

public class ServiceCreationTests {
    @Test
    @DisplayName("Creat service with incomplete fields")
    void serviceWithIncompleteFields() {
        //Person service creation
        List<String>imgUrl=new ArrayList<>();
        List<String>locations=new ArrayList<>();
        imgUrl.add("Any url");
        locations.add("Cairo");
        //No name
        BasicService service=new Person("","Description fot this service", (float) 3.4,6,
                150,imgUrl,"job",locations);
        ServiceBuilder builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("Please Complete Empty fields",builder.getService(null));
        //No description
        service=new Person("name","", (float) 3.4,6
                ,150,imgUrl,"job",locations);
        builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("Please Complete Empty fields",builder.getService(null));
        //invalid cost
        service=new Person("name","Description fot this service", (float) 3.4,6
                ,-50,imgUrl,"job",locations);
        builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("Invalid cost value",builder.getService(null));

        //invalid cost
        service=new Person("name","Description fot this service", (float) 3.4,6,
                0,imgUrl,"job",locations);
        builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("Invalid cost value",builder.getService(null));

        // No job title
        service=new Person("name","Description fot this service", (float) 3.4,6,
                5,imgUrl,"",locations);
        builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("Please enter a job title",builder.getService(null));

        // No images
        imgUrl.clear();
        service=new Person("name","Description fot this service", (float) 3.4,6,
                150,imgUrl,"job",locations);
        builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("You should provide at least one image",builder.getService(null));
        //No locations
        imgUrl.add("URL");
        locations.clear();
        service=new Person("name","Description fot this service", (float) 3.4,6,
                150,imgUrl,"job",locations);
        builder=new ServiceBuilder((Person) service);
        Assertions.assertEquals("You should provide at least one location",builder.getService(null));
    }
}
