package com.solvd.landscapingApp.models.equipment;

public class GasCan extends Equipment{
    private boolean isFull;

    public GasCan(int id, int gasTankSize, int currentGasAmount, int truckID, boolean isFull) {
        super(id, gasTankSize, currentGasAmount, truckID);
        this.isFull = isFull;
    }

    public GasCan() {
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "GasCan{" +
                "isFull=" + isFull +
                '}';
    }
}
