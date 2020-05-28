package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.*;
import com.wsfzsc.pojo.*;
import com.wsfzsc.service.CommentService;
import com.wsfzsc.service.CommodityService;
import com.wsfzsc.service.IndentDetailService;
import com.wsfzsc.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("indentService")
public class IndentServiceImpl implements IndentService {

    @Autowired
    private IndentMapper indentMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private IndentDetailService indentDetailService;

    @Override
    public List<Indent> showAll(Integer status) {
        IndentExample indentExample = new IndentExample();
        IndentExample.Criteria criteria = indentExample.createCriteria();
        criteria.andIndentStatusEqualTo(status);
        List<Indent> indents = indentMapper.selectByExampleWithUserAddress(indentExample);
        return indents;
    }

    //修改状态
    @Override
    public Integer updateStatus(List<Integer> list, Integer upd_status) {
        Indent indent = new Indent();
        indent.setIndentStatus(upd_status);
        IndentExample indentExample = new IndentExample();
        IndentExample.Criteria criteria = indentExample.createCriteria();
        criteria.andIndentIdIn(list);
        Date date = new Date();
        //退货
        if(upd_status == 1){
            indent.setIndentDrawbackMoneyTime(date);
        }else if(upd_status == 3){
            indent.setIndentEndTime(date);
        }
        Integer i = indentMapper.updateByExampleSelective(indent,indentExample);
        return i;
    }

    @Override
    public Integer saveIndent(Integer user_id,float total){
        Indent indent=new Indent();
        Integer indentRecId=222200; //联查address表 写该user_id的第一个收货人id（默认值） 先写死

        //插入该订单
        indent.setIndentUserId(user_id);
        indent.setIndentRecId(indentRecId);
        indent.setIndentStatus(0);
        indent.setIndentDeleteStatus(0);
        indent.setIndentTotal(total);
        indent.setIndentCarriage(12f);
        Date date = new Date(System.currentTimeMillis());
        /*设置下单时间*/
        indent.setIndentCreateTime(date);
        indentMapper.insertSelective(indent);

        //获得刚刚插入的订单的订单编号
        IndentExample example=new IndentExample();
        example.createCriteria().andIndentUserIdEqualTo(user_id).andIndentCreateTimeEqualTo(date);
        List<Indent> seIndent = indentMapper.selectByExample(example);

        return seIndent.get(0).getIndentId();
    }


    @Override
    public  List<Indent> getAllIndentByUid(Integer uid){

        IndentExample example=new IndentExample();
        //查找该用户所有未删除订单
        example.createCriteria().andIndentUserIdEqualTo(uid).andIndentDeleteStatusEqualTo(0);
        List<Indent> indents =indentMapper.selectByExample(example);

        return indents;
    }

    @Override
    public  Map<String,String> payIndent(int id,int addressId,int payway) {
        Indent indent=new Indent();
        Map<String,String> map=new HashMap<String,String>();
        List<IndentDetail> indentDetails= indentDetailService.showById(id); //查找该订单所有详情
        for ( IndentDetail indentDetail:indentDetails) {    //遍历订单详情
            Commodity commodity=indentDetail.getCommodity();    //获取该订单详情的商品
            System.out.println("indentDetail.getIndentGoodsNum()======"+indentDetail.getIndentGoodsNum());
            System.out.println("commodity.getCommodityStock()========"+commodity.getCommodityStock());
            if(indentDetail.getIndentGoodsNum()>commodity.getCommodityStock()){     //若购买数量大于库存，不可以成功购买
                indent.setIndentId(id);
                indent.setIndentStatus(0);      //支付状态：未支付
                indentMapper.updateByPrimaryKeySelective(indent);
                map.put("paymessage","支付失败！您购买的商品"+commodity.getCommodityName()+"库存不足");
                break;
            }else{    //若购买数量不大于库存，可以成功购买
                indent.setIndentId(id);
                indent.setIndentStatus(1);      //修改支付状态：已支付
                indent.setIndentWay(payway);     //修改支付方式：从前台取回
                indent.setIndentRecId(addressId);
                Date date = new Date(System.currentTimeMillis());
                indent.setIndentPaidTime(date);     //设置付款时间
                indentMapper.updateByPrimaryKeySelective(indent);
                Commodity updateCom =new Commodity();
                updateCom.setCommodityId(commodity.getCommodityId());
                updateCom.setCommodityStock(commodity.getCommodityStock()-indentDetail.getIndentGoodsNum());
                commodityService.updateCommodity(updateCom);  //修改库存
                map.put("paymessage","支付成功!");
            }
        }
        return map;
    }

    @Override
    public void deleteIndent(int id) {
        Indent indent=new Indent();
        indent.setIndentId(id);
        indent.setIndentDeleteStatus(1);
        indentMapper.updateByPrimaryKeySelective(indent);

    }

    @Override
    public void sureIndent(int id) {
        Indent indent=new Indent();
        indent.setIndentId(id);
        indent.setIndentStatus(3);
        Date date = new Date(System.currentTimeMillis());
        indent.setIndentEndTime(date);     //设置订单完成时间
        indentMapper.updateByPrimaryKeySelective(indent);
    }

    @Override
    public List<Address> getAddressByUserid(Integer id) {
        AddressExample addressExample=new AddressExample();
        addressExample.createCriteria().andUserIdEqualTo(id);
        List<Address> addresses= addressMapper.selectByExample(addressExample);

        return addresses;
    }

    @Override
    public void changeIndent(int id) {
        Indent indent=new Indent();
        indent.setIndentId(id);
        indent.setIndentStatus(2);
        Date date = new Date(System.currentTimeMillis());
        indent.setIndentDrawbackTime(date);     //设置订单换货时间
        indentMapper.updateByPrimaryKeySelective(indent);
    }

    @Override
    public Integer insertComment(int indentId, String myComment) {

        return commentService.insertComment(indentId,myComment);

    }


}
