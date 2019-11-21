package com.example.foodie.controller;

import com.example.foodie.service.ArticleService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.vo.ArticleVo;
import com.example.foodie.vo.TitleAndPictureVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 根据街道ID查询文章标题和图片路径
     * @param request
     * @param streetId
     * @return
     */
    @PostMapping
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
    @PostMapping
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
    public ControllerResult selectByText(HttpServletRequest request,
                                         @RequestParam("text")String text){
        List<TitleAndPictureVo> list = articleService.selectByText(text);
        return ControllerResult.createSuccess("查询成功",list);
    }
    /**
     * 根据文章id查询文章内容
     * @param request
     * @param articleId
     * @return
     */
    @PostMapping
    public ControllerResult selectById(HttpServletRequest request,
                                       @RequestParam("articleId")String articleId){
        ArticleVo articleVo = articleService.selectById(articleId);
        return ControllerResult.createSuccess("查询成功",articleVo);
    }
}
