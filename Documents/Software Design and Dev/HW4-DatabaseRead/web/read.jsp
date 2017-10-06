<%-- 
    Document   : read
    Created on : Oct 5, 2017, 8:43:55 PM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>Ryan's Teams</h1>
        <%= table %>
    </body>
</html>
