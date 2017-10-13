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

public class ReadQuery {
    private Connection conn;
    private ResultSet results;
    
    
    public ReadQuery(){
       Properties props = new Properties(); //MWC
       InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead(){
        try {
            String query = "Select * from MLB_Teams";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
                    } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
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
            while(this.results.next()){
                
                Teams teams = new Teams();
                teams.setTeamID(this.results.getInt("teamID"));
                teams.setTeamName(this.results.getString("teamName"));
                teams.setConference(this.results.getString("conference"));
                teams.setDivision(this.results.getString("division"));
                teams.setCity(this.results.getString("city"));
                teams.setState(this.results.getString("state"));
                teams.setStadiumName(this.results.getString("stadiumName"));
                teams.setYrBuilt(this.results.getInt("yrBuilt"));
                
                
                table += "<tr>";
                table += "<td>";
                    table += teams.getTeamID();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getTeamName();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getConference();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getDivision();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getCity();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getState();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getStadiumName();
                table += "</td>";
                
                table += "<td>";
                    table += teams.getYrBuilt();
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        table += "</table>";
        
           return table;
    }
    
}