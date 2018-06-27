package com.oracle.sjgl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.sjgl.util.CookieUtil;

public class FilterAll implements Filter{

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Filter初始化");
	}
	
	
	//过滤器拦截所有请求，防止访问需要登陆的页面
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");	//解决中文乱码 不用在servlet中逐个配置
		String url = req.getRequestURL().toString();
		String uid = CookieUtil.getUidByCookies(req.getCookies());
		
		//放行条件判断
		if((!"".equals(uid)&&uid!=null)||url.contains(".js")||url.contains(".css")||url.contains(".jpg")||url.contains(".gif")||url.contains(".png")||url.contains("Login")){
			filter.doFilter(req, resp);
		}else{
			//若条件不满足,弹回登录页面并显示错误信息
			req.setAttribute("msg", "您未登陆,请先登录!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	public void destroy() {
		System.out.println("Filter销毁");
	}

	
}
