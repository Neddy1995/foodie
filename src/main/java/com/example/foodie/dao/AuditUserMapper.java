package com.example.foodie.dao;

import com.example.foodie.bean.AuditUser;

public interface AuditUserMapper {
    int deleteByPrimaryKey(String auditUserId);

    int insert(AuditUser record);

    int insertSelective(AuditUser record);

    AuditUser selectByPrimaryKey(String auditUserId);

    int updateByPrimaryKeySelective(AuditUser record);

    int updateByPrimaryKey(AuditUser record);
}