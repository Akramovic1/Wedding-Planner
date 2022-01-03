package com.example.weddingplanner.serviceCompenentTests;

import com.example.weddingplanner.model.serviceComponent.serviceAppendices.Pictures;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PicturesTest {
    /*
    test construction of the class Picture
     */
    @Test
    void picturesConstructorWithNoNull() {
        Pictures p=new Pictures("wedding-planner","564556916291473","WsafMT2fFgx1KOvBL-AEdcATFXM",true);
        assertEquals("wedding-planner",p.getCloud_name());
        assertEquals("564556916291473",p.getApi_key());
        assertEquals("WsafMT2fFgx1KOvBL-AEdcATFXM",p.getApi_secret());
        assertTrue(p.isSecure());
    }
    @Test
    void picturesConstructorWithNullCloud_name() {
        Pictures p=new Pictures(null,"564556916291473","WsafMT2fFgx1KOvBL-AEdcATFXM",true);
        assertEquals("wedding-planner",p.getCloud_name());
        assertEquals("564556916291473",p.getApi_key());
        assertEquals("WsafMT2fFgx1KOvBL-AEdcATFXM",p.getApi_secret());
        assertTrue(p.isSecure());
    }
    @Test
    void picturesConstructorWithNullApi_key() {
        Pictures p=new Pictures("wedding-planner",null,"WsafMT2fFgx1KOvBL-AEdcATFXM",true);
        assertEquals("wedding-planner",p.getCloud_name());
        assertEquals("564556916291473",p.getApi_key());
        assertEquals("WsafMT2fFgx1KOvBL-AEdcATFXM",p.getApi_secret());
        assertTrue(p.isSecure());
    }
    @Test
    void picturesConstructorWithNullApi_secret() {
        Pictures p=new Pictures("wedding-planner","564556916291473",null,true);
        assertEquals("wedding-planner",p.getCloud_name());
        assertEquals("564556916291473",p.getApi_key());
        assertEquals("WsafMT2fFgx1KOvBL-AEdcATFXM",p.getApi_secret());
        assertTrue(p.isSecure());
    }
    @Test
    void picturesConstructorWithNullSecure() {
        Pictures p=new Pictures("wedding-planner","564556916291473","WsafMT2fFgx1KOvBL-AEdcATFXM",false);
        assertEquals("wedding-planner",p.getCloud_name());
        assertEquals("564556916291473",p.getApi_key());
        assertEquals("WsafMT2fFgx1KOvBL-AEdcATFXM",p.getApi_secret());
        assertTrue(p.isSecure());
    }

    @Test
    void testPictures() {
        Pictures p=new Pictures();
        assertEquals("wedding-planner",p.getCloud_name());
        assertEquals("564556916291473",p.getApi_key());
        assertEquals("WsafMT2fFgx1KOvBL-AEdcATFXM",p.getApi_secret());
        assertTrue(p.isSecure());
    }

    /*
    check if the url is right
     */
    private static boolean isValid(String url)
    {
        try {
            new URL(url).toURI();
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /*
    test the function MapOfPicInFolder
     */
    @Test
    void mapOfPicInFolderNullPath() {
        Pictures p = new Pictures();
        assertNull(p.MapOfPicInFolder(null));
    }
    @Test
    void mapOfPicInFolderNotValidPath() {
        Pictures p = new Pictures();
        assertNull(p.MapOfPicInFolder("C:\\Users\\momen\\OneDrive\\Desktop\\NotValidPath"));
    }
    @Test
    void mapOfPicInFolderEmptyFolder() {
        Pictures p = new Pictures();
        assertEquals(0,p.MapOfPicInFolder("testing Appendices\\New folder").size());
    }
    @Test
    void mapOfPicInFolderCorrectFolder() {
        Pictures p = new Pictures();
        List<Map<String,Integer>> m=p.MapOfPicInFolder("testing Appendices\\New folder1");
        assertEquals(1,m.size());
        assertTrue(isValid(String.valueOf(m.get(0).get("url"))));
        p.deletePicture(String.valueOf(m.get(0).get("public_id")));
    }
    /*
    test the function urlOfPicInFolder
     */
    @Test
    void urlOfPicInFolderNullPath() {
        Pictures p = new Pictures();
        assertNull(p.urlOfPicInFolder(null));
    }
    @Test
    void urlOfPicInFolderNotValidPath() {
        Pictures p = new Pictures();
        assertNull(p.urlOfPicInFolder("C:\\Users\\momen\\OneDrive\\Desktop\\NotValidPath"));
    }
    @Test
    void urlOfPicInFolderEmptyFolder() {
        Pictures p = new Pictures();
        assertEquals(0,p.urlOfPicInFolder("testing Appendices\\New folder").size());
    }
    @Test
    void urlOfPicInFolderCorrectFolder() {
        Pictures p = new Pictures();
        List<Map<String,Integer>> m=p.MapOfPicInFolder("testing Appendices\\New folder1");
        assertEquals(1,m.size());
        assertTrue(isValid(String.valueOf(m.get(0).get("url"))));
        p.deletePicture(String.valueOf(m.get(0).get("public_id")));
    }

    /*
    test the function deletePicture
     */
    @Test
    void deletePictureExistingPicture() {
        Pictures p = new Pictures();
        List<Map<String,Integer>> m=p.MapOfPicInFolder("testing Appendices\\New folder1");
        assertEquals(1,m.size());
        assertTrue(isValid(String.valueOf(m.get(0).get("url"))));
        p.deletePicture(String.valueOf(m.get(0).get("public_id")));
    }
    @Test
    void deletePictureNonExistingPicture() {
        Pictures p = new Pictures();
        assertTrue(p.deletePicture("arpikpiwufddcsgi8ulMOMEN"));
    }
    @Test
    void deletePictureWithNullPublic_id() {
        Pictures p = new Pictures();
        assertTrue(p.deletePicture(null));
    }

    /*
    test the function mapOfPicture
     */
    @Test
    void mapOfPictureNullPath() {
        Pictures p = new Pictures();
        assertNull(p.mapOfPicture(null));
    }
    @Test
    void mapOfPictureNotValidPath() {
        Pictures p = new Pictures();
        File pic=new File("C:\\Users\\momen\\OneDrive\\Desktop\\NotValidPath");
        assertNull(p.mapOfPicture(pic));
    }
    @Test
    void mapOfPicInFolderNonPicture() {
        Pictures p = new Pictures();
        File pic=new File("testing Appendices\\New folder");
        assertNull(p.mapOfPicture(pic));
    }
    @Test
    void mapOfPictureCorrectPicture() {
        Pictures p = new Pictures();
        File pic=new File("testing Appendices\\happy new year 2022.jpg");
        var m=p.mapOfPicture(pic);
        assertTrue(isValid(String.valueOf(m.get("url"))));
        p.deletePicture(String.valueOf(m.get("public_id")));
    }

    /*
    test the function urlOfPicture
     */
    @Test
    void urlOfPictureNullPath() {
        Pictures p = new Pictures();
        assertNull(p.urlOfPicture(null));
    }
    @Test
    void urlOfPictureNotValidPath() {
        Pictures p = new Pictures();
        File pic=new File("C:\\Users\\momen\\OneDrive\\Desktop\\NotValidPath");
        assertNull(p.urlOfPicture(pic));
    }
    @Test
    void urlOfPictureNonPicture() {
        Pictures p = new Pictures();
        File pic=new File("testing Appendices\\New folder");
        assertNull(p.urlOfPicture(pic));
    }
    @Test
    void urlOfPictureCorrectPicture() {
        Pictures p = new Pictures();
        File pic=new File("testing Appendices\\happy new year 2022.jpg");
        var m=p.mapOfPicture(pic);
        assertTrue(isValid(String.valueOf(m.get("url"))));
        p.deletePicture(String.valueOf(m.get("public_id")));
    }

    /*
    test the function urlOfPicturePath
     */
    @Test
    void urlOfPicturePathNullPath() {
        Pictures p = new Pictures();
        assertNull(p.urlOfPicturePath(null));
    }
    @Test
    void urlOfPicturePathNotValidPath() {
        Pictures p = new Pictures();
        assertNull(p.urlOfPicturePath("C:\\Users\\momen\\OneDrive\\Desktop\\NotValidPath"));
    }
    @Test
    void urlOfPicturePathNonPicture() {
        Pictures p = new Pictures();
        assertNull(p.urlOfPicturePath("testing Appendices\\New folder"));
    }
    @Test
    void urlOfPicturePathCorrectPicture() {
        Pictures p = new Pictures();
        File pic=new File("testing Appendices\\happy new year 2022.jpg");
        var m=p.mapOfPicture(pic);
        assertTrue(isValid(String.valueOf(m.get("url"))));
        p.deletePicture(String.valueOf(m.get("public_id")));
    }
}