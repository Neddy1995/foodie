package com.example.foodie.dao;

import com.example.foodie.bean.Comment;
import com.example.foodie.bean.DataBean;
import com.example.foodie.vo.CommentVo;

import java.util.Date;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(String commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<String> selectByUserId(String userId);

    List<CommentVo> selectByArticleId(String articleId);

    List<DataBean> selectCommentNumByDay(String dateDay);

    List<DataBean> selectCommentNumByMonth(String dateMonth);

    int selectCommentNum(String articleId);
}