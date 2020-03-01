package com.example.foodie.service.impl;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.Picture;
import com.example.foodie.dao.ArticleMapper;
import com.example.foodie.dao.PictureMapper;
import com.example.foodie.service.ArticleService;
import com.example.foodie.vo.ArticleVo;
import com.example.foodie.vo.TitleAndPictureVo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<TitleAndPictureVo> selectByStreet(String streetId) {
        List<Article> articleList = articleMapper.selectByStreetId(streetId);
        List<TitleAndPictureVo> list = getTitleAndPictureVos(articleList);
        return list;
    }

    @Override
    public List<TitleAndPictureVo> selectByType(String typeId) {
        List<Article> articleList = articleMapper.selectByTypeId(typeId);
        List<TitleAndPictureVo> list = getTitleAndPictureVos(articleList);
        return list;
    }

    @Override
    public List<TitleAndPictureVo> selectByText(String text) {
        List<Article> articleList = articleMapper.selectByText(text);
        List<TitleAndPictureVo> list = getTitleAndPictureVos(articleList);
        return list;
    }

    @Override
    public List<TitleAndPictureVo> selectByArticleList(List<String> articleIdList) {
        List<Article> articleList = articleMapper.selectByComment(articleIdList);
        List<TitleAndPictureVo> list = getTitleAndPictureVos(articleList);
        return list;
    }


    @Override
    public ArticleVo selectById(String articleId) {
        ArticleVo articleVo = new ArticleVo();

        Article article = articleMapper.selectByPrimaryKey(articleId);
        List<Picture> list = pictureMapper.selectByArticleId(articleId);

        BeanUtils.copyProperties(article,articleVo); //拷贝内容
        articleVo.setList(list);
        return articleVo;
    }

    @Override
    public String insertArticle(Article article) {
        article.setCreateTime(new Date());
        article.setState(0);
        System.out.println(""+article.toString());
        articleMapper.insertSelective(article);
        return article.getArticleId();
    }

    @Override
    public boolean deleteArticle(String articleId) {
//        先查询是否存在
        Article article = articleMapper.selectByPrimaryKey(articleId);
//        存在才删除
        if(article != null){
            articleMapper.deleteByPrimaryKey(articleId);
            return true;
        }
        return false;
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateByPrimaryKeySelective(article);
    }

    /**
     * 抽取的代码，循环将文章标题和图片路径加入到数组中
     * @param articleList
     * @return
     */
    @NotNull
    private List<TitleAndPictureVo> getTitleAndPictureVos(List<Article> articleList) {
        List<TitleAndPictureVo> list = new ArrayList<>();

        for (Article article : articleList) {
            TitleAndPictureVo titleAndPictureVo = new TitleAndPictureVo();
            List<Picture> pictureList = pictureMapper.selectByArticleId(article.getArticleId());
            Picture picture = new Picture();
            if (pictureList.size()!=0){
                picture =pictureList.get(0);
            }
            titleAndPictureVo.setArticleAndPicture(article, picture);
            list.add(titleAndPictureVo);
        }
        return list;
    }
}
