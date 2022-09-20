package com.solvd.landscapingApp.models.equipment;

import java.util.Date;

public class Chainsaw extends Equipment{

    private String model;
    private Date lastChainMaintenance;
    private Date nextChainMaintenance;

    public Chainsaw(int id, int gasTankSize, int currentGasAmount, int truckID, String model, Date lastChainMaintenance, Date nextChainMaintenance) {
        super(id, gasTankSize, currentGasAmount, truckID);
        this.model = model;
        this.lastChainMaintenance = lastChainMaintenance;
        this.nextChainMaintenance = nextChainMaintenance;
    }

    public Chainsaw() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getLastChainMaintenance() {
        return lastChainMaintenance;
    }

    public void setLastChainMaintenance(Date lastChainMaintenance) {
        this.lastChainMaintenance = lastChainMaintenance;
    }

    public Date getNextChainMaintenance() {
        return nextChainMaintenance;
    }

    public void setNextChainMaintenance(Date nextChainMaintenance) {
        this.nextChainMaintenance = nextChainMaintenance;
    }

    @Override
    public String toString() {
        return "Chainsaw{" +
                "model='" + model + '\'' +
                ", lastChainMaintenance=" + lastChainMaintenance +
                ", nextChainMaintenance=" + nextChainMaintenance +
                '}';
    }
}
