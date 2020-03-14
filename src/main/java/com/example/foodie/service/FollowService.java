package com.example.foodie.service;

import java.util.List;

public interface FollowService {

    /**
     * 添加一条收藏记录
     * @param userId
     * @param articleId
     */
    void insertFollow(String userId, String articleId);

    /**
     * 查询文章收藏数
     * @param articleId
     * @return
     */
    int selectFollowNum(String articleId);

    /**
     * 删除一条收藏记录
     * @param userId
     * @param articleId
     */
    void deleteFollow(String userId,String articleId);

    /**
     * 查询收藏记录
     * @param userId
     * @return
     */
    List<String> selectByUserId(String userId);
}
