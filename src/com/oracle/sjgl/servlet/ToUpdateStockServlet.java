package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.service.ProductService;

public class ToUpdateStockServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ղ���
		String stid = request.getParameter("stid");
		
		request.setAttribute("stock", ps.selectStockByPrimaryKey(stid));
		
		request.getRequestDispatcher("content/institution-editstock.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
