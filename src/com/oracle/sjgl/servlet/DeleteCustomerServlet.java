package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Customer;
import com.oracle.sjgl.service.CustomService;

public class DeleteCustomerServlet extends HttpServlet {
	
	private CustomService cs = new CustomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接收参数
		String cusid = request.getParameter("cusid");
		
		Customer cus = cs.selectCustomerByPrimaryKey(Integer.parseInt(cusid));
		
		cus.setIsDel(1);
			
		cs.deleteCustomer(cus);
		
		//转发
		request.getRequestDispatcher("SelectCustomerListServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	} 

}
