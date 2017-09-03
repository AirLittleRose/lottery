package com.yc.web.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.soccer.bean.Game;
import com.yc.soccer.bean.Jczq_info;
import com.yc.soccer.bean.Jczq_order;
import com.yc.soccer.bean.League;
import com.yc.soccer.biz.GameBiz;
import com.yc.web.model.JsonModel;

import oracle.sql.DATE;

@Controller
public class GameController {

	@Resource(name = "gameBizImpl")
	private GameBiz gameBiz;

	/**
	 * 查询比赛信息
	 * @param game
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/findGames.action")
	public @ResponseBody JsonModel findGames(Game game, HttpServletRequest request, HttpServletResponse response) {
		JsonModel jm = new JsonModel();
		jm.setCode(0);
		List<Game> list = gameBiz.findGames(game);
		if(list != null) {
			jm.setCode(1);
			jm.setRows(list);
		}
		return jm;
	}

	/**
	 * 下注信息确认(未确认订单前,先将购买信息用session保存)
	 * @param request
	 * @param response
	 * @param session
	 * @param ji
	 * @return
	 */
	@RequestMapping("/to_xiazhu.action")
	public void to_xiazhu(HttpServletRequest request, HttpServletResponse response, HttpSession session, Jczq_info ji) {
		session.setAttribute("info", ji);	
	}
	
	@RequestMapping("/to_jczq_order.action")
	public String to_jczq_order(HttpSession session) {
		//获取前台信息
		Jczq_info ji = (Jczq_info) session.getAttribute("info");
		Jczq_order jo = new Jczq_order();
		jo.setOrder_id(UUID.randomUUID().toString());	//UUID->单号
		for(int i = 0; i<Integer.parseInt(ji.getNum()); i++) {
			
		}
		return "jczq_order";
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
