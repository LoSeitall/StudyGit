package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.SellOrder;
import com.oracle.sjgl.service.ProductService;

public class ToUpdateSellOrderServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String oid = request.getParameter("oid");
		
		SellOrder so = ps.selectOneOrder(Integer.parseInt(oid));
		
		request.setAttribute("so", so);
		request.getRequestDispatcher("content/institution-editsellorder.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
