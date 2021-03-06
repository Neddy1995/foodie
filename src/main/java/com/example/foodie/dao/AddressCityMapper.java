package com.example.foodie.dao;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.Province;

import java.util.List;

public interface AddressCityMapper {
    int deleteByPrimaryKey(String cityId);

    int insert(AddressCity record);

    int insertSelective(AddressCity record);

    AddressCity selectByPrimaryKey(String cityId);

    int updateByPrimaryKeySelective(AddressCity record);

    int updateByPrimaryKey(AddressCity record);

    List<AddressCity> selectAllCity();

//    List<Province> selectProvince();

    List<AddressCity> selectCity(String provinceId);
}