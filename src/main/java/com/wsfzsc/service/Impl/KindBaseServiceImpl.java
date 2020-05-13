package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.KindBaseMapper;
import com.wsfzsc.pojo.KindBase;
import com.wsfzsc.pojo.KindBaseExample;
import com.wsfzsc.service.KindBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * YSC 2020.04.23
 */
@Service("kindBaseService")
public class KindBaseServiceImpl implements KindBaseService {

    @Autowired
    private KindBaseMapper kindBaseDao;

    //显示所有数据
    @Override
    public List<KindBase> showAll() {
        List<KindBase> list = kindBaseDao.selectByExample(null);
        return list;
    }

    //用id选择商品类别信息
    @Override
    public KindBase showKind(Integer upd_id) {
        KindBase kindBase = kindBaseDao.selectByPrimaryKey(upd_id);
        return kindBase;
    }

    //查看商品类别是否重复
    @Override
    public boolean check_kind(String kind_name) {
        KindBaseExample kindBaseExample = new KindBaseExample();
        KindBaseExample.Criteria criteria = kindBaseExample.createCriteria();
        criteria.andKindNameEqualTo(kind_name);
        Long check = kindBaseDao.countByExample(kindBaseExample);
        return check == 0;
    }

    //修改商品类别
    @Override
    public Integer updateKind(KindBase kindBase) {
        Integer i = kindBaseDao.updateByPrimaryKey(kindBase);
        return i;
    }

    //删除单个商品类别
    @Override
    public Integer deleteKind(Integer delete_id) {
        Integer i = kindBaseDao.deleteByPrimaryKey(delete_id);
        return i;
    }

    //批量删除
    @Override
    public Integer deleteBatchKind(List<Integer> list) {
        KindBaseExample kindBaseExample = new KindBaseExample();
        KindBaseExample.Criteria criteria = kindBaseExample.createCriteria();
        criteria.andKindIdIn(list);
        Integer i = kindBaseDao.deleteByExample(kindBaseExample);
        return i;
    }

    //查询商品类别 带模糊
    @Override
    public List<KindBase> selectKind(String kind_name) {
        KindBaseExample kindBaseExample = new KindBaseExample();
        KindBaseExample.Criteria criteria = kindBaseExample.createCriteria();
        criteria.andKindNameLike("%" + kind_name + "%");
        List<KindBase> kindBases = kindBaseDao.selectByExample(kindBaseExample);
        return kindBases;
    }

    //增添类别
    @Override
    public Integer insertKind(KindBase kindBase) {
        Integer i = kindBaseDao.insertSelective(kindBase);
        return i;
    }
}
