package com.example.foodie.controller;

import com.example.foodie.bean.ArticleType;
import com.example.foodie.service.ArticleTypeService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService articleTypeService;

    @PostMapping("/selectType.do")
    public ControllerResult selectType(@RequestParam("typeId")String typeId){
        ArticleType articleType = articleTypeService.selectType(typeId);
        return ControllerResult.createSuccess("查询成功",articleType);
    }
}
