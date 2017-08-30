package com.yc.soccer.jsonModel;

public class MatchInfo {

	private Integer game_id; // 比赛id
	private Integer league_id; // 联赛id
	private Integer season_id; // 赛季Id

	private Integer home_id; // 主队id
	private String home_name; // 主队名

	private Integer away_id; // 客队id
	private String away_name; // 客队名

	private Long match_date_cn; // 比赛时间 北京时间

	private Integer home_score; // 主队得分
	private Integer away_score; // 客队得分

	private Integer game_status;// 比赛状态
	// 未开始=0，比赛推迟=1，比赛延期=2，比赛取消=3，弃赛=4, 比赛中断=5， 比赛进行中=32，比赛 结束 =30

	private Integer game_time; // 比赛时长

	public MatchInfo() {
		super();
	}

	public Integer getGame_id() {
		return game_id;
	}

	public void setGame_id(Integer game_id) {
		this.game_id = game_id;
	}

	public Integer getLeague_id() {
		return league_id;
	}

	public void setLeague_id(Integer league_id) {
		this.league_id = league_id;
	}

	public Integer getSeason_id() {
		return season_id;
	}

	public void setSeason_id(Integer season_id) {
		this.season_id = season_id;
	}

	public Integer getHome_id() {
		return home_id;
	}

	public void setHome_id(Integer home_id) {
		this.home_id = home_id;
	}

	public String getHome_name() {
		return home_name;
	}

	public void setHome_name(String home_name) {
		this.home_name = home_name;
	}

	public Integer getAway_id() {
		return away_id;
	}

	public void setAway_id(Integer away_id) {
		this.away_id = away_id;
	}

	public String getAway_name() {
		return away_name;
	}

	public void setAway_name(String away_name) {
		this.away_name = away_name;
	}

	public Long getMatch_date_cn() {
		return match_date_cn;
	}

	public void setMatch_date_cn(Long match_date_cn) {
		this.match_date_cn = match_date_cn;
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

	public Integer getGame_status() {
		return game_status;
	}

	public void setGame_status(Integer game_status) {
		this.game_status = game_status;
	}

	public Integer getGame_time() {
		return game_time;
	}

	public void setGame_time(Integer game_time) {
		this.game_time = game_time;
	}

	@Override
	public String toString() {
		return "MatchInfo [game_id=" + game_id + ", league_id=" + league_id + ", season_id=" + season_id + ", home_id="
				+ home_id + ", home_name=" + home_name + ", away_id=" + away_id + ", away_name=" + away_name
				+ ", match_date_cn=" + match_date_cn + ", home_score=" + home_score + ", away_score=" + away_score
				+ ", game_status=" + game_status + ", game_time=" + game_time + "]";
	}
	

}
