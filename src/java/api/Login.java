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
import util.properties.LoginProperties;
import util.type.LoginType;
import util.type.ResponseType;

/**
 *
 * @author Mihailo
 */
public class Login extends Api{

    @Override
    public String uri() {
        return "/login";
    }

    @Override
    public int responseType() {
        return ResponseType.WEB_PAGE;
    }

    @Override
    public Object response(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        //
        int loginType = getLoginType(username, password);
        //
        //String loginType = LoginProperties.getInstance().getLoginType(username, password);
        if (loginType != LoginType.NEUSPELO) {
            HttpSession session  = request.getSession(true);
            session.setAttribute(LoginType.LOGIN_TYPE, loginType);
            
            if (loginType == LoginType.ADMIN)
                return "/WEB-INF/admin.jsp";
            else //ako nije admin onda je salter neki 
                return "/WEB-INF/salter.jsp";
            
        }
        
        
        return "/authorization_denied.html";
    }
    
    
    
    //==========================================================================
    //
    //                          TEST FAZA
    //
    //==========================================================================
    
    
    private int getLoginType(String username, String password) {
        //admin
//        if (equalPair(LoginType.ADMIN_USERNAME_KEY, username, LoginType.ADMIN_PASSWORD_KEY, password))
//            return LoginType.ADMIN;
//        
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
        
        return -1;
        
    }
    
    
    
   
    private boolean equalPair(String userKey, String userTarget, String passKey, String passTarget) {
        return userTarget.equals(passTarget);
    }
    
}
