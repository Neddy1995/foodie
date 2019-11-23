package com.example.foodie.service.impl;

import com.example.foodie.bean.ArticleType;
import com.example.foodie.dao.ArticleTypeMapper;
import com.example.foodie.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Override
    public String selectOrInsert(ArticleType articleType) {
//        查询
        String typeId = articleTypeMapper.selectByName(articleType);
        if (typeId==null||"".equals(typeId)){
            articleTypeMapper.insertSelective(articleType);
            typeId=articleType.getTypeId();
        }
        return typeId;
    }

    @Override
    public String updateType(ArticleType articleType) {
        return articleTypeMapper.selectByName(articleType);
    }
}
