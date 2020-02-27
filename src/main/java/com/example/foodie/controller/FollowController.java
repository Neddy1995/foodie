package com.example.foodie.controller;

import com.example.foodie.service.FollowService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class FollowController {

    @Autowired
    private FollowService followService;

    /**
     * 收藏文章
     * @param request
     * @param articleId
     * @return
     */
    @PostMapping("/insertFollow.do")
    public ControllerResult insertFollow(HttpServletRequest request,
                                         @RequestParam("articleId")String articleId){
        HttpSession session = request.getSession();
        followService.insertFollow((String)session.getAttribute(SessionKeyValue.USER_ID),articleId);
        return ControllerResult.createSuccess("收藏成功");
    }

    /**
     * 查询收藏数
     * @param articleId
     * @return
     */
    @PostMapping("selectFollowNum.do")
    public ControllerResult selectFollowNum(@RequestParam("articleId")String articleId){
        int i = followService.selectFollowNum(articleId);
        return ControllerResult.createSuccess("查询收藏数成功",i);
    }

    /**
     * 删除收藏
     * @param articleId
     * @return
     */
    @PostMapping("deleteFollow.do")
    public ControllerResult deleteFollow(HttpServletRequest request,
                                       @RequestParam("articleId")String articleId){
        HttpSession session = request.getSession();
        followService.deleteFollow((String)session.getAttribute(SessionKeyValue.USER_ID),articleId);
        return ControllerResult.createSuccess("删除成功");
    }


}
