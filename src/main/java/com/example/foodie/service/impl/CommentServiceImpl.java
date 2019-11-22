package com.example.foodie.service.impl;

import com.example.foodie.dao.CommentMapper;
import com.example.foodie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<String> selectByUserId(String userId) {
        return commentMapper.selectByUserId(userId);
    }
}
