package com.example.foodie.controller;

import com.example.foodie.bean.Article;
import com.example.foodie.bean.ArticleType;
import com.example.foodie.service.*;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import com.example.foodie.vo.ArticleTypePictureVo;
import com.example.foodie.vo.ArticleVo;
import com.example.foodie.vo.TitleAndPictureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private ArticlePictureService articlePictureService;

    /**
     * 根据街道ID查询文章标题和图片路径
     * @param request
     * @param streetId
     * @return
     */
    @PostMapping("/selectByStreet.do")
    public ControllerResult selectByStreet(HttpServletRequest request,
                                          @RequestParam("streetId")String streetId){
        List<TitleAndPictureVo> list = articleService.selectByStreet(streetId);
        return ControllerResult.createSuccess("查询成功",list);
    }

    /**
     * 根据类型ID查询文章标题和图片路径
     * @param request
     * @param typeId
     * @return
     */
    @PostMapping("/selectByType.do")
    public ControllerResult selectByType(HttpServletRequest request,
                                         @RequestParam("typeId")String typeId){
        List<TitleAndPictureVo> list = articleService.selectByType(typeId);
        return ControllerResult.createSuccess("查询成功",list);
    }

    /**
     * 根据搜索内容查询文章标题和图片路径
     * @param request
     * @param text
     * @return
     */
    @PostMapping("/selectByText.do")
    public ControllerResult selectByText(HttpServletRequest request,
                                         @RequestParam("text")String text){
        List<TitleAndPictureVo> list = articleService.selectByText(text);
        return ControllerResult.createSuccess("查询成功",list);
    }

    /**
     * 根据用户id查询评论的文章标题和图片路径
     * @return
     */
    @GetMapping("selectByComment.do")
    public ControllerResult selectByComment(HttpServletRequest request){
        HttpSession session = request.getSession();
//        查询评论
        List<String> articleIdList = commentService.selectByUserId((String) session.getAttribute(SessionKeyValue.USER_ID));
        if(articleIdList.isEmpty()){
            return ControllerResult.createFail("没有评论的文章");
        }
//        查询文章
        List<TitleAndPictureVo> list = articleService.selectByArticleList(articleIdList);
        return ControllerResult.createSuccess("查询成功",list);
    }

    /**
     * 根据用户id查询收藏的文章标题和图片路径
     * @return
     */
    @GetMapping("selectByLike.do")
    public ControllerResult selectByLike(HttpServletRequest request){
        HttpSession session = request.getSession();
//        查询评论
        List<String> articleIdList = likeService.selectByUserId((String) session.getAttribute(SessionKeyValue.USER_ID));
        if(articleIdList.isEmpty()){
            return ControllerResult.createFail("没有收藏的的文章");
        }
//        查询文章
        List<TitleAndPictureVo> list = articleService.selectByArticleList(articleIdList);
        return ControllerResult.createSuccess("查询成功",list);
    }

    /**
     * 根据文章id查询文章内容
     * @param request
     * @param articleId
     * @return
     */
    @PostMapping("/selectById.do")
    public ControllerResult selectById(HttpServletRequest request,
                                       @RequestParam("articleId")String articleId){
        ArticleVo articleVo = articleService.selectById(articleId);
        return ControllerResult.createSuccess("查询成功",articleVo);
    }

    /**
     * 新增一篇文章
     * @param request
     * @param articleTypePictureVo
     * @return
     */
    @PostMapping("/insertArticle.do")
    public ControllerResult insertArticle(HttpServletRequest request,
                                          @RequestBody ArticleTypePictureVo articleTypePictureVo){

        HttpSession session = request.getSession();

        Article article =articleTypePictureVo.getArticle();
        ArticleType articleType = articleTypePictureVo.getArticleType();
        List<String> list = articleTypePictureVo.getList();

//        查询是否存在该类型的文章，不存在则创建
        String typeId= articleTypeService.selectOrInsert(articleType);

//        插入一条数据
//        article.setAuthor((String) session.getAttribute(SessionKeyValue.USER_ID));
        article.setTypeId(typeId);
        String articleId = articleService.insertArticle(article);

//        插入图片
        articlePictureService.insertArticlePicture(articleId,list);

        return ControllerResult.createSuccess("创建文章成功");
    }

    /**
     * 删除一篇文章
     * @param request
     * @param articleId
     * @return
     */
    @PostMapping("/deleteArticle.do")
    public ControllerResult deleteArticle(HttpServletRequest request,
                                          @RequestParam("articleId")String articleId){
//        删除文章
        boolean i = articleService.deleteArticle(articleId);
        if (i){
//            删除图片
            articlePictureService.deleteArticlePicture(articleId);
            return ControllerResult.createSuccess("删除文章成功");
        }
        return ControllerResult.createFail("删除文章失败：不存在该文章");
    }

    /**
     * 修改一篇文章
     * @param request
     * @param articleTypePictureVo
     * @return
     */
    @PostMapping("/updateArticle.do")
    public ControllerResult updateArticle(HttpServletRequest request,
                                          @RequestBody ArticleTypePictureVo articleTypePictureVo){

        Article article =articleTypePictureVo.getArticle();
        ArticleType articleType = articleTypePictureVo.getArticleType();
        List<String> list = articleTypePictureVo.getList();

//        修改类型
        String typeId = articleTypeService.updateType(articleType);

//        修改文章
        article.setTypeId(typeId);
        articleService.updateArticle(article);

//        修改图片
        articlePictureService.updateArticlePicture(article.getArticleId(),list);

        return ControllerResult.createSuccess("修改成功");
    }
}
