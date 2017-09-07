package com.yc.soccer.biz;

import java.util.List;

import com.yc.soccer.bean.Jczq_result;

/**
 * 竞彩足球  比赛结果
 * @author xiang
 *
 */
public interface Jczq_resultBiz {
	
	//添加比赛结果
	void addResult(List<Jczq_result> list);
	
	//开奖,即将下注信息的下注结果result修改
	void openJczqLottery();
}
