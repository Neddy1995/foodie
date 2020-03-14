package com.example.foodie.controller;

import com.example.foodie.bean.Comment;
import com.example.foodie.service.CommentService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import com.example.foodie.vo.CommentVo;
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
     * @param articleId
     * @param commentText
     * @return
     */
    @PostMapping("/insertComment.do")
    public ControllerResult insertComment(HttpServletRequest request,
                                          @RequestParam("articleId")String articleId,
                                          @RequestParam("commentText")String commentText){
        HttpSession session = request.getSession();
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setCommentText(commentText);
        comment.setUserId((String) session.getAttribute(SessionKeyValue.USER_ID));
        commentService.insertComment(comment);
        return ControllerResult.createSuccess("评论成功");
    }

    @PostMapping("/selectCommentNum.do")
    public ControllerResult selectCommentNum(HttpServletRequest request,
                                             @RequestParam("articleId")String articleId){
        return ControllerResult.createSuccess("查询评论数成功",commentService.selectCommentNum(articleId));
    }

    /**
     * 查询文章的所有评论
     * @param articleId
     * @return
     */
    @PostMapping("/selectComment.do")
    public ControllerResult selectComment(@RequestParam("articleId")String articleId){
        List<CommentVo> commentVo = commentService.selectByArticleId(articleId);
        if(commentVo.size()==0){
            return ControllerResult.createFail("还没有评论");
        }
        System.out.println("111111111111111111111111111111111111111111111111111111111111111"+commentVo.toString());
        return ControllerResult.createSuccess("查询评论成功",commentVo);
    }

    /**
     * 删除文章的评论
     * @param commentId
     * @return
     */
    @PostMapping("/deleteComment.do")
    public ControllerResult deleteComment(@RequestParam("commentId")String commentId){
        commentService.deleteComment(commentId);
        return ControllerResult.createSuccess("删除评论成功");
    }

    /**
     * 修改文章的评论
     * @param comment
     * @return
     */
    @PostMapping("/updateComment.do")
    public ControllerResult updateComment(@RequestBody Comment comment){
        commentService.updateComment(comment);
        return ControllerResult.createSuccess("修改评论成功");
    }
}
