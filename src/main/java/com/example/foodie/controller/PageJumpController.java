package com.example.foodie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 视图跳转的controller
 */


@Controller
public class PageJumpController {

    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("/login.h")
    public String login(){
        return "login";
    }

    /**
     * 跳转到系统首页
     * @return
     */
    @RequestMapping("/index.h")
    public String index(){
        return "index";
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
     * 跳转到购物车界面
     * @return
     */
    @RequestMapping("/shoppingCart.h")
    public String shoppingCart(){
        return "shoppingCart";
    }

    /**
     * 跳转到收藏夹界面
     * @return
     */
    @RequestMapping("/favorite.h")
    public String favorite(){
        return "favorite";
    }

    /**
     * 跳转到用户界面
     * @return
     */
    @RequestMapping("/user.h")
    public String user(){
        return "user";
    }

    @RequestMapping("/analysis.h")
    public String analysis(){
        return "analysis";
    }
}
