<%-- 
    Document   : add
    Created on : Oct 12, 2017, 11:11:31 PM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a New Team</title>
        <link rel = 'stylesheet' type = 'text/css' href = 'HW5style.css'/>
    </head>
    <body id="add">
        <h1>Add a New Team</h1>
        
        
        <form name="addForm" action="addTeam" method="get">
            
            <label>Team Name:</label>
            <input type="text" name="teamName" value=""/>
            <br>
            <label>Conference:</label>
            <input type="text" name="conference" value=""/>
            <br>
            <label>Division:</label>
            <input type="text" name="division" value=""/>
            <br>
            <label>City:</label>
            <input type="text" name="city" value=""/>
            <br>
            <label>State:</label>
            <input type="text" name="state" value=""/>
            <br>
            <label>Stadium Name:</label>
            <input type="text" name="stadiumName" value=""/>
            <br>
            <label>Year Built:</label>
            <input type="text" name="yrBuilt" value=""/>
            <br>
            <input type="submit" name="submit" value="Submit"/>
        </form>
    </body>
</html>
