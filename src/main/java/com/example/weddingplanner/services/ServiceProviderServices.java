package com.example.weddingplanner.services;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.facade.ServiceProviderFacade;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.IPictures;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.IServiceDate;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.Pictures;
import com.example.weddingplanner.model.serviceComponent.serviceAppendices.ServiceDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("providerService")
public class ServiceProviderServices {
    private ServiceProviderFacade serviceFacade;
    @Autowired
    public ServiceProviderServices(ServiceDAO serviceDAO) {
        serviceFacade=new ServiceProviderFacade(serviceDAO);
    }
    public String createService(BasicService service) {
        return this.serviceFacade.createService(service);
    }

    public int setPicturesOfService(int serviceID,String path){
        return serviceFacade.setPicturesOfService(serviceID,path);
    }

    public int removePicturesOfService(int serviceID,String imgURL){
        return serviceFacade.removePicturesOfService(serviceID,imgURL);
    }
    public List<String> getPicturesOfService(int serviceID){
        return serviceFacade.getPicturesOfService(serviceID);
    }
    public List<Date> freeComingThirtyDays(int serviceID){
        return serviceFacade.freeComingThirtyDays(serviceID);
    }
    public List<Date>freeComingNDays(int serviceID,int n){
        return serviceFacade.freeComingNDays(serviceID,n);
    }
    public boolean isFreeDate(int serviceID,String date) throws ParseException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date parsedDate= formatter.parse(date);
            return serviceFacade.isDateFree(serviceID,parsedDate);
        }
       catch (Exception e){
           System.out.println("Not valid date format");
           return false;
       }
    }

}


