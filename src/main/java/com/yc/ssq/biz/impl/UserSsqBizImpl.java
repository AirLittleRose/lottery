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
import com.yc.ssq.bean.AwardInfo;
import com.yc.ssq.bean.BetSsq;
import com.yc.ssq.bean.LotteryResult;
import com.yc.ssq.bean.NotAwardInfo;
import com.yc.ssq.bean.UserSsq;
import com.yc.ssq.biz.UserSsqBiz;
import com.yc.ssq.jsonModel.Ssq;
import com.yc.ssq.jsonModel.SsqJson;
import com.yc.tasks.SsqTask;
import com.yc.utils.DateUtil;

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
			try {
				ussqs.setUsid(usid);
				list = (List<BetSsq>) this.baseDao.findAll(ussqs, "findAfterBuy");
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
	public List<UserSsq> findSsqIssue(Integer userid) throws Exception {
		List<UserSsq> list = null;
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("userid", userid);
		list = this.baseDao.findAll(UserSsq.class, "findSsqIssue",parameterMap);
		if(list!=null){
			return list;
		}else{
			return null;
		}
	}


	@Override
	//@Scheduled(cron = "0 50 21 ? * TUE,THU,SUN")
	public void addLotteryResult() throws Exception {
		System.out.println("定时器..............");
		Object t = new LotteryResult();
		this.baseDao.del(t , "deleteOldResult");
		List<LotteryResult> lotteryResultList = this.testSsqTask();
		if(lotteryResultList!=null){
			this.baseDao.save(LotteryResult.class, "addLotteryResult", lotteryResultList);
		}
	}
	
	/**
	 * 把获取到的json数据SsqJson 用 List<LotteryResult>接收
	 * @return
	 * @throws ParseException
	 */
	private List<LotteryResult> testSsqTask() throws ParseException{
		SsqTask st = new SsqTask();
		
		SsqJson sj = st.ssq_history( DateUtil.parseDateToString(new Date(), "yyyy") );
		List<Ssq> result = sj.getResult();
		List<LotteryResult> list = new ArrayList<LotteryResult>();
		for(int i=0;i<result.size();i++){
			LotteryResult lr = new LotteryResult();
			lr.setSsq_issue(  result.get(i).getLotteryQh()  );
			lr.setResulttime(  result.get(i).getLotteryDate()  );
			String lotterynum = result.get(i).getLotteryNumber();
			String lotterynums = lotterynum.replaceAll(",", " ");
			
			String redlottery = lotterynums.substring(0, 17);
			
			String bluelottery = lotterynums.substring(18, 20);
			
			lr.setRedball(redlottery);
			lr.setBlueball(bluelottery);
			list.add(lr);			
		}
		return list;
	}


	@Override
	public void compareAndSave() throws Exception {
//		UserSsq us = new UserSsq();
//		us.setSsq_issue();
//		Integer issue = Integer.parseInt(us.getSsq_issue())-1;
//		String ssq_issue =issue.toString();
//		
		String qh = "2017100";
		LotteryResult lr = this.findLotteryResult(qh);
		
		List<BetSsq> list = this.findUserSsqBetBySsqIssue(qh);
		String blueResult = lr.getBlueball();
		String redResult = lr.getRedball();
		String rb1 = redResult.substring(0, 2);
		String rb2 = redResult.substring(3, 5);
		String rb3 = redResult.substring(6, 8);
		String rb4 = redResult.substring(9, 11);
		String rb5 = redResult.substring(12, 14);
		String rb6 = redResult.substring(15, 17);
		
		List<AwardInfo> awardlist = new ArrayList<AwardInfo>();
		List<NotAwardInfo> notawardlist = new ArrayList<NotAwardInfo>();
		for(int i=0;i<list.size();i++){
			int redcount = 0;
			BetSsq bs = new BetSsq();
			bs=list.get(i);
			
			String blueball = bs.getBlueball();
			String redball = bs.getRedball();
			String red1 = redball.substring(0, 2);
			String red2 = redball.substring(3, 5);
			String red3 = redball.substring(6, 8);
			String red4 = redball.substring(9, 11);
			String red5 = redball.substring(12, 14);
			String red6 = redball.substring(15, 17);
			if(rb1.equals(red1)){
				redcount = redcount+1;
			}
			if(rb2.equals(red2)){
				redcount = redcount+1;
			}
			if(rb3.equals(red3)){
				redcount = redcount+1;
			}
			if(rb4.equals(red4)){
				redcount = redcount+1;
			}
			if(rb5.equals(red5)){
				redcount = redcount+1;
			}
			if(rb6.equals(red6)){
				redcount = redcount+1;
			}
			//这里随机产生一个销量		170 296 080
			int r = (int)(Math.random()*120592160+270592160);
			
			//
			if( blueResult.equals(blueball) && redcount==0 ||  blueResult.equals(blueball) && redcount==1 || blueResult.equals(blueball) && redcount==2){
				AwardInfo ai = new AwardInfo();
				
				Double award = bs.getMultinum()*bs.getSigprice()*2.5;
				ai.setUsid(bs.getUsid());
				ai.setRedball(bs.getRedball());
				ai.setBlueball(bs.getBlueball());
				ai.setGrade(6);
				ai.setAward(award);
				awardlist.add(ai);
			}else if( (blueResult.equals(blueball) && redcount==3 ) || redcount==4){
				AwardInfo ai = new AwardInfo();
				
				Double award = bs.getMultinum()*bs.getSigprice()*5.0;
				ai.setUsid(bs.getUsid());
				ai.setRedball(bs.getRedball());
				ai.setBlueball(bs.getBlueball());
				ai.setGrade(5);
				ai.setAward(award);
				awardlist.add(ai);
			}else if( (blueResult.equals(blueball) && redcount==4 ) || redcount==5){
				AwardInfo ai = new AwardInfo();
				
				Double award = bs.getMultinum()*bs.getSigprice()*100.0;
				ai.setUsid(bs.getUsid());
				ai.setRedball(bs.getRedball());
				ai.setBlueball(bs.getBlueball());
				ai.setGrade(4);
				ai.setAward(award);
				awardlist.add(ai);
			}else if( blueResult.equals(blueball) && redcount==5 ){
				AwardInfo ai = new AwardInfo();
				
				Double award = bs.getMultinum()*bs.getSigprice()*1500.0;
				ai.setUsid(bs.getUsid());
				ai.setRedball(bs.getRedball());
				ai.setBlueball(bs.getBlueball());
				ai.setGrade(3);
				ai.setAward(award);
				awardlist.add(ai);
			}else if( redcount==6 ){
				AwardInfo ai = new AwardInfo();
				double Amount = 0.25*r*2;
				//随机产生二等奖的总注数  最低50注
				int r2 = (int)(Math.random()*420+200-Math.random()*150);
				Double award = bs.getMultinum()*(Amount/r2);
				if(award>5000000.0){
					award = 5000000.0;
				}
				ai.setUsid(bs.getUsid());
				ai.setRedball(bs.getRedball());
				ai.setBlueball(bs.getBlueball());
				ai.setGrade(2);
				ai.setAward(award);
				awardlist.add(ai);
			}else if( blueResult.equals(blueball) && redcount==6 ){
				AwardInfo ai = new AwardInfo();
				double Amount = 0.65*r*2;
				//随机产生二等奖的总注数  最低50注
				int r1 = (int)(Math.random()*70+25-Math.random()*10);
				Double award = bs.getMultinum()*(Amount/r1);
				if(award>10000000.0){
					award = 10000000.0;
				}
				ai.setUsid(bs.getUsid());
				ai.setRedball(bs.getRedball());
				ai.setBlueball(bs.getBlueball());
				ai.setGrade(1);
				ai.setAward(award);
				awardlist.add(ai);
			}else{
				NotAwardInfo nai = new NotAwardInfo();
				nai.setUsid(bs.getUsid());
				nai.setRedball(bs.getRedball());
				nai.setBlueball(bs.getBlueball());
				notawardlist.add(nai);
			}
		}
		this.baseDao.save(AwardInfo.class, "addAwardInfo", awardlist);
		this.baseDao.save(NotAwardInfo.class, "addNotAwardInfo", notawardlist);
		
		
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("ssq_issue", qh);
		this.baseDao.update(UserSsq.class, "updateStatus",parameterMap);
	}
	
	/**
	 * 根据期号（本期）查出开奖结果，并返回
	 * @param ssq_issue
	 * @return
	 */
	private LotteryResult findLotteryResult(String ssq_issue){
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("ssq_issue", ssq_issue);
		LotteryResult lr = new LotteryResult();
		lr = (LotteryResult) this.baseDao.findOne(LotteryResult.class, "findLotteryResult", parameterMap);
		return lr;
	}
	
	/**
	 * 查出指定期号的用户投注双色球信息
	 * @param ssq_issue
	 * @return
	 */
	private List<BetSsq> findUserSsqBetBySsqIssue(String ssq_issue){
		List<BetSsq> list = null;
		Map<String, String> parameterMap = new HashMap<String, String>();
		parameterMap.put("ssq_issue", ssq_issue);
		list = this.baseDao.findAll(BetSsq.class, "findUserSsqBetBySsqIssue", parameterMap);
		return list;
	}


	@Override
	public List<AwardInfo> findAwardInfo(AwardInfo ai) throws Exception {
		List<AwardInfo> list = null;
		list = this.baseDao.findAll(ai, "findAwardInfo");
		return list;
	}


	@Override
	public Integer findAwardInfoCount(AwardInfo ai) throws Exception {
		Integer count = 0;
		AwardInfo awardInfo = null;
		awardInfo = (AwardInfo) this.baseDao.findOne(ai, "findAwardInfoCount");
		count = awardInfo.getAwardInfocount();
		return count;
	}
}
