package com.wsfzsc.service.Impl;

import com.wsfzsc.mapper.CommodityMapper;
import com.wsfzsc.mapper.QuestionMapper;
import com.wsfzsc.pojo.Commodity;
import com.wsfzsc.pojo.CommodityExample;
import com.wsfzsc.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityMapper commodityDao;

    private QuestionMapper questionDao;

    //全部商品
    @Override
    public List<Commodity> selectAll() {
        List<Commodity> commodities = commodityDao.selectByExampleWithKind(null);
        return commodities;
    }

    //校验商品名称
    @Override
    public boolean select_check_name(String check_name) {
        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityNameEqualTo(check_name);
        long l = commodityDao.countByExample(commodityExample);
        return l==1;
    }

    /**
     * 更新本地文件夹的图片
     *  1.找到本地文件夹图片地址
     *  2.删除图片
     *  3.增添新图片 返回图片路径
     */
    @Override
    public String updatePhoto(MultipartFile file, Integer upd_id) {
        //获取到路径
        String oldPath = "D:"+commodityDao.selectByPrimaryKey(upd_id).getCommodityPicture();
        File oldFile = new File(oldPath);
        if(oldFile.exists()){
            oldFile.delete();
            System.out.println("成功删除");
        }
        return this.insertPhoto(file);
    }

    @Override
    public Integer updateCommodity(Commodity commodity) {
        Integer i = commodityDao.updateByPrimaryKeySelective(commodity);
        return i;
    }

    /*public String updatePhoto( Integer upd_id) {
        //获取到路径
        String oldPath = "D:"+commodityDao.selectByPrimaryKey(upd_id).getCommodityPicture();
        File oldFile = new File(oldPath);
        if(oldFile.exists()){
            oldFile.delete();
            System.out.println("成功删除");
        }
        return null;
    }*/
    //模糊查询 名称 详情 风格
    @Override
    public List<Commodity> selectCommodity(String commodity_name) {
        List<Commodity> list = commodityDao.selectByCommodityName("%"+commodity_name+"%");
        return list;
    }

    //修改商品是否上架
    @Override
    public Integer updateStatus(List<Integer> lists,Integer i) {
        Commodity commodity = new Commodity();
        commodity.setCommodityStatus(i);
        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityIdIn(lists);
        Integer k = commodityDao.updateByExampleSelective(commodity,commodityExample);
        return k;
    }

    //单个删除
    @Override
    public Integer deleteCommodity(Integer deleteId) {
        Integer i = commodityDao.deleteByPrimaryKey(deleteId);
        return i;
    }

    //批量删除
    @Override
    public Integer deleteBatch(List<Integer> list) {
        CommodityExample commodityExample = new CommodityExample();
        CommodityExample.Criteria criteria = commodityExample.createCriteria();
        criteria.andCommodityIdIn(list);
        Integer i = commodityDao.deleteByExample(commodityExample);
        return i;
    }

    //id 查询单个
    @Override
    public Commodity selectOne(Integer selectId) {
        Commodity commodity = commodityDao.selectByPrimaryKey(selectId);
        return commodity;
    }

    //增添数据
    @Override
    public Integer insertCommodity(Commodity commodity) {
        Integer i = commodityDao.insertSelective(commodity);
        return i;
    }

    @Override
    public String insertPhoto(MultipartFile file) {
        //声明存放文件的路径
        String filepath = "D:\\photoUpLoad";
        //获取到文件的名字
        String filename = file.getOriginalFilename();
        final String replace = UUID.randomUUID().toString().substring(0,5);
        filename = replace+"_"+filename;
        File fullpath = new File(filepath,filename);
        String filesave = "\\photoUpLoad\\"+filename;
        //存放文件
        try{
            file.transferTo(fullpath);
            return filesave;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
