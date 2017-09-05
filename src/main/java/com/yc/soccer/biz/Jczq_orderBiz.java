package com.yc.soccer.biz;

import java.util.List;

import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_order;

/**
 * 竞彩足球 订单
 * @author xiang
 *
 */
public interface Jczq_orderBiz {
	/**
	 * 添加订单信息
	 * @param jo
	 */
	void addOrder(Jczq_order jo,List<Jczq> jczqs);
	
	void calculateBonus();
}
