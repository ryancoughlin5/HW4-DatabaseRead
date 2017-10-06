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
        <title>Team Table</title>
        <link rel = 'stylesheet' type = 'text/css' href = 'HW4style.css'/>

    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>MLB Teams Table</h1>

        <%= table %>
            
    </body>
</html>
