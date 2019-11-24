package com.example.foodie.service.impl;

import com.example.foodie.bean.Like;
import com.example.foodie.dao.LikeMapper;
import com.example.foodie.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public List<String> selectByUserId(String userId) {
        return likeMapper.selectByUserId(userId);
    }

    @Override
    public void insertLike(String userId, String articleId) {
        Like like = new Like(articleId,userId,new Date());
        likeMapper.insertSelective(like);
    }

    @Override
    public int selectLikeNum(String articleId) {
        return likeMapper.selectLikeNum(articleId);
    }

    @Override
    public void deleteLike(String userId, String articleId) {
        Like like = new Like();
        like.setArticleId(articleId);
        like.setUserId(userId);
        likeMapper.deleteLike(like);
    }
}
