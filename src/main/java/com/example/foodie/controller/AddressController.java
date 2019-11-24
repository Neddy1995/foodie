package com.example.foodie.controller;

import com.example.foodie.bean.AddressCity;
import com.example.foodie.bean.AddressStreet;
import com.example.foodie.service.AddressService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 查询城市
     * @return
     */
    @GetMapping("/selectCity.do")
    public ControllerResult selectCity(){
        List<AddressCity> addressCity = addressService.selectCity();
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
