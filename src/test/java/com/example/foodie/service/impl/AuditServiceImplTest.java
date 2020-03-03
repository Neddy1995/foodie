package com.example.foodie.service.impl;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.service.AuditService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class AuditServiceImplTest {

    @Autowired
    private AuditService auditService;

    @Test
    void selectPassArticle() {
        System.out.println(""+auditService.selectPassArticle("1"));
    }

    @Test
    void insertAuditArticle() {
    }
}