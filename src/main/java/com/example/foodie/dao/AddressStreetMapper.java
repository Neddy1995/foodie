package com.example.foodie.dao;

import com.example.foodie.bean.AddressStreet;

public interface AddressStreetMapper {
    int deleteByPrimaryKey(String streetId);

    int insert(AddressStreet record);

    int insertSelective(AddressStreet record);

    AddressStreet selectByPrimaryKey(String streetId);

    int updateByPrimaryKeySelective(AddressStreet record);

    int updateByPrimaryKey(AddressStreet record);
}