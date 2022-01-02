package com.example.weddingplanner.services;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.facade.ServiceProviderFacade;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//@Service("providerService")
public class ServiceProviderServices {
    private final ServiceDAO serviceDAO;
    private ServiceProviderFacade serviceFacade;
    //@Autowired
    public ServiceProviderServices(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
        serviceFacade=new ServiceProviderFacade(serviceDAO);
    }

    public String createService(BasicService service) {
        return this.serviceFacade.createService(service);
    }


}


