package com.yc.soccer.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.dao.BaseDao;
import com.yc.soccer.bean.League;
import com.yc.soccer.biz.LeagueBiz;

@Service
@Transactional
public class LeagueBizImpl implements LeagueBiz {

	@Resource(name="baseDao")
	private BaseDao baseDao;
	@Override
	public List<League> findAllLeague() {
		List<League> list = baseDao.findAll(League.class, "findAllLeague");
		return list;
	}
	
	@Override
	public void saveLeague() {
		baseDao.save(new League(), "saveLeague");
	}

}
