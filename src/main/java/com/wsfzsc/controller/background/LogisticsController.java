package com.wsfzsc.controller.background;

import com.wsfzsc.service.LogisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logistic")
public class LogisticsController {

    @Autowired
    private LogisticService logisticService;

    @RequestMapping(value="/selectOne", produces = "application/json; charset=utf-8")
    public @ResponseBody String selectOne(@RequestParam("indentId") Integer indentId, Model model){
        String address = logisticService.selectOne(indentId);
        return address;
    }

    @RequestMapping("/updateOne")
    public @ResponseBody Integer updateOne(@RequestParam("indentId") Integer indentId, @RequestParam("address") String address, Model model){
        Integer i = logisticService.updateOne(indentId, address);
        return i;
    }
}
