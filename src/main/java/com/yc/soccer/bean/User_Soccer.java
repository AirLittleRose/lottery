package com.yc.soccer.bean;

import java.io.Serializable;

public class User_Soccer implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer usid;	//id
	private Integer orderid;//订单号
	private Integer userid;	//用户id
	private Integer sid;	//足彩投注信息id
	private String ordertime;//下单时间
	
	public User_Soccer(Integer usid, Integer orderid, Integer userid, Integer sid, String ordertime) {
		super();
		this.usid = usid;
		this.orderid = orderid;
		this.userid = userid;
		this.sid = sid;
		this.ordertime = ordertime;
	}

	public User_Soccer() {
		super();
	}

	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	@Override
	public String toString() {
		return "User_Soccer [usid=" + usid + ", orderid=" + orderid + ", userid=" + userid + ", sid=" + sid
				+ ", ordertime=" + ordertime + "]";
	}
	
}
