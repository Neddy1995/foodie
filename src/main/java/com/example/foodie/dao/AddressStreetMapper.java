package com.example.foodie.dao;

import com.example.foodie.bean.AddressStreet;

public interface AddressStreetMapper {
    int deleteByPrimaryKey(String streetId);

    int insert(AddressStreet record);

    int insertSelective(AddressStreet record);
}