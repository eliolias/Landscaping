package com.solvd.landscapingApp.models;

public class Employees {
    private int id;
    private String name;
    private double payRate;
    private boolean canMow;
    private boolean canDrive;
    private int companyID;

    public Employees(int id, String name, double payRate, boolean canMow, boolean canDrive, int companyID) {
        this.id = id;
        this.name = name;
        this.payRate = payRate;
        this.canMow = canMow;
        this.canDrive = canDrive;
        this.companyID = companyID;
    }

    public Employees() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public boolean isCanMow() {
        return canMow;
    }

    public void setCanMow(boolean canMow) {
        this.canMow = canMow;
    }

    public boolean isCanDrive() {
        return canDrive;
    }

    public void setCanDrive(boolean canDrive) {
        this.canDrive = canDrive;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", payRate=" + payRate +
                ", canMow=" + canMow +
                ", canDrive=" + canDrive +
                ", companyID=" + companyID +
                '}';
    }
}
