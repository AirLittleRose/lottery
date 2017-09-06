package com.yc.soccer.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_order;
import com.yc.soccer.bean.OrderDetail;
import com.yc.soccer.biz.Jczq_orderBiz;

@Service
@Transactional
public class Jczq_orderBizImpl implements Jczq_orderBiz {

	@Resource(name="baseDao")
	BaseDao baseDao ;
	
	/**
	 * 下注, 先添加 jczq_order,后添加jczq下注信息
	 */
	@Override
	public void addOrder(Jczq_order jo,List<Jczq> jczqs) {
		baseDao.save(jo, "addOrder");
		baseDao.save(Jczq.class, "addJczq", jczqs);
	}

	@Override
	public void calculateBonus() {
		//查出过关的所有下注信息
		List<Jczq> jczqs = baseDao.findAll(Jczq_order.class, "selectAllInfo");
		
		//判断是否是统一订单的标志
		String str = "";
		//奖金
		float bonus = 1L;
		//奖金池   键->订单   值->奖金
		Map<String, Float> bonusPool = new HashMap<String, Float>();
		for(Jczq jczq : jczqs) {
			if("".equals(str) || str.equals(jczq.getOrder_id())) {
				str = jczq.getOrder_id();
				bonus *= jczq.getOdds() * jczq.getTimes() * 2;
				bonusPool.put(str, bonus);
			}else {
				//设置标志
				str = jczq.getOrder_id();
				//奖金置1
				bonus = 1L;
				bonus *= jczq.getOdds() * jczq.getTimes() * 2;
				bonusPool.put(str, bonus);
			}
		}
		for(String key : bonusPool.keySet()) {
			
		}
	}

	@Override
	public List<OrderDetail> findOrderDetail(Jczq_order jo) {
		List<OrderDetail> list = baseDao.findAll(jo, "selectOrderDetail");
		return list;
	}

	@Override
	public int findOrderCount(Jczq_order jo) {
		
		return (int)baseDao.getFunc(jo, "getOrderCount");
	}

	@Override
	public List<Jczq_order> findOrder(Jczq_order jo) {
		List<Jczq_order> list = this.baseDao.findAll(jo, "selectAllOrder");
		return list;
	}

}
