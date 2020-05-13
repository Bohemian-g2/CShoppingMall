package com.wsfzsc.controller.background;

import com.wsfzsc.pojo.IndentDetail;
import com.wsfzsc.service.IndentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/indentDetail")
public class IndentDetailController {
    @Autowired
    private IndentDetailService indentDatailService;

    //显示对应订单所有商品信息
    @RequestMapping("/showById")
    public @ResponseBody
    List<IndentDetail> showById(@RequestParam("indentId") Integer indentId, Model model){
        List<IndentDetail> list = indentDatailService.showById(indentId);
        return list;
    }
}
