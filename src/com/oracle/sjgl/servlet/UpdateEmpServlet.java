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

public class UpdateEmpServlet extends HttpServlet {
	
	private EmpService es = new EmpService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String birthday = request.getParameter("birthday");
		String hireday = request.getParameter("hireday");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		
		Emp emp = new Emp();
		emp.setEid(Integer.parseInt(eid));
		emp.setEname(ename);
		emp.setSex(sex);
		emp.setPhone(phone);
		emp.setJob(job);
		try {
			emp.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
			emp.setHireday(new SimpleDateFormat("yyyy-MM-dd").parse(hireday));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		es.updateByPrimaryKey(emp);
		
		request.getRequestDispatcher("SelectEmpListServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
