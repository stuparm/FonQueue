/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.ReflectionUtil;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Properties;
import api.Api;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.properties.ServletProperties;

/**
 *
 * @author mihailo
 */
public class AppController {

    public AppController() {
        
        try {

            List<Class> klase = ReflectionUtil.getClassesFromPackage("api");
//            Properties properties = new Properties();

            for (Class apiKlasa : klase) {
                if (apiKlasa.getSuperclass() == Api.class) {
                    Constructor konstruktor = apiKlasa.getConstructor();
                    Api apiObject = (Api) konstruktor.newInstance();
                    String uri = apiObject.uri();
                    String putanja = apiKlasa.getName();
//                    properties.put(uri, putanja);
                    ServletProperties.getInstance().insertClassPath(uri, putanja);
                }
            }
//            ServletProperties.storeProperties(properties);

         } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    public void process(String uri, HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) {
        
         try {

            
//            Properties prop = ServletProperties.getProperties();
//            String classPath = prop.getProperty(uri);
            
            String classPath = ServletProperties.getInstance().getClassPath(uri);
            if (classPath == null) {
                throw new RuntimeException("There is no class in property file");
            }

            Class apiClass = Class.forName(classPath);
            Constructor konstruktor = apiClass.getConstructor();
            Api apiObject = (Api) konstruktor.newInstance();
            apiObject.proccesRequest(request, response, servlet);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        
        
        
        
        
        
    }
    
    
    
}
