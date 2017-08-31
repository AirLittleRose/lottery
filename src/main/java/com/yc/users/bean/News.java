package com.yc.users.bean;

import java.io.Serializable;

public class News implements Serializable{	
	
	private static final long serialVersionUID = 5382551705845705975L;
	
	private Integer newid;
	private String news;
	
	public Integer getNewid() {
		return newid;
	}
	public void setNewid(Integer newid) {
		this.newid = newid;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	
	@Override
	public String toString() {
		return "News [newid=" + newid + ", news=" + news + "]";
	}
	
	

}
