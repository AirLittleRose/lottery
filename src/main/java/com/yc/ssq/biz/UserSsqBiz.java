package com.yc.ssq.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.ssq.bean.AwardInfo;
import com.yc.ssq.bean.BetSsq;
import com.yc.ssq.bean.LotteryResult;
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
	 * 用户购买成功，则跳出购买的彩票信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public List<BetSsq> buyAndFind(UserSsq ussqs,List<BetSsq> betlists) throws Exception;
	
	public List<BetSsq> findTest(Integer usid) throws Exception;
	/**
	 * 查出数据库所有的用户订单期号
	 * @return
	 * @throws Exception
	 */
	public List<UserSsq> findSsqIssue(Integer userid) throws Exception;
	
	/**定时器
	 * 每次开奖的时候，将每期的结果存入数据库
	 * @param lotteryResultList
	 * @return
	 */
	public void addLotteryResult()throws Exception;
	
	/**定时器
	 * 比较开奖结果和在本站购买的双色球，然后把中奖的放在中奖表里，未中奖的放在未中奖表里
	 * 
	 * @throws Exception
	 */
	public void compareAndSave()throws Exception;
	
	/**
	 * 查找用户的中奖信息
	 * @param ai  需要：userid status
	 * @return
	 * @throws Exception
	 */
	public List<AwardInfo> findAwardInfo(AwardInfo ai)throws Exception;
	
	public Integer findAwardInfoCount(AwardInfo ai)throws Exception;
}
