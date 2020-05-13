package com.wsfzsc.controller.background;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wsfzsc.pojo.KindBase;
import com.wsfzsc.service.KindBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类别
 * YSC
 */
@Controller
@RequestMapping("/kindBase")
public class KindBaseController {

    @Autowired
    private KindBaseService kindBaseService;

    //通过数字拿到具体的信息，如果没改的时候，默认是首页
    @RequestMapping("/show")
    public @ResponseBody
    PageInfo show(@RequestParam("pn") Integer pn, Model model){
        PageHelper.startPage(pn,10);
        List<KindBase> kindBaseList = kindBaseService.showAll();
        PageInfo pageInfo = new PageInfo(kindBaseList, 5);
        return pageInfo;
    }

    //显示所有商品类别
    @RequestMapping("/showKindName")
    public @ResponseBody
    List<KindBase> showKindName(Model model){
        List<KindBase> kindBaseList = kindBaseService.showAll();
        return kindBaseList;
    }

    //用id查询对应的商品类别名称
    @RequestMapping("/showKind")
    public @ResponseBody
    KindBase showKind(@RequestParam("upd_id") Integer upd_id, Model model){
        KindBase kindBase = kindBaseService.showKind(upd_id);
        return kindBase;
    }

    //增添商品类别
    @RequestMapping("/insertKind")
    public @ResponseBody
    Integer insertKind(KindBase kindBase, Model model){
        Integer i = kindBaseService.insertKind(kindBase);
        return i;
    }

    //查询类别信息 带模糊
    @RequestMapping("/selectKind")
    public @ResponseBody
    PageInfo selectKind(@RequestParam("pn") Integer pn, @RequestParam("kind_name") String kind_name, Model model){
        PageHelper.startPage(pn,10);
        List<KindBase> lists = kindBaseService.selectKind(kind_name);
        PageInfo pageInfo = new PageInfo(lists,5);
        return pageInfo;
    }

    //辅助查询 商品类别名称是否重复
    @RequestMapping("/check_kind")
    public @ResponseBody
        boolean check_kind(@RequestParam("kind_name")String kind_name, Model model){
        boolean check = kindBaseService.check_kind(kind_name);
        return check;
    }

    //更新商品类别信息
    @RequestMapping("/updateKind")
    public @ResponseBody
    Integer updateKind(KindBase kindBase, Model model){
        System.out.println(kindBase);
        Integer i = kindBaseService.updateKind(kindBase);
        return i;
    }

    //删除商品类别信息
    @RequestMapping("/deleteKind")
    public @ResponseBody
    Integer deleteKind(@RequestParam("delete_id") Integer delete_id, Model model){
        Integer i = kindBaseService.deleteKind(delete_id);
        return i;
    }

    //批量删除商品类别
    @RequestMapping("/deleteBatch")
    public @ResponseBody
    Integer deleteBatch(@RequestParam("deleteBatchIds") String deleteBatchIds, Model model){
        String[] split = deleteBatchIds.split("-");
        List<Integer> list = new ArrayList<>();
        for(String s : split){
            list.add(Integer.parseInt(s));
        }
        Integer i = kindBaseService.deleteBatchKind(list);
        return i;
    }
}
