package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class LikeServiceTest {

    @Autowired
    private LikeService likeService;

    @Test
    void insertLike() {
        String userId = "26407398717521924";
        String articleId = "26407398717521929";
        likeService.insertLike(userId,articleId);
    }

    @Test
    void selectLikeNum() {
        String articleId = "26407398717521929";
        System.out.println("" + likeService.selectLikeNum(articleId));
    }

    @Test
    void deleteLike() {
        String userId = "26407398717521924";
        String articleId = "26407398717521929";
        likeService.deleteLike(userId,articleId);
    }
}