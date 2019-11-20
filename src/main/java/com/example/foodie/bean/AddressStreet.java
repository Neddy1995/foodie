package com.example.foodie.bean;

public class AddressStreet {
    private String streetId;

    private String cityId;

    private String streeName;

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

    public String getStreeName() {
        return streeName;
    }

    public void setStreeName(String streeName) {
        this.streeName = streeName == null ? null : streeName.trim();
    }
}