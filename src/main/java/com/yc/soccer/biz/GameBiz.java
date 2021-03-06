package com.yc.soccer.biz;

import java.util.List;
import com.yc.soccer.bean.Game;
public interface GameBiz {


	/**
	 * 通过条件查找相关的比赛
	 * @param game
	 * @return
	 */
	List<Game> findGames(Game game);
	
	/**
	 * 保存比赛信息
	 */
	void savaGame();
}
