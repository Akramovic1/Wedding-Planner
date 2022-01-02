package com.example.weddingplanner.model.viewComponent;

import com.example.weddingplanner.dao.ServiceDAO;
import com.example.weddingplanner.model.serviceComponent.BasicService;
import com.example.weddingplanner.model.serviceComponent.Person;
import com.example.weddingplanner.model.serviceComponent.Place;
import org.apache.catalina.loader.ParallelWebappClassLoader;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class Filter {
    static ServiceDAO dao;
    public Filter(ServiceDAO dao) {
        Filter.dao = dao;
    }
    public static String parseSQL(String tableName,ArrayList<Attribute>attributes){
        StringBuilder parseSQL=new StringBuilder("SELECT * FROM "+tableName);
        if(attributes!=null&&attributes.size()>0){
            parseSQL.append(" WHERE ");
            for(Attribute attribute :attributes){
                if(attribute.getColumnName().equals("cost")||attribute.getColumnName().equals("rate")){
                    parseSQL.append("("+attribute.getColumnName()+" between "+attribute.getVal().split(" ")[0]+" and "+attribute.getVal().split(" ")[1]+" )");
                    parseSQL.append(" and ");
                }
                else {
                parseSQL.append("("+attribute.getColumnName()+" = "+attribute.getVal()+")");
                parseSQL.append(" and ");}
            }
            parseSQL= new StringBuilder(parseSQL.substring(0, parseSQL.lastIndexOf("a")));
        }

        return String.valueOf(parseSQL);
    }
    public static ArrayList<Person>makePersonFilter(ArrayList<Attribute>attributes){
        String tableName="persons";
        String SQLCommand=parseSQL(tableName,attributes);
        return (ArrayList<Person>) dao.performPersonSQL(SQLCommand);
    }
    public static ArrayList<Place>makePlacesFilter(ArrayList<Attribute>attributes){
        String tableName="places";
        String SQLCommand=parseSQL(tableName,attributes);
        return (ArrayList<Place>) dao.performPlaceSQL(SQLCommand);
    }



    public static void main(String[] args) {
        ArrayList<Attribute>x=new ArrayList<>();
        Attribute a1=new Attribute("location","Alexandria");
        Attribute a2=new Attribute("cost","52 105");
        Attribute a3=new Attribute("rate","2.5 4");
        Attribute a4=new Attribute("job","photographer");
       // x.add(a1);x.add(a2);x.add(a3);x.add(a4);
        System.out.println(Filter.parseSQL("persons",x));

    }

}


