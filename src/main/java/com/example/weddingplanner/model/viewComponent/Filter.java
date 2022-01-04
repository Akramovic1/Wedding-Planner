package com.example.weddingplanner.model.viewComponent;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.dao.ServiceJdbcDAO;
import com.example.weddingplanner.dao.UserDAO;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import org.apache.catalina.loader.ParallelWebappClassLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
public class Filter {
    private final ServiceDAO dao;

    public Filter(ServiceDAO dao){
        this.dao= dao;
    }
    public static String parseSQL(String tableName,ArrayList<Attribute>attributes){
        StringBuilder parseSQL=new StringBuilder("SELECT * FROM "+tableName);
        if(attributes!=null&&attributes.size()>0){
            parseSQL.append(" WHERE ");
            for(Attribute attribute :attributes){
                if(attribute.getColumnName().equals("cost")||attribute.getColumnName().equals("rate")||attribute.getColumnName().equals("capacity")){
                    if(!attribute.getVal().equals("0,")){
                    parseSQL.append("("+attribute.getColumnName()+" between "+attribute.getVal().split(",")[0]+" and "+attribute.getVal().split(",")[1]+" )");
                    parseSQL.append(" and ");
                }
                }
                else if(attribute.getColumnName().equals("location")&&(!attribute.getVal().equals(""))){
                    if(tableName.equals("places")){
                        parseSQL.append("( "+attribute.getColumnName()+" in "+" (");
                        String[] locations=attribute.getVal().split(",");
                        for(String location :locations){
                            parseSQL.append("\""+location+"\""+",");
                        }
                        if(parseSQL.charAt(parseSQL.length()-1)==','){
                            parseSQL= new StringBuilder(parseSQL.substring(0, parseSQL.length() - 1));
                        }
                        parseSQL.append("))");
                        parseSQL.append(" and ");
                    }
                    else if(tableName.equals("persons")){
                        parseSQL.append(" ID IN (Select distinct ID FROM person_locations WHERE location in ( ");
                        String[] locations=attribute.getVal().split(",");
                        for(String location :locations){
                            parseSQL.append("\""+location+"\""+",");
                        }
                        if(parseSQL.charAt(parseSQL.length()-1)==','){
                            parseSQL= new StringBuilder(parseSQL.substring(0, parseSQL.length() - 1));
                        }
                        parseSQL.append("))");
                        parseSQL.append(" and ");
                    }
                    else {
                        System.out.println("Invalid table name");
                    }
                }
                else {
                    if(!attribute.getVal().equals("")){
                parseSQL.append("("+attribute.getColumnName()+" = \""+attribute.getVal()+"\")");
                parseSQL.append(" and ");}
                }
            }
            if(parseSQL.lastIndexOf("a")!=-1){
            parseSQL= new StringBuilder(parseSQL.substring(0, parseSQL.lastIndexOf("a")));}
            else {parseSQL= new StringBuilder(parseSQL.substring(0, parseSQL.lastIndexOf("WHERE")));}
        }

        return String.valueOf(parseSQL);
    }

    public  ArrayList<Person>makePersonFilter(ArrayList<Attribute>attributes){
        String tableName="persons";
        String SQLCommand=parseSQL(tableName,attributes);
        System.out.println(SQLCommand);
        ArrayList<Person>filteredServices=(ArrayList<Person>) dao.performPersonSQL(SQLCommand);
        for(Person p:filteredServices){
            p.setLocation(dao.getLocationsOfPerson(p.getID()));
            p.setImgUrl(dao.getPicturesOfService(p.getID()));
        }
        return filteredServices;
    }
    public  ArrayList<Place>makePlacesFilter(ArrayList<Attribute>attributes){
        String tableName="places";
        String SQLCommand=parseSQL(tableName,attributes);
        System.out.println(SQLCommand);
        ArrayList<Place>filteredServices=(ArrayList<Place>) dao.performPlaceSQL(SQLCommand);
        for(Place p:filteredServices){
            p.setImgUrl(dao.getPicturesOfService(p.getID()));
        }
        return filteredServices;
    }



    public static void main(String[] args) {
        ArrayList<Attribute>x=new ArrayList<>();
        Attribute a1=new Attribute("location","alexandria,cairo");
        Attribute a2=new Attribute("cost","52,105");
        Attribute a3=new Attribute("rate","2.5,4");
        //Attribute a4=new Attribute("job","photographer");
        x.add(a1);x.add(a2);x.add(a3);//x.add(a4);
        System.out.println(Filter.parseSQL("persons",x));

        ArrayList<Attribute>x2=new ArrayList<>();
        Attribute a11=new Attribute("location","alexandria");
        Attribute a22=new Attribute("cost","52,105");
        Attribute a33=new Attribute("rate","2.5,4");
        Attribute a44=new Attribute("capacity","8,800");
        //Attribute a4=new Attribute("job","photographer");
        x2.add(a11);x2.add(a22);x2.add(a33);x2.add(a44);
        System.out.println(Filter.parseSQL("places",x2));

    }

}


