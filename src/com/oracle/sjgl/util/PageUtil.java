package com.oracle.sjgl.util;

import java.util.List;

/**
 * 分页工具类
 * @author User
 */
public class PageUtil {
	private List list;
	private String str;
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	/**
	 * 本方法用于分页显示
	 * @param pageno
	 * @param totalcount
	 * @param size
	 */
	public void init(int pageno,int totalcount,int size,String servletname){
		int totalpage = 0;
		
		str = "<ul class='clearfix'>";
		
		if(pageno != 1){
			str += "<li><a href='"+servletname+"?pageno=1&size=5'>首页</a></li>";
			str += "<li><a href='"+servletname+"?pageno="+(pageno-1)+"&size=5'>上页</a></li>";
		}
		
		if(totalcount%size == 0){
			totalpage = totalcount/size;
		}else{
			totalpage = (totalcount/size) + 1;
		}
		
		for(int i=1;i<=totalpage;i++){
			if(i == pageno){
				str += "<li class='current'>"+i+"</li>";
			}else{
				str += "<li><a href='"+servletname+"?pageno="+i+"&size=5'>"+i+"</a></li>";
			}
		}
		
		if(pageno != totalpage){
			str += "<li><a href='"+servletname+"?pageno="+(pageno+1)+"&size=5'>下页</a></li>";
			str += "<li><a href='"+servletname+"?pageno="+totalpage+"&size=5'>尾页</a></li>";
		}
		
		str += "<li class='pageinfo'>第"+(pageno)+"页</li>";
	    str += "<li class='pageinfo'>共"+totalpage+"页</li>";
	    str += "</ul>";
	    setStr(str);
	}
}
