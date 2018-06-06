package com.oracle.sjgl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.service.EmpService;

public class DeleteEmpServlet extends HttpServlet {
	
	private EmpService es = new EmpService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String eid = request.getParameter("eid");
		
		Emp emp = es.selectByPrimaryKeyEmp(eid);
		emp.setIsDel(1);
		es.deleteByPrimaryKey(emp);
		
		//内部转发
		request.getRequestDispatcher("SelectEmpListServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
