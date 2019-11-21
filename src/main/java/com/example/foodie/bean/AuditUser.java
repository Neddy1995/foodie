package com.example.foodie.bean;

import java.util.Date;

public class AuditUser {
    private String auditUserId;

    private String auditedUserId;

    private String auditText;

    private String userId;

    private Date auditTime;

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId == null ? null : auditUserId.trim();
    }

    public String getAuditedUserId() {
        return auditedUserId;
    }

    public void setAuditedUserId(String auditedUserId) {
        this.auditedUserId = auditedUserId == null ? null : auditedUserId.trim();
    }

    public String getAuditText() {
        return auditText;
    }

    public void setAuditText(String auditText) {
        this.auditText = auditText == null ? null : auditText.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}