package com.yc.soccer.bean;

import java.io.Serializable;

/**
 * 竞彩足球  下注信息  
 * @author xiang
 *	
 */
public class Jczq implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer jid;	//id
	private String order_id;//订单号
	private String game_id;
	private Integer predict;//预测结果	0,1,2 胜平负
	private float odds;		//赔率
	private Integer times;	//倍数
	private Integer result;	//结果	0,1 -> 输/赢
	
	private Integer guoguan_type;
	
	public Jczq(Integer jid, String order_id, String game_id, Integer predict, float odds, Integer times,
			Integer result) {
		super();
		this.jid = jid;
		this.order_id = order_id;
		this.game_id = game_id;
		this.predict = predict;
		this.odds = odds;
		this.times = times;
		this.result = result;
	}

	public Jczq() {
		super();
	}

	public Integer getJid() {
		return jid;
	}

	public void setJid(Integer jid) {
		this.jid = jid;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	

	public String getGame_id() {
		return game_id;
	}

	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}

	public Integer getPredict() {
		return predict;
	}

	public void setPredict(Integer predict) {
		this.predict = predict;
	}

	public float getOdds() {
		return odds;
	}

	public void setOdds(float odds) {
		this.odds = odds;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public Integer getGuoguan_type() {
		return guoguan_type;
	}

	public void setGuoguan_type(Integer guoguan_type) {
		this.guoguan_type = guoguan_type;
	}

	@Override
	public String toString() {
		return "Jczq [jid=" + jid + ", order_id=" + order_id + ", game_id=" + game_id + ", predict=" + predict
				+ ", odds=" + odds + ", times=" + times + ", result=" + result + ", guoguan_type=" + guoguan_type + "]";
	}
	
}
