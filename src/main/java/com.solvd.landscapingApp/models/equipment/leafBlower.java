package com.solvd.landscapingApp.models.equipment;

public class leafBlower extends Equipment{
    private String model;
    private int CFM;

    public leafBlower(int id, int gasTankSize, int currentGasAmount, int truckID, String model, int CFM) {
        super(id, gasTankSize, currentGasAmount, truckID);
        this.model = model;
        this.CFM = CFM;
    }

    public leafBlower() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCFM() {
        return CFM;
    }

    public void setCFM(int CFM) {
        this.CFM = CFM;
    }

    @Override
    public String toString() {
        return "leafBlower{" +
                "model='" + model + '\'' +
                ", CFM=" + CFM +
                '}';
    }
}
