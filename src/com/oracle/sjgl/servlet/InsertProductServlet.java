package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Product;
import com.oracle.sjgl.service.ProductService;

public class InsertProductServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String type = request.getParameter("type");
		String time = request.getParameter("time");
		String supplier = request.getParameter("supplier");
		
		Product p = new Product();
		
		ps.insertProductSelective(p);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
