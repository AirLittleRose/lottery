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
			JsonModel jm = new JsonModel();
			Game game = new Game();
			String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			request.setAttribute("date", today);
			game.setStart(today);
			game.setEnd(addDate(today, 1));
			List<Game> list = this.gameBiz.findGames(game);
			int count = this.gameBiz.getGamesCount(game);
			if (list == null) {
				jm.setCode(0);
				request.setAttribute("info", jm);
				request.getRequestDispatcher("soccer.jsp").forward(request, response);
			}
			jm.setRows(list);
			jm.setTotal(count);
			jm.setCode(1);
			request.setAttribute("info", jm);
			request.getRequestDispatcher("soccer.jsp").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private String addDate(String date, int num) {
		try {
			long before = new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime();
			long after = before + 3600 * 24 * num * 1000L;
			date = new SimpleDateFormat("yyyy-MM-dd").format(after);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
