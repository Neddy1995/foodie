package com.example.foodie.controller;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.AddressStreet;
import com.example.foodie.bean.Province;
import com.example.foodie.service.AddressService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 查询省份
     * @return
     */
    @GetMapping("/selectProvince.do")
    public ControllerResult selectProvince(){
        List<Province> provinces = addressService.selectProvince();
        return ControllerResult.createSuccess("查询省份成功",provinces);
    }

    /**
     * 根据省份查询城市
     * @param provinceId
     * @return
     */
    @PostMapping("/selectCityByProvince.do")
    public ControllerResult selectCityByProvince(@RequestParam("provinceId")String provinceId){
        List<AddressCity> addressCities = addressService.selectCityByProvince(provinceId);
        System.out.println(""+provinceId);
        return ControllerResult.createSuccess("查询城市成功",addressCities);
    }

    /**
     * 查询城市
     * @param cityId
     * @return
     */
    @PostMapping("/selectCity.do")
    public ControllerResult selectCity(@RequestParam("cityId")String cityId){
        AddressCity addressCity = addressService.selectCity(cityId);
        return ControllerResult.createSuccess("查询城市成功",addressCity);
    }

    /**
     * 查询区县
     * @param cityId
     * @return
     */
    @PostMapping("/selectStreet.do")
    public ControllerResult selectStreet(@RequestParam("cityId")String cityId){
        List<AddressStreet> addressStreet = addressService.selectStreet(cityId);
        return ControllerResult.createSuccess("查询区县成功",addressStreet);
    }

}
