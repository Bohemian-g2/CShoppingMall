package com.wsfzsc.controller.front;


import com.wsfzsc.pojo.Question;
import com.wsfzsc.service.MbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("encry")
public class MbController {

    @RequestMapping("ToMb")
    public String ToMb(){
        return "front/userC/MbSetting";
    }

    @Autowired
    private MbService mbService;

    /*前台下拉列表获取问题*/
    @RequestMapping("getEncry")
    @ResponseBody
    public List<Question> getEncry(){
       List<Question> result = mbService.getAllQuestion();
        return result;
    }

}
