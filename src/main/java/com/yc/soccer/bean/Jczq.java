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
	private Integer predict;//预测结果	0,1,2 胜平负
	private float odds;		//赔率
	private Integer times;	//倍数
	private Integer result;	//结果	0,1 -> 输/赢
	
	public Jczq(Integer jid, String order_id, Integer predict, float odds, Integer times, Integer result) {
		super();
		this.jid = jid;
		this.order_id = order_id;
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

	@Override
	public String toString() {
		return "Jczq [jid=" + jid + ", order_id=" + order_id + ", predict=" + predict + ", odds=" + odds + ", times="
				+ times + ", result=" + result + "]";
	}
	
	
	
}
