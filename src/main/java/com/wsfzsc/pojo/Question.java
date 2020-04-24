package com.wsfzsc.pojo;

public class Question {
    private Integer questionId;

    private String question;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public Question() {
    }

    public Question(Integer questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                '}';
    }
}