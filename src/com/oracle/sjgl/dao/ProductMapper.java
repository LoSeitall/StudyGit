package com.oracle.sjgl.dao;

import java.util.List;

import com.oracle.sjgl.po.Product;
import com.oracle.sjgl.util.LimitNum;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

	List<Product> selectAll(LimitNum ln);
	
	List<Product> ProductCount();
	
	List<Product> selectProductByCondition(Product product);
	
	List<Product> ProductCountCondition(Product p);
}