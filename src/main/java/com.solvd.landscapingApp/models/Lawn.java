package com.solvd.landscapingApp.models;

public class Lawn {
    private int id;
    private int timeToMow;
    private int costToMow;
    private String requirements;
    private int addressID;
    private int customerID;

    public Lawn(int id, int timeToMow, int costToMow, String requirements, int addressID, int customerID) {
        this.id = id;
        this.timeToMow = timeToMow;
        this.costToMow = costToMow;
        this.requirements = requirements;
        this.addressID = addressID;
        this.customerID = customerID;
    }

    public Lawn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeToMow() {
        return timeToMow;
    }

    public void setTimeToMow(int timeToMow) {
        this.timeToMow = timeToMow;
    }

    public int getCostToMow() {
        return costToMow;
    }

    public void setCostToMow(int costToMow) {
        this.costToMow = costToMow;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Lawn{" +
                "id=" + id +
                ", timeToMow=" + timeToMow +
                ", costToMow=" + costToMow +
                ", requirements='" + requirements + '\'' +
                ", addressID=" + addressID +
                ", customerID=" + customerID +
                '}';
    }
}
