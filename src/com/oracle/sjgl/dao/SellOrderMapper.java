package com.oracle.sjgl.dao;

import java.util.List;
import com.oracle.sjgl.po.SellOrder;
import com.oracle.sjgl.util.LimitNum;

public interface SellOrderMapper {

	int deleteByPrimaryKey(Integer oid);

    int insert(SellOrder record);

    int insertSelective(SellOrder record);

    SellOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(SellOrder record);

    int updateByPrimaryKey(SellOrder record);

    List<SellOrder> selectAll(LimitNum ln);

    List<SellOrder> selectAllCount();

    List<SellOrder> selectAllByCondition(SellOrder so);

    List<SellOrder> selectAllByConditionCount(SellOrder so);

    SellOrder selectByPid(SellOrder so);


}
