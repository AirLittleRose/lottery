package com.yc.soccer.bean;

import java.io.Serializable;

/**
 * 联赛
 * @author xiang
 *
 */
public class League implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Integer league_id;	//联盟id
	private	String league_name;	//联盟名
	private String color;
	
	private Integer new_id; //设置的新id

	public League(Integer league_id, String league_name, String color, Integer new_id) {
		super();
		this.league_id = league_id;
		this.league_name = league_name;
		this.color = color;
		this.new_id = new_id;
	}

	public League() {
		super();
	}

	public Integer getLeague_id() {
		return league_id;
	}

	public void setLeague_id(Integer league_id) {
		this.league_id = league_id;
	}

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getNew_id() {
		return new_id;
	}

	public void setNew_id(Integer new_id) {
		this.new_id = new_id;
	}

	@Override
	public String toString() {
		return "League [league_id=" + league_id + ", league_name=" + league_name + ", color=" + color + ", new_id="
				+ new_id + "]";
	}

}
