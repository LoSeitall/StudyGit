package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Customer;
import com.oracle.sjgl.service.CustomService;

public class InsertCustomerServlet extends HttpServlet {

	private CustomService cs = new CustomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cusname = request.getParameter("cusname");
		String cusphone = request.getParameter("cusphone");
		String pid = request.getParameter("pid");
		String custime = request.getParameter("custime");
		String descr = request.getParameter("descr");
		
		Customer cus = new Customer();
		cus.setCusname(cusname);
		cus.setCusphone(cusphone);
		cus.setDescr(descr);
		cus.setPid(Integer.parseInt(pid));
		try {
			cus.setCustime(new SimpleDateFormat("yyyy-MM-dd").parse(custime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cs.insertCustomer(cus);
		
		request.getRequestDispatcher("SelectCustomerListServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
