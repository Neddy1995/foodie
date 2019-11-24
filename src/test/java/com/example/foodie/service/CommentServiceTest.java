package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("测试CommentService的insertComment方法")
    void insertComment() {
        Comment comment = new Comment("1","12","1234");
        commentService.insertComment(comment);
    }

    @Test
    void selectByArticleId() {
        List<Comment> list = commentService.selectByArticleId("1");
        System.out.println("返回的JSON" + list.toString());
    }

    @Test
    void deleteComment() {
        commentService.deleteComment("26407398717521933");
    }

    @Test
    void updateComment() {
        Comment comment = new Comment("26407398717521933","1","12","abcd");
        commentService.updateComment(comment);
    }
}