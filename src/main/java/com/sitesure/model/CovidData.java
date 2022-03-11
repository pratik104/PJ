package com.sitesure.model;

public class CovidData {
    private int id;
    private String state;
    private String country;
    private int totalCases;
    private int newCases;

    public int getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getNewCases() {
        return newCases;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public void setNewCases(int newCases) {
        this.newCases = newCases;

    }

    @Override
    public String toString() {
        return "CovidData{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", totalCases=" + totalCases +
                ", newCases=" + newCases +
                '}';
    }
}
