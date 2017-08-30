package com.yc.web.tags;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class YearSelectTag extends TagSupport {
	private String id;
	private String className;
	private String name;
	private String clickEvent;

	@Override
	public int doStartTag() throws JspException {
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		
		JspWriter out=super.pageContext.getOut();
		StringBuffer sb=new StringBuffer();
		sb.append("<select ");
		if( id!=null&&!"".equals(id)){
			sb.append(" id=\""+id+"\" ");
		}
		if( className!=null&& !"".equals(className)){
			sb.append(" class=\""+className+"\" ");
		}
		if(  name!=null&&!"".equals(name)){
			sb.append(" name=\""+name+"\" ");
		}
		if( clickEvent!=null&& !"".equals(clickEvent)){
			sb.append(" onClick=\""+clickEvent+"\" ");
		}
		sb.append(">");
		for(  int i=year-5;i<=year;i++  ){
			if(    i==year ){
				sb.append("<option value=\""+i+"\" selected>"+i+"</option>");
			}else{
				sb.append("<option value=\""+i+"\">"+i+"</option>");
			}
		}
		for( int i=year+1;i<=year+3;i++){
			sb.append("<option value=\""+i+"\">"+i+"</option>");
		}
		sb.append("</select>");
		
		try {
			out.println(   sb.toString() );
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return super.EVAL_BODY_INCLUDE;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClickEvent(String clickEvent) {
		this.clickEvent = clickEvent;
	}

	
	
	
}
