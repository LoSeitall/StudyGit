package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.service.ProductService;
import com.oracle.sjgl.util.DateFormat;

public class InsertStockListServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		String mid = request.getParameter("mid");
		String count = request.getParameter("count");
		String price = request.getParameter("price");
		String time = request.getParameter("time");
		String shop = request.getParameter("shop");
		String marketPrice = request.getParameter("marketprice");

		Stock s = new Stock();
		s.setPid(Integer.parseInt(pid));
		s.setMid(Integer.parseInt(mid));
		s.setCid(Integer.parseInt(cid));
		s.setCount(Integer.parseInt(count));
		s.setTime(DateFormat.StringToDate(time));
		ps.insertSelective(s);
		
		Sku sku = new Sku();
		sku.setPid(Integer.parseInt(pid));
		sku.setMid(Integer.parseInt(mid));
		sku.setCid(Integer.parseInt(cid));
		sku.setSkuNum(Integer.parseInt(count));
		sku.setPrice(Integer.parseInt(price));
		sku.setMarketPrice(Integer.parseInt(marketPrice));
		sku.setShop(shop);
		ps.insertSelective(sku);
		
		request.getRequestDispatcher("SelectStockListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
