package com.example.foodie.service.impl;

import com.example.foodie.bean.Comment;
import com.example.foodie.dao.CommentMapper;
import com.example.foodie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<String> selectByUserId(String userId) {
        return commentMapper.selectByUserId(userId);
    }

    @Override
    public void insertComment(Comment comment) {
        comment.setCommentTime(new Date());
        commentMapper.insertSelective(comment);
    }

    @Override
    public List<Comment> selectByArticleId(String articleId) {
        return commentMapper.selectByArticleId(articleId);
    }

    @Override
    public void deleteComment(String commentId) {
        commentMapper.deleteByPrimaryKey(commentId);

    }

    @Override
    public void updateComment(Comment comment) {
        comment.setCommentTime(new Date());
        commentMapper.updateByPrimaryKeySelective(comment);
    }
}
