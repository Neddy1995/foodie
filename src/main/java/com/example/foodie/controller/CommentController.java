package com.example.foodie.controller;

import com.example.foodie.bean.Comment;
import com.example.foodie.service.CommentService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 插入一条评论
     * @param request
     * @param comment
     * @return
     */
    @PostMapping("/insertComment.do")
    public ControllerResult insertComment(HttpServletRequest request,
                                          @RequestBody Comment comment){
        HttpSession session = request.getSession();
        comment.setUserId((String) session.getAttribute(SessionKeyValue.USER_ID));
        commentService.insertComment(comment);
        return ControllerResult.createSuccess("评论成功");
    }

    /**
     * 查询文章的所有评论
     * @param articleId
     * @return
     */
    @PostMapping("/selectComment.do")
    public ControllerResult selectComment(@RequestParam("articleId")String articleId){
        List<Comment> comment = commentService.selectByArticleId(articleId);
        return ControllerResult.createSuccess("查询评论成功",comment);
    }

    @PostMapping("/deleteComment.do")
    public ControllerResult deleteComment(@RequestParam("commentId")String commentId){
        commentService.deleteComment(commentId);
        return ControllerResult.createSuccess("删除评论成功");
    }

    @PostMapping("/updateComment.do")
    public ControllerResult updateComment(@RequestBody Comment comment){
        commentService.updateComment(comment);
        return ControllerResult.createSuccess("修改评论成功");
    }
}
