package com.example.foodie.dao;

import com.example.foodie.bean.AuditUser;

public interface AuditUserMapper {
    int deleteByPrimaryKey(Integer auditUserId);

    int insert(AuditUser record);

    int insertSelective(AuditUser record);

    AuditUser selectByPrimaryKey(Integer auditUserId);

    int updateByPrimaryKeySelective(AuditUser record);

    int updateByPrimaryKey(AuditUser record);
}