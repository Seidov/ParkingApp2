package com.sultanseidov.parkingapp.model;

public class ParkingLotItemModel {
    private int id;
    private String name;
    private String hourlyRate;
    private String distance;
    private String freeArea;

    public ParkingLotItemModel() {
    }

    public ParkingLotItemModel(int id, String name, String hourlyRate, String distance, String freeArea) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.distance = distance;
        this.freeArea = freeArea;
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

    public String getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(String hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFreeArea() {
        return freeArea;
    }

    public void setFreeArea(String freeArea) {
        this.freeArea = freeArea;
    }
}
