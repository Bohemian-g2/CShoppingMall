package com.wsfzsc.service;

import com.wsfzsc.pojo.KindBase;

import java.util.List;

/**
 * 商品类别接口
 * YSC 2020.04.23
 */
public interface KindBaseService {

    List<KindBase> showAll();

    KindBase showKind(Integer upd_id);

    boolean check_kind(String kind_name);

    Integer updateKind(KindBase kindBase);

    Integer deleteKind(Integer delete_id);

    Integer deleteBatchKind(List<Integer> list);

    List<KindBase> selectKind(String kind_name);

    Integer insertKind(KindBase kindBase);
}
