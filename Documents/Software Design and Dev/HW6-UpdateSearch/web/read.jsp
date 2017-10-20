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
        <link rel = 'stylesheet' type = 'text/css' href = 'HW6style.css'/>

    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        
        <div class="wrap"> <!--div to hold all other divs-->
            
            <%@include file="includes/header.jsp"%>
            
            <%@include file="includes/menu.jsp"%>

            <div class="main">
        
        <h2>MLB Teams Table</h2>

        <%= table %>
        </div>

            <%@include file="includes/footer.jsp"%><!--Footer-->>     
    </body>
</html>
