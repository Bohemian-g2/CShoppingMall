package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.AnswerMapper;
import com.wsfzsc.mapper.UserInfMapper;
import com.wsfzsc.pojo.Answer;
import com.wsfzsc.pojo.AnswerExample;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private UserInfMapper userInfMapper;


    @Override
    public String saveAnswer(Answer answer) {
        answerMapper.insertSelective(answer);
        return String.valueOf(answer.getUserId());
    }

    @Override
    public List<Answer> getUserQueAndAws(Integer userId) {
        AnswerExample a = new AnswerExample();
        AnswerExample.Criteria criteria = a.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<Answer> list = answerMapper.selectByUserIdWithQue(a);
        return list;
    }

    @Override
    public String checkAnswer(Integer userId,Integer QueId, String Answer) {
        Answer answer = answerMapper.selectByUserIdAndQueId(userId,QueId);
        if (answer.getAnswer().equals(Answer)){
            UserInf user = userInfMapper.selectByUserId(userId);
            System.out.println(user);
            return user.getPassword();
        }

        return null;
    }
}
