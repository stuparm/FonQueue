/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import util.type.LoginType;

/**
 *
 * @author Mihailo
 */
public class LoginProperties {
    
    private static LoginProperties instance;
    
    private LoginProperties(){
        createProperties();
    }
    public static LoginProperties getInstance() {
        if (instance == null) {
            instance = new LoginProperties();
        }
        return instance;
    }
    private Properties properties;
    
    
    private void createProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("logovanje.properties"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Vraca korisnika ukoliko postoji, pogledati klasu LoginType
     * @param username
     * @param password
     * @return String sa korisnikom ako korisnik postoji, ako login ne prodje vraca null
     */
    public int getKorisnik(String username, String password) {
        //admin
        if (equalPair(LoginType.ADMIN_USERNAME_KEY, username, LoginType.ADMIN_PASSWORD_KEY, password))
            return LoginType.ADMIN;
        
        //salter 1
        if (equalPair(LoginType.SALTER_1_USERNAME_KEY, username, LoginType.SALTER_1_PASSWORD_KEY, password))
            return LoginType.SALTER_1;
        
        //salter 2
        if (equalPair(LoginType.SALTER_2_USERNAME_KEY, username, LoginType.SALTER_2_PASSWORD_KEY, password))
            return LoginType.SALTER_2;
        
        //salter 3
        if (equalPair(LoginType.SALTER_3_USERNAME_KEY, username, LoginType.SALTER_3_PASSWORD_KEY, password))
            return LoginType.SALTER_3;
        
        //salter 4
        if (equalPair(LoginType.SALTER_4_USERNAME_KEY, username, LoginType.SALTER_4_PASSWORD_KEY, password))
            return LoginType.SALTER_4;
        
        //salter 5
        if (equalPair(LoginType.SALTER_5_USERNAME_KEY, username, LoginType.SALTER_5_PASSWORD_KEY, password))
            return LoginType.SALTER_5;
        
        return LoginType.NEUSPELO;
        
    }
    
    /**
     * 
     * @param key kljuc za koji se u properties trazi vrednost XYZ
     * @param targetValue vrednost sa kojom se poredi ABC
     * @return ako su targetValue i ABC iste  -> true, false u suprotnom
     */
    private boolean equal(String key, String targetValue) {
        return properties.getProperty(key).equals(targetValue);
    }
    
   
    private boolean equalPair(String userKey, String userTarget, String passKey, String passTarget) {
        return equal(userKey, userTarget) && equal(passKey, passTarget);
    }
    
    
}
