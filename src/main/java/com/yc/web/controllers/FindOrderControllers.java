package com.yc.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.ssq.biz.UserSsqBiz;
import com.yc.web.model.JsonModel;

@Controller
public class FindOrderControllers {
	
	@Resource(name="userSsqBizImpl")
	private UserSsqBiz userSsqBiz;
	
	@RequestMapping("/user/findSsqOrder.action")
	public String findSsqOrder(HttpServletRequest request,
							HttpSession session){
		return "ssq_myorder";
		
	}
}
