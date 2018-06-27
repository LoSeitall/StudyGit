package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Stock;
import com.oracle.sjgl.service.ProductService;
import com.oracle.sjgl.util.PageUtil;

public class SelectStockListByConditionServlet extends HttpServlet {

	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String pageno = request.getParameter("pageno");
		String size = request.getParameter("size");
		String stid = request.getParameter("stid");
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		
		if("".equals(pageno)||pageno==null){
			pageno = "1";
		}
		if("".equals(size)||size==null){
			size = "5";
		}
		
		Stock s = new Stock();
		if(!"".equals(pid)&&pid!=null){
			s.setPid(Integer.parseInt(pid));
		}
		if(!"".equals(cid)&&cid!=null){
			s.setCid(Integer.parseInt(cid));
		}
		if(!"".equals(stid)&&stid!=null){
			s.setStid(Integer.parseInt(stid));
		}
		
		PageUtil pu = ps.selectAllStockByCondition(Integer.parseInt(pageno), Integer.parseInt(size), s);
		
		request.setAttribute("stid", stid);
		request.setAttribute("pid", pid);
		request.setAttribute("cid", cid);
		request.setAttribute("pageutil", pu);
		
		request.getRequestDispatcher("content/institution-liststock.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
