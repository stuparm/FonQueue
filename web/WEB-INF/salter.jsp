<%-- 
    Document   : salter
    Created on : May 23, 2015, 4:07:58 AM
    Author     : Mihailo
--%>

<%@page import="util.type.LoginType"%>
<%@page import="logika.sluzba.Sluzba"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>
            <%
                String redniBrojString = session.getAttribute(LoginType.LOGIN_TYPE).toString();
                out.println(redniBrojString); 
            %>
        </p>
        
        
       
        <a href="api/otvoriSalter">Otvori salter</a>
        
        <div>
            <%= Sluzba.getInstance().vratiSalter(redniBrojString).vratiTekucegString() %>
            
        </div>
        
        
    </body>
</html>
