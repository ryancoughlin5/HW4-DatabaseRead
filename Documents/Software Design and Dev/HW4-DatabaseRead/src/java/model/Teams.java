/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ryan
 */
public class Teams {
    private int teamID;
    private String teamName;
    private String conference;
    private String division;
    private String city;
    private String state;
    private String stadiumName;
    private int yrBuilt;

    
    public Teams() {
        this.teamID = 0;
        this.teamName = "";
        this.conference = "";
        this.division = "";
        this.city = "";
        this.state = "";
        this.stadiumName = "";
        this.yrBuilt = 0;
    }
    
    
    public Teams(int teamID, String teamName, String conference, String division, String city, String state, String stadiumName, int yrBuilt) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.conference = conference;
        this.division = division;
        this.city = city;
        this.state = state;
        this.stadiumName = stadiumName;
        this.yrBuilt = yrBuilt;
    }

    public int getTeamID() {
        return teamID;
    }

    public void setTeamID(int teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public int getYrBuilt() {
        return yrBuilt;
    }

    public void setYrBuilt(int yrBuilt) {
        this.yrBuilt = yrBuilt;
    }

    @Override
    public String toString() {
        return "Teams{" + "teamID=" + teamID + ", teamName=" + teamName + ", conference=" + conference + ", division=" + division + ", city=" + city + ", state=" + state + ", stadiumName=" + stadiumName + ", yrBuilt=" + yrBuilt + '}';
    }
    
    
    
}
