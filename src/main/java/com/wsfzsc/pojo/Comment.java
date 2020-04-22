package com.wsfzsc.pojo;

public class Comment {
    private Integer commentId;
    private Integer userId;
    private Integer indentId;
    private String commentTime;
    private String content;

    public Integer getCommentId() { return commentId; }

    public void setCommentId(Integer commentId) { this.commentId = commentId; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public Integer getIndentId() { return indentId; }

    public void setIndentId(Integer indentId) { this.indentId = indentId; }

    public String getCommentTime() {return commentTime;}

    public void setCommentTime(String commentTime) {this.commentTime = commentTime; }

    public String getContent() { return content; }

    public void setContent(String content) {this.content = content; }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", indentId=" + indentId +
                ", commentTime='" + commentTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
