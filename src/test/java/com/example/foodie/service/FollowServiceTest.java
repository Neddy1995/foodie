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
class FollowServiceTest {

    @Autowired
    private FollowService followService;

    @Test
    void insertFollow() {
        String userId = "26407398717521924";
        String articleId = "26407398717521929";
        followService.insertFollow(userId,articleId);
    }

    @Test
    void selectFollowNum() {
        String articleId = "26407398717521929";
        System.out.println("" + followService.selectFollowNum(articleId));
    }

    @Test
    void deleteFollow() {
        String userId = "26407398717521924";
        String articleId = "26407398717521929";
        followService.deleteFollow(userId,articleId);
    }
}