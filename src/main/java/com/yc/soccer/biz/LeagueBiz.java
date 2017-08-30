package com.yc.soccer.biz;

import java.util.List;

import com.yc.soccer.bean.League;

public interface LeagueBiz {
	
	/**
	 * 查出所有联赛
	 * @param league_name
	 * @return
	 */
	List<League> findAllLeague();
	
	/**
	 * 添加联赛
	 */
	void saveLeague();
}
