package com.wsfzsc.controller.front;

import com.wsfzsc.pojo.CDetail;
import com.wsfzsc.pojo.UserInf;
import com.wsfzsc.service.CDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Cart")
public class CartController {
    @Autowired
    private CDetailService cDetailService;

    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request){
        UserInf user = (UserInf)request.getSession().getAttribute("user");
        if(cDetailService.selectAll(user.getUserId()) != null){
            List<CDetail> cDetails = cDetailService.selectAll(user.getUserId());
            request.setAttribute("cDetails",cDetails);
            request.setAttribute("CDTotal",cDetails.size());
            return "frontground/frontCart";
        }
        return "frontground/frontCart";
    }

    //前台的选购
    @RequestMapping("/insertOne")
    @ResponseBody
    public String insertOne(Integer commodityId, HttpServletRequest request){
        UserInf user = (UserInf)request.getSession().getAttribute("user");
        String result = cDetailService.insertOne(commodityId,user.getUserId());
        //String result = cDetailService.insertOne(commodityId,1);
        return result;
    }

    //选购+跳转到购物车界面
    @RequestMapping("/insertOneCurrent")
    public String insertOneCurrent(Integer commodityId, HttpServletRequest request){
        UserInf user = (UserInf)request.getSession().getAttribute("user");
        String result = cDetailService.insertOne(commodityId,user.getUserId());
        //String result = cDetailService.insertOne(commodityId,1);
        return "forward:/Cart/selectAll";
    }

    //返回刷新的购物车信息
    @RequestMapping("/updateCDetailMoney")
    @ResponseBody
    public CDetail updateCDetailMoney(Integer commodityId, Integer cartId, Integer opera){
        if(opera == 1){
            //如果是添加数据 提前判断下库存
            CDetail cDetail = cDetailService.selectOne(cartId,commodityId);
            if(cDetail.getCommodity().getCommodityStock()-1 < cDetail.getCartCommodityNumbe()){
                return null;
            }
        }
        Integer i = cDetailService.updateCDetailMoney(cartId,commodityId,opera);
        CDetail cDetail = cDetailService.selectOne(cartId,commodityId);
        return cDetail;
    }

    @RequestMapping("/deleteBatch")
    @ResponseBody
    public Integer deleteBatch(Integer cartId,String commodityIds){
        /**
         * 批量删除中cartIds包含符号 -
         * 单个删除并不包含 但是也可以split
         * 分割之后放入list集合中
         */
        String[] commodityId = commodityIds.split("-");
        List<Integer> commodityIdList = new ArrayList<>();
        for(String temp : commodityId){
            commodityIdList.add(Integer.parseInt(temp));
        }
        Integer i = cDetailService.deleteBatch(cartId,commodityIdList);
        return i;
    }

}









