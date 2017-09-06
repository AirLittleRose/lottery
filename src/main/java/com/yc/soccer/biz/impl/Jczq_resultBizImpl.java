package com.yc.soccer.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_result;
import com.yc.soccer.biz.Jczq_resultBiz;

@Service
@Transactional
public class Jczq_resultBizImpl implements Jczq_resultBiz{

	@Resource(name="baseDao")
	private BaseDao baseDao;
	
	@Override
	public void addResult(List<Jczq_result> list) {
		baseDao.save(Jczq_result.class, "addResult", list);
	}

	@Override
	public void openJczqLottery() {
		Jczq jczq = new Jczq();
		Jczq_result jr = new Jczq_result();
		jczq.setGame_id(this.getPrev());
		jr.setGame_id(this.getPrev());
		//查出下注信息
		List<Jczq> jczqs = this.baseDao.findAll(jczq, "selectJczqByGameId");
		//查出比赛结果
		List<Jczq_result> jrs = this.baseDao.findAll(jr, "selectResultByGameId");
		
		//通过game_id,对比预测结果和比赛结果, 给下注信息的result设置相对应的值
		
		//比赛结果
		for(Jczq_result j : jrs) {
			//下注信息
			for(Jczq zq : jczqs) {
				if(Integer.parseInt(zq.getGame_id()) < Integer.parseInt(j.getGame_id())) {
					continue;
				}else if(Integer.parseInt(zq.getGame_id()) == Integer.parseInt(j.getGame_id())) {
					int result = (zq.getPredict() == j.getResult()) ? 1 : 0;
					zq.setResult(result);
					this.baseDao.update(zq, "openJczqLottery");
				}else {
					break;
				}
			}
		}

	}
	
	
	
	
	private int isWin(Integer score1, Integer score2) {
		if(score1 == score2) {
			return 1;
		}else {
			return 0;
		}
	}
	
	
	
	
	private String getPrev() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime()-24*60*60*1000);
		String str = date.substring(2, 4) + date.substring(5, 7) + date.substring(8, 10)+"%";
		return str;
	}
	
	
	
	
	
	
}
