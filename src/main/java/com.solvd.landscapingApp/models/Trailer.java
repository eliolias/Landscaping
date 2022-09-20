package com.solvd.landscapingApp.models;

public class Trailer {
    private int id;
    private String licensePlate;
    private int length;
    private int truckID;

    public Trailer(int id, String licensePlate, int length, int truckID) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.length = length;
        this.truckID = truckID;
    }

    public Trailer() {
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", length=" + length +
                ", truckID=" + truckID +
                '}';
    }
}
