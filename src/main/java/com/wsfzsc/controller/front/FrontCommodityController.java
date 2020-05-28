package com.wsfzsc.controller.front;

import com.wsfzsc.pojo.Commodity;
import com.wsfzsc.pojo.KindBase;
import com.wsfzsc.service.CommodityService;
import com.wsfzsc.service.KindBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/frontCommodity")
public class FrontCommodityController {
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private KindBaseService kindBaseService;

    //显示所有商品信息
    @RequestMapping("/selectAll")
    public String selectAll(HttpServletRequest request){
        //上架的货物
        List<Commodity> list = commodityService.selectCommodityUp();
        //商品类别
        List<KindBase> kindBases = kindBaseService.showAll();
        //模拟热卖商品和好评商品
        List<Commodity> hotlist = new ArrayList<>();
        List<Commodity> goodlist = new ArrayList<>();
        for(int count = 0 ; count < list.size() ; count ++){
            if(count <= 4){
                hotlist.add(list.get(count));
            }else{
                goodlist.add(list.get(count));
            }
        }
        request.setAttribute("kindBases",kindBases);
        request.setAttribute("hotlist",hotlist);
        request.setAttribute("goodlist",goodlist);
        return "forward:/index.jsp";
    }

    //显示指定商品信息
    @RequestMapping("/selectOne")
    public String selectOne(Integer commodityId, HttpServletRequest request){
        Commodity commodity = commodityService.selectOne(commodityId);
        request.setAttribute("commodity",commodity);
        return "front/commoditydetails";
    }

    //显示指定商品信息 json传输
    @RequestMapping("/selectOneJson")
    @ResponseBody
    public Commodity selectOneJson(Integer commodityId){
        Commodity commodity = commodityService.selectOne(commodityId);
        return commodity;
    }

    //根据商品类别显示
    @RequestMapping("/selectByKind")
    public String selectByKind(Integer kindId, HttpServletRequest request){
        List<Commodity> commodityKindList = commodityService.selectByKind(kindId);
        request.setAttribute("commodityList",commodityKindList);
        return "front/frontShow";
    }

    //根据商品的简单信息模糊查询
    @RequestMapping("/selectByDim")
    public String selectByDim(String selectCommodity, HttpServletRequest request){
        List<Commodity> list = commodityService.selectCommodity(selectCommodity);
        request.setAttribute("commodityList",list);
        return "front/frontShow";
    }

}
