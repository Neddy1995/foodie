package com.example.foodie.service;

import com.example.foodie.bean.DataBean;

import java.util.Date;
import java.util.List;

public interface DataService {

    /**
     * 按天查询点赞数
     * @param dateDay
     * @return
     */
    List<DataBean> selectLikeNumByDay(Date dateDay);

    /**
     * 按天查询评论数
     * @param dateDay
     * @return
     */
    List<DataBean> selectCommentNumByDay(Date dateDay);

    /**
     * 按天查询关注数
     * @param dateDay
     * @return
     */
    List<DataBean> selectFollowNumByDay(Date dateDay);

    /**
     * 按天查询文章创建数
     * @param dateDay
     * @return
     */
    List<DataBean> selectArticleNumByDay(Date dateDay);

    /**
     * 按天查询文章审核通过数
     * @param dateDay
     * @return
     */
    List<DataBean> selectPassNumByDay(Date dateDay);

    /**
     * 按天查询文章审核数
     * @param dateDay
     * @return
     */
    List<DataBean> selectAuditNumByDay(Date dateDay);

    /**
     * 按月查询点赞数
     * @param dateDay
     * @return
     */
    List<DataBean> selectLikeNumByMonth(Date dateDay);

    /**
     * 按月查询评论数
     * @param dateDay
     * @return
     */
    List<DataBean> selectCommentNumByMonth(Date dateDay);

    /**
     * 按月查询关注数
     * @param dateDay
     * @return
     */
    List<DataBean> selectFollowNumByMonth(Date dateDay);

    /**
     * 按月查询文章创建数
     * @param dateDay
     * @return
     */
    List<DataBean> selectArticleNumByMonth(Date dateDay);

    /**
     * 按月查询文章审核通过数
     * @param dateDay
     * @return
     */
    List<DataBean> selectPassNumByMonth(Date dateDay);

    /**
     * 按月查询文章审核数
     * @param dateDay
     * @return
     */
    List<DataBean> selectAuditNumByMonth(Date dateDay);
}
