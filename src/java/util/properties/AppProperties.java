/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.properties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Mihailo
 */
public class AppProperties {
    
    private static AppProperties instance;
    private AppProperties(){
        createProperties();
    }
    public static AppProperties getInstance() {
        if (instance == null) {
            instance = new AppProperties();
        }
        return instance;
    }
    private Properties properties;
    
    
    private void createProperties() {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
//            properties.load(new FileInputStream("application.properties"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
//    public int getKapacitetPomocniRed() {
//        return Integer.parseInt(properties.getProperty("pomocnired"));
//    }
    
    
    
    //==========================================================================
    //
    //                          TEST VERZIJA
    //
    //==========================================================================
    
    public int getKapacitetPomocniRed() {
        return 6;
    }
    
    
    
    
    
    
    
    
}
