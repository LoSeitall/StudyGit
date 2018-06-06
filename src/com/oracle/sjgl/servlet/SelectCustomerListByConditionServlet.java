package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Customer;
import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.service.CustomService;
import com.oracle.sjgl.util.PageUtil;

public class SelectCustomerListByConditionServlet extends HttpServlet {
	
	private CustomService cs = new CustomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String pid = request.getParameter("pid");
		String cusid = request.getParameter("cusid");
		String cusname = request.getParameter("cusname");
		String pageno = request.getParameter("pageno");
		String size = request.getParameter("size");
		System.out.println(pid+cusid+cusname);
		if("".equals(pageno)||pageno==null){
			pageno = "1";
		}
		if("".equals(size)||size==null){
			size = "5";
		}
		
		Customer cus = new Customer();
		if(pid!=null&&!"".equals(pid)){
			cus.setPid(Integer.parseInt(pid));
		}
		if(cusid!=null&&!"".equals(cusid)){
			cus.setCusid(Integer.parseInt(cusid));
		}
		if(cusname!=null&&!"".equals(cusname)){
			cus.setCusname(cusname);
		}
		PageUtil pu = cs.selectAllCustomerByCondition(Integer.parseInt(pageno), Integer.parseInt(size), cus);
		
		request.setAttribute("pid",pid);
		request.setAttribute("cusname", cusname);
		request.setAttribute("cusid", cusid);
		request.setAttribute("pageutil", pu);
		request.getRequestDispatcher("content/institution-customerlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
