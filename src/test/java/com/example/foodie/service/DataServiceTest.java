package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.DataBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class DataServiceTest {

    @Autowired
    private DataService dataService;
    @Test
    void selectLikeNumByDay() {
            List<DataBean> list = dataService.selectLikeNumByDay(new Date());
            System.out.println(""+list.toString());
    }

    @Test
    void selectCommentNumByDay() {
    }

    @Test
    void selectFollowNumByDay() {
    }

    @Test
    void selectArticleNumByDay() {
    }

    @Test
    void selectPassNumByDay() {
    }

    @Test
    void selectAuditNumByDay() {
    }

    @Test
    void selectLikeNumByMonth() {
    }

    @Test
    void selectCommentNumByMonth() {
    }

    @Test
    void selectFollowNumByMonth() {
    }

    @Test
    void selectArticleNumByMonth() {
    }

    @Test
    void selectPassNumByMonth() {
    }

    @Test
    void selectAuditNumByMonth() {
    }
}