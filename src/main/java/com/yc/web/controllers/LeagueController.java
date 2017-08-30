package com.yc.web.controllers;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.soccer.bean.League;
import com.yc.soccer.biz.LeagueBiz;
import com.yc.web.model.JsonModel;

@Controller
public class LeagueController {
	
	@Resource(name="leagueBizImpl")
	private LeagueBiz leagueBiz;
	
	@RequestMapping("/find_all_league.action" )
	public @ResponseBody JsonModel findAllLeague() {
		List<League> list = leagueBiz.findAllLeague();
		JsonModel jm = new JsonModel();
		jm.setCode(0);
		if(list != null) {
			jm.setRows(list);
			jm.setCode(1);
		}
		return jm;
	}

	@RequestMapping("/addLeague.action" )
	public void addLeague() {
		leagueBiz.saveLeague();
	}
}
