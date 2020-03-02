package com.example.foodie.service;

import com.example.foodie.bean.Article;
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
     * 根据多个文章id查询文章的标题和图片的路径
     * @param articleIdList
     * @return
     */
    List<TitleAndPictureVo> selectByArticleList(List<String> articleIdList);

    /**
     * 根据用户id查询文章的标题和图片的路径
     * @param userId
     * @return
     */
    List<TitleAndPictureVo> selectByUserId(String userId);

    /**
     * 根据id查询文章内容
     * @param articleId
     * @return
     */
    ArticleVo selectById(String articleId);

    /**
     * 新增一篇文章
     * @param article
     */
    String insertArticle(Article article);

    /**
     * 删除一篇文章
     * @param articleId
     * @return
     */
    boolean deleteArticle(String articleId);


    /**
     * 修改一篇文章
     * @param article
     * @return
     */
    void updateArticle(Article article);
}
