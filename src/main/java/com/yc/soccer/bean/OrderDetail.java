package com.yc.soccer.bean;

public class OrderDetail {
	private String order_id;
	private Integer guoguan_type;
	private Integer amount;
	private Float bonus;
	private String last_time;
	private String buy_time;
	private String game_id;
	private Integer predict;
	private Float odds;
	private Integer times;
	private Integer result;
	private String league_name;
	private String home_name;
	private String away_name;
	private String game_time;
	
	public OrderDetail(String order_id, Integer guoguan_type, Integer amount, Float bonus, String last_time,
			String buy_time, String game_id, Integer predict, Float odds, Integer times, Integer result,
			String league_name, String home_name, String away_name, String game_time) {
		super();
		this.order_id = order_id;
		this.guoguan_type = guoguan_type;
		this.amount = amount;
		this.bonus = bonus;
		this.last_time = last_time;
		this.buy_time = buy_time;
		this.game_id = game_id;
		this.predict = predict;
		this.odds = odds;
		this.times = times;
		this.result = result;
		this.league_name = league_name;
		this.home_name = home_name;
		this.away_name = away_name;
		this.game_time = game_time;
	}
	
	public OrderDetail() {
		super();
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Float getBonus() {
		return bonus;
	}

	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}

	public String getLast_time() {
		return last_time;
	}

	public void setLast_time(String last_time) {
		this.last_time = last_time;
	}

	public String getBuy_time() {
		return buy_time;
	}

	public void setBuy_time(String buy_time) {
		this.buy_time = buy_time;
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

	public Float getOdds() {
		return odds;
	}

	public void setOdds(Float odds) {
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

	public String getLeague_name() {
		return league_name;
	}

	public void setLeague_name(String league_name) {
		this.league_name = league_name;
	}

	public String getHome_name() {
		return home_name;
	}

	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}

	public String getAway_name() {
		return away_name;
	}

	public void setAway_name(String away_name) {
		this.away_name = away_name;
	}

	public String getGame_time() {
		return game_time;
	}

	public void setGame_time(String game_time) {
		this.game_time = game_time;
	}

	@Override
	public String toString() {
		return "OrderDetail [order_id=" + order_id + ", guoguan_type=" + guoguan_type + ", amount=" + amount
				+ ", bonus=" + bonus + ", last_time=" + last_time + ", buy_time=" + buy_time + ", game_id=" + game_id
				+ ", predict=" + predict + ", odds=" + odds + ", times=" + times + ", result=" + result
				+ ", league_name=" + league_name + ", home_name=" + home_name + ", away_name=" + away_name
				+ ", game_time=" + game_time + "]";
	}
	
}
