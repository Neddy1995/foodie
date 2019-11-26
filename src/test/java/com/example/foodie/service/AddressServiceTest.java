package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @Test
    @DisplayName("测试AddressService的查询城市信息selectCity方法")
    void selectCity() {
        System.out.println(""+addressService.selectCity().toString());
    }

    @Test
    @DisplayName("测试AddressService的查询曲线信息selectStreet方法")
    void selectStreet() {
        String cityId = "0260322";
        System.out.println(""+addressService.selectStreet(cityId).toString());
    }
}