
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Teams;

public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
        
         Properties props = new Properties(); //MWC
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead(){
        try {
            String query = "Select * from MLB_Teams";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
                    } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void doSearch(String teamName){
     
        try {
            String query = "SELECT * FROM mlb_teams WHERE UPPER(teamName) LIKE ?";

            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + teamName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getHTMLTable(){
       
        String table = "";

        table += "<table>";

        table += "<tr>";
            table += "<th>   </th>";
            table += "<th>Team Name</th>";
            table += "<th>Conference</th>";
            table += "<th>Division</th>";
            table += "<th>City</th>";
            table += "<th>State</th>";
            table += "<th>Stadium Name</th>";
            table += "<th>Year Built</th>";
        table += "</tr>";
            
        try {
            if(!this.results.isBeforeFirst()){
                table += "<tr>";
                    table += "<td colspan='6'> Sorry, no records matched your search</td>";
                table += "<tr>";
}
            else{
            
            while(this.results.next()){
                
                Teams team = new Teams();
                team.setTeamID(this.results.getInt("teamID"));
                team.setTeamName(this.results.getString("teamName"));
                team.setConference(this.results.getString("conference"));
                team.setDivision(this.results.getString("division"));
                team.setCity(this.results.getString("city"));
                team.setState(this.results.getString("state"));
                team.setStadiumName(this.results.getString("stadiumName"));
                team.setYrBuilt(this.results.getInt("yrBuilt"));
                
                
                table += "<tr>";
                table += "<td>";
                    table += team.getTeamID();
                table += "</td>";
                
                table += "<td>";
                    table += team.getTeamName();
                table += "</td>";
                
                table += "<td>";
                    table += team.getConference();
                table += "</td>";
                
                table += "<td>";
                    table += team.getDivision();
                table += "</td>";
                
                table += "<td>";
                    table += team.getCity();
                table += "</td>";
                
                table += "<td>";
                    table += team.getState();
                table += "</td>";
                
                table += "<td>";
                    table += team.getStadiumName();
                table += "</td>";
                
                table += "<td>";
                    table += team.getYrBuilt();
                table += "</td>";
               
                table += "<td>";
                table += "<a href=update?teamID=" + team.getTeamID() + ">Update</a>";
                table += "<a href=delete?teamID=" + team.getTeamID() + ">Delete</a>";
                table += "</td>";
                
                table += "</tr>";
                }
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        table += "</table>";
        
           return table;
            
    }
}

    

