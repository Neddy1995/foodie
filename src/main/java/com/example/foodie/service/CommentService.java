package com.example.foodie.service;

import com.example.foodie.bean.Comment;
import com.example.foodie.vo.CommentVo;

import java.util.List;

public interface CommentService {

    /**
     * 根据用户id查询评论的文章id
     * @param userId
     * @return
     */
    List<String> selectByUserId(String userId);

    /**
     * 插入一条评论
     * @param comment
     */
    void insertComment(Comment comment);

    /**
     * 查询文章的评论
     * @param articleId
     * @return
     */
    List<CommentVo> selectByArticleId(String articleId);

    /**
     * 删除评论
     * @param commentId
     */
    void deleteComment(String commentId);

    /**
     * 修改评论
     * @param comment
     */
    void updateComment(Comment comment);

    /**
     * 查询评论数
     * @param articleId
     * @return
     */
    int selectCommentNum(String articleId);
}
