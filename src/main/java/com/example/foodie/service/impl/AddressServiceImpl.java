package com.example.foodie.service.impl;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.AddressStreet;
import com.example.foodie.dao.AddressCityMapper;
import com.example.foodie.dao.AddressStreetMapper;
import com.example.foodie.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressCityMapper addressCityMapper;

    @Autowired
    private AddressStreetMapper addressStreetMapper;

    @Override
    public List<AddressCity> selectCity() {
        return addressCityMapper.selectAllCity();
    }

    @Override
    public List<AddressStreet> selectStreet(String cityId) {
        return addressStreetMapper.selectByCityId(cityId);
    }
}
