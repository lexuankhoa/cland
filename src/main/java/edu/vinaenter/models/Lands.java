package edu.vinaenter.models;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Lands {
	
	private int lid;
	@NotEmpty(message = "Tên không được để trống !")
	private String lname;
	@NotEmpty(message = "Mô tả không được để trống !")
	private String description;
	
	private Timestamp date_create;
	
	private String picture;
//	@NotNull(message = "Diện tích không được để trống !")
	private int area;
	@NotEmpty(message = "Địa chỉ không được để trống !")
	private String address;
	
	private int count_views;
	
	public Lands(int lid, @NotEmpty(message = "Tên không được để trống !") String lname,
			@NotEmpty(message = "Mô tả không được để trống !") String description, Timestamp date_create,
			String picture, /* @NotNull(message = "Diện tích không được để trống !") */ int area,
			@NotEmpty(message = "Địa chỉ không được để trống !") String address, int count_views, Category category) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.date_create = date_create;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.count_views = count_views;
		this.category = category;
	}

	private Category category;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCount_views() {
		return count_views;
	}

	public void setCount_views(int count_views) {
		this.count_views = count_views;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public Lands() {
		super();
	}

	@Override
	public String toString() {
		return "Lands [lid=" + lid + ", lname=" + lname + ", description=" + description + ", date_create="
				+ date_create + ", picture=" + picture + ", area=" + area + ", address=" + address + ", count_views="
				+ count_views + ", category=" + category + "]";
	}
	
	
}
