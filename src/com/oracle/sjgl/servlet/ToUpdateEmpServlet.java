package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.service.EmpService;

public class ToUpdateEmpServlet extends HttpServlet {
	
	private EmpService es = new EmpService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//接送参数
		String eid = request.getParameter("eid");
		
		//显示指定数据
		request.setAttribute("emp", es.selectByPrimaryKeyEmp(eid));
		
		//转发
		request.getRequestDispatcher("content/institution-editemp.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
