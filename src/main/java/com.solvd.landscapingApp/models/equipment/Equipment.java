package com.solvd.landscapingApp.models.equipment;

public class Equipment {

    private int id;
    private int gasTankSize;
    private int currentGasAmount;
    private int truckID;

    public Equipment(int id, int gasTankSize, int currentGasAmount, int truckID) {
        this.id = id;
        this.gasTankSize = gasTankSize;
        this.currentGasAmount = currentGasAmount;
        this.truckID = truckID;
    }

    public Equipment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGasTankSize() {
        return gasTankSize;
    }

    public void setGasTankSize(int gasTankSize) {
        this.gasTankSize = gasTankSize;
    }

    public int getCurrentGasAmount() {
        return currentGasAmount;
    }

    public void setCurrentGasAmount(int currentGasAmount) {
        this.currentGasAmount = currentGasAmount;
    }

    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }
}
