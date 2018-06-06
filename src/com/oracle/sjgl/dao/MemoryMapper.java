package com.oracle.sjgl.dao;

import com.oracle.sjgl.po.Memory;

public interface MemoryMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Memory record);

    int insertSelective(Memory record);

    Memory selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Memory record);

    int updateByPrimaryKey(Memory record);
}