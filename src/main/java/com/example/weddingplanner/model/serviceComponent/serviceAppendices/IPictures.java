package com.example.weddingplanner.model.serviceComponent.serviceAppendices;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IPictures {
    /*
    construct the object with the values needed to create Cloudinary
     */
    /*
    construct the object with the default values needed to create Cloudinary
     */

    /*
    get list of maps which contain the url of the pictures in that folder
     */
    public List<Map<String, Integer>> MapOfPicInFolder(String folderPath);
    /*
    get list of url of the pictures in that folder
     */
    public List<String> urlOfPicInFolder(String folderPath);
    /*
    delete tha picture with that public_id
    return true if the picture is deleted
           false if not
     */
    public boolean deletePicture(String public_id);
    /*
    get the map which contain the url of that picture
     */
    public Map mapOfPicture(File picture);
    /*
    get the url of that picture
     */
    public String urlOfPicture(File picture);
    /*
    get the url of the picture with that path
     */
    public String urlOfPicturePath(String path);
}
