package com.yc.web.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.yc.ssq.bean.AwardInfo;
import com.yc.ssq.bean.BetSsq;
import com.yc.ssq.bean.UserSsq;
import com.yc.ssq.biz.UserSsqBiz;
import com.yc.users.bean.Users;
import com.yc.utils.DateUtil;
import com.yc.web.model.JsonModel;

@RestController 
public class UserBetSsqController {
	@Resource(name="userSsqBizImpl")
	private UserSsqBiz userSsqBiz;
	
	private DateUtil dateUil;
	
	@RequestMapping("/user/userBetSsq.action")
	public JsonModel userBetSsq(HttpServletRequest request,HttpSession session) {
		JsonModel jm = new JsonModel();
		String[] redlist = request.getParameterValues("redball");
		String[] bluelist = request.getParameterValues("blueball");
		String sigprice = request.getParameter("sigprice");
		String multinum = request.getParameter("multinum");
		
		List<String> reds = Arrays.asList(redlist);
		List<String> blues =Arrays.asList(bluelist);
		
		List<String> redball = new ArrayList<String>();
		List<String> blueball = new ArrayList<String>();
		String redb = null;
		String blueb = null;
		for(int i=0;i<reds.size();i++){
			redb = reds.get(i);
			blueb = blues.get(i);
		}
		String[] redlists = redb.split(",");
		String[] bluelists = blueb.split(",");
		for(int i=0;i<redlists.length;i++){
			redball.add(redlists[i]);
			blueball.add(bluelists[i]);
		}		
		UserSsq ussqs = new UserSsq();
		Users user = (Users) session.getAttribute("users");
		ussqs.setUserid(user.getUserid());
		ussqs.setOrderid();
		try {
			ussqs.setSsq_issue();
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setMsg(e.getMessage());
		}
		List<BetSsq> betlists = new ArrayList<BetSsq>();
		for(int i=0;i<redball.size();i++){
			
			BetSsq bs = new BetSsq();
			String red = (redball.get(i).toString() );
			String blue = (blueball.get(i).toString() );
			bs.setRedball(red);
			bs.setBlueball(blue);
			bs.setSigprice(Integer.parseInt(sigprice));
			bs.setMultinum(Integer.parseInt(multinum));
			betlists.add(bs);
		}
		try {
			UserSsq userssq = new UserSsq();
			List<BetSsq> betssqlist = this.userSsqBiz.buyAndFind(ussqs, betlists);
			userssq.setUsername(betssqlist.get(0).getUsername());
			userssq.setOrderid(betssqlist.get(0).getOrderid());
			userssq.setOrdertime(betssqlist.get(0).getOrdertime());
			userssq.setSsq_issue(betssqlist.get(0).getSsq_issue());
			
			request.getSession().setAttribute("betssqlist", betssqlist);
			request.getSession().setAttribute("userssq", userssq);
			jm.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setMsg(e.getMessage());
		}
		return jm;
	}
	
	@RequestMapping("/user/toBuyInfo.action")
	public void toBuyInfo(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/pages/buyInfo.jsp").forward(request, response);
	}
	
	@RequestMapping("/user/toMyorder.action")
	public void toMyorder(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException{
		this.findSsqIssue(request,session);
		request.getRequestDispatcher("/WEB-INF/pages/myorder.jsp").forward(request, response);
	}
	
	@RequestMapping("/user/findSsqIssue.action")
	public JsonModel findSsqIssue(HttpServletRequest request,HttpSession session){
		JsonModel jm = new JsonModel();
		try {
			Integer userid = ((Users) session.getAttribute("users")).getUserid();
			List<UserSsq> lists = this.userSsqBiz.findSsqIssue(userid);
			if(lists!=null){
				request.getSession().setAttribute("ssqIssueList", lists);
				jm.setCode(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setMsg(e.getMessage());
		}
		
		return jm;		
	}
	
	@RequestMapping("/user/findAwardInfo.action")
	public JsonModel findAwardInfo(HttpServletRequest request,HttpSession session){
		Integer pages = Integer.parseInt(  request.getParameter("pages").toString()  );
		Integer pagesize = Integer.parseInt(  request.getParameter("pagesize")  );
		Integer start = (pages-1)*pagesize;
		JsonModel jm = new JsonModel();
		AwardInfo ai = new AwardInfo();
		Integer userid = ((Users) session.getAttribute("users")).getUserid();
		ai.setUserid(userid);
		ai.setStatus(1);
		ai.setPages(pages);
		ai.setPagesize(pagesize);
		ai.setStart(start);
		try {
			List<AwardInfo> list = this.userSsqBiz.findAwardInfo(ai);
			if(list!=null){
				request.getSession().setAttribute("awardInfoList", list);
				jm.setCode(1);
				jm.setRows(list);
				jm.setPages(pages);
				jm.setPagesize(pagesize);
			}
			Integer count = this.userSsqBiz.findAwardInfoCount(ai);
			if(count!=null){
				jm.setTotal(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jm.setCode(0);
			jm.setMsg(e.getMessage());
		}
		return jm;
	}
}
