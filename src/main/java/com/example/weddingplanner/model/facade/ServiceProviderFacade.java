package com.example.weddingplanner.model.facade;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.ServiceBuilder;

public class ServiceProviderFacade {
    private final ServiceDAO dao;

    public ServiceProviderFacade(ServiceDAO dao){
        this.dao= dao;
    }
    public String createService(BasicService service){
        ServiceBuilder builder;
        if(service instanceof Person){
            builder=new ServiceBuilder((Person) service);
        }
        else if(service instanceof Place){
            builder=new ServiceBuilder((Place) service);
        }
        else {
            System.out.println("Unknown Service type");
            return null;
        }
        return builder.getService(dao);
    }

}
