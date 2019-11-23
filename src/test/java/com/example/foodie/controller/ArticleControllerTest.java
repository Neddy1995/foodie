package com.example.foodie.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.Article;
import com.example.foodie.bean.ArticleType;
import com.example.foodie.service.ArticleService;
import com.example.foodie.vo.ArticleTypePictureVo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = FoodieApplicationTest.class)
@AutoConfigureMockMvc
class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    //    不执行的类
//    @MockBean
//    private ArticleService articleService;

    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() throws Exception {
//        初始化MockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void insertArticle() throws Exception {
        Article article = new Article("2","2","2","026032202723");
        article.setAuthor("12");
        ArticleType articleType = new ArticleType();
        articleType.setType1("2");
        articleType.setType2("2");
        List<String> list = new ArrayList<>();
        list.add("2");

        ArticleTypePictureVo articleTypePictureVo = new ArticleTypePictureVo(article,articleType,list);
        MvcResult mvcResult = mockMvc.perform(
                post("/insertArticle.do")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(articleTypePictureVo))
        ).andReturn();
        System.out.println("返回的JSON"+mvcResult.getResponse().getContentAsString());
    }

    @Test
    void deleteArticle() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                post("deleteArticle.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("articleId","2")
        ).andReturn();
        System.out.println("返回的JSON"+mvcResult.getResponse().getContentAsString());
    }

    @Test
    void updateArticle() throws Exception {
        Article article = new Article("2","2","2","026032202723");
        article.setArticleId("2");
        ArticleType articleType = new ArticleType();
        articleType.setType1("2");
        articleType.setType2("2");
        List<String> list = new ArrayList<>();
        list.add("3");

        ArticleTypePictureVo articleTypePictureVo = new ArticleTypePictureVo(article,articleType,list);

        MvcResult mvcResult = mockMvc.perform(
                post("/updateArticle.do")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSONObject.toJSONString(articleTypePictureVo))
        ).andReturn();
        System.out.println("返回的JSON"+mvcResult.getResponse().getContentAsString());
    }
}