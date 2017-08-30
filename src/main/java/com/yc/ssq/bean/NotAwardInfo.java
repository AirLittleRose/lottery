package com.yc.ssq.bean;

import java.io.Serializable;

public class NotAwardInfo implements Serializable {
	private static final long serialVersionUID = 2656861810120468035L;
	
	private Integer aid;
	private Integer userid;
	private String username;
	private String orderid;
	
	public Integer getAid() {
		return aid;
	}
	
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	@Override
	public String toString() {
		return "NotAwardInfo [aid=" + aid + ", userid=" + userid + ", username=" + username + ", orderid=" + orderid
				+ "]";
	}

}
