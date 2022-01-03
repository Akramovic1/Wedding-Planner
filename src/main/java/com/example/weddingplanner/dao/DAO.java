package com.example.weddingplanner.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface DAO <T>{

    List<T> list();

    int create(T t);

    T get(int id);

    int update(T t , int id);

    int delete(int id);

    static int getNewID(String path){
        int id = -1;
        try {
            Scanner sc = new Scanner(new File(path));
            id = sc.nextInt();
            sc.close();
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(Integer.toString(id + 1));
            fileWriter.close();
        } catch(FileNotFoundException fileNotFoundException){
            System.err.println("ERROR ! " + path + " is not found");
            System.exit(-1);
        } catch (IOException ioException) {
            System.err.println("ERROR ! " + path + " is corrupted");
            System.exit(-1);
        }
        return id;
    }
}
