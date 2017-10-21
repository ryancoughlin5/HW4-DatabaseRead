<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <link rel = 'stylesheet' type = 'text/css' href = 'HW6style.css'/>
        <title>Search Teams</title>
    </head>
    <body>
        
        <div class="wrap"> <!--div to hold all other divs-->
            
            <%@include file="includes/header.jsp"%>
            
            <%@include file="includes/menu.jsp"%>

        <div class="main"> 
        <h2>Search Teams</h2>
        
        <form name="searchForm" action="search" method="get">
            <input type="text" name="searchval" value=""><br>
            <input type="submit" name="submit" value="Search">
        </form>
            
             </div>

           <%@include file="includes/footer.jsp"%><!--Footer-->
        </div>
    </body>
</html>
