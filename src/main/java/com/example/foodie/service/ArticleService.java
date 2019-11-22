package com.example.foodie.service;

import com.example.foodie.vo.ArticleVo;
import com.example.foodie.vo.TitleAndPictureVo;

import java.util.List;

public interface ArticleService {

    /**
     * 根据地址ID查询文章的标题和图片的路径
     * @param streetId
     * @return
     */
    List<TitleAndPictureVo> selectByStreet(String streetId);


    /**
     * 根据类型ID查询文章的标题和图片的路径
     * @param typeId
     * @return
     */
    List<TitleAndPictureVo> selectByType(String typeId);

    /**
     * 根据搜索内容查询文章标题和图片路径
     * @param text
     * @return
     */
    List<TitleAndPictureVo> selectByText(String text);


    /**
     * 根据id查询文章内容
     * @param articleId
     * @return
     */
    ArticleVo selectById(String articleId);


}
