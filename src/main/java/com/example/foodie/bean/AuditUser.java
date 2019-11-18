package com.example.foodie.bean;

import java.util.Date;

public class AuditUser {
    private Integer auditUserId;

    private Integer auditedUserId;

    private String auditText;

    private Integer userId;

    private Date auditTime;

    public Integer getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(Integer auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Integer getAuditedUserId() {
        return auditedUserId;
    }

    public void setAuditedUserId(Integer auditedUserId) {
        this.auditedUserId = auditedUserId;
    }

    public String getAuditText() {
        return auditText;
    }

    public void setAuditText(String auditText) {
        this.auditText = auditText == null ? null : auditText.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}