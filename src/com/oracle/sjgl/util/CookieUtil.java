package com.oracle.sjgl.util;

import javax.servlet.http.Cookie;

/**
 * Cookie相关操作工具类
 * @author User
 *
 */
public class CookieUtil {
	
	/**
	 * 本方法用于在cookie中取出uid
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
