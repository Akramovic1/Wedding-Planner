package com.example.weddingplanner.model.facade;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.ServiceBuilder;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.IPictures;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.IServiceDate;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.Pictures;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.ServiceDate;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public int setPicturesOfService(int serviceID,String path){
        IPictures pictures=new Pictures();
        String imgURL=pictures.urlOfPicture(new File(path));
       return dao.addPictureToService(serviceID,imgURL);
    }
    public int removePicturesOfService(int serviceID,String imgURL){
        IPictures pictures=new Pictures();
        pictures.deletePicture(imgURL);
        return dao.removePictureToService(serviceID,imgURL);
    }
    public List<String> getPicturesOfService(int serviceID){
        IPictures pictures=new Pictures();
        return  dao.getPicturesOfService(serviceID);
    }
    public List<Date> freeComingThirtyDays(int serviceID){
        IServiceDate serviceDate=new ServiceDate();
        ArrayList<Date>busyDates= (ArrayList<Date>) dao.getBusyDates(serviceID);
        return serviceDate.freeComingThirtyDays(busyDates);
    }
    public List<Date>freeComingNDays(int serviceID,int n){
        IServiceDate serviceDate=new ServiceDate();
        ArrayList<Date>busyDates= (ArrayList<Date>) dao.getBusyDates(serviceID);
        return  serviceDate.comingFreeNDays(busyDates,n);
    }
    public boolean isDateFree(int serviceID,Date date){
        IServiceDate serviceDate=new ServiceDate();
        ArrayList<Date>busyDates= (ArrayList<Date>) dao.getBusyDates(serviceID);
        return serviceDate.isDateFree(busyDates,date);
    }
    public List<Person> searchPersonByName(String name){
        ArrayList<Person>searched= (ArrayList<Person>) dao.searchPersonByName(name);
        for(Person p :searched){
            p.setImgUrl(dao.getPicturesOfService(p.getID()));
            p.setLocation(dao.getLocationsOfPerson(p.getID()));
        }
        return searched;
    }
    public List<Place> searchPlaceByName(String name){
        ArrayList<Place>searched= (ArrayList<Place>) dao.searchPlaceByName(name);
        for(Place p :searched){
            p.setImgUrl(dao.getPicturesOfService(p.getID()));
        }
        return searched;
    }

}
