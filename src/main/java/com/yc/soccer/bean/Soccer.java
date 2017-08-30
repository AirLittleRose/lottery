package com.yc.soccer.bean;

import java.io.Serializable;
/**
 * 足彩投注信息
 * @author xiang
 *
 */
public class Soccer implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer sid; 	//id
	private Integer game_id;	//比赛id
	
	/**
	 * 0->主胜,1->主败,2->主败
	 */
	private Integer predictresult;	//预测结果
	
	/**
	 * 0->未开奖,1->已开奖
	 */
	private Integer status;	//开奖状态

	public Soccer(Integer sid, Integer game_id, Integer predictresult, Integer status) {
		super();
		this.sid = sid;
		this.game_id = game_id;
		this.predictresult = predictresult;
		this.status = status;
	}

	public Soccer() {
		super();
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Integer getGame_id() {
		return game_id;
	}

	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}

	public Integer getPredictresult() {
		return predictresult;
	}

	public void setPredictresult(Integer predictresult) {
		this.predictresult = predictresult;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Soccer [sid=" + sid + ", game_id=" + game_id + ", predictresult=" + predictresult + ", status=" + status
				+ "]";
	}
	
}
