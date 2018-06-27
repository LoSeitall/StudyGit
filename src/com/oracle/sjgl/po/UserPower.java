package com.oracle.sjgl.po;

public class UserPower {
	private int uid;
	private int rid;
	
	public UserPower() {
		
	}
	public UserPower(int uid, int rid) {
		super();
		this.uid = uid;
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "UserPower [uid=" + uid + ", rid=" + rid + "]";
	}
	
	
}
