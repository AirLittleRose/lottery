package com.yc.ssq.bean;

import java.io.Serializable;

public class AwardInfo implements Serializable {

	private static final long serialVersionUID = -3305417322946666295L;
	/*
	--中奖信息		awardInfo
	--aid
	--userid
	--username
	--单号
	--中奖等级
	--中奖金额
	--（期号、红蓝球号码、注数、单注价格、收益倍率）
	 */
	private Integer aid;
	private Integer userid;
	private String username;
	private String orderid;
	private Integer grade;
	private Double award;
	
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Double getAward() {
		return award;
	}

	public void setAward(Double award) {
		this.award = award;
	}

	@Override
	public String toString() {
		return "AwardInfo [aid=" + aid + ", userid=" + userid + ", username=" + username + ", orderid=" + orderid
				+ ", grade=" + grade + ", award=" + award + "]";
	} 
	
}
