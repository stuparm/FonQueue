/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika.sluzba;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import util.JsonUtil;
import util.type.LoginType;

/**
 *
 * @author Mihailo
 */
public class Sluzba {
    
    private Salter[] salteri; 
    
  
    
    public void zatvoriSalter(int brojSaltera) {
        salteri[brojSaltera].zatvoriSalter();
    }
    
    public void otvoriSalter(int brojSaltera) {
        salteri[brojSaltera].otvoriSalter();
    }
    
    public Salter vratiSalter(int brojSaltera) {
        return salteri[brojSaltera];
    }
 
    public Salter[] vratiSaltere() {
        return salteri;
    }
    
    public JSONObject kreirajJSON() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        
        for (Salter salter : salteri) {      
            if (salter != null) {
                array.put(salter.salterJSON());
            }
        }   
        try {
            json.put(JsonUtil.SALTERI, array);
        } catch (JSONException ex) {
            Logger.getLogger(Sluzba.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }   
        return json;
    }
   
    
    public Salter vratiSalter (String redniBrojString) {
        int redniBroj = Integer.parseInt(redniBrojString);
        return salteri[redniBroj];
    }
    
    
    //SINGLETON
    private static Sluzba instance;
    private Sluzba(){
        salteri = new Salter[5];
        salteri[0] = new Salter(1);
        salteri[1] = new Salter(2);
        salteri[2] = new Salter(3);
        salteri[3] = new Salter(4);
        salteri[4] = new Salter(5);
        
    }
    public static Sluzba getInstance() {
        if (instance == null)
            instance = new Sluzba();
        return instance;
    }
    
    
    
}
