package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.CDetailMapper;
import com.wsfzsc.mapper.CartMapper;
import com.wsfzsc.mapper.CommodityMapper;
import com.wsfzsc.pojo.*;
import com.wsfzsc.service.CDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cDetailService")
public class CDetailServiceImpl implements CDetailService {

    @Autowired
    private CDetailMapper cDetailDao;

    @Autowired
    private CartMapper cartDao;

    @Autowired
    private CommodityMapper commodityDao;

    @Override
    public List<CDetail> selectAll(Integer userId) {
        /**
         * 通过userId获取cartId
         */
        CartExample cartExample = new CartExample();
        CartExample.Criteria criteria1 = cartExample.createCriteria();
        criteria1.andCartUserIdEqualTo(userId);
        List<Cart> carts = cartDao.selectByExample(cartExample);
        //查询购物车详情
        if(carts.size() != 0){
            CDetailExample cDetailExample = new CDetailExample();
            CDetailExample.Criteria criteria = cDetailExample.createCriteria();
            criteria.andCartIdEqualTo(carts.get(0).getCartId());
            List<CDetail> cDetails = cDetailDao.selectByExampleWithCommodityCart(cDetailExample);
            return cDetails;
        }
        return null;
    }

    @Override
    public String insertOne(Integer commodityId, Integer userId) {
        //先判断是否有货
        if(commodityDao.selectByPrimaryKey(commodityId).getCommodityStock() <= 0){
            return "stockout";
        }else{
            //拿商品单价
            Float commodityMoney = commodityDao.selectByPrimaryKey(commodityId).getCommodityMoney();
            //对购物车大表是否有值进行判断
            CartExample cartExample = new CartExample();
            CartExample.Criteria criteria = cartExample.createCriteria();
            criteria.andCartUserIdEqualTo(userId);
            //说明购物车没有数据 即创建一个购物车
            if(cartDao.selectByExample(cartExample).size() == 0){
                Cart cart = new Cart();
                cart.setCartUserId(userId);
                cart.setCartCapacity(120);
                cartDao.insertSelective(cart);
                //拿购物车ID
                CartExample cartExample1 = new CartExample();
                CartExample.Criteria criteria1 = cartExample1.createCriteria();
                criteria1.andCartUserIdEqualTo(userId);
                Integer cartId = (cartDao.selectByExample(cartExample1)).get(0).getCartId();
                //购物车详情表存放数据 只添加一个
                cDetailDao.insert(new CDetail(cartId,commodityId,1,commodityMoney));
                return "true";
            }
            //购物车有数据的情况
            //拿购物车ID
            CartExample cartExample1 = new CartExample();
            CartExample.Criteria criteria1 = cartExample1.createCriteria();
            criteria1.andCartUserIdEqualTo(userId);
            Integer cartId = cartDao.selectByExample(cartExample1).get(0).getCartId();
            //判断购物车详情表是否有该商品 有就加一 没有就新增数据
            if(cDetailDao.selectByPrimaryKey(new CDetailKey(cartId,commodityId)) != null){
                //存在数据 更新数据
                Integer number = cDetailDao.selectByPrimaryKey(new CDetailKey(cartId,commodityId)).getCartCommodityNumbe();
                Float money = cDetailDao.selectByPrimaryKey(new CDetailKey(cartId, commodityId)).getCartCommodityMoney();
                cDetailDao.updateByPrimaryKeySelective(new CDetail(cartId,commodityId,number+1,money+commodityMoney));
                return "true";
            }else{
                cDetailDao.insert(new CDetail(cartId,commodityId,1,commodityMoney));
                return "true";
            }
        }
    }

    @Override
    public Integer updateCDetailMoney(Integer cartId, Integer commodityId, Integer opera) {
        CDetail cDetail = this.selectOne(cartId,commodityId);
        CDetail cDetail1 = new CDetail();
        cDetail1.setCartId(cartId);
        cDetail1.setCartCommodityId(commodityId);
        /**
         * opera 0减少 1增加
         */
        if(opera == 0){
            cDetail1.setCartCommodityNumbe(cDetail.getCartCommodityNumbe()-1);
            cDetail1.setCartCommodityMoney(cDetail.getCartCommodityMoney()-cDetail.getCommodity().getCommodityMoney());
        }else{
            //加商品
            cDetail1.setCartCommodityNumbe(cDetail.getCartCommodityNumbe()+1);
            cDetail1.setCartCommodityMoney(cDetail.getCartCommodityMoney()+cDetail.getCommodity().getCommodityMoney());
        }
        Integer i = cDetailDao.updateByPrimaryKeySelective(cDetail1);
        return i;
    }

    @Override
    public CDetail selectOne(Integer cartId, Integer commodityId) {
        CDetailExample cDetailExample = new CDetailExample();
        CDetailExample.Criteria criteria = cDetailExample.createCriteria();
        criteria.andCartIdEqualTo(cartId);
        criteria.andCartCommodityIdEqualTo(commodityId);
        CDetail cDetail = cDetailDao.selectByExampleWithCommodityCart(cDetailExample).get(0);
        return cDetail;
    }

    //批量删除 单个删除
    @Override
    public Integer deleteBatch(Integer cartId, List<Integer> commodityIdList) {
        CDetailExample cDetailExample = new CDetailExample();
        CDetailExample.Criteria criteria = cDetailExample.createCriteria();
        criteria.andCartIdEqualTo(cartId);
        criteria.andCartCommodityIdIn(commodityIdList);
        Integer i = cDetailDao.deleteByExample(cDetailExample);
        return i;
    }

}
