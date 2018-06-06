package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.po.Product;
import com.oracle.sjgl.service.ProductService;
import com.oracle.sjgl.util.PageUtil;

public class SelectProductListByConditionServlet extends HttpServlet {
	
	private ProductService ps = new ProductService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String pageno = request.getParameter("pageno");
		String size = request.getParameter("size");
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		
		if("".equals(pageno)||pageno==null){
			pageno = "1";
		}
		if("".equals(size)||size==null){
			size = "5";
		}
		
		Product p = new Product();
		if(!"".equals(pname)&&pname!=null){
			p.setPname(pname);
		}
		if(!"".equals(pid)&&pid!=null){
			p.setPid(Integer.parseInt(pid));
		}
		
		PageUtil pu = ps.selectProductByCondition(Integer.parseInt(pageno), Integer.parseInt(size),p);
		request.setAttribute("pid", pid);
		request.setAttribute("pname", pname);
		request.setAttribute("pageutil", pu);
		request.getRequestDispatcher("content/institution-productlist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
