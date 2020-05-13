package com.wsfzsc.service;

import com.wsfzsc.pojo.Indent;

import java.util.List;

public interface IndentService {
    List<Indent> showAll(Integer status);

    Integer updateStatus(List<Integer> list, Integer upd_status);
}
