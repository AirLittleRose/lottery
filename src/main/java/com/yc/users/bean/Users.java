package com.yc.users.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Users implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer userid;
	private String username;
	private String password;
	private String tel;
	private String email;
	private String idcard;
	private String validataCode;
	private Timestamp outDate;
	    
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getValidataCode() {
		return validataCode;
	}
	public void setValidataCode(String validataCode) {
		this.validataCode = validataCode;
	}
	public Timestamp getOutDate() {
		return outDate;
	}
	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
	}
	@Override
	public String toString() {
		return "Users [userid=" + userid + ", username=" + username + ", password=" + password + ", tel=" + tel
				+ ", email=" + email + ", idcard=" + idcard + ", validataCode=" + validataCode + ", outDate=" + outDate
				+ "]";
	}
	
	
	
	
}
