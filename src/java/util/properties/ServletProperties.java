/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 *
 * @author mihailo
 */
public class ServletProperties {

    private Map<String,String> map;
    
    
//    public static Properties getProperties() {
//        Properties prop = new Properties();
//        try {
//            prop.load(new FileInputStream("servlet.properties"));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//        return prop;
//    }
//    
    public String getClassPath(String uri) {
        return map.get(uri);
    }
    
    public void insertClassPath(String uri, String putanja) {
        map.put(uri, putanja);
    }
    
    
    
    
    
    
//    public static void storeProperties(Properties properties) {
//        
//        try {
//            File file = new File("servlet.properties");
//            OutputStream out = new FileOutputStream(file);
//            properties.store(out, null);
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
    
    
    
    
    
    
    // SINGLETON
    private static ServletProperties instance;
    private ServletProperties(){
        map = new HashMap<>();
    }
    public static ServletProperties getInstance() {
        if (instance == null)
            instance = new ServletProperties();
        return instance;
    }
    

}
