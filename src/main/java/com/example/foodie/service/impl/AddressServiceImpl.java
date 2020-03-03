package com.example.foodie.service.impl;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.AddressStreet;
import com.example.foodie.bean.Province;
import com.example.foodie.dao.AddressCityMapper;
import com.example.foodie.dao.AddressStreetMapper;
import com.example.foodie.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressCityMapper addressCityMapper;

    @Autowired
    private AddressStreetMapper addressStreetMapper;

    @Override
    public List<Province> selectProvince() {
        List<AddressCity> lists = addressCityMapper.selectAllCity();
        List<Province> list = new ArrayList<>();
        Set<Map> set = new HashSet<>();
        for(AddressCity addressCity:lists){
            Map<String,String> map = new HashMap<>();
            map.put(addressCity.getCityId().substring(0,3),addressCity.getProvince());
            set.add(map);
        }
        for (Map<String,String> map:set) {
            Province province = new Province();
            for(String key :map.keySet()){
                province.setprovinceId(key);
                province.setProvince(map.get(key));
            }
            list.add(province);
        }
        System.out.println(""+list.size());
        return list;
    }

    @Override
    public List<AddressCity> selectCityByProvince(String provinceId) {
        return addressCityMapper.selectCity(provinceId);
    }

    @Override
    public List<AddressStreet> selectStreet(String cityId) {
        return addressStreetMapper.selectByCityId(cityId);
    }

    @Override
    public AddressCity selectCity(String cityId) {
        return addressCityMapper.selectByPrimaryKey(cityId);
    }

    @Override
    public String selectAllByStreet(String streetId) {
        AddressCity addressCity = addressCityMapper.selectByPrimaryKey(streetId.substring(0,7));
        AddressStreet addressStreet = addressStreetMapper.selectByPrimaryKey(streetId);
        String cityAndStreet = addressCity.getProvince()+addressCity.getCity()+addressStreet.getstreetName();
        return cityAndStreet;
    }
}
