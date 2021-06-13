package com.sultanseidov.parkingapp.model;


import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    private String userName;

    @SerializedName("email")
    private String userEmail;

    @SerializedName("phone_number")
    private String userPhoneNumber;

    @SerializedName("vehicle_number")
    private String userVehicleNumber;

    @SerializedName("vehicle_type")
    private String userVehicleType;

    @SerializedName("password")
    private String password;

    public User() {
    }

    public User(String userName, String userEmail, String userPhoneNumber, String userVehicleNumber, String userVehicleType, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userVehicleNumber = userVehicleNumber;
        this.userVehicleType = userVehicleType;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserVehicleNumber() {
        return userVehicleNumber;
    }

    public void setUserVehicleNumber(String userVehicleNumber) {
        this.userVehicleNumber = userVehicleNumber;
    }

    public String getUserVehicleType() {
        return userVehicleType;
    }

    public void setUserVehicleType(String userVehicleType) {
        this.userVehicleType = userVehicleType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
