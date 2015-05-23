/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author Mihailo
 */
public class JsonUtil {
    
    public static final String INDEX = "index";
    public static final String REDNI_BROJ = "redniBroj";
    public static final String EMPTY = "empty";
    public static final String GLAVNI_RED = "glavniRed";
    public static final String POMOCNI_RED = "pomocniRed";
    public static final String SALTER_BROJ = "salter_broj";
    public static final String STATUS_SALTER = "statusSalter";
    public static final String OTVOREN = "otvoren";
    public static final String ZATVOREN = "zatvoren";
    public static final String TEKUCI = "tekuci";
    public static final String SALTERI = "salteri";
    
    public static JSONObject nemaStudentaJSON() {
        JSONObject json = new JSONObject();
        try {
            json.put(INDEX, EMPTY);
            json.put(REDNI_BROJ, EMPTY);
        } catch (JSONException ex) {
            Logger.getLogger(JsonUtil.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return json;
    }
    
//    public static JSONObject zatvorenSalterJSON(int brojSaltera) {
//        JSONObject json = new JSONObject();
//        try {  
//            json.put(SALTER_BROJ, brojSaltera);
//            json.put(STATUS_SALTER, ZATVOREN);
//            json.put(TEKUCI, nemaStudentaJSON());
//        } catch (JSONException ex) {
//            Logger.getLogger(JsonUtil.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace();
//        }
//        return json;
//    }
    
    
    
}
