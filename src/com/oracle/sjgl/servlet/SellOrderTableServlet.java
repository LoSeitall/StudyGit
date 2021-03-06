package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.service.ProductService;

public class SellOrderTableServlet extends HttpServlet {
	
	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str = ps.SellOrderTableJson();
		
		request.setAttribute("str", str);
		
		request.getRequestDispatcher("content/xiaoshoutongji.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
