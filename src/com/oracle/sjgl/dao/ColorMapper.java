package com.oracle.sjgl.dao;

import com.oracle.sjgl.po.Color;

public interface ColorMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Color record);

    int insertSelective(Color record);

    Color selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);
}