package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.service.ProductService;

public class UpdateSkuServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String skuid = request.getParameter("skuid");
		String pid = request.getParameter("pid");	
		String cid = request.getParameter("cid"); 
		String mid = request.getParameter("mid");
		String price = request.getParameter("price");
		String marketPrice = request.getParameter("marketprice");
		String skunum = request.getParameter("skunum");
		String shop = request.getParameter("shop");
		
		Sku sku = new Sku();
		sku.setSkuid(Integer.parseInt(skuid));
		sku.setPid(Integer.parseInt(pid));
		sku.setCid(Integer.parseInt(cid));
		sku.setMid(Integer.parseInt(mid));
		sku.setPrice(Integer.parseInt(price));
		sku.setMarketPrice(Integer.parseInt(marketPrice));
		sku.setSkuNum(Integer.parseInt(skunum));
		sku.setShop(shop);
		
		ps.updateByPrimaryKey(sku);
		
		request.getRequestDispatcher("SelectSkuUpdateServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
