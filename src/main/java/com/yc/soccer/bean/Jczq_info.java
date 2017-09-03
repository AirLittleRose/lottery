package com.yc.soccer.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 前端接收参数时使用
 * @author xiang
 *
 */
public class Jczq_info implements Serializable{

	private static final long serialVersionUID = 1L;


	private String[] game_id;		//id
	private String[] game_time;		//时间
	private String[] home_name;		//主队
	private String[] away_name;		//客队	
	private String[] sp;			//预测结果
	private String[] odds;			//赔率
	private String num;				//场数
	private String type;				//过关类型
	private String pel;				//倍数
	private String amount;				//总金额
	public Jczq_info(String[] game_id, String[] game_time, String[] home_name, String[] away_name, String[] sp,
			String[] odds, String num, String type, String pel, String amount) {
		super();
		this.game_id = game_id;
		this.game_time = game_time;
		this.home_name = home_name;
		this.away_name = away_name;
		this.sp = sp;
		this.odds = odds;
		this.num = num;
		this.type = type;
		this.pel = pel;
		this.amount = amount;
	}
	public Jczq_info() {
		super();
	}
	public String[] getGame_id() {
		return game_id;
	}
	public void setGame_id(String[] game_id) {
		this.game_id = game_id;
	}
	public String[] getGame_time() {
		return game_time;
	}
	public void setGame_time(String[] game_time) {
		this.game_time = game_time;
	}
	public String[] getHome_name() {
		return home_name;
	}
	public void setHome_name(String[] home_name) {
		this.home_name = home_name;
	}
	public String[] getAway_name() {
		return away_name;
	}
	public void setAway_name(String[] away_name) {
		this.away_name = away_name;
	}
	public String[] getSp() {
		return sp;
	}
	public void setSp(String[] sp) {
		this.sp = sp;
	}
	public String[] getOdds() {
		return odds;
	}
	public void setOdds(String[] odds) {
		this.odds = odds;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPel() {
		return pel;
	}
	public void setPel(String pel) {
		this.pel = pel;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Jczq_info [game_id=" + Arrays.toString(game_id) + ", game_time=" + Arrays.toString(game_time)
				+ ", home_name=" + Arrays.toString(home_name) + ", away_name=" + Arrays.toString(away_name) + ", sp="
				+ Arrays.toString(sp) + ", odds=" + Arrays.toString(odds) + ", num=" + num + ", type=" + type + ", pel="
				+ pel + ", amount=" + amount + "]";
	}
	
}
