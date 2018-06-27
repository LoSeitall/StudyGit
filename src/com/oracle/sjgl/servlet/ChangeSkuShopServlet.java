package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Sku;
import com.oracle.sjgl.service.ProductService;

public class ChangeSkuShopServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String skuid = request.getParameter("skuid");
		String originnum = request.getParameter("originnum");
		String skunum = request.getParameter("skunum");
		String shop = request.getParameter("shop");
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		String mid = request.getParameter("mid");
		
		if(Integer.parseInt(originnum)<Integer.parseInt(skunum)){
			request.setAttribute("msg", "调拨数量不得大于当前库存!");
			request.getRequestDispatcher("content/institution-editskuchangeshop.jsp").forward(request, response);
		}else{
			Sku sku = ps.selectByPrimaryKey(skuid);
			sku.setSkuid(Integer.parseInt(skuid));
			sku.setSkuNum(sku.getSkuNum()-Integer.parseInt(skunum));
			ps.updateByPrimaryKey(sku);
			Sku skunew = ps.selectSkuByPid(pid, shop);
			if(skunew==null){
				skunew = new Sku();
				skunew.setPid(Integer.parseInt(pid));
				skunew.setCid(Integer.parseInt(cid));
				skunew.setMid(Integer.parseInt(mid));
				skunew.setMarketPrice(0);
				skunew.setPrice(0);
				skunew.setShop(shop);
				skunew.setSkuNum(Integer.parseInt(skunum));
				skunew.setIsDel(0);
				ps.insert(skunew);
				request.setAttribute("msg", "调拨成功!");
				request.getRequestDispatcher("content/institution-editskuchangeshop.jsp").forward(request, response);
			}else{
				skunew.setSkuNum(skunew.getSkuNum()+Integer.parseInt(skunum));
				ps.updateByPrimaryKey(skunew);
				request.setAttribute("msg", "调拨成功!");
				request.getRequestDispatcher("content/institution-editskuchangeshop.jsp").forward(request, response);
			}
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
