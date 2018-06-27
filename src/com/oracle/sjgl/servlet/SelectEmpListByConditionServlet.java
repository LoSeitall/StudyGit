package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.po.Emp;
import com.oracle.sjgl.service.EmpService;
import com.oracle.sjgl.util.PageUtil;

public class SelectEmpListByConditionServlet extends HttpServlet {
	
	private EmpService es = new EmpService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String sex = request.getParameter("sex");
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String pageno = request.getParameter("pageno");
		String size = request.getParameter("size");
		System.out.println(sex+eid+ename);
		
		if("".equals(pageno)||pageno==null){
			pageno = "1";
		}
		if("".equals(size)||size==null){
			size = "5";
		}
		
		Emp emp = new Emp();
		if(sex!=null&&!"".equals(sex)){
			emp.setSex(sex);
		}
		if(ename!=null&&!"".equals(ename)){
			emp.setEname(ename);
		}
		if(eid!=null&&!"".equals(eid)){
			emp.setEid(Integer.parseInt(eid));
		}
		PageUtil pu = es.selectAllByCondition(Integer.parseInt(pageno), Integer.parseInt(size), emp);
		
		request.setAttribute("sex", sex);
		request.setAttribute("eid",eid);
		request.setAttribute("ename", ename);
		request.setAttribute("pageutil", pu);
		request.getRequestDispatcher("content/institution-list.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
