package com.wsfzsc.service;

import com.wsfzsc.pojo.Address;
import com.wsfzsc.pojo.Indent;

import java.util.List;
import java.util.Map;

public interface IndentService {
    List<Indent> showAll(Integer status);

    Integer updateStatus(List<Integer> list, Integer upd_status);

    public Integer saveIndent(Integer user_id, float total);

    public List<Indent> getAllIndentByUid(Integer uid);

    public Map<String,String> payIndent(int id, int addressId, int payway);

    public void deleteIndent(int id);

    public void sureIndent(int id);

    public List<Address> getAddressByUserid(Integer id);

    public void changeIndent(int id);

    public Integer insertComment(int indentId,String myComment);
}
