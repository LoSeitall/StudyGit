package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Product;
import com.oracle.sjgl.service.ProductService;

public class DeleteProductServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pid = request.getParameter("pid");
		
		Product product = new Product();
		
		product.setIsDel(1);
		
		ps.deleteProductById(product);
		
		request.getRequestDispatcher("SelectProductListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
