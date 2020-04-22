package com.wsfzsc.controller.background;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("Login")
    public String Login(){
        return "/background/backLogin";
    }

    @RequestMapping("SuperAdmin")
    public String SuperAdmin(){return "/background/back"; }

    @RequestMapping("OrdinaryAdmin")
    public String OrdinaryAdmin(){return "/background/ordinaryback"; }



}
