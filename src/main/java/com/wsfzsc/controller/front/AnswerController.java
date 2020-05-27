package com.wsfzsc.controller.front;


import com.wsfzsc.pojo.Answer;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Answer")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    /*设置密保问题*/
    @RequestMapping("AddAnswer")
    public String AddAnswer(String questionIdOne,String questionIdTwo,
            String answerOne, String answerTwo, HttpServletRequest request){
        System.out.println(questionIdOne+"-----"+answerOne+"-----"
                +questionIdTwo+"------"+answerTwo);
        UserInf user = (UserInf) request.getSession().getAttribute("nuser");
        Integer qIdOne = Integer.valueOf(questionIdOne);
        Integer qIdTwo = Integer.valueOf(questionIdTwo);
        if(user.getUserId()==null||
                questionIdOne.length()==0||questionIdTwo.length()==0||
                answerOne.length()==0||answerTwo.length()==0) {
            return "front/userC/MbSetting";
        }else if(qIdOne.intValue() == qIdTwo.intValue()){
                return "front/userC/MbSetting";
        }else{
                Integer uId = user.getUserId();
                Answer resultOne = new Answer();
                resultOne.setUserId(uId);
                resultOne.setQuestionId(qIdOne);
                resultOne.setAnswer(answerOne);
                answerService.saveAnswer(resultOne);
                Answer resultTwo = new Answer();
                resultTwo.setUserId(uId);
                resultTwo.setQuestionId(qIdTwo);
                resultTwo.setAnswer(answerTwo);
                answerService.saveAnswer(resultTwo);
            }

        return "frontground/UserLogin";
    }

    /*忘记密码时获取用户密保问题*/
    @RequestMapping("getForgetEncry")
    @ResponseBody
    public List<Answer> ForgetEncry(@RequestBody Map<String,Object> map,HttpServletRequest request){
        String temp = map.get("getUserId").toString();
        System.out.println(temp);
        Integer userId = Integer.valueOf(temp);
        List<Answer> result = answerService.getUserQueAndAws(userId);
        request.getSession().setAttribute("getPwdUserId",userId);
        System.out.println("result="+result);
        return result;
    }

    /*验证密保*/
    @RequestMapping("getForgetPwd")

    public String getForgetPwd(String AnswerOne,String AnswerOneToOne,HttpServletRequest request){

       /* String temp1 = map.get("AnswerQne").toString();
        System.out.println("temp1="+temp1);*/
        /*String temp2 = map.get("qId").toString();
        System.out.println("temp2="+temp2);*/

        if(AnswerOneToOne.length()==0||AnswerOneToOne.equals(" ")){
            return "front/userC/FindoutPwd";
        }
        String temp3 = request.getSession().getAttribute("getPwdUserId").toString();
        System.out.println("temp3="+temp3);
        Integer userId = Integer.valueOf(temp3);
        Integer queId = Integer.valueOf(AnswerOne);
        String resultPwd = answerService.checkAnswer(userId,queId,AnswerOneToOne);
        if(resultPwd==null||resultPwd.isEmpty()){
            return "front/userC/FindoutPwd";
        }else{
            System.out.println(resultPwd);
            return "front/userC/UpdateForgetPwd";
        }
    }


}
