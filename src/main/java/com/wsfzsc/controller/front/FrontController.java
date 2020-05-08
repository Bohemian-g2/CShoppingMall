package com.wsfzsc.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("front")
public class FrontController {
    /*页面跳转功能*/
    /*商品详情页面返回 （包括库存）*/
    @RequestMapping("commoditydetails")
    public String commoditydetail(){
        return "front/commoditydetails";
    }

    /*商品购物车页面返回 （包括库存）*/
    @RequestMapping("frontCart")
    public String frontCart(){
        return "front/frontCart";
    }

    /*商品收藏页面返回 （包括库存）*/
    @RequestMapping("frontCollect")
    public String frontCollect(){
        return "front/frontCollect";
    }

    /*商品收藏页面返回 （包括库存）*/
    @RequestMapping("frontRecord")
    public String frontRecord(){
        return "front/frontRecord";
    }

    /*商品检索页面返回*/
    @RequestMapping("frontShow")
    public String frontShow(){
        return "front/frontShow";
    }

    /*购物车检索相似商品页面返回*/
    @RequestMapping("similarcommodity")
    public String similarcommodity(){
        return "front/similarcommodity";
    }

    /*购物车检索相似商品页面返回*/
    @RequestMapping("order")
    public String order(){
        return "front/order";
    }

    /*评论页面异步返回*/
    @RequestMapping("comment")
    @ResponseBody
    public ModelAndView comment(){
        ModelAndView model=new ModelAndView();
        model.setViewName("front/comment");
        return model;
    }
}
