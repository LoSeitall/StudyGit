package com.oracle.sjgl.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	
	public static String changeDate(Date date){
		
		String d = "";
		
		try {
			d = new SimpleDateFormat("yyyy-MM-dd").format(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return d;
	}
	
}
