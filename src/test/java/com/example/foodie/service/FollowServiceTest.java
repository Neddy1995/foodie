package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("测试FollowService的新增关注insertFollow方法")
    void insertFollow() {
        String userId = "26407398717521924";
        String articleId = "26407398717521929";
        followService.insertFollow(userId,articleId);
    }

    @Test
    @DisplayName("测试FollowService的查询文章的关注数量selectFollowNum方法")
    void selectFollowNum() {
        String articleId = "26407398717521929";
        System.out.println("" + followService.selectFollowNum(articleId));
    }

    @Test
    @DisplayName("测试FollowService的取消关注deleteFollow方法")
    void deleteFollow() {
        String userId = "26407398717521924";
        String articleId = "26407398717521929";
        followService.deleteFollow(userId,articleId);
    }
}