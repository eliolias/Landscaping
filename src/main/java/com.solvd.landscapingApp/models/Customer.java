package com.solvd.landscapingApp.models;

import java.util.List;

public class Customer {
    private int id;
    private String name;
    private int routeID;

    public Customer(int id, String name, int routeID) {
        this.id = id;
        this.name = name;
        this.routeID = routeID;
    }

    public Customer() {
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

    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", routeID=" + routeID +
                '}';
    }
}
