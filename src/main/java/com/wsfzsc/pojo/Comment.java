package com.wsfzsc.pojo;

import java.util.Date;

public class Comment {
    private Integer commentId;

    private Integer userId;

    private Integer indentId;

    private Date commentTime;

    private String content;



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
        this.content = content == null ? null : content.trim();
    }

    public Comment() {
    }

    public Comment(Integer commentId, Integer userId, Integer indentId, Date commentTime, String content) {
        this.commentId = commentId;
        this.userId = userId;
        this.indentId = indentId;
        this.commentTime = commentTime;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", indentId=" + indentId +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                '}';
    }
}