package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    void selectByStreet() {
        String streetId = "026032202723";
        System.out.println("返回的对象"+articleService.selectByStreet(streetId).toString());
    }

    @Test
    void selectByType() {
        String typeId = "1";
        System.out.println("返回的对象"+articleService.selectByType(typeId).toString());
    }

    @Test
    void selectByText() {
    }

    @Test
    void selectById() {
    }
}