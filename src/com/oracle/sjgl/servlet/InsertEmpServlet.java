package com.oracle.sjgl.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.service.EmpService;

public class InsertEmpServlet extends HttpServlet {

	private EmpService es = new EmpService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//接收参数
		String ename = request.getParameter("ename");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String hiredate = request.getParameter("hiredate");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		
		Emp emp = new Emp();
		emp.setEname(ename);
		emp.setJob(job);
		emp.setPhone(phone);
		emp.setSex(sex);
		try {
			emp.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
			emp.setHireday(new SimpleDateFormat("yyyy-MM-dd").parse(hiredate));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		es.insertSelective(emp);
		
		request.getRequestDispatcher("SelectEmpListServlet").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doGet(request, response);
	}

}
