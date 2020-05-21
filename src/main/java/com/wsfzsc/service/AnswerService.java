package com.wsfzsc.service;

import com.wsfzsc.pojo.Answer;

import java.util.List;


public interface AnswerService {
    /*存入用户设置的密保问题*/
    public String saveAnswer(Answer answer);

    /*忘记密码获取密保问题*/
    public List<Answer> getUserQueAndAws(Integer userId);

    /*检查密保与答案*/
    public String checkAnswer(Integer userId,Integer QueId,String Answer);
}
