package com.wsfzsc.service;

import com.wsfzsc.pojo.Commodity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommodityService {
    List<Commodity> selectAll();

    List<Commodity> selectCommodity(String commodity_name);

    Integer updateStatus(List<Integer> lists, Integer i);

    Integer deleteCommodity(Integer deleteId);

    Integer deleteBatch(List<Integer> list);

    Commodity selectOne(Integer selectId);

    Integer insertCommodity(Commodity commodity);

    String insertPhoto(MultipartFile file);

    boolean select_check_name(String check_name);

    String updatePhoto(MultipartFile file, Integer upd_id);

    Integer updateCommodity(Commodity commodity);

    List<Commodity> selectCommodityUp();

    List<Commodity> selectByKind(Integer kindId);
    /*获取单价*/
    public float getAccountByCId(Integer CommodityId);
}
