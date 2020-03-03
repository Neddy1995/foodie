package com.example.foodie.service.impl;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.AuditArticle;
import com.example.foodie.bean.Picture;
import com.example.foodie.dao.ArticleMapper;
import com.example.foodie.dao.AuditArticleMapper;
import com.example.foodie.dao.PictureMapper;
import com.example.foodie.service.AuditService;
import com.example.foodie.vo.TitleAndPictureVo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private PictureMapper pictureMapper;

    @Autowired
    private AuditArticleMapper auditArticleMapper;

    @Override
    public List<Article> selectAuditArticle() {
        List<Article> articleList = articleMapper.selectAuditArticle();
        return articleList;
    }

    @Override
    public List<Article> selectPassArticle(String userId) {
        List<String> listArticleId = auditArticleMapper.selectPassArticle(userId);
        if(listArticleId.size()!=0){
            List<Article> articleList = articleMapper.selectPassArticle(listArticleId);
            return articleList;
        }
        return null;
    }

    @Override
    public void insertAuditArticle(AuditArticle auditArticle,String state) {
        auditArticle.setAuditTime(new Date());
        if("1".equals(state)){
            auditArticle.setAuditText("SUCCESS");
            Article article = new Article(auditArticle.getArticleId(),1);
            articleMapper.updateByPrimaryKeySelective(article);
        }else{
            auditArticle.setAuditText("FAIL");
            Article article = new Article(auditArticle.getArticleId(),2);
            articleMapper.updateByPrimaryKeySelective(article);
        }
        auditArticleMapper.insertSelective(auditArticle);
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
            Picture picture = pictureMapper.selectByArticleId(article.getArticleId()).get(0);
            titleAndPictureVo.setArticleAndPicture(article, picture);

            list.add(titleAndPictureVo);
        }
        return list;
    }
}
