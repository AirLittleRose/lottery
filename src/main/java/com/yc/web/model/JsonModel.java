package com.yc.web.model;

import java.io.Serializable;
import java.util.List;

public class JsonModel<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8817018028802464551L;
	private Integer code;  //操作状态吗 1 成功 2 失败
	private String msg;    //信息
	private Object obj;		//对象 
	private String url;		//访问页面
	
	//前端需要的啊  把查到的信息封装到这里面
	private Integer total;   //总记录数
	private Integer pages;   //当前为第几页
	private Integer pagesize; //每页xx条
	private List<T> rows;   //记录集合
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "JsonModel [code=" + code + ", msg=" + msg + ", obj=" + obj + ", url=" + url + ", total=" + total
				+ ", pages=" + pages + ", pagesize=" + pagesize + ", rows=" + rows + "]";
	}
	
	
	
	
	

}
