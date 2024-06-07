package com.company;
import java.io.Serializable;
import java.util.Date;

public class Race implements Serializable { //race class
    Date date;
    private String[][] drivDetails; // drivDetails 2D array
    private int c = 0; // Initializing the variable c

    public Race(Date ddate, int a) { // constructor of race
        this.drivDetails = new String[a][2]; // 2D array to get the name and position
        this.date = ddate;
    }

    public String[][] getDrivDetails() {
        return drivDetails;
    } // getting the getDrivDetails 2D array

    public void setDrivDetails(String dname, String dposition) {
        this.drivDetails[c][0] = dname;
        this.drivDetails[c][1] = dposition;
        c++; //variable to increment the 2D array one by one.
    }

    public Date getDate() {
        return date;
    }
}