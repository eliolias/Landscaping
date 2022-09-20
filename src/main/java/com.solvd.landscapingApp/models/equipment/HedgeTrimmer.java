package com.solvd.landscapingApp.models.equipment;

public class HedgeTrimmer extends Equipment{

    private String model;
    private boolean isElectric;

    public HedgeTrimmer(int id, int gasTankSize, int currentGasAmount, int truckID, String model, boolean isElectric) {
        super(id, gasTankSize, currentGasAmount, truckID);
        this.model = model;
        this.isElectric = isElectric;
    }

    public HedgeTrimmer() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    @Override
    public String toString() {
        return "HedgeTrimmer{" +
                "model='" + model + '\'' +
                ", isElectric=" + isElectric +
                '}';
    }
}
