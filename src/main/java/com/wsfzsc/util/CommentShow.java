package com.wsfzsc.util;

import java.util.Date;

public class CommentShow {
    private Integer commentId;

    private Integer userId;

    private Integer indentId;

    private Date commentTime;

    private String content;

    private String userTitle;

    private String userName;

    public CommentShow() {
    }

    public CommentShow(Integer commentId, Integer userId, Integer indentId, Date commentTime, String content, String usertitle, String userName) {
        this.commentId = commentId;
        this.userId = userId;
        this.indentId = indentId;
        this.commentTime = commentTime;
        this.content = content;
        this.userTitle = usertitle;
        this.userName = userName;
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

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(String userTitle) {
        this.userTitle = userTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CommentShow{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", indentId=" + indentId +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                ", userTitle='" + userTitle + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
