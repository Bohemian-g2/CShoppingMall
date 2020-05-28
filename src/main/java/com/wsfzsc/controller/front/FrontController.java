package com.wsfzsc.controller.front;

import com.wsfzsc.pojo.Address;
import com.wsfzsc.pojo.Comment;
import com.wsfzsc.pojo.Indent;
import com.wsfzsc.pojo.IndentDetail;
import com.wsfzsc.service.CommentService;
import com.wsfzsc.service.IndentDetailService;
import com.wsfzsc.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/front")
public class FrontController {
    /*页面跳转功能*/

    @Autowired
    private IndentService indentService;

    @Autowired
    private IndentDetailService indentDetailService;

    @Autowired
    private CommentService commentService;

    /*商品详情页面返回 （包括库存）*/
    @RequestMapping("commoditydetails")
    public String commoditydetail(){
        return "front/commoditydetails";
    }

    /*商品购物车页面返回 （包括库存）*/
    @RequestMapping("frontCart")
    public String frontCart(){
        return "frontground/frontCart";
    }

    /*商品收藏页面返回 （包括库存）*/
    @RequestMapping("frontCollect")
    public String frontCollect(){
        return "frontground/frontCollect";
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


    /*保存订单*/
    @RequestMapping("frontSaveIndent")
    public String frontSaveIndent(String ids, String nums, String moneys){
        String ids_list[]=ids.split(",");
        String nums_list[]= nums.split(",");
        Integer uid=222;    //从……中获取，先写死

        Integer indent_id= indentService.saveIndent(uid,1110);
        for(int i=0;i<ids_list.length;i++){
            indentDetailService.saveIndentDetail(indent_id,Integer.parseInt(ids_list[i]),Integer.parseInt(nums_list[i]));
        }
        List<Indent> indentList= indentService.getAllIndentByUid(uid);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("indentList",indentList);

        return "front/order";
    }

    /*显示订单*/
    @RequestMapping("frontShowIndent")
    public String frontShowIndent(){
        Integer uid=222;    //从……中获取，先写死

        List<Indent> indentList= indentService.getAllIndentByUid(uid);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.getSession().setAttribute("indentList",indentList);

        return "front/order";
    }

    /*显示订单详情*/
    @RequestMapping(value="/frontShowIndentDetailByIndentId",method = {RequestMethod.POST})
    @ResponseBody
    public List<IndentDetail> frontShowIndentDetailByIndentId( @RequestParam(value = "id",defaultValue = "1111")String id){
        System.out.println("=========controller--frontShowIndentDetailByIndentId=====id="+id);

        List<IndentDetail> indentDetailListList= indentDetailService.showById(Integer.parseInt(id));

        return indentDetailListList;
    }

    /*支付订单*/
    @RequestMapping("frontPayIndent")
    @ResponseBody
    public Map<String,String> frontPayIndent(Integer id, Integer addressId, Integer payway){

        return indentService.payIndent(id,addressId,payway);

    }

    /* 删除订单*/
    @RequestMapping("frontDeleteIndent")
    @ResponseBody
    public void frontDeleteIndent(Integer id){

        indentService.deleteIndent(id);

    }

    /* 订单确认收货*/
    @RequestMapping("frontSureIndent")
    @ResponseBody
    public void frontSureIndent(Integer id){

        indentService.sureIndent(id);

    }

    /*显示该用户所有的收货信息*/
    @RequestMapping(value="/frontShowAddressByUserId",method = {RequestMethod.POST})
    @ResponseBody
    public List<Address> frontShowAddressByUserId(@RequestParam(value = "id",defaultValue = "1111")String id){
        System.out.println("=========controller--frontShowAddressByUserId=====id="+id);

        List<Address> addressList=indentService.getAddressByUserid(Integer.parseInt(id));

        return addressList;
    }


    /* 订单换货*/
    @RequestMapping("frontChangeIndent")
    @ResponseBody
    public void frontChangeIndent(Integer id){

        indentService.changeIndent(id);
    }

    /* 订单评论*/
    @RequestMapping("frontInsertComment")
    public String frontInsertComment(Integer indentId,String myComment){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        indentId=Integer.parseInt(request.getParameter("indentId"));
        myComment=request.getParameter("myComment");
        System.out.println("indentId==="+indentId+"myComment===="+myComment);
        indentService.insertComment(indentId,myComment);

        return "forward:frontShowIndent";
    }

    /*查找订单评价*/
    @RequestMapping("frontFindCommentByid")
    @ResponseBody
    public List<Comment> frontFindCommentByid(Integer id){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        id=Integer.parseInt(request.getParameter("id"));
        return commentService.getCommentByIndentid(id);
    }
}
