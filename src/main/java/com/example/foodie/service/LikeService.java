package com.example.foodie.service;

import java.util.List;

public interface LikeService {

    /**
     * 根据用户id查询收藏的文章id
     * @param userId
     * @return
     */
    List<String> selectByUserId(String userId);
}
