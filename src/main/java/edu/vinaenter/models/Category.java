package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;

public class Category {
	private int cid;
	@NotEmpty(message = "Tên danh mục không được để trống !")
	private String cname;
	private int totalLand;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	public Category(int cid) {
		super();
		this.cid = cid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	
	public int getTotalLand() {
		return totalLand;
	}
	public void setTotalLand(int totalLand) {
		this.totalLand = totalLand;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Category(int cid, @NotEmpty(message = "Tên danh mục không được để trống !") String cname, int totalLand) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.totalLand = totalLand;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", totalLand=" + totalLand + "]";
	}


	
}
