package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.po.SellOrder;
import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.service.ProductService;

public class DeleteSellOrderServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String oid = request.getParameter("oid");
		String pid = request.getParameter("pid");
		String count = request.getParameter("count");
		String shop = request.getParameter("shop");
		
		SellOrder so = ps.selectOneOrder(Integer.parseInt(oid));
		Sku sku = ps.selectSkuByPid(pid,shop);
		so.setIsDel(1);
		sku.setSkuNum(sku.getSkuNum()+Integer.parseInt(count));
		ps.deleteOrder(so);
		ps.updateByPrimaryKey(sku);
		
		request.getRequestDispatcher("SelectSellOrderServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
