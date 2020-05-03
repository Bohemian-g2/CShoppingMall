package com.wsfzsc.pojo;

import java.util.Date;

public class CommentHelper {
    private Integer commentId;//评论id
    private Integer userId;//用户id
    private Integer indentId;//订单id
    private Date commentTime;//评论时间
    private String content;//评论内容
    private Integer commodityId;//商品id
    private String commodityName;//商品名
    private String userLoginName;//用户账号

    public CommentHelper() {
    }

    public CommentHelper(Integer commentId, Integer userId, Integer indentId, Date commentTime, String content, Integer commodityId, String commodityName, String userLoginName) {
        this.commentId = commentId;
        this.userId = userId;
        this.indentId = indentId;
        this.commentTime = commentTime;
        this.content = content;
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.userLoginName = userLoginName;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIndentId() {
        return indentId;
    }

    public void setIndentId(Integer indentId) {
        this.indentId = indentId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    @Override
    public String toString() {
        return "CommentHelper{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", indentId=" + indentId +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                ", commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", userLoginName='" + userLoginName + '\'' +
                '}';
    }
}
