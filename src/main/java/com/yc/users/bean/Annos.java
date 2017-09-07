package com.yc.users.bean;

import java.io.Serializable;
import java.sql.Date;

public class Annos implements Serializable{
	
	private static final long serialVersionUID = 7514211943925346935L;
	
	  private Integer anid;  
	  private String  title; 
	  private Date    adate;
	  private String  content;  
	  private String  auth;
	  private String sign;
	  
		public Integer getAnid() {
			return anid;
		}
		public void setAnid(Integer anid) {
			this.anid = anid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Date getAdate() {
			return adate;
		}
		public void setAdate(Date adate) {
			this.adate = adate;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getAuth() {
			return auth;
		}
		public void setAuth(String auth) {
			this.auth = auth;
		}		
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		@Override
		public String toString() {
			return "Annos [anid=" + anid + ", title=" + title + ", adate=" + adate + ", content=" + content + ", auth="
					+ auth + ", sign=" + sign + "]";
		}
}
