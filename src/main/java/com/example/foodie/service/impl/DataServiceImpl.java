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
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDay);
        return commentMapper.selectCommentNumByDay(date);
    }

    @Override
    public List<DataBean> selectFollowNumByDay(Date dateDay) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDay);
        return followMapper.selectFollowNumByDay(date);
    }

    @Override
    public List<DataBean> selectArticleNumByDay(Date dateDay) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDay);
        return articleMapper.selectArticleNumByDay(date);
    }

    @Override
    public List<DataBean> selectPassNumByDay(Date dateDay) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDay);
        return auditArticleMapper.selectPassNumByDay(date);
    }

    @Override
    public List<DataBean> selectAuditNumByDay(Date dateDay) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(dateDay);
        return auditArticleMapper.selectAuditNumByDay(date);
    }

    @Override
    public List<DataBean> selectLikeNumByMonth(Date dateMonth) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(dateMonth);
        return likeMapper.selectLikeNumByMonth(date);
    }

    @Override
    public List<DataBean> selectCommentNumByMonth(Date dateMonth) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(dateMonth);
        return commentMapper.selectCommentNumByMonth(date);
    }

    @Override
    public List<DataBean> selectFollowNumByMonth(Date dateMonth) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(dateMonth);
        return followMapper.selectFollowNumByMonth(date);
    }

    @Override
    public List<DataBean> selectArticleNumByMonth(Date dateMonth) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(dateMonth);
        return articleMapper.selectArticleNumByMonth(date);
    }

    @Override
    public List<DataBean> selectPassNumByMonth(Date dateMonth) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(dateMonth);
        return auditArticleMapper.selectPassNumByMonth(date);
    }

    @Override
    public List<DataBean> selectAuditNumByMonth(Date dateMonth) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(dateMonth);
        return auditArticleMapper.selectAuditNumByMonth(date);
    }
}
