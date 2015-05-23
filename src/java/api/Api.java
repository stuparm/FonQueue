/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;


import util.type.ResponseType;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author mihailo
 */
public abstract class Api {
    
    /**
     * Uri za koji je odgovoran ovaj api
     * @return 
     */
    public abstract String uri();

    /**
     * Koristiti klasu za ResponseType i njene konsatne<br/>
     * Trenutno su podrzani TEXT, IMAGE, JSON
     * @return 
     */
    public abstract int responseType();

    /**
     * Odgovor, treba vratiti objekat koji odgovara tipu ResponseType
     * @param request
     * @return 
     */
    public abstract Object response(HttpServletRequest request, HttpServletResponse response);

    public void proccesRequest(HttpServletRequest request, HttpServletResponse response, HttpServlet servlet) throws ServletException, IOException {

        Object responseObject = response(request,response);

        if (responseType() == ResponseType.IMAGE) {
            BufferedImage image = (BufferedImage) responseObject;
            sendImage(servlet, response, image);
        }

        else if (responseType() == ResponseType.TEXT) {
            String text = (String) responseObject;
            sendText(response, text);
        }
        else if (responseType() == ResponseType.WEB_PAGE) {
            String uri = (String)responseObject;
            redirect(request, response, uri);
        }
        else if (responseType() == ResponseType.JSON_OBJECT) {
            JSONObject json = (JSONObject)responseObject;
            sendJSON(response,json);
        }
        else if (responseType() == ResponseType.NOTHING) {
            //do nothing
        }

    }

    protected void sendImage(HttpServlet servlet,HttpServletResponse response, BufferedImage image) {
        try {
            response.setContentType("image/jpeg");
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void sendText(HttpServletResponse response, String text) {
        try {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println(text);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void redirect(HttpServletRequest request,HttpServletResponse reaponse, String uri) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(uri);
        view.forward(request, reaponse);
    }

    protected void sendJSON(HttpServletResponse response, JSONObject json) {
        try {
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.println(json.toString());
            out.close();
        } catch (IOException e) {
            Logger.getLogger(Api.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        
    }

}
