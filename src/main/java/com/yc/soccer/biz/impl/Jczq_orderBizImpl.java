package com.yc.soccer.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.Jczq;
import com.yc.soccer.bean.Jczq_order;
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

}
