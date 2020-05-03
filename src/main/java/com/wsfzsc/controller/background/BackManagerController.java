package com.wsfzsc.controller.background;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wsfzsc.pojo.Admin;
import com.wsfzsc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("background")
public class BackManagerController {
    /*页面跳转功能*/
    /*管理员列表页面返回*/
    @RequestMapping("AdminList")
    @ResponseBody
    public ModelAndView AdminList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/AdminList");
        return model;
    }

    /*用户列表页面返回*/
    @RequestMapping("UserList")
    @ResponseBody
    public ModelAndView UserList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/UserList");
        return model;
    }

    /*评论列表页面返回*/
    @RequestMapping("CommentList")
    @ResponseBody
    public ModelAndView CommentList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/CommentList");
        return model;
    }

    /*商品列表页面返回*/
    @RequestMapping("CommodityList")
    @ResponseBody
    public ModelAndView CommodityList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/CommodityList");
        return model;
    }

    /*商品分类列表页面返回*/
    @RequestMapping("CommodityKindList")
    @ResponseBody
    public ModelAndView CommodityKindList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/CommodityKindList");
        return model;
    }

    /*订单列表页面返回*/
    @RequestMapping("OrderList")
    @ResponseBody
    public ModelAndView OrderList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/OrderList");
        return model;
    }
    /*换货订单*/
    @RequestMapping("ReplaceOrderList")
    @ResponseBody
    public ModelAndView ReplaceOrderList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/ReplaceOrderList");
        return model;
    }
    /*退货订单*/
    @RequestMapping("ReturnOrderList")
    @ResponseBody
    public ModelAndView ReturnOrderList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/ReturnOrderList");
        return model;
    }
    /*发货订单*/
    @RequestMapping("SendOrderList")
    @ResponseBody
    public ModelAndView SendOrderList(){
        ModelAndView model=new ModelAndView();
        model.setViewName("background/info/SendOrderList");
        return model;
    }
}
