package com.wsfzsc.controller.front;

import com.wsfzsc.pojo.*;
import com.wsfzsc.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    @Autowired
    private CDetailService cDetailService;

    @Autowired
    private  CommodityService commodityService;

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


    /*保存订单*/
    @RequestMapping("frontSaveIndent")
    public String frontSaveIndent(@RequestParam("ids") String ids,
                                  @RequestParam("nums")String nums,HttpServletRequest request){
        String[] ids_list =ids.split(",");
        String[] nums_list = nums.split(",");
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        Integer uid= user.getUserId();
        float total=0;
        for(int i=0;i<ids_list.length;i++){
            float money=commodityService.getAccountByCId(Integer.parseInt(ids_list[i]));
            total+=money*Integer.parseInt(ids_list[i]);
        }
        Integer indent_id= indentService.saveIndent(uid,total);
        for(int i=0;i<ids_list.length;i++){
            indentDetailService.saveIndentDetail(indent_id,Integer.parseInt(ids_list[i]),Integer.parseInt(nums_list[i]));
        }
        List<Indent> indentList= indentService.getAllIndentByUid(uid);
        request.getSession().setAttribute("indentList",indentList);
        return "front/order";
    }

    /*显示订单*/
    @RequestMapping("frontShowIndent")
    public String frontShowIndent(HttpServletRequest request){
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        Integer uid= user.getUserId();
        List<Indent> indentList= indentService.getAllIndentByUid(uid);
        request.getSession().setAttribute("indentList",indentList);
        return "front/order";
    }

    /*显示订单详情*/
    @RequestMapping(value="/frontShowIndentDetailByIndentId")
    @ResponseBody
    public List<IndentDetail> frontShowIndentDetailByIndentId( @RequestParam("id")String id){
        List<IndentDetail> indentDetailListList= indentDetailService.showById(Integer.parseInt(id));
        System.out.println(indentDetailListList);
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

    /*生成订单并删除购物车*/
    @RequestMapping("frontSaveIndentDeleleCart")
    public String frontSaveIndentDeleleCart(Integer cartId,@RequestParam("ids") String ids,
                                            @RequestParam("nums")String nums,HttpServletRequest request){
        String[] ids_list =ids.split(",");
        String[] nums_list = nums.split(",");
        List<Integer> idList = new ArrayList<>();
        UserInf user = (UserInf) request.getSession().getAttribute("user");
        Integer uid= user.getUserId();
        float total=0;
        for(int i=0;i<ids_list.length;i++){
            float money=commodityService.getAccountByCId(Integer.parseInt(ids_list[i]));
            total+=money*Integer.parseInt(ids_list[i]);
        }
        Integer indent_id= indentService.saveIndent(uid,total);
        for(int i=0;i<ids_list.length;i++){
            indentDetailService.saveIndentDetail(indent_id,Integer.parseInt(ids_list[i]),Integer.parseInt(nums_list[i]));
            idList.add(Integer.parseInt(ids_list[i]));
        }

        //调用批量删除购物车的方法
        cDetailService.deleteBatch(cartId,idList);
        return "front/order";
    }
}
