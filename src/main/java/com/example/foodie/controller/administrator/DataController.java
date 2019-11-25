package com.example.foodie.controller.administrator;

import com.example.foodie.bean.DataBean;
import com.example.foodie.service.DataService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class DataController {

    /**
     * 按天查询（1、数据做数据走向，按小时做；2、数据做表格化，按天做）
     * 按月查询（1、数据做数据走向，按天做；2、数据做表格化，按月做）
     * 点赞表article_like，评论表comment,关注表follow，文章表article（创建数，通过审核数，审核数）
     */
    @Autowired
    private DataService dataService;

    /**
     * 按天查询所有的表数据
     * @param dateDay
     * @return
     */
    @PostMapping("/selectLikeByDay.do")
    public ControllerResult selectLikeByDay(@RequestParam("dateDay")Date dateDay){
        List list = new ArrayList<>();
        List<DataBean> dataBeanLike = dataService.selectLikeNumByDay(dateDay); //点赞数
        List<DataBean> dataBeanComment = dataService.selectCommentNumByDay(dateDay);//评论数
        List<DataBean> dataBeanFollow = dataService.selectFollowNumByDay(dateDay);//关注数
        List<DataBean> dataBeanArticle = dataService.selectArticleNumByDay(dateDay);//文章创建数
        List<DataBean> dataBeanPass = dataService.selectPassNumByDay(dateDay);//文章通过审核数
        List<DataBean> dataBeanAudit = dataService.selectAuditNumByDay(dateDay);//文章审核数
        list.add(dataBeanLike);
        list.add(dataBeanComment);
        list.add(dataBeanFollow);
        list.add(dataBeanArticle);
        list.add(dataBeanPass);
        list.add(dataBeanAudit);
        return ControllerResult.createSuccess("查询成功",list);
    }

    /**
     * 按月查询所有的表数据
     * @param dateMonth
     * @return
     */
    @PostMapping("/selectLikeByMonth.do")
    public ControllerResult selectLikeByMonth(@RequestParam("dateMonth")Date dateMonth){
        List  list = new ArrayList<>();
        List<DataBean> dataBeanLike = dataService.selectLikeNumByMonth(dateMonth); //点赞数
        List<DataBean> dataBeanComment = dataService.selectCommentNumByMonth(dateMonth);//评论数
        List<DataBean> dataBeanFollow = dataService.selectFollowNumByMonth(dateMonth);//关注数
        List<DataBean> dataBeanArticle = dataService.selectArticleNumByMonth(dateMonth);//文章创建数
        List<DataBean> dataBeanPass = dataService.selectPassNumByMonth(dateMonth);//文章通过审核数
        List<DataBean> dataBeanAudit = dataService.selectAuditNumByMonth(dateMonth);//文章审核数
        list.add(dataBeanLike);
        list.add(dataBeanComment);
        list.add(dataBeanFollow);
        list.add(dataBeanArticle);
        list.add(dataBeanPass);
        list.add(dataBeanAudit);
        return ControllerResult.createSuccess("查询成功",list);
    }

}
