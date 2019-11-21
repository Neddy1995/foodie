package com.example.foodie.controller;

import com.example.foodie.service.ArticleService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ControllerResult selectByStreet(HttpServletRequest request,
                                          @RequestParam("street_id")String street_id){
        articleService.selectByStreet(street_id);
    }
}
