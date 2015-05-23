/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika.domen;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonObject;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import util.JsonUtil;

/**
 *
 * @author Mihailo
 */
public class Student {
    
    private String index;
    private int redniBroj;

    public Student(String indexj) {
        this.index = index;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getIndex() {
        return index;
    }

    public int getRedniBroj() {
        return redniBroj;
    }
    
    public JSONObject getJSON() {
        JSONObject json = new JSONObject();
        try {
            json.put(JsonUtil.INDEX, index);
            json.put(JsonUtil.REDNI_BROJ, redniBroj);
        } catch (JSONException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    
}
