package com.company;

import java.io.Serializable;
public abstract class Driver implements Serializable { 
    private String dlocation; 
    private String dteam;
    private String dname;
    private int noposition;
    private int nopoints;
    private int noraces;
    private int noOffirstplaces;
    private int NoOfsecondPlaces;
    private int NoOfthirdPlaces;

    public Driver(String name, String location, String dteam, int noraces) { 
        this.dname = name;
        this.dlocation = location;
        this.dteam = dteam;
        this.noraces = noraces;
    }

    public int getNoOfsecondPlaces() {
        return NoOfsecondPlaces;
    }

    public int getNoOfthirdPlaces() {
        return NoOfthirdPlaces;
    }

    public int getNoOffirstplaces() {
        return noOffirstplaces;
    }
    public void setNoOffirstplaces() {
        this.noOffirstplaces++;
    }

    public void setNoOfsecondPlaces() {
        this.NoOfsecondPlaces++;
    }
    public void setNoOfthirdPlaces() {
        this.NoOfthirdPlaces++;
    }

    public int getNoposition() {
        return noposition;
    }

    public void setNoposition(int noposition) {
        this.noposition = noposition;
    }

    public int getNopoints() {
        return nopoints;
    }

    public void setNopoints(int nopoints) {
        this.nopoints += nopoints;
    }

    public int getNoraces() {
        return noraces;
    }

    public void setNoraces() { 
        this.noraces++;
    }

    public String getDlocation() {
        return dlocation;
    }

    public String getDteam() {
        return dteam;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
