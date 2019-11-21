package com.example.foodie.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.foodie.FoodieApplicationTests;
import com.example.foodie.bean.User;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = FoodieApplicationTests.class)
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

//    不执行的类
//    @MockBean
//    private UserService userService;



    @Before()  //这个方法在每个方法执行之前都会执行一遍
    public void setup() throws Exception {
//        初始化MockMvc对象
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        System.out.println("开始测试");
    }

    @Test
    @DisplayName("测试UserController的login方法")
    void login() throws Exception {
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("userName","12");
        map.add("password","11");
        map.add("paramCode","");
        MvcResult mvcResult =  mockMvc.perform(
                post("/login.do")//请求的url,请求的方法是post
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)//数据的格式
                        .params(map))//添加参数
                .andReturn();
        System.out.println("返回的json" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("测试UserController的register方法")
    void register() throws Exception {
        User user = new User("12","11",1);
        MvcResult mvcResult = mockMvc.perform(
                post("/register.do")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(user))
        ).andReturn();
        System.out.println("返回的json" + mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("测试UserController的selectUser方法")
    void selectUser() throws Exception {
        login();
        MvcResult mvcResult = mockMvc.perform(
                get("/selectUser.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andReturn();
        System.out.println("返回的JSON" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("测试UserController的updateUser方法")
    void updateUser() throws Exception {
        User user = new User();
        user.setUserProfile("2");
        MvcResult mvcResult = mockMvc.perform(
                post("/updateUser.do")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JSONObject.toJSONString(user))
        ).andReturn();
        System.out.println("返回的JSON"+mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("测试UserController的updatePassword方法")
    void updatePassword() throws Exception {
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("password","1");
        map.add("passwordNow","1");
        MvcResult mvcResult = mockMvc.perform(
                post("/updatePassword.do")
                .contentType(MediaType.APPLICATION_JSON)
                .params(map)
        ).andReturn();
        System.out.println("返回的JSON" + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("测试UserController的logout方法")
    void logout() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/logout.do")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        ).andReturn();
        System.out.println("返回的JSON" + mvcResult.getResponse().getContentAsString());

    }
}