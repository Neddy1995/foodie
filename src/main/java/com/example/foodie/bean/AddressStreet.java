package com.example.foodie.bean;

public class AddressStreet {
    private String streetId;

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId == null ? null : streetId.trim();
    }
}