package com.yc.ssq.bean;

import java.io.Serializable;

public class NotAwardInfo implements Serializable {
	private static final long serialVersionUID = 2656861810120468035L;
	
	private Integer aid;
	private Integer usid;
	private String redball;
	private String blueball;
	
	public Integer getAid() {
		return aid;
	}
	
	public void setAid(Integer aid) {
		this.aid = aid;
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

	@Override
	public String toString() {
		return "NotAwardInfo [aid=" + aid + ", usid=" + usid + ", redball=" + redball + ", blueball=" + blueball + "]";
	}
}
