package com.example.foodie.service;

import java.util.List;

public interface LikeService {

    /**
     * 根据用户id查询收藏的文章id
     * @param userId
     * @return
     */
    List<String> selectByUserId(String userId);

    /**
     * 插入一条记录
     * @param userId
     * @param articleId
     */
    void insertLike(String userId, String articleId);

    /**
     * 查询文章的点赞数
     * @param articleId
     * @return
     */
    int selectLikeNum(String articleId);

    /**
     * 删除一条记录
     * @param userId
     * @param articleId
     */
    void deleteLike(String userId, String articleId);
}
