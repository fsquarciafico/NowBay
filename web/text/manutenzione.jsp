<%-- 
    Document   : manutenzione
    Created on : 13-giu-2018, 19.58.51
    Author     : Ferdinando
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <link rel="shortcut icon" href="css/images/favicon.gif"/>
        <title>Manutenzione</title>
    </head>
    
           
                
    <center> <c:choose><c:when test="${stato}">
    <body>
        <h1>SITO IN MANUTENZIONE!!!</h1>
                        </c:when>
                       
                        <c:otherwise>
                          <body>
                              <img src="manutenzione.jpg"/> 
                          </c:otherwise>
                        </c:choose>
                    
                    <form class="registrazione" method="post" action="Login">
                        <center><fieldset>
                        <p>
                            <label for="name">Administrator</label>
                            <input type="text" id="name" name="name" required value="" />
                        </p>

                        <p>
                            <label for="password">Password</label>
                            <input type="password" id="password" name="password" required value=""  />
                        </p>
                        <p>
                            <select name="manutenzione">
                                <option value ="0"> OPERATIVO</option>
                                 <option value ="1"> IN MANUTENZIONE</option>
                            </select>
                        </p>
                        <p class="bottone">
                            <button class="bottone-invia" type="submit">Invia</button>
                        </p>

                        </fieldset>
                        </center>
                    </form></center>
    </body>
</html>
