package com.yc.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.soccer.bean.Game;
import com.yc.soccer.bean.League;
import com.yc.soccer.biz.GameBiz;
import com.yc.web.model.JsonModel;

import oracle.sql.DATE;

@Controller
public class GameController {

	@Resource(name = "gameBizImpl")
	private GameBiz gameBiz;


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

	@RequestMapping("/addGame.action")
	public void addGame() {
		gameBiz.savaGame();
	}
	
	
//	@RequestMapping("/test.action")
//	public @ResponseBody JsonModel test(Game game, HttpServletRequest request) {
//		JsonModel jm = new JsonModel();
//		jm.setCode(0);
//		if(game != null) {
//			request.setAttribute("date", game.getMatch_date_cn());
//			game.setStart(game.getMatch_date_cn());
//			game.setEnd(this.addDate(game.getMatch_date_cn(), 1));
//			List<String> leaguesList = new ArrayList<String>();
//			String[] strs = game.getLeaguesInfo().split(",");
//			for(String str : strs) {
//				leaguesList.add(str);
//			}
//			game.setLeaguesList(leaguesList);
//			List<Game> list = this.gameBiz.findGames(game);
//			int count = this.gameBiz.getGamesCount(game);
//			if (list != null) {
//				jm.setRows(list);
//				jm.setTotal(count);
//				jm.setCode(1);
//			}
//		}
//		return jm;
//	}
	
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
