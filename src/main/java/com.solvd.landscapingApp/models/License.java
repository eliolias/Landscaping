package com.solvd.landscapingApp.models;

import java.util.Date;

public class License {

    private int id;
    private String type;
    private Date expDate;
    private int employeeID;

    public License(int id, String type, Date expDate, int employeeID) {
        this.id = id;
        this.type = type;
        this.expDate = expDate;
        this.employeeID = employeeID;
    }

    public License() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Licenses{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", expDate=" + expDate +
                ", employeeID=" + employeeID +
                '}';
    }
}
