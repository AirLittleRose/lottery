package com.yc.ssq.bean;

import java.io.Serializable;

public class LotteryResult implements Serializable {

	private static final long serialVersionUID = -497777108003153341L;
	/*
	--双色球开奖结果	lotteryResult
	--lrid
	--期号	ssq_issue
	--开奖日期
	--红球号码
	--蓝球号码
	--兑奖截止日期 
	 */
	private Integer lrid;
	private String ssq_issue;
	private String resulttime;
	private String redball;
	private String blueball;
	private String validity;
	
	public Integer getLrid() {
		return lrid;
	}

	public void setLrid(Integer lrid) {
		this.lrid = lrid;
	}

	public String getSsq_issue() {
		return ssq_issue;
	}

	public void setSsq_issue(String ssq_issue) {
		this.ssq_issue = ssq_issue;
	}

	public String getResulttime() {
		return resulttime;
	}

	public void setResulttime(String resulttime) {
		this.resulttime = resulttime;
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

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	@Override
	public String toString() {
		return "LotteryResult [lrid=" + lrid + ", ssq_issue=" + ssq_issue + ", resulttime=" + resulttime + ", redball="
				+ redball + ", blueball=" + blueball + ", validity=" + validity + "]";
	}

}
