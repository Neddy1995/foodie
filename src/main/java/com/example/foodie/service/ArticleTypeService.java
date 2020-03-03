package com.example.foodie.service;

import com.example.foodie.bean.ArticleType;

public interface ArticleTypeService {

    /**
     * 查询是否存在该类型，不存在则创建
     * @param articleType
     * @return
     */
    String selectOrInsert(ArticleType articleType);

    /**
     * 修改文章类型
     * @param articleType
     * @return
     */
    String updateType(ArticleType articleType);

    ArticleType selectType(String typeId);
}
