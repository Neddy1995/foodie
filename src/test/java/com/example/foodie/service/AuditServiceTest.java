package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.AuditArticle;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class AuditServiceTest {

    @Autowired
    private AuditService auditService;

    @Test
    @DisplayName("测试AuditService的查询需要审核的文章的标题和图片selectAuditArticle方法")
    void selectAuditArticle() {
        System.out.println(""+auditService.selectAuditArticle().toString());
    }

    @Test
    @DisplayName("测试AuditService的查询该管理员审核的文章selectPassArticle方法")
    void selectPassArticle() {
        String userId = "1";
        System.out.println(""+auditService.selectPassArticle(userId).toString());
    }

    @Test
    @DisplayName("测试AuditService的审核通过insertAuditArticle方法")
    void insertAuditArticle() {
        AuditArticle auditArticle = new AuditArticle("26407398717521929","通过","1");
        auditService.insertAuditArticle(auditArticle,"1");
    }
}