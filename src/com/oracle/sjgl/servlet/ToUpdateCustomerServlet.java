package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.service.CustomService;

public class ToUpdateCustomerServlet extends HttpServlet {
	
	private CustomService cs = new CustomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接送参数
		String cusid = request.getParameter("cusid");
		
		request.setAttribute("customer", cs.selectCustomerByPrimaryKey(Integer.parseInt(cusid)));
		
		//转发
		request.getRequestDispatcher("content/institution-editcustomer.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
