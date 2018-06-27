package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Salary;
import com.oracle.sjgl.service.EmpService;
import com.oracle.sjgl.util.PageUtil;

public class SelectEmpSalaryServlet extends HttpServlet {

	private EmpService es = new EmpService();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String eid = request.getParameter("eid");
		String pageno = request.getParameter("pageno");
		String size = request.getParameter("size");

		if("".equals(pageno)||pageno==null){
			pageno = "1";
		}
		if("".equals(size)||size==null){
			size = "5";
		}

		List<Salary> sl = es.selectSalaryByEid(eid);
				
		request.setAttribute("sl", sl);

		request.getRequestDispatcher("content/institution-empsalary.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
