package com.yc.ssq.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.ssq.bean.BetSsq;
import com.yc.ssq.bean.UserSsq;

@Service
public interface UserSsqBiz {

	/**
	 * 用户购买双色球
	 * 1.添加       用户投注双色球信息      userSsq
	 * 2.添加        双色球投注信息		list<betSsq>
	 * @param ussq
	 * @return
	 */
	public Integer addUserSsq(UserSsq ussqs,List<BetSsq> ssqs) throws Exception;
	
	/**
	 * 如果用户购买成功，则跳出购买的彩票信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<BetSsq> buyAndFind(UserSsq ussqs,List<BetSsq> betlists) throws Exception;
	
	public List<BetSsq> findTest(Integer usid) throws Exception;
	
	public List<UserSsq> findSsqIssue() throws Exception;
}
