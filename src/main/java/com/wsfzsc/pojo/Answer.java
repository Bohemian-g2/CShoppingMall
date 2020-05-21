package com.wsfzsc.pojo;

public class Answer {
    private Integer answerId;

    private Integer questionId;

    private Integer userId;

    private String answer;

    /**
     * 带外键 question，用户
     * @return
     */
    private Question question;

    private UserInf userInf;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public UserInf getUserInf() {
        return userInf;
    }

    public void setUserInf(UserInf userInf) {
        this.userInf = userInf;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Answer() {
    }

    public Answer(Integer answerId, Integer questionId, Integer userId, String answer) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.userId = userId;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", userId=" + userId +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}