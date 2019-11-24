package com.example.foodie.service.impl;

import com.example.foodie.bean.Follow;
import com.example.foodie.dao.FollowMapper;
import com.example.foodie.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public void insertFollow(String userId, String articleId) {
        Follow follow = new Follow(articleId,userId,new Date());
        followMapper.insertSelective(follow);
    }

    @Override
    public int selectFollowNum(String articleId) {
        return followMapper.selectFollowNum(articleId);
    }

    @Override
    public void deleteFollow(String userId,String articleId) {
        Follow follow = new Follow();
        follow.setArticleId(articleId);
        follow.setUserId(userId);
        followMapper.deleteFollow(follow);
    }
}
