package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    @DisplayName("测试ArticleService的根据区县查询文章的标题和图片selectByStreet方法")
    void selectByStreet() {
        String streetId = "026032202723";
        System.out.println("返回的对象"+articleService.selectByStreet(streetId).toString());
    }

    @Test
    @DisplayName("测试ArticleService的根据类型查询文章的标题和图片selectByType方法")
    void selectByType() {
        String typeId = "1";
        System.out.println("返回的对象"+articleService.selectByType(typeId).toString());
    }

    @Test
    @DisplayName("测试ArticleService的搜索查询文章的标题和图片selectByText方法")
    void selectByText() {
        String text = "1";
        System.out.println("返回的对象"+articleService.selectByText(text).toString());
    }

    @Test
    @DisplayName("测试ArticleService的根据多个文章id查询文章的标题和图片（评论和关注使用）selectByArticleList方法")
    void selectByArticleList() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        System.out.println(""+ articleService.selectByArticleList(list));
    }

    @Test
    @DisplayName("测试ArticleService的根据文章id查询文章内容selectById方法")
    void selectById() {
        String articleId = "1";
        System.out.println("返回的对象"+articleService.selectById(articleId).toString());
    }

//    增，删，改直接测试controller
}