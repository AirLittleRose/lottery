package com.yc.soccer.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_order;
import com.yc.soccer.bean.OrderDetail;
import com.yc.soccer.biz.Jczq_orderBiz;
import com.yc.soccer.utils.Combine;

@Service
@Transactional
public class Jczq_orderBizImpl implements Jczq_orderBiz {

	@Resource(name = "baseDao")
	private BaseDao baseDao;

	private Combine<Jczq> com = new Combine<Jczq>();

	/**
	 * 下注, 先添加 jczq_order,后添加jczq下注信息
	 */
	@Override
	public void addOrder(Jczq_order jo, List<Jczq> jczqs) {
		baseDao.save(jo, "addOrder");
		baseDao.save(Jczq.class, "addJczq", jczqs);
	}

	@Override
	public void calculateBonus(Jczq_order jo) {
		try {
			// 查出过关的所有下注信息
			List<Jczq> jczqs = baseDao.findAll(jo, "selectWinInfo");

			// 判断是否是统一订单的标志
			String str = "";

			// 中奖分类信息(分类方式:订单编号)
			Map<String, List<Jczq>> infoMap = new HashMap<String, List<Jczq>>();

			// 存储同一订单编号所有信息
			List<Jczq> jczqList = null;

			// 分类
			for (Jczq jczq : jczqs) {
				// 第一个订单的编号
				if ("".equals(str) || !jczq.getOrder_id().equals(str)) {
					jczqList = new ArrayList<Jczq>();
					jczqList.add(jczq);
					str = jczq.getOrder_id();
				} else if (jczq.getOrder_id().equals(str)) {// 相同订单编号的订单
					jczqList.add(jczq);
					infoMap.put(str, jczqList);
				}
			}

			Set<String> keySet = infoMap.keySet();
			
			// 奖金
			float bonus = 1L;

			// 奖金池 键->订单 值->奖金
			Map<String, Float> bonusPool = new HashMap<String, Float>();
			
			// 取出单个订单号的信息
			for (String key : keySet) {
				float totalMoney = 0L; //每单的奖金
				List<Jczq> jczqss = infoMap.get(key);
				// 组合
				List<List<Jczq>> jList = com.toCombine(jczqss, jczqss.get(0).getGuoguan_type());
				// 每一注
				for (List<Jczq> list : jList) {
					float money = 0L;	//每注的奖金
					float odds = 1L; //单注的总赔率	
					int pel = list.get(0).getTimes(); //每注的倍数
					// 算奖金
					for (Jczq j : list) {
						odds *= j.getOdds();
					}
					money = 2 * pel * odds;
					totalMoney += money;
				}
				bonusPool.put(key, totalMoney);
			}
			Set<String> bkey = bonusPool.keySet();
			for(String b : bkey) {
				Jczq_order jorder = new Jczq_order();
				jorder.setOrder_id(b);
				jorder.setBonus(bonusPool.get(b));
				baseDao.update(jorder, "updateBonus");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderDetail> findOrderDetail(Jczq_order jo) {
		List<OrderDetail> list = baseDao.findAll(jo, "selectOrderDetail");
		return list;
	}

	@Override
	public int findOrderCount(Jczq_order jo) {

		return (int) baseDao.getFunc(jo, "getOrderCount");
	}

	@Override
	public List<Jczq_order> findOrder(Jczq_order jo) {
		List<Jczq_order> list = this.baseDao.findAll(jo, "selectAllOrder");
		return list;
	}

	@Override
	public List<OrderDetail> findDetailByOrderId(Jczq_order jo) {
		List<OrderDetail> list = this.baseDao.findAll(jo, "findDetailByOrderId");
		return list;
	}

}
