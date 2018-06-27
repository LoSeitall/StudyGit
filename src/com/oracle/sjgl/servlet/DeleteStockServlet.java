package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.service.ProductService;

public class DeleteStockServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String stid = request.getParameter("stid");
		String count = request.getParameter("count");
		String pid = request.getParameter("pid");
		String shop = request.getParameter("shop");
		
		Stock stock = new Stock();
		Sku sku = ps.selectSkuByPid(pid,shop);
		stock.setStid(Integer.parseInt(stid));
		stock.setPid(Integer.parseInt(pid));
		stock.setIsDel(1);
		sku.setPid(Integer.parseInt(pid));
		sku.setSkuNum(sku.getSkuNum()-Integer.parseInt(count));
		sku.setShop(shop);
		
		ps.deleteByPrimaryKey(stock);
		ps.updateByPid(sku);
		
		request.getRequestDispatcher("SelectStockListDeleteServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
