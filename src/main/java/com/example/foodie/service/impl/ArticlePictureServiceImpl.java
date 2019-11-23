package com.example.foodie.service.impl;

import com.example.foodie.bean.ArticlePicture;
import com.example.foodie.dao.ArticlePictureMapper;
import com.example.foodie.service.ArticlePictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlePictureServiceImpl implements ArticlePictureService {

    @Autowired
    private ArticlePictureMapper articlePictureMapper;
    @Override
    public void insertArticlePicture(String articleId, List<String> list) {
        for (String pictureId: list) {
            ArticlePicture articlePicture = new ArticlePicture(articleId,pictureId);
            articlePictureMapper.insert(articlePicture);
        }
    }

    @Override
    public void deleteArticlePicture(String articleId) {
        articlePictureMapper.deleteByaArticleId(articleId);
    }

    @Override
    public void updateArticlePicture(String articleId, List<String> list) {
        articlePictureMapper.deleteByaArticleId(articleId);
        for (String pictureId:list) {
            ArticlePicture articlePicture = new ArticlePicture(articleId,pictureId);
            articlePictureMapper.insert(articlePicture);
        }
    }
}
