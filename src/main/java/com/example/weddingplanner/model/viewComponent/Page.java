package com.example.weddingplanner.model.viewComponent;

import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;

import java.util.ArrayList;

public class Page {
    // system Assumes each page have 10 services
    private static ArrayList<Person>allPersonServices=new ArrayList<>();
    private static ArrayList<Place>allPlaceServices=new ArrayList<>();
    public static void setPersonPage(ArrayList<Attribute>attributes){
        allPersonServices=Filter.makePersonFilter(attributes);
    }
    public static void setPlacePage(ArrayList<Attribute>attributes){
        allPlaceServices=Filter.makePlacesFilter(attributes);
    }
    public static ArrayList<Person> getPersonPage(int pageNumber){
      int start=(pageNumber-1)*10;
      int end=(pageNumber)*10;
      ArrayList<Person>page=end<allPlaceServices.size()?new ArrayList<>(allPersonServices.size()):new ArrayList<>(end);
      for(int i=0;i<page.size();i++){
          page.add(allPersonServices.get(start+i));
      }
      return page;
    }
    public static ArrayList<Place> getPlacePage(int pageNumber){
        int start=(pageNumber-1)*10;
        int end=(pageNumber)*10;
        ArrayList<Place>page=end<allPlaceServices.size()?new ArrayList<>(allPlaceServices.size()):new ArrayList<>(end);
        for(int i=0;i<page.size();i++){
            page.add(allPlaceServices.get(start+i));
        }
        return page;
    }

}

