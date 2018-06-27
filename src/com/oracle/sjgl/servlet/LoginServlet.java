package com.oracle.sjgl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oracle.sjgl.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收参数
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		
		//将参数传递给Service层
		UserService us = new UserService();
		boolean flag = us.loginUser(username, password);
		int temp = us.UID;
		String uid = Integer.toString(temp);
		
		
		//根据传回的值确定是否登陆成功
		if(flag){
			
			//创建添加cookie
			Cookie cookie = new Cookie("uid",uid);
			cookie.setMaxAge(300);
			cookie.setPath("/");
			
			response.addCookie(cookie);
			response.sendRedirect("index.html");
		
		}else{
			request.setAttribute("msg", "用户名/密码错误!");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
