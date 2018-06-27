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
		//���ղ���
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		
		//���������ݸ�Service��
		UserService us = new UserService();
		boolean flag = us.loginUser(username, password);
		int temp = us.UID;
		String uid = Integer.toString(temp);
		
		
		//���ݴ��ص�ֵȷ���Ƿ��½�ɹ�
		if(flag){
			
			//�������cookie
			Cookie cookie = new Cookie("uid",uid);
			cookie.setMaxAge(300);
			cookie.setPath("/");
			
			response.addCookie(cookie);
			response.sendRedirect("index.html");
		
		}else{
			request.setAttribute("msg", "�û���/�������!");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
