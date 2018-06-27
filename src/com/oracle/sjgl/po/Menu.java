package com.oracle.sjgl.po;

public class Menu {
	private int mid;
	private String mname;
	private int code;
	private String url;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + ", code=" + code + ", url=" + url + "]";
	}
	
	
	
}
