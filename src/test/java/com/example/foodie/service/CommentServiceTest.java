package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.Comment;
import com.example.foodie.vo.CommentVo;
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
    @DisplayName("测试CommentService的新增评论insertComment方法")
    void insertComment() {
        Comment comment = new Comment("1","12","1234");
        commentService.insertComment(comment);
    }

    @Test
    @DisplayName("测试CommentService的根据文章id查询评论selectByArticleId方法")
    void selectByArticleId() {
        List<CommentVo> list = commentService.selectByArticleId("26577884424437794");
        System.out.println("返回的JSON" + list.toString());
    }

    @Test
    @DisplayName("测试CommentService的删除评论deleteComment方法")
    void deleteComment() {
        commentService.deleteComment("26407398717521933");
    }

    @Test
    @DisplayName("测试CommentService的修改评论updateComment方法")
    void updateComment() {
        Comment comment = new Comment("26407398717521933","1","12","abcd");
        commentService.updateComment(comment);
    }

    @Test
    @DisplayName("测试CommentService的查询评论数selectCommentNum方法")
    void selectCommentNum(){
        System.out.println(""+commentService.selectCommentNum("1"));
    }
}