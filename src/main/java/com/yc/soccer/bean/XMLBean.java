package com.yc.soccer.bean;

import java.io.Serializable;

public class XMLBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String xid;		//场次
	private String oddsmid;	//
	private String oh;		//主胜-赔率
	private String od;		//平 -赔率
	private String oa;		//主败-赔率
	private String lid;		//联赛-id
	private String ln;		//联赛名
	private String sid;		
	private String hn;		//主队名
	private String gn;		//客队名
	private Integer htid;	//主队-id
	private Integer gtid;	//客队-id
	private String mtime;	//比赛时间
	private String cl;		//颜色
	
	public String getXid() {
		return xid;
	}
	public void setXid(String xid) {
		this.xid = xid;
	}
	public String getOddsmid() {
		return oddsmid;
	}
	public void setOddsmid(String oddsmid) {
		this.oddsmid = oddsmid;
	}
	public String getOh() {
		return oh;
	}
	public void setOh(String oh) {
		this.oh = oh;
	}
	public String getOd() {
		return od;
	}
	public void setOd(String od) {
		this.od = od;
	}
	public String getOa() {
		return oa;
	}
	public void setOa(String oa) {
		this.oa = oa;
	}
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getHn() {
		return hn;
	}
	public void setHn(String hn) {
		this.hn = hn;
	}
	public String getGn() {
		return gn;
	}
	public void setGn(String gn) {
		this.gn = gn;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public String getCl() {
		return cl;
	}
	public void setCl(String cl) {
		this.cl = cl;
	}
	public Integer getHtid() {
		return htid;
	}
	public void setHtid(Integer htid) {
		this.htid = htid;
	}
	public Integer getGtid() {
		return gtid;
	}
	public void setGtid(Integer gtid) {
		this.gtid = gtid;
	}
	@Override
	public String toString() {
		return "XMLBean [xid=" + xid + ", oddsmid=" + oddsmid + ", oh=" + oh + ", od=" + od + ", oa=" + oa + ", lid="
				+ lid + ", ln=" + ln + ", sid=" + sid + ", hn=" + hn + ", gn=" + gn + ", htid=" + htid + ", gtid="
				+ gtid + ", mtime=" + mtime + ", cl=" + cl + "]";
	}

	
	
	
}
