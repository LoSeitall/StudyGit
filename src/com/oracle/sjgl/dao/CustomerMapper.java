package com.oracle.sjgl.dao;

import java.util.List;

import com.oracle.sjgl.po.Customer;
import com.oracle.sjgl.util.LimitNum;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer cusid);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer cusid);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    List<Customer> selectAllCustomer(LimitNum ln);
    
    List<Customer> customerCount();
    
    List<Customer> customerCountCondition(Customer customer);
    
    List<Customer> selectAllCustomerByCondition(Customer customer);
}