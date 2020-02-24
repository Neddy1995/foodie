package com.example.foodie.service;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.AddressStreet;
import com.example.foodie.bean.Province;

import java.util.List;
import java.util.Set;

public interface AddressService {

    /**
     * 查询省份
     * @return
     */
    List<Province> selectProvince();

    /**
     * 查询城市
     * @return
     */
    List<AddressCity> selectCity(String provinceId);

    /**
     * 查询区县
     * @param cityId
     * @return
     */
    List<AddressStreet> selectStreet(String cityId);

}
