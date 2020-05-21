package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.QuestionMapper;
import com.wsfzsc.pojo.Question;
import com.wsfzsc.pojo.QuestionExample;
import com.wsfzsc.service.MbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MbServiceImpl implements MbService {

    @Autowired
    private QuestionMapper questionMapper;

    /*得到所有密保问题，若问题已被选择，则不再得到*/
    @Override
    public List<Question> getAllQuestionExcSelected(List<Integer> list) {
        QuestionExample example = new QuestionExample();
        QuestionExample.Criteria criteria = example.createCriteria();
        criteria.andQuestionIdNotIn(list);
        List<Question> questions = questionMapper.selectByExample(example);
        return questions;
    }
    /*得到所有密保问题*/
    @Override
    public List<Question> getAllQuestion() {
        return questionMapper.selectByExample(null);
    }
}
