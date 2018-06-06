package com.oracle.sjgl.service;

import java.util.List;

import com.oracle.sjgl.dao.CustomerMapper;
import com.oracle.sjgl.po.Customer;
import com.oracle.sjgl.util.DateFormat;
import com.oracle.sjgl.util.LimitNum;
import com.oracle.sjgl.util.PageUtil;
import com.oracle.sjgl.util.getSession;

public class CustomService {
	
	private getSession gs = new getSession();
	
	public int customerCountCondition(Customer cus){
		
		return gs.getSession().getMapper(CustomerMapper.class).customerCountCondition(cus).size();
	
	}
	
	public PageUtil selectAllCustomerByCondition(int pageno,int size,Customer customer){
		
		PageUtil pu = new PageUtil();
		
		customer.setSize(size);
		
		customer.setLimitnum((pageno-1)*size);
		
		List<Customer> customerlist = gs.getSession().getMapper(CustomerMapper.class).selectAllCustomerByCondition(customer);
		
		
		for (Customer cus : customerlist) {
			cus.setScustime(DateFormat.changeDate(cus.getCustime()));
		}
		
		pu.setList(customerlist);
		
		pu.init(pageno, customerCountCondition(customer), size, "SelectCustomerListByConditionServlet");
		
		gs.closeSession();
		
		return pu;
	}
	
	public int customerCount(){
		
		return gs.getSession().getMapper(CustomerMapper.class).customerCount().size();
		
	
	}
	
	public void insertCustomer(Customer cus){
		
		gs.getSession().getMapper(CustomerMapper.class).insertSelective(cus);
		
		gs.closeSession();
		
	}
	
	public Customer selectCustomerByPrimaryKey(int cusid){
		
		Customer cus = gs.getSession().getMapper(CustomerMapper.class).selectByPrimaryKey(cusid);
		
		cus.setScustime(DateFormat.changeDate(cus.getCustime()));
		
		return cus;
		
	
	}
	
	public PageUtil selectAllCustomer(int pageno,int size){
		
		PageUtil pu = new PageUtil();
		
		LimitNum ln = new LimitNum(size,size*(pageno-1));
		
		List<Customer> customerlist = gs.getSession().getMapper(CustomerMapper.class).selectAllCustomer(ln);
		
		for (Customer cus : customerlist) {
			cus.setScustime(DateFormat.changeDate(cus.getCustime()));
		}
		
		pu.setList(customerlist);
		
		pu.init(pageno, customerCount(), size, "SelectCustomerListServlet");
		
		gs.closeSession();
		
		return pu;
	}
	
	public void deleteCustomer(Customer cus){
		
		gs.getSession().getMapper(CustomerMapper.class).updateByPrimaryKeySelective(cus);
		//gs.getSession().getMapper(CustomerMapper.class).deleteByPrimaryKey(cusid);
		
		gs.closeSession();
		
	}

	public void updateCustomer(Customer c) {
		
		gs.getSession().getMapper(CustomerMapper.class).updateByPrimaryKeySelective(c);
		
		gs.closeSession();
		
	}
	
}
