package com.wsfzsc.controller.background;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsfzsc.pojo.Indent;
import com.wsfzsc.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/indent")
public class IndentController {

    @Autowired
    private IndentService indentService;

    //根据订单状态查询
    @RequestMapping("/showAll")
    public @ResponseBody
    PageInfo showAll(@RequestParam("pn") Integer pn, @RequestParam("data") Integer status, Model model){
        PageHelper.startPage(pn,10);
        List<Indent> list = indentService.showAll(status);
        PageInfo pageInfo = new PageInfo(list,5);
        return pageInfo;
    }

    //订单换货
    @RequestMapping("/updateStatus")
    public @ResponseBody
    Integer updateStatus(String upd_ids, Integer upd_status, Model model){
        String[] split = upd_ids.split("-");
        List<Integer> list = new ArrayList<>();
        for(String s : split){
            list.add(Integer.parseInt(s));
        }
        Integer i = indentService.updateStatus(list,upd_status);
        return i;
    }
}
