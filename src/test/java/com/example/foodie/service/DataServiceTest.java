package com.example.foodie.service;

import com.example.foodie.FoodieApplicationTest;
import com.example.foodie.bean.DataBean;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = FoodieApplicationTest.class)
@RunWith(SpringRunner.class)
class DataServiceTest {

    @Autowired
    private DataService dataService;

    @Test
    @DisplayName("测试DataService的查询当天各小时的点赞数selectLikeNumByDay方法")
    void selectLikeNumByDay() throws ParseException {
        String s = "2019-11-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectLikeNumByDay(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当天各小时的评论数selectCommentNumByDay方法")
    void selectCommentNumByDay() throws ParseException {
        String s = "2019-11-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectCommentNumByDay(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当天各小时的关注数selectFollowNumByDay方法")
    void selectFollowNumByDay() throws ParseException {
        String s = "2019-11-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectFollowNumByDay(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当天各小时的新建文章数selectArticleNumByDay方法")
    void selectArticleNumByDay() throws ParseException {
        String s = "2019-11-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectArticleNumByDay(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当天各小时的审核通过文章数selectPassNumByDay方法")
    void selectPassNumByDay() throws ParseException {
        String s = "2019-11-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectPassNumByDay(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当天各小时的已审核数selectAuditNumByDay方法")
    void selectAuditNumByDay() throws ParseException {
        String s = "2019-11-25";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectAuditNumByDay(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当月各小时的点赞数selectLikeNumByMonth方法")
    void selectLikeNumByMonth() throws ParseException {
        String s = "2019-11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectLikeNumByMonth(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当月各小时的关注数selectCommentNumByMonth方法")
    void selectCommentNumByMonth() throws ParseException {
        String s = "2019-11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectCommentNumByMonth(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当月各小时的评论数selectFollowNumByMonth方法")
    void selectFollowNumByMonth() throws ParseException {
        String s = "2019-11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectFollowNumByMonth(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当月各小时的新建文章数selectArticleNumByMonth方法")
    void selectArticleNumByMonth() throws ParseException {
        String s = "2019-11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectArticleNumByMonth(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当月各小时的通过审核的文章数selectPassNumByMonth方法")
    void selectPassNumByMonth() throws ParseException {
        String s = "2019-11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectPassNumByMonth(date);
        System.out.println(""+list.toString());
    }

    @Test
    @DisplayName("测试DataService的查询当月各小时的已审核文章数selectAuditNumByMonth方法")
    void selectAuditNumByMonth() throws ParseException {
        String s = "2019-11";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(s);
        List<DataBean> list = dataService.selectAuditNumByMonth(date);
        System.out.println(""+list.toString());
    }
}