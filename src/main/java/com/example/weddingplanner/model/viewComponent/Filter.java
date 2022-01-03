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
                if(attribute.getColumnName().equals("cost")||attribute.getColumnName().equals("rate")){
                    parseSQL.append("("+attribute.getColumnName()+" between "+attribute.getVal().split(",")[0]+" and "+attribute.getVal().split(",")[1]+" )");
                    parseSQL.append(" and ");
                }
                else if(attribute.getColumnName().equals("location")){
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
                        parseSQL.append(" ID IN (Select distinct ID FROM persons_location WHERE location in ( ");
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
                parseSQL.append("("+attribute.getColumnName()+" = \""+attribute.getVal()+"\")");
                parseSQL.append(" and ");}
            }
            parseSQL= new StringBuilder(parseSQL.substring(0, parseSQL.lastIndexOf("a")));
        }

        return String.valueOf(parseSQL);
    }
    public  ArrayList<Person>makePersonFilter(ArrayList<Attribute>attributes){
        String tableName="persons";
        String SQLCommand=parseSQL(tableName,attributes);
        System.out.println(SQLCommand);
        return (ArrayList<Person>) dao.performPersonSQL(SQLCommand);
    }
    public  ArrayList<Place>makePlacesFilter(ArrayList<Attribute>attributes){
        String tableName="places";
        String SQLCommand=parseSQL(tableName,attributes);
        return (ArrayList<Place>) dao.performPlaceSQL(SQLCommand);
    }



    public static void main(String[] args) {
        ArrayList<Attribute>x=new ArrayList<>();
        Attribute a1=new Attribute("location","Alexandria,cairo");
        Attribute a2=new Attribute("cost","52,105");
        Attribute a3=new Attribute("rate","2.5,4");
        //Attribute a4=new Attribute("job","photographer");
        x.add(a1);x.add(a2);x.add(a3);//x.add(a4);
        System.out.println(Filter.parseSQL("persons",x));

    }

}


