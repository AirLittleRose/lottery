package com.yc.ssq.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.yc.ssq.biz.impl.UserSsqBizImpl;

public class BetSsq implements Serializable {

	private static final long serialVersionUID = 349646827466255851L;
	/*
	--双色球投注信息		betSsq
	--bsid
	--usid		用户投注双色球id
	--期号	ssq_issue	2017xxx (每周二、四、日晚上21:15开奖)
	--单注价格		sigprice
	--注数		multinum
	--红球号码		redball
	--蓝球号码		blueball
	 */
	private Integer usid;
	private Integer bsid;
	
	private Integer userid;
	private String username;
	private String orderid;
	private String ordertime;
	private String ssq_issue;
	
	private Integer sigprice;
	private Integer multinum;
	private String redball;
	private String blueball;
	
	public Integer getBsid() {
		return bsid;
	}

	public void setBsid(Integer bsid) {
		this.bsid = bsid;
	}

	public Integer getSigprice() {
		return sigprice;
	}

	public void setSigprice(Integer sigprice) {
		this.sigprice = sigprice;
	}

	public Integer getMultinum() {
		return multinum;
	}

	public void setMultinum(Integer multinum) {
		this.multinum = multinum;
	}

	public String getRedball() {
		return redball;
	}

	public void setRedball(String redball) {
		this.redball = redball;
	}

	public String getBlueball() {
		return blueball;
	}

	public void setBlueball(String blueball) {
		this.blueball = blueball;
	}

	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
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

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public String getSsq_issue() {
		return ssq_issue;
	}

	public void setSsq_issue(String ssq_issue) {
		this.ssq_issue = ssq_issue;
	}

	@Override
	public String toString() {
		return "BetSsq [usid=" + usid + ", bsid=" + bsid + ", userid=" + userid + ", username=" + username
				+ ", orderid=" + orderid + ", ordertime=" + ordertime + ", ssq_issue=" + ssq_issue + ", sigprice="
				+ sigprice + ", multinum=" + multinum + ", redball=" + redball + ", blueball=" + blueball + "]";
	}
	
}
