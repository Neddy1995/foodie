package com.example.foodie.controller;

import com.example.foodie.bean.Like;
import com.example.foodie.service.LikeService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LikeController {

    @Autowired
    private LikeService likeService;

    /**
     * 用户点赞
     * @param request
     * @param articleId
     * @return
     */
    @PostMapping("/insertLike.do")
    public ControllerResult insertLike(HttpServletRequest request,
                                       @RequestParam("articleId")String articleId){
        HttpSession session = request.getSession();
        likeService.insertLike((String)session.getAttribute(SessionKeyValue.USER_ID),articleId);
        return ControllerResult.createSuccess("点赞成功");
    }

    /**
     * 查询文章点赞数
     * @param articleId
     * @return
     */
    @PostMapping("selectLike.do")
    public ControllerResult selectLike(@RequestParam("artilceId")String articleId){
        int i = likeService.selectLikeNum(articleId);
        return ControllerResult.createSuccess("查询成功",i);
    }

    /**
     * 取消点赞
     * @param request
     * @param articleId
     * @return
     */
    @PostMapping("deleteLike.do")
    public ControllerResult deleteLike(HttpServletRequest request,
                                       @RequestParam("articleId")String articleId){
        HttpSession session = request.getSession();
        likeService.deleteLike((String)session.getAttribute(SessionKeyValue.USER_ID),articleId);
        return ControllerResult.createSuccess("删除成功");
    }
}