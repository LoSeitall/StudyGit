package com.oracle.sjgl.util;

import javax.servlet.http.Cookie;

/**
 * Cookie��ز���������
 * @author User
 *
 */
public class CookieUtil {
	
	/**
	 * ������������cookie��ȡ��uid
	 * @param cs
	 * @return
	 */
	public static String getUidByCookies(Cookie[] cs){
		
		String uid = "";
		
		if(cs==null){
			
			return uid;
			
		}
		
		for (Cookie cookie : cs) {
			if(cookie.getName().equals("uid")){
				
				return cookie.getValue();
			
			}
		}

		return uid;
		
	}
}
