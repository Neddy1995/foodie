package com.example.foodie.dao;

import com.example.foodie.bean.AddressCity;

public interface AddressCityMapper {
    int deleteByPrimaryKey(Integer cityId);

    int insert(AddressCity record);

    int insertSelective(AddressCity record);

    AddressCity selectByPrimaryKey(Integer cityId);

    int updateByPrimaryKeySelective(AddressCity record);

    int updateByPrimaryKey(AddressCity record);
}