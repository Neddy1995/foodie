package com.example.foodie.bean;

import java.util.List;

public class AddressStreet {
    private String streetId;

    private String cityId;

    private String streetName;

    public String getStreetId() {
        return streetId;
    }

    public void setStreetId(String streetId) {
        this.streetId = streetId == null ? null : streetId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getstreetName() {
        return streetName;
    }

    public void setstreetName(String streetName) {
        this.streetName = streetName == null ? null : streetName.trim();
    }

    @Override
    public String toString() {
        return "AddressStreet{" +
                "streetId='" + streetId + '\'' +
                ", cityId='" + cityId + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}