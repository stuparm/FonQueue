/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika.sluzba;

import izuzetak.PrazanRedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logika.domen.Student;
import logika.red.GlavniRed;
import logika.red.PomocniRed;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import util.JsonUtil;

/**
 *
 * @author Mihailo
 */
public class Salter {
    
    private int brojSaltera;
    private GlavniRed glavniRed;
    private PomocniRed pomocniRed;
    private int redniBrojStudenta;
    private String status;
    
    public Salter(int brojSaltera) {
        glavniRed = new GlavniRed();
        pomocniRed = new PomocniRed();
        redniBrojStudenta = 1;
        this.brojSaltera = brojSaltera;
        status = JsonUtil.ZATVOREN;
    }

    public void setBrojSaltera(int brojSaltera) {
        this.brojSaltera = brojSaltera;
    }
    
    public void zatvoriSalter() {
        status = JsonUtil.ZATVOREN;
    }
    
    public void otvoriSalter() {
        status = JsonUtil.OTVOREN;
    }
    
    
    public void ubaciStudenta(String index) {
        Student student = new Student(index);
        student.setRedniBroj(redniBrojStudenta);
        redniBrojStudenta++;
        glavniRed.ubaci(student);
    }
    
    public void izbaciStudenta() throws PrazanRedException {
        Student student = glavniRed.izbaci();
        pomocniRed.ubaci(student);
    }
    
    public JSONObject vratiTekucegJSON() throws PrazanRedException {
        return glavniRed.vratiPrvog().getJSON();
    }
    
    public String vratiTekucegString() {
        try {
            return glavniRed.vratiPrvog().getRedniBroj()+"";
        } catch (PrazanRedException ex) {
            return "Nema Nikog";
        }
    }
    
    
    public JSONArray vratiPomocniRedJSON() {
        return pomocniRed.sviStudentiJSONArray();
    }
    
    public JSONObject salterJSON() {
        JSONObject json = new JSONObject();
        try {
            json.put(JsonUtil.SALTER_BROJ, brojSaltera);
            json.put(JsonUtil.STATUS_SALTER, status);
            try {
                json.put(JsonUtil.TEKUCI, vratiTekucegJSON());
            } catch (PrazanRedException ex) {
                json.put(JsonUtil.TEKUCI, JsonUtil.nemaStudentaJSON());
            }
        } catch (JSONException ex) {
            Logger.getLogger(Salter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }
    
   
    
    
}
