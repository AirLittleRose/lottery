package com.yc.ssq.biz.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.ssq.bean.BetSsq;
import com.yc.ssq.bean.UserSsq;
import com.yc.ssq.biz.UserSsqBiz;

@Service(value="userSsqBizImpl")
@Transactional(rollbackFor=Exception.class)
public class UserSsqBizImpl implements UserSsqBiz {
	
	@Resource(name="baseDao")
	private BaseDao baseDao;


	/**
	 * 用户购买双色球
	 * 1.添加       用户投注双色球信息      userSsq
	 * 2.添加        双色球投注信息		list<betSsq>
	 * @throws Exception 
	 */
	@Override
	public Integer addUserSsq(UserSsq ussqs,List<BetSsq> betlists) throws Exception {
		if(betlists!=null && betlists.size()>0){		
			this.baseDao.save(ussqs, "addUserSsq"); 	//添加用户投注内容，生成usid 作为  betSsq的外键
			Integer usid = ussqs.getUsid();
			ussqs.setBetlists(betlists);
			List<BetSsq> betlist = new ArrayList<BetSsq>();
			for(int i = 0;i<betlists.size();i++){
				BetSsq betssq = new BetSsq();
				betssq.setUsid(usid);
				betssq.setSigprice(betlists.get(i).getSigprice());
				betssq.setMultinum(betlists.get(i).getMultinum());
				betssq.setRedball(betlists.get(i).getRedball());
				betssq.setBlueball(betlists.get(i).getBlueball());
				
				betlist.add(betssq);
			}
			this.baseDao.save(BetSsq.class, "addBetSsq", betlist);
			return usid;
		}
		return null;
	}


	@Override
	public List<BetSsq> buyAndFind(UserSsq ussqs,List<BetSsq> betlists) throws Exception {
		Integer usid = this.addUserSsq(ussqs, betlists);
		if(usid!=null){
			List<BetSsq> list = null;
			Map<String, Integer> parameterMap = new HashMap<String, Integer>();
			parameterMap.put("usid", usid);
			try {
				list = (List<BetSsq>) this.baseDao.findAll(BetSsq.class, "findAfterBuy", parameterMap);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return list;
		}else{
			return null;
		}
	}


	@Override
	public List<BetSsq> findTest(Integer usid) throws Exception {
		if(usid!=null){
			List<BetSsq> list = null;
			Map<String, Integer> parameterMap = new HashMap<String, Integer>();
			parameterMap.put("usid", usid);
			try {
				list = (List<BetSsq>) this.baseDao.findAll(BetSsq.class, "findAfterBuy", parameterMap);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			return list;
		}else{
			return null;
		}
	}


	@Override
	//@Scheduled(cron = "0/5 * * * * *")
	public List<UserSsq> findSsqIssue() throws Exception {
		List<UserSsq> list = null;
		list = this.baseDao.findAll(UserSsq.class, "findSsqIssue");
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}
}
