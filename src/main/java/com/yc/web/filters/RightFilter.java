package com.yc.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RightFilter implements Filter {

	public void destroy() {
	}

	//TODO:   权限过滤
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		HttpSession session=req.getSession();
		if(   session.getAttribute("users")==null){
			resp.sendRedirect("../index.action");
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
