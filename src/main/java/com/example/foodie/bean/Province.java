package com.example.foodie.bean;

public class Province {
    private String provinceId;
    private String province;

    public String getprovinceId() {
        return provinceId;
    }

    public void setprovinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceId='" + provinceId + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
