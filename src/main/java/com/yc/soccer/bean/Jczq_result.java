package com.yc.soccer.bean;

import java.io.Serializable;

/**
 * 
 * @author xiang
 *
 */
public class Jczq_result implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer jrid;		//id
	private String game_id;	//比赛id
	private Integer home_score;	//主队得分
	private Integer away_score;	//客队得分
	private Integer result;		//比赛结果   胜平负



	public Jczq_result(Integer jrid, String game_id, Integer home_score, Integer away_score, Integer result) {
		super();
		this.jrid = jrid;
		this.game_id = game_id;
		this.home_score = home_score;
		this.away_score = away_score;
		this.result = result;
	}

	public Jczq_result() {
		super();
	}

	public Integer getJrid() {
		return jrid;
	}

	public void setJrid(Integer jrid) {
		this.jrid = jrid;
	}

	public String getGame_id() {
		return game_id;
	}

	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}

	public Integer getHome_score() {
		return home_score;
	}

	public void setHome_score(Integer home_score) {
		this.home_score = home_score;
	}

	public Integer getAway_score() {
		return away_score;
	}

	public void setAway_score(Integer away_score) {
		this.away_score = away_score;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Jczq_result [jrid=" + jrid + ", game_id=" + game_id + ", home_score=" + home_score + ", away_score="
				+ away_score + ", result=" + result + "]";
	}

}
