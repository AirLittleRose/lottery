package com.yc.soccer.bean;

import java.io.Serializable;

/**
 * 球队
 * @author xiang
 *
 */
public class Team implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer team_id;	//球队id
	private Integer league_id;	//联盟id
	private String name_zh;	//联盟名
	
	public Team(Integer team_id, Integer league_id, String name_zh) {
		super();
		this.team_id = team_id;
		this.league_id = league_id;
		this.name_zh = name_zh;
	}
	
	public Team() {
		super();
	}

	public Integer getTeam_id() {
		return team_id;
	}

	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}

	public Integer getLeague_id() {
		return league_id;
	}

	public void setLeague_id(Integer league_id) {
		this.league_id = league_id;
	}

	public String getName_zh() {
		return name_zh;
	}

	public void setName_zh(String name_zh) {
		this.name_zh = name_zh;
	}

	@Override
	public String toString() {
		return "Team [team_id=" + team_id + ", league_id=" + league_id + ", name_zh=" + name_zh + "]";
	}

}
