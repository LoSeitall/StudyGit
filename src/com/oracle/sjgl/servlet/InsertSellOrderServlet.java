package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.SellOrder;
import com.oracle.sjgl.service.ProductService;
import com.oracle.sjgl.util.DateFormat;

public class InsertSellOrderServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String eid = request.getParameter("eid");
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		String mid = request.getParameter("mid");
		String price = request.getParameter("price");
		String time = request.getParameter("time");
		String count = request.getParameter("count");
		String shop = request.getParameter("shop");

		SellOrder so = new SellOrder();
		so.setEid(Integer.parseInt(eid));
		so.setPid(Integer.parseInt(pid));
		so.setCid(Integer.parseInt(cid));
		so.setMid(Integer.parseInt(mid));
		so.setPrice(Integer.parseInt(price));
		so.setCount(Integer.parseInt(count));
		so.setTime(DateFormat.StringToDate(time));
		so.setShop(shop);
		ps.insertOrder(so);
		
		request.getRequestDispatcher("SelectSellOrderServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
