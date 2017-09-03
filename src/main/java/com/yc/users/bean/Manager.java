package com.yc.users.bean;

import java.io.Serializable;

public class Manager implements Serializable{

	private static final long serialVersionUID = -1041290651287782568L;
	
	private Integer mid;  
	private String  mname;  
	private String  pwd;
	
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", pwd=" + pwd + "]";
	}
	
	
	
	

}
