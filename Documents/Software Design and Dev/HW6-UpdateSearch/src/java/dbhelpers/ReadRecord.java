
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

public class ReadRecord {
    private Connection conn;
    private ResultSet results;
    
    private Teams team = new Teams();
    private int teamID;
    
    
    public ReadRecord(int teamID){
    
        Properties props = new Properties(); //MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String driver = props.getProperty("driver.name");
       String url = props.getProperty("server.name");
       String username = props.getProperty("user.name");
       String passwd = props.getProperty("user.password");
       
       this.teamID = teamID;
       
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    public void doRead(){
    
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM teams WHERE teamID = ?";
            
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            
            //fill in the preparedstatement
            ps.setInt(1, teamID);
            
            //exectue the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            team.setTeamID(this.results.getInt("teamID"));
            team.setTeamName(this.results.getString("teamName"));
            team.setConference(this.results.getString("conference"));
            team.setDivision(this.results.getString("division"));
            team.setCity(this.results.getString("city"));
            team.setState(this.results.getString("state"));
            team.setStadiumName(this.results.getString("stadiumName"));
            team.setYrBuilt(this.results.getInt("yrBuilt"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Teams getTeams(){
        return this.team;
    }
}
 