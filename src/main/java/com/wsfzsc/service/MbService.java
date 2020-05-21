package com.wsfzsc.service;

import com.wsfzsc.pojo.Question;

import java.util.List;

public interface MbService {
    /*查询密保问题*/
    public List<Question> getAllQuestionExcSelected(List<Integer> list);
    /*查询所有密保问题*/
    public List<Question> getAllQuestion();

}
