package com.example.weddingplanner.model.viewComponent;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.facade.UserFacade;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component("PagingSystem")
public class Page {
    // system Assumes each page have 10 services
    private static ArrayList<Person>allPersonServices=new ArrayList<>();
    private static ArrayList<Place>allPlaceServices=new ArrayList<>();
    private static Filter pageFilter = null;
    @Autowired
    public Page(ServiceDAO serviceDAO) {
        pageFilter=new Filter(serviceDAO);
    }



    public  void setPersonPage(ArrayList<Attribute>attributes){
        allPersonServices=pageFilter.makePersonFilter(attributes);
    }
    public  void setPlacePage(ArrayList<Attribute>attributes){
        allPlaceServices=pageFilter.makePlacesFilter(attributes);
    }
    public  ArrayList<Person> getPersonPage(int pageNumber){
      int start=(pageNumber-1)*10;
      int end=(pageNumber)*10;
      ArrayList<Person>page=end<allPlaceServices.size()?new ArrayList<>(allPersonServices.size()):new ArrayList<>(end);
      for(int i=0;i<Math.min(allPersonServices.size(),end);i++){
          page.add(allPersonServices.get(start+i));
      }
      return page;
    }
    public  ArrayList<Place> getPlacePage(int pageNumber){
        int start=(pageNumber-1)*10;
        int end=(pageNumber)*10;
        ArrayList<Place>page=end<allPlaceServices.size()?new ArrayList<>(allPlaceServices.size()):new ArrayList<>(end);
        for(int i=0;i<Math.min(allPlaceServices.size(),end);i++){
            page.add(allPlaceServices.get(start+i));
        }
        return page;
    }

}

