package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.service.ProductService;

public class UpdateStockServlet extends HttpServlet {
	
	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//接收参数
		String stid = request.getParameter("stid");
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		String mid = request.getParameter("mid");
		String count = request.getParameter("count");
		
		Stock s = new Stock();
		s.setStid(Integer.parseInt(stid));
		s.setPid(Integer.parseInt(pid));
		s.setMid(Integer.parseInt(mid));
		s.setCount(Integer.parseInt(count));
		s.setCid(Integer.parseInt(cid));
		
		ps.updateByPrimaryKey(s);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
