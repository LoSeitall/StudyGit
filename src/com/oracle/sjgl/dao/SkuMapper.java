package com.oracle.sjgl.dao;

import java.util.List;

import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.util.LimitNum;

public interface SkuMapper {
    int deleteByPrimaryKey(Integer skuid);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer skuid);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
    
    List<Sku> selectAll(LimitNum ln);
    
    Sku selectByPid(Sku sku);
    
    int updateByPidSelective(Sku record);
    
    List<Sku> selectAllCount();
    
}