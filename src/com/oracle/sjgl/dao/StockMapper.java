package com.oracle.sjgl.dao;

import java.util.List;
import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.util.LimitNum;

public interface StockMapper {
    int deleteByPrimaryKey(Integer stid);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer stid);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
    
    List<Stock> selectAll(LimitNum ln);
    
    List<Stock> stockCount();
    
    List<Stock> StockConditionCount(Stock stock);
    
    List<Stock> selectAllBycondition(Stock stock);
    
    List<Stock> stockCount (Stock stock);
}