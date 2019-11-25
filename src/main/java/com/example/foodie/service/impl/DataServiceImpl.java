package com.example.foodie.service.impl;

import com.example.foodie.bean.DataBean;
import com.example.foodie.dao.*;
import com.example.foodie.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private LikeMapper likeMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private AuditArticleMapper auditArticleMapper;

    @Override
    public List<DataBean> selectLikeNumByDay(Date dateDay) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDay);
        return likeMapper.selectLikeNumByDay(date);
    }

    @Override
    public List<DataBean> selectCommentNumByDay(Date dateDay) {
        return commentMapper.selectCommentNumByDay(dateDay);
    }

    @Override
    public List<DataBean> selectFollowNumByDay(Date dateDay) {
        return followMapper.selectFollowNumByDay(dateDay);
    }

    @Override
    public List<DataBean> selectArticleNumByDay(Date dateDay) {
        return articleMapper.selectArticleNumByDay(dateDay);
    }

    @Override
    public List<DataBean> selectPassNumByDay(Date dateDay) {
        return auditArticleMapper.selectPassNumByDay(dateDay);
    }

    @Override
    public List<DataBean> selectAuditNumByDay(Date dateDay) {
        return auditArticleMapper.selectAuditNumByDay(dateDay);
    }

    @Override
    public List<DataBean> selectLikeNumByMonth(Date dateDay) {
        return likeMapper.selectLikeNumByMonth(dateDay);
    }

    @Override
    public List<DataBean> selectCommentNumByMonth(Date dateDay) {
        return commentMapper.selectCommentNumByMonth(dateDay);
    }

    @Override
    public List<DataBean> selectFollowNumByMonth(Date dateDay) {
        return followMapper.selectFollowNumByMonth(dateDay);
    }

    @Override
    public List<DataBean> selectArticleNumByMonth(Date dateDay) {
        return articleMapper.selectArticleNumByMonth(dateDay);
    }

    @Override
    public List<DataBean> selectPassNumByMonth(Date dateDay) {
        return auditArticleMapper.selectPassNumByMonth(dateDay);
    }

    @Override
    public List<DataBean> selectAuditNumByMonth(Date dateDay) {
        return auditArticleMapper.selectAuditNumByMonth(dateDay);
    }
}
