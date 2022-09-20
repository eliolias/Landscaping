package com.solvd.landscapingApp.models;

public class Truck {

    private int id;
    private String licensePlate;
    private int currentGasAmount;
    private int gasTankSize;
    private int companyID;

    public Truck(int id, String licensePlate, int currentGasAmount, int gasTankSize, int companyID) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.currentGasAmount = currentGasAmount;
        this.gasTankSize = gasTankSize;
        this.companyID = companyID;
    }

    public Truck() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCurrentGasAmount() {
        return currentGasAmount;
    }

    public void setCurrentGasAmount(int currentGasAmount) {
        this.currentGasAmount = currentGasAmount;
    }

    public int getGasTankSize() {
        return gasTankSize;
    }

    public void setGasTankSize(int gasTankSize) {
        this.gasTankSize = gasTankSize;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", currentGasAmount=" + currentGasAmount +
                ", gasTankSize=" + gasTankSize +
                ", companyID=" + companyID +
                '}';
    }
}
