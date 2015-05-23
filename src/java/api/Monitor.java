/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logika.sluzba.Salter;
import logika.sluzba.Sluzba;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import util.JsonUtil;
import util.type.ResponseType;

/**
 *
 * @author Mihailo
 */
public class Monitor extends Api{

    @Override
    public String uri() {
        return "/monitor";
    }

    @Override
    public int responseType() {
        return ResponseType.JSON_OBJECT;
    }

    @Override
    public Object response(HttpServletRequest request, HttpServletResponse response) {
        JSONObject json = Sluzba.getInstance().kreirajJSON();
        return json;
    }
    
    
    
    
}
