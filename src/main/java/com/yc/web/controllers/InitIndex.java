package com.yc.web.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yc.soccer.bean.Game;
import com.yc.soccer.biz.GameBiz;
import com.yc.web.model.JsonModel;

@Controller
public class InitIndex {
	
	@Resource(name="gameBizImpl")
	private GameBiz gameBiz;
//	@RequestMapping(value="/index.action",method=RequestMethod.GET)
//	public String index(){
//	
//		return "index";
//	}
//	
//	
//	
//	@RequestMapping(value="/toRegister.action",method=RequestMethod.GET)
//	public String toRegister(){
//		
//		return "register";
//	}
	
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
