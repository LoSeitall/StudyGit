package com.oracle.sjgl.po;

public class KuCunTable {
	
	private String name;
	private Double y;
	private boolean sliced;
	private boolean selected;
	
	
	public KuCunTable() {
		super();
	}
	public KuCunTable(String name, Double y, boolean sliced, boolean selected) {
		super();
		this.name = name;
		this.y = y;
		this.sliced = sliced;
		this.selected = selected;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public boolean isSliced() {
		return sliced;
	}
	public void setSliced(boolean sliced) {
		this.sliced = sliced;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	@Override
	public String toString() {
		return "KuCunTable [name=" + name + ", y=" + y + ", sliced=" + sliced + ", selected=" + selected + "]";
	}
	
	
}
