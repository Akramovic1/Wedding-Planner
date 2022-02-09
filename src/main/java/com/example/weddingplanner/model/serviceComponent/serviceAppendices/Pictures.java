package com.example.weddingplanner.model.serviceComponent.serviceAppendices;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pictures implements IPictures {
    private String cloud_name = "wedding-planner";
    private String api_key= "564556916291473";
    private String api_secret= "WsafMT2fFgx1KOvBL-AEdcATFXM";
    private boolean secure=true;
    public String getCloud_name() {
        return this.cloud_name;
    }

    public String getApi_key() {
        return this.api_key;
    }

    public String getApi_secret() {
        return this.api_secret;
    }

    public boolean isSecure() {
        return this.secure;
    }


    private Cloudinary cloudinary;
    public Cloudinary getCloudinary(){
        return this.cloudinary;
    }

    public Pictures(String cloud_name,String api_key,String api_secret,boolean secure){
        if (!(cloud_name==null||api_key==null||api_secret==null||secure==false)){
            this.cloud_name = cloud_name;
            this.api_key= api_key;
            this.api_secret= api_secret;
            this.secure=secure;
        }
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloud_name,
                "api_key", api_key,
                "api_secret", api_secret,
                "secure", secure));
    }

    public Pictures(){
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloud_name,
                "api_key", api_key,
                "api_secret", api_secret,
                "secure", true));
    }
    private static boolean isImage(File file) {
        try {
            return ImageIO.read(file) != null;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public List<Map<String,Integer>> MapOfPicInFolder(String folderPath){
        if (folderPath==null){
            return null;
        }
        else {
            List<Map<String, Integer>> maps = new ArrayList<Map<String, Integer>>();
            File folder = new File(folderPath);
            File[] listOfFiles = folder.listFiles();
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", cloud_name,
                    "api_key", api_key,
                    "api_secret", api_secret,
                    "secure", secure));
            if (listOfFiles == null){
                return null;
            }
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile()) {
                    if (isImage(listOfFile)) {
                        System.out.println("Image File " + listOfFile.getName());
                        Map uploadResult = null;
                        try {
                            uploadResult = cloudinary.uploader().upload(listOfFile, ObjectUtils.emptyMap());
                            maps.add(uploadResult);
                        } catch (IOException e) {
                            //e.printStackTrace();
                            System.out.println("Error while uploading Picture " + listOfFile.getName());
                        }
                    }
                }
            }
            return maps;
        }
    }
    @Override
    public List<String> urlOfPicInFolder(String folderPath){
        if (folderPath==null){
            return null;
        }
        List<String> mapsURL = new ArrayList<String>();
        List<Map<String,Integer>> maps= MapOfPicInFolder(folderPath);
        if (maps==null){
            return null;
        }
        for (Map<String, Integer> map : maps) {
            mapsURL.add(String.valueOf(map.get("url")));
        }
        return mapsURL;
    }
    @Override
    public boolean deletePicture(String public_id){
        if (public_id==null){
            return true;
        }
        Map deleteParams = ObjectUtils.asMap("invalidate", true );
        try {
            cloudinary.uploader().destroy(public_id, deleteParams);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Error while deleting Picture");
            return false;
        }
        return true;
    }
    @Override
    public Map mapOfPicture(File picture){
        if (picture==null){
            return null;
        }
        if (picture.isFile()) {
            if (isImage(picture)) {
                System.out.println("Image File " + picture.getName());
                Map uploadResult = null;
                try {
                    uploadResult = cloudinary.uploader().upload(picture, ObjectUtils.emptyMap());
                    return uploadResult;
                } catch (IOException e) {
                    //e.printStackTrace();
                    System.out.println("Error while uploading Picture " + picture.getName());
                    return null;
                }
            }
            return null;
        }
        return null;
    }
    @Override
    public String urlOfPicture(File picture){
        Map map=mapOfPicture(picture);
        if (map!=null){
            return String.valueOf(map.get("url"));
        }
        else return null;
    }
    @Override
    public String urlOfPicturePath(String path){
        if (path==null){
            return null;
        }
        File picture = new File(path);
        return urlOfPicture(picture);
    }
}
