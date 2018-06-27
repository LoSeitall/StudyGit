package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.service.ProductService;

public class DeleteSkuServlet extends HttpServlet {
	
	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String skuid = request.getParameter("skuid");
		
		Sku sku = new Sku();
		
		sku.setSkuid(Integer.parseInt(skuid));
		sku.setIsDel(1);
		
		ps.deleteByPrimaryKey(sku);
		
		request.getRequestDispatcher("content/institution-listskuupdate.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
