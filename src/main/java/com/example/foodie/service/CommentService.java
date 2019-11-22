package com.example.foodie.service;

import java.util.List;

public interface CommentService {

    /**
     * 根据用户id查询评论的文章id
     * @param userId
     * @return
     */
    List<String> selectByUserId(String userId);
}
