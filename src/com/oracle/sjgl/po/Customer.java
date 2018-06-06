package com.oracle.sjgl.po;

import java.util.Date;

public class Customer {
    private Integer cusid;

    private String cusname;

    private String cusphone;

    private Integer pid;

    private Date custime;

    private String descr;

    private Integer isDel;
    
    private String scustime;
    
    private int size;
    
    private int limitnum;
    
    

    public String getScustime() {
		return scustime;
	}

	public void setScustime(String scustime) {
		this.scustime = scustime;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getLimitnum() {
		return limitnum;
	}

	public void setLimitnum(int limitnum) {
		this.limitnum = limitnum;
	}

	public Integer getCusid() {
        return cusid;
    }

    public void setCusid(Integer cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname == null ? null : cusname.trim();
    }

    public String getCusphone() {
        return cusphone;
    }

    public void setCusphone(String cusphone) {
        this.cusphone = cusphone == null ? null : cusphone.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCustime() {
        return custime;
    }

    public void setCustime(Date custime) {
        this.custime = custime;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr == null ? null : descr.trim();
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}