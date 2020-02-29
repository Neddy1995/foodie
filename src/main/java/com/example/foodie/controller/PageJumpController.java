package com.example.foodie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图跳转的controller
 */


@Controller
public class PageJumpController {

    /**
     * 跳转到系统首页
     * @return
     */
    @RequestMapping("/index.h")
    public String index(){
        return "index";
    }

    /**
     * 跳转到附近页面
     * @return
     */
    @RequestMapping("/nearby.h")
    public String nearby(){
        return "nearby";
    }

    /**
     * 跳转到美食界面
     * @return
     */
    @RequestMapping("/delicious.h")
    public String delicious(){
        return "delicious";
    }

    /**
     * 跳转到甜品界面
     * @return
     */
    @RequestMapping("/sweetmeats.h")
    public String dessert(){
        return "sweetmeats";
    }

    /**
     * 跳转到用户界面
     * @return
     */
    @RequestMapping("/information.h")
    public String user(){
        return "information";
    }
    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("/login.h")
    public String login(){
        return "login";
    }


    /**
     * 跳转到注册界面
     * @return
     */
    @RequestMapping("/register.h")
    public String register(){
        return "register";
    }

    /**
     * 跳转到创建文章界面
     * @return
     */
    @RequestMapping("/createArticle.h")
    public String createArticle(){
        return "createArticle";
    }

}
