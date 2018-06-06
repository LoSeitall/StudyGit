package com.oracle.sjgl.dao;

import java.util.List;

import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.util.LimitNum;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer eid);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer eid);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
    
    List<Emp> selectAll(LimitNum ln); 
    
    List<Emp> EmpCount();
    
    List<Emp> selectAllByCondition(Emp emp);
    
    List<Emp> EmpCountCondition(Emp emp);
}