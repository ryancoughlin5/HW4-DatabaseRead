<%-- 
    Document   : index
    Created on : Oct 5, 2017, 4:53:57 PM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MLB Teams</title>
        <link rel = 'stylesheet' type = 'text/css' href = 'HW6style.css'/>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs-->
            
            <%@include file="includes/header.jsp"%>
            
            <%@include file="includes/menu.jsp"%>

        <div class="main"> 
            <h2>Major League Baseball Teams Database</h2><br>
        </div>
        
            <%@include file="includes/footer.jsp"%><!--Footer-->

        </div> <!--close wrap div-->
    </body>
</html>
