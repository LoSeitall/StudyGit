package com.oracle.sjgl.dao;

import com.oracle.sjgl.po.SellOrder;

public interface SellOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(SellOrder record);

    int insertSelective(SellOrder record);

    SellOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(SellOrder record);

    int updateByPrimaryKey(SellOrder record);
}