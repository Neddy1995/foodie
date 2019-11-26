package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.AuditArticle;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
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
    void selectAuditArticle() {
        System.out.println(""+auditService.selectAuditArticle().toString());
    }

    @Test
    void selectPassArticle() {
        String userId = "1";
        System.out.println(""+auditService.selectPassArticle(userId).toString());
    }

    @Test
    void insertAuditArticle() {
        AuditArticle auditArticle = new AuditArticle("26407398717521929","通过","1");
        auditService.insertAuditArticle(auditArticle);
    }
}