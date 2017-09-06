package com.yc.soccer.biz;

import java.util.List;

import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_order;
import com.yc.soccer.bean.OrderDetail;

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
	
	/**
	 * 查看用户的订单详情
	 */
	List<OrderDetail> findOrderDetail(Jczq_order jo);
	
	/**
	 * 查出用户的订单数
	 */
	int findOrderCount(Jczq_order jo);
	
	/**
	 * 查看用户订单
	 */
	List<Jczq_order> findOrder(Jczq_order jo);
}
