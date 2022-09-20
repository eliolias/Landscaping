package com.solvd.landscapingApp.models;

public class LawnMower {

    private int id;
    private String model;
    private int deckSize;
    private int gasTankSize;
    private int currentGasAmount;
    private int trailerID;

    public LawnMower(int id, String model, int deckSize, int gasTankSize, int currentGasAmount, int trailerID) {
        this.id = id;
        this.model = model;
        this.deckSize = deckSize;
        this.gasTankSize = gasTankSize;
        this.currentGasAmount = currentGasAmount;
        this.trailerID = trailerID;
    }

    public LawnMower() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
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

    public int getTrailerID() {
        return trailerID;
    }

    public void setTrailerID(int trailerID) {
        this.trailerID = trailerID;
    }

    @Override
    public String toString() {
        return "LawnMower{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", deckSize=" + deckSize +
                ", gasTankSize=" + gasTankSize +
                ", currentGasAmount=" + currentGasAmount +
                ", trailerID=" + trailerID +
                '}';
    }
}
