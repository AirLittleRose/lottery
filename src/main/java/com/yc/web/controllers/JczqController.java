package com.yc.web.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yc.soccer.bean.Game;
import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_info;
import com.yc.soccer.bean.Jczq_order;
import com.yc.soccer.bean.League;
import com.yc.soccer.bean.OrderDetail;
import com.yc.soccer.biz.GameBiz;
import com.yc.soccer.biz.Jczq_orderBiz;
import com.yc.soccer.biz.LeagueBiz;
import com.yc.users.bean.Users;
import com.yc.web.model.JsonModel;


@Controller
public class JczqController {

	@Resource(name = "gameBizImpl")
	private GameBiz gameBiz;

	@Resource(name = "jczq_orderBizImpl")
	private Jczq_orderBiz jcza_orderBiz;
	
	@Resource(name="leagueBizImpl")
	private LeagueBiz leagueBiz;
	
	/**
	 * 查出所有的联赛
	 * @return
	 */
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
	
	/**
	 * 下注
	 * @param session
	 * @return
	 */
	@RequestMapping("/jczq/to_jczq_order.action")
	public String to_jczq_order(HttpSession session) {
		if(session.getAttribute("flag") != null) {
			//获取用户对象信息
			Users user = (Users) session.getAttribute("users");
			//获取前台信息
			Jczq_info ji = (Jczq_info) session.getAttribute("info");
	
			if(ji != null && user != null) {
				//订单信息解析
				Jczq_order jo = this.parse2Order(ji, user);
				//下注信息解析
				List<Jczq> jczqs = this.parse2Jczq(ji, jo);
	
				session.setAttribute("jczq_order", jo);
				session.setAttribute("jczqs", jczqs);
				
				session.setAttribute("flag", null);
				session.removeAttribute("flag");
				
				try {
					jcza_orderBiz.addOrder(jo, jczqs);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "jczq_order";
	}
	
	/**
	 * 查询用户的订单  详情
	 * @param request
	 * @param session
	 */
	@RequestMapping("findJczqOrder.action")
	public @ResponseBody JsonModel findJczqOrder(HttpServletRequest request,HttpSession session) {
		Integer pages = Integer.parseInt(  request.getParameter("pages").toString()  );
		Integer pagesize = Integer.parseInt(  request.getParameter("pagesize")  );
		Integer start = (pages-1)*pagesize;
		JsonModel jm = new JsonModel();
		jm.setCode(0);
		Integer userid = ((Users) session.getAttribute("users")).getUserid();
		Jczq_order jo = new Jczq_order();
		jo.setPagesize(pagesize);
		jo.setStart(start);
		jo.setUserid(userid);
		List<Jczq_order> orderList = jcza_orderBiz.findOrder(jo);
		if(orderList != null) {
			jm.setRows(orderList);
			jm.setCode(1);
		}
		jm.setTotal(jcza_orderBiz.findOrderCount(jo));
		return jm;
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
	
	/**
	 * 订单信息解析
	 * @param ji
	 * @param user
	 * @return
	 */
	private Jczq_order parse2Order(Jczq_info ji, Users user) {
		Jczq_order jo = new Jczq_order();
		jo.setUserid(user.getUserid());		//用户id
		jo.setOrder_id(UUID.randomUUID().toString());	//UUID->单号
		jo.setGuoguan_type(ji.getType());	//过关类型
		jo.setAmount(Integer.parseInt(ji.getAmount()));	//总金额
		jo.setLast_time(this.getLastTime(ji.getGame_time()));	//设置最后时间
		jo.setBuy_time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		return jo;
	}
	
	/**
	 * 下注信息解析
	 * @param ji
	 * @param user
	 * @return
	 */
	private List<Jczq> parse2Jczq(Jczq_info ji,Jczq_order jo) {
		List<Jczq> jczqs = new ArrayList<Jczq>();
		for(int i=0; i<Integer.parseInt(ji.getNum()); i++) {
			Jczq jczq = new Jczq();
			jczq.setOrder_id(jo.getOrder_id());
			jczq.setGame_id(ji.getGame_id()[i]);
			jczq.setPredict(Integer.parseInt(ji.getSp()[i]));
			jczq.setOdds(Float.parseFloat(ji.getOdds()[i]));
			jczq.setTimes(Integer.parseInt(ji.getPel()));
			jczqs.add(jczq);
		}
		return jczqs;
	}
	
	//获取最后的时间
	private String getLastTime(String[] strs) {
		long last = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		//获取每个time
		for(int i=0; i<strs.length; i++) {
			String str = strs[i];
			Date date = null;
			try {
				date = sdf.parse(str);
				long temp = date.getTime();
				if(temp > last) {
					last = temp;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sdf.format(new Date(last));
	}
}
