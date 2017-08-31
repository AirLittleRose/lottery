package com.yc.web.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yc.soccer.biz.GameBiz;
import com.yc.users.bean.News;
import com.yc.users.biz.NewsBiz;
import com.yc.web.model.JsonModel;

@Controller
public class InitIndex {
	@Resource(name = "newsBizImpl")
	private NewsBiz newsBiz;
	
	@Resource(name="gameBizImpl")
	private GameBiz gameBiz;
	

	@RequestMapping(value="/index.action",method=RequestMethod.GET)
	public void index(News news,HttpServletRequest request,HttpServletResponse response, HttpSession session) throws IOException, ServletException{	
		newsBiz.putData(news);		
		JsonModel jsonModel = newsBiz.searchNews(news);   
		request.setAttribute("jsonModel", jsonModel);
		session.setAttribute("list", jsonModel.getRows());
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}	
	
	@RequestMapping(value="/toRegister.action",method=RequestMethod.GET)
	public String toRegister(){
		
		return "register";
	}
	
	@RequestMapping(value="/toLogin.action",method=RequestMethod.GET)
	public String toLogin(){
		
		return "login";
	}
	
	@RequestMapping(value="/resetPass.action",method=RequestMethod.GET)
	public String toResetPass(){
		
		return "resetPass";
	}
	
	@RequestMapping(value="/toSoccer.action")
	public void toSoccer(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getRequestDispatcher("soccer.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
