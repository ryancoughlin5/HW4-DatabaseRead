<%-- 
    Document   : updateForm
    Created on : Oct 20, 2017, 10:16:38 AM
    Author     : Ryan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Teams" %>
<% Teams team = (Teams)request.getAttribute("team"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = 'stylesheet' type = 'text/css' href = 'HW6style.css'/>
        <title>Update A Team</title>
    </head>
    <body>
        <h1>Update A Team</h1>
        
        
        <form name="updateForm" action="updateTeam" method="get">
            <table class="update">
            <tr>
                <td class="right">Team ID:</td>
                <td><input type="text" name="teamID" value="<%=team.getTeamID()%>" readonly/></td>
            </tr>
            <tr>
                <td class="right">Team Name:</td>
                <td><input type="text" name="teamName" value="<%=team.getTeamName()%>"/></td>
            </tr>
            <tr>
                <td class="right">Conference:</td>
                <td><input type="text" name="conference" value="<%=team.getConference()%>"/></td>
            </tr>
            <tr>
                <td class="right">Division:</td>
                <td><input type="text" name="division" value="<%=team.getDivision()%>"/></td>
            </tr>
            <tr>
                <td class="right">City:</td>
                <td><input type="text" name="city" value="<%=team.getCity()%>"/></td>
            </tr>
            <tr>
                <td class="right">State:</td>
                <td><input type="text" name="state" value="<%=team.getState()%>"/></td>
            </tr>
            <tr>
                <td class="right">Stadium Name:</td>
                <td><input type="text" name="stadiumName" value="<%=team.getStadiumName()%>"/></td>
            </tr>
            <tr>
                <td class="right">Year Built:</td>
                <td><input type="text" name="yrBuilt" value="<%=team.getYrBuilt()%>"/></td>
            </tr>
            </table>
            <br>
            <input type="reset" name="reset" value="Clear"/>
            <input type="submit" name="submit" value="Update"/>
        </form>
    </body>
</html>
