package com.example.weddingplanner.model.serviceComponent;

import com.example.weddingplanner.dao.ServiceDAO;

public class ServiceBuilder {
    private final BasicService service;

    public ServiceBuilder(Place service) {
        this.service = service;
    }
    public ServiceBuilder(Person service) {
        this.service = service;
    }
    private boolean notFilled(String s){
        return s == null || s.isBlank();
    }
    public String getService(ServiceDAO serviceDAO){
       if(notFilled(service.getName())||notFilled(service.getDescription())){
           return "Please Complete Empty fields";
       }
       if(service.getImgUrl().size()==0){
           return "You should provide at least one image";
       }
       if(service.getCost()<=0){
           return "Invalid cost value";
       }
       // Additional Rules for building a Person service
       if(service  instanceof Person){
           if(notFilled(((Person)service).getJob())){
               return "Please enter a job title";
           }
           else if(((Person) service).getLocation().size()==0){
               return "You should provide at least one location";
           }
           else {
               serviceDAO.create(service);
               for(String location : ((Person) service).getLocation()){
                    serviceDAO.addLocationOfPerson(service.getID(),location);
               }
               for(String imgURL : service.getImgUrl()){
                   serviceDAO.addLocationOfPerson(service.getID(),imgURL);
               }
               return "Service has sent to system administrators successfully";
           }
       }
       // Additional Rules for building a Place service
       else if(service instanceof Place){
            if(((Place) service).getCapacity()==0){
                return "Invalid Capacity";
            }
            else if(notFilled(((Place)service).getLocation())){
                return "You should provide location";
            }
            else {
               serviceDAO.create(service);
               return "Service has sent to system administrators successfully";
            }
       }
       else
           return "Unsupported service type";

    }
}
