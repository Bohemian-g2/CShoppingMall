package com.wsfzsc.service;

import com.wsfzsc.pojo.IndentDetail;

import java.util.List;

public interface IndentDetailService {
    List<IndentDetail> showById(Integer indentId);

    public String saveIndentDetail(Integer indent_id, Integer goods_id, Integer goods_num);


}
