package com.oracle.sjgl.po;

import java.util.List;

public class SellOrderTable {
	private String name;
	private List<Integer> data;
	
	
	public SellOrderTable() {
		super();
	}
	public SellOrderTable(String name, List<Integer> data) {
		super();
		this.name = name;
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		CaiGouTable other = (CaiGouTable) obj;
		return this.getName().equals(other.getName());
	
	}
}
