package com.yc.web.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.soccer.biz.TeamBiz;
import com.yc.web.model.JsonModel;

@Controller
public class TeamController {
	
	@Resource(name="teamBizImpl")
	private TeamBiz teamBiz;
		
	@RequestMapping(value="/addTeam.action")
	public void addTeam() {
		teamBiz.addTeams();
	}
}
