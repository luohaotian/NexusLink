package com.SchoolBlog.model;

public class ProductFrom {
	private String name;
	private String description;
	private String price;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long newId) {
		this.id = newId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
