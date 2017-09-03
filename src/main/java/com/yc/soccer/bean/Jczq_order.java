package com.yc.soccer.bean;

import java.io.Serializable;

/**
 * 竞彩足球 -- 下单
 * @author xiang
 *
 */
public class Jczq_order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer joid;		//id
	private Integer userid;		//用户id
	private String order_id;	//订单id
	private Integer guoguan_type;//过关类型
	private Integer amout;		//总金额
	private float bonus;		//奖金	
	private String last_time;	//总开奖时间
	
	public Jczq_order(Integer joid, Integer userid, String order_id, Integer guoguan_type, Integer amout, float bonus,
			String last_time) {
		super();
		this.joid = joid;
		this.userid = userid;
		this.order_id = order_id;
		this.guoguan_type = guoguan_type;
		this.amout = amout;
		this.bonus = bonus;
		this.last_time = last_time;
	}

	public Jczq_order() {
		super();
	}

	public Integer getJoid() {
		return joid;
	}

	public void setJoid(Integer joid) {
		this.joid = joid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getGuoguan_type() {
		return guoguan_type;
	}

	public void setGuoguan_type(Integer guoguan_type) {
		this.guoguan_type = guoguan_type;
	}

	public Integer getAmout() {
		return amout;
	}

	public void setAmout(Integer amout) {
		this.amout = amout;
	}

	public float getBonus() {
		return bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

	@Override
	public String toString() {
		return "Jczq_order [joid=" + joid + ", userid=" + userid + ", order_id=" + order_id + ", guoguan_type="
				+ guoguan_type + ", amout=" + amout + ", bonus=" + bonus + ", last_time=" + last_time + "]";
	}
	
	
	
}
