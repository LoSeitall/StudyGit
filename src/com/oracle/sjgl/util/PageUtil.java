package com.oracle.sjgl.util;

import java.util.List;

/**
 * ��ҳ������
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
	 * ���������ڷ�ҳ��ʾ
	 * @param pageno
	 * @param totalcount
	 * @param size
	 */
	public void init(int pageno,int totalcount,int size,String servletname){
		int totalpage = 0;
		
		str = "<ul class='clearfix'>";
		
		if(pageno != 1){
			str += "<li><a href='"+servletname+"?pageno=1&size=5'>��ҳ</a></li>";
			str += "<li><a href='"+servletname+"?pageno="+(pageno-1)+"&size=5'>��ҳ</a></li>";
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
			str += "<li><a href='"+servletname+"?pageno="+(pageno+1)+"&size=5'>��ҳ</a></li>";
			str += "<li><a href='"+servletname+"?pageno="+totalpage+"&size=5'>βҳ</a></li>";
		}
		
		str += "<li class='pageinfo'>��"+(pageno)+"ҳ</li>";
	    str += "<li class='pageinfo'>��"+totalpage+"ҳ</li>";
	    str += "</ul>";
	    setStr(str);
	}
}
