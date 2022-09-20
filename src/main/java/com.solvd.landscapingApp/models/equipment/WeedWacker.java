package com.solvd.landscapingApp.models.equipment;

public class WeedWacker extends Equipment{

    private String model;
    private String bladeType;

    public WeedWacker(int id, int gasTankSize, int currentGasAmount, int truckID, String model, String bladeType) {
        super(id, gasTankSize, currentGasAmount, truckID);
        this.model = model;
        this.bladeType = bladeType;
    }

    public WeedWacker() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBladeType() {
        return bladeType;
    }

    public void setBladeType(String bladeType) {
        this.bladeType = bladeType;
    }

    @Override
    public String toString() {
        return "WeedWacker{" +
                "model='" + model + '\'' +
                ", bladeType='" + bladeType + '\'' +
                '}';
    }
}
