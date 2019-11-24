package com.example.foodie.service;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.AddressStreet;

import java.util.List;

public interface AddressService {

    /**
     * 查询城市
     * @return
     */
    List<AddressCity> selectCity();

    /**
     * 查询区县
     * @param cityId
     * @return
     */
    List<AddressStreet> selectStreet(String cityId);
}
