package com.example.foodie.service.impl;

import com.example.foodie.dao.LikeMapper;
import com.example.foodie.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public List<String> selectByUserId(String userId) {
        return likeMapper.selectByUserId(userId);
    }
}
