package com.example.foodie.service;

import java.util.List;

public interface ArticlePictureService {

    /**
     * 插入图片
     * @param articleId
     * @param list
     */
    void insertArticlePicture(String articleId, List<String> list);

    /**
     * 删除图片
     * @param articleId
     */
    void deleteArticlePicture(String articleId);

    /**
     * 修改图片
     * @param articleId
     * @param list
     */
    void updateArticlePicture(String articleId, List<String> list);
}
