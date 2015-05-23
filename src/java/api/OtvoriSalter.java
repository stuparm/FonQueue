/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logika.sluzba.Sluzba;
import util.type.LoginType;
import util.type.ResponseType;

/**
 *
 * @author Mihailo
 */
public class OtvoriSalter extends Api{

    @Override
    public String uri() {
        return "/otvoriSalter";
    }

    @Override
    public int responseType() {
        return ResponseType.WEB_PAGE;
    }

    @Override
    public Object response(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            System.out.println("NIJE KREIRANA SESIJA");
            return null;
        }
        String brojSalteraString = session.getAttribute(LoginType.LOGIN_TYPE).toString();
        int brojSaltera = Integer.parseInt(brojSalteraString);
        Sluzba.getInstance().otvoriSalter(brojSaltera);
        response.setHeader("Refresh", "2");
        
        return "/WEB-INF/salter.jsp";
    }
    
}
