package com.oracle.sjgl.dao;

import java.util.List;

import com.oracle.sjgl.po.Salary;

public interface SalaryMapper {
    int deleteByPrimaryKey(Integer said);

    int insert(Salary record);

    int insertSelective(Salary record);

    Salary selectByPrimaryKey(Integer said);

    int updateByPrimaryKeySelective(Salary record);

    int updateByPrimaryKey(Salary record);
    
    List<Salary> selectAll();
}