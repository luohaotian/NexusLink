package com.SchoolBlog.model;

import java.util.Date;

public class LostBean {

	private int id;
	private int getterId;
	private String lostXuehao;
	private String lostPlace;
	private String lostPhone;
	private String lostInfo;
	private int status;
	private Date getTime;
	private UserBean getter;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLostXuehao() {
		return lostXuehao;
	}
	public void setLostXuehao(String lostXuehao) {
		this.lostXuehao = lostXuehao;
	}
	public String getLostPlace() {
		return lostPlace;
	}
	public void setLostPlace(String lostPlace) {
		this.lostPlace = lostPlace;
	}
	public String getLostPhone() {
		return lostPhone;
	}
	public void setLostPhone(String lostPhone) {
		this.lostPhone = lostPhone;
	}
	public String getLostInfo() {
		return lostInfo;
	}
	public void setLostInfo(String lostInfo) {
		this.lostInfo = lostInfo;
	}
	public int getGetterId() {
		return getterId;
	}
	public void setGetterId(int getterId) {
		this.getterId = getterId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public UserBean getGetter() {
		return getter;
	}
	public void setGetter(UserBean getter) {
		this.getter = getter;
	}
	public Date getGetTime() {
		return getTime;
	}
	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}
	
	
}
