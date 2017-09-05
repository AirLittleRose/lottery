package com.yc.ssq.bean;

import java.io.Serializable;

import com.yc.bean.CommonBean;

public class AwardInfo extends CommonBean implements Serializable {

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
	private Integer usid;
	private Integer userid;
	private String orderid;
	private String ordertime;
	private String ssq_issue;
	private Integer multinum;
	private Integer status;
	
	private String redball;
	private String blueball;
	private Integer grade;
	private Double award;
	private Integer awardInfocount;
	
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
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

	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public Integer getMultinum() {
		return multinum;
	}

	public void setMultinum(Integer multinum) {
		this.multinum = multinum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAwardInfocount() {
		return awardInfocount;
	}

	public void setAwardInfocount(Integer awardInfocount) {
		this.awardInfocount = awardInfocount;
	}

	@Override
	public String toString() {
		return "AwardInfo [aid=" + aid + ", usid=" + usid + ", userid=" + userid + ", orderid=" + orderid
				+ ", ordertime=" + ordertime + ", ssq_issue=" + ssq_issue + ", multinum=" + multinum + ", status="
				+ status + ", redball=" + redball + ", blueball=" + blueball + ", grade=" + grade + ", award=" + award
				+ ", awardInfocount=" + awardInfocount + "]";
	}

}
