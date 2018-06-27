package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.service.CustomService;
import com.oracle.sjgl.util.PageUtil;

public class SelectCustomerListServlet extends HttpServlet {
	
	private CustomService cs = new CustomService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageno = request.getParameter("pageno");
		String size = request.getParameter("size");
		if("".equals(pageno)||pageno==null){
			pageno = "1";
		}
		if("".equals(size)||size==null){
			size = "5";
		}
		PageUtil pu = cs.selectAllCustomer(Integer.parseInt(pageno),Integer.parseInt(size));
		request.setAttribute("pageutil", pu);
		request.getRequestDispatcher("content/institution-customerlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
