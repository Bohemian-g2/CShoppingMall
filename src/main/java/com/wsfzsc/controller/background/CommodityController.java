package com.wsfzsc.controller.background;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsfzsc.pojo.Commodity;
import com.wsfzsc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService commodityService;

    //显示全部数据（部分列）select_check_name
    @RequestMapping("/showAll")
    public @ResponseBody
    PageInfo showAll(@RequestParam("pn") Integer pn, Model model){
        PageHelper.startPage(pn,10);
        List<Commodity> lists = commodityService.selectAll();
        PageInfo pageInfo = new PageInfo(lists,5);
        return pageInfo;
    }

    //显示单个数据
    @RequestMapping("/selectOne")
    public @ResponseBody Commodity selectOne(@RequestParam("selectId") Integer selectId,Model model){
        Commodity commodity = commodityService.selectOne(selectId);
        return commodity;
    }

    //校验商品名称
    @RequestMapping("/select_check_name")
    public @ResponseBody
    String select_check_name(@RequestParam("check_name") String check_name, Model model){
        boolean check = commodityService.select_check_name(check_name);
        if(check == true){
            return "error";
        }else{
            return "success";
        }
    }

    /**
     * 添加单个数据 在这里分成两步
     * 1.insertPhoto 方法 作用只存放文件 返回保存的文件路径(方便查询)
     * 2.insertCommodity 方法 因为有Date类型 无法直接封装成实体类对象(暂时没有方法)
     *      所以通过拿参数的笨方法 在Controller层生成实体类对象
     * @param file
     * @param model
     * @return
     */
    @RequestMapping("/insertPhoto")
    public @ResponseBody
    String insertPhoto(@RequestParam("file") MultipartFile file, Model model){
        String filename = commodityService.insertPhoto(file);
        return filename;
    }

    //增添商品
    @RequestMapping("/insertCommodity")
    public @ResponseBody
    Integer insertCommodity(Integer commodityKind, String commodityName, Integer commodityStatus, Float commodityMoney,
                            Integer commodityStock, String commoditySize, Integer commoditySex, String commodityPicture,
                            String commodityDescript, String commodityColor, String commodityStyle, String commoditySource, @DateTimeFormat(pattern = "yyyy-MM-dd") Date commodityDate, Model model ){
        Commodity commodity = new Commodity();
        commodity.setCommodityName(commodityName);
        commodity.setCommodityKind(commodityKind);
        commodity.setCommodityStatus(commodityStatus);
        commodity.setCommodityMoney(commodityMoney);
        commodity.setCommodityStock(commodityStock);
        commodity.setCommoditySize(commoditySize);
        commodity.setCommoditySex(commoditySex);
        commodity.setCommodityPicture(commodityPicture);
        commodity.setCommodityDescript(commodityDescript);
        commodity.setCommodityColor(commodityColor);
        commodity.setCommodityStyle(commodityStyle);
        commodity.setCommoditySource(commoditySource);
        commodity.setCommodityDate(commodityDate);
        Integer i = commodityService.insertCommodity(commodity);
        return i;
    }

    //更新照片库 先删除 再添加
    @RequestMapping("/updatePhoto")
    public @ResponseBody
    String updatePhoto(MultipartFile file, Integer upd_id){
        String filepath = commodityService.updatePhoto(file,upd_id);
        return filepath;
    }

    //更新商品
    @RequestMapping("/updateCommodity")
    public @ResponseBody
    Integer updateCommodity (Integer commodityId, Integer commodityKind, String commodityName, Float commodityMoney,
                             Integer commodityStock, String commoditySize, Integer commoditySex, String commodityPicture,
                             String commodityDescript, String commodityColor, String commodityStyle, String commoditySource, @DateTimeFormat(pattern = "yyyy-MM-dd") Date commodityDate, Model model ){
        Commodity commodity = new Commodity();
        commodity.setCommodityId(commodityId);
        commodity.setCommodityName(commodityName);
        commodity.setCommodityKind(commodityKind);
        commodity.setCommodityMoney(commodityMoney);
        commodity.setCommodityStock(commodityStock);
        commodity.setCommoditySize(commoditySize);
        commodity.setCommoditySex(commoditySex);
        commodity.setCommodityPicture(commodityPicture);
        commodity.setCommodityDescript(commodityDescript);
        commodity.setCommodityColor(commodityColor);
        commodity.setCommodityStyle(commodityStyle);
        commodity.setCommoditySource(commoditySource);
        commodity.setCommodityDate(commodityDate);
        Integer i = commodityService.updateCommodity(commodity);
        return i;
    }
    //模糊查询 可从名称 详情 风格 进行查询
    @RequestMapping("/selectCommodity")
    public @ResponseBody
    PageInfo selectCommodity(@RequestParam("pn") Integer pn, @RequestParam("data") String commodity_name, Model model){
        PageHelper.startPage(pn,10);
        List<Commodity> lists = commodityService.selectCommodity(commodity_name);
        PageInfo pageInfo = new PageInfo(lists,5);
        return pageInfo;
    }

    //更新商品是否上架
    @RequestMapping("/updateStatus")
    public @ResponseBody
        Integer updateStatus(@RequestParam("commodity_status") String commodity_status, @RequestParam("upd_status") String upd_status, Model model){
        Integer i;
        String[] list = commodity_status.split("-");
        List<Integer> lists = new ArrayList<>();
        for(String s : list){
            lists.add(Integer.parseInt(s));
        }
        if(upd_status.equals("true")){
            //上架
            i = commodityService.updateStatus(lists,1);
        }else {
            //下架
            i = commodityService.updateStatus(lists,2);
        }
        return i;
    }
    //删除单个
    @RequestMapping("/deleteCommodity")
    public @ResponseBody
        Integer deleteCommodity(@RequestParam("deleteId") Integer deleteId, Model model){
        Integer i = commodityService.deleteCommodity(deleteId);
        return i;
    }
    //批量删除
    @RequestMapping("/deleteBatchCommodity")
    public @ResponseBody
        Integer deleteBatchCommodity(@RequestParam("del_ids") String del_ids, Model model){
        List<Integer> list = new ArrayList<>();
        String[] del_id = del_ids.split("-");
        for(String s : del_id){
            list.add(Integer.parseInt(s));
        }
        Integer i = commodityService.deleteBatch(list);
        return i;
    }

}
