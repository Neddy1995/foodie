package com.example.foodie.service.impl;

import com.example.foodie.dao.ArticleMapper;
import com.example.foodie.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void selectByStreet(String street_id) {

    }
}
