package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Customer;
import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.service.CustomService;
import com.oracle.sjgl.service.EmpService;

public class UpdateCustomerServlet extends HttpServlet {

	private CustomService cs = new CustomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String cusid = request.getParameter("cusid");
		String cusname = request.getParameter("cusname");
		String pid = request.getParameter("pid");
		String custime = request.getParameter("custime");
		String cusphone = request.getParameter("cusphone");
		String descr = request.getParameter("descr");
		
		Customer c = new Customer();
		c.setCusid(Integer.parseInt(cusid));
		c.setCusname(cusname);
		c.setCusphone(cusphone);
		c.setDescr(descr);
		c.setPid(Integer.parseInt(pid));
		try {
			c.setCustime(new SimpleDateFormat("yyyy-MM-dd").parse(custime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cs.updateCustomer(c);
		
		request.getRequestDispatcher("SelectCustomerListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}


}
