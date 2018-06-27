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
		System.out.println("Filter��ʼ��");
	}
	
	
	//�����������������󣬷�ֹ������Ҫ��½��ҳ��
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");	//����������� ������servlet���������
		String url = req.getRequestURL().toString();
		String uid = CookieUtil.getUidByCookies(req.getCookies());
		
		//���������ж�
		if((!"".equals(uid)&&uid!=null)||url.contains(".js")||url.contains(".css")||url.contains(".jpg")||url.contains(".gif")||url.contains(".png")||url.contains("Login")){
			filter.doFilter(req, resp);
		}else{
			//������������,���ص�¼ҳ�沢��ʾ������Ϣ
			req.setAttribute("msg", "��δ��½,���ȵ�¼!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	public void destroy() {
		System.out.println("Filter����");
	}

	
}
