package com.yc.soccer.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 比赛
 * @author xiang
 *	
 */
public class Game implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer game_id;	//比赛id
	private Integer league_id; //联赛id
	private Integer home_id;	//主场id	
	private Integer away_id;	//客队id
	private String game_time;	//比赛时间
	private String oh;		
	private String od;
	private String oa;
	
	
	//前端显示
	private String home_name;
	private String away_name;
	private String league_name;
	private String color;

	
	private String screen;
	private String end_date;	//购彩截止时间
	
	//用于判断是否添加  隐藏栏
	private String flag;
	private String todayday;
	
	private String start;
	private String end;
	private String leaguesInfo;
	private List<String> leaguesList;
	
	public Game(Integer game_id, Integer league_id, Integer home_id, Integer away_id, String game_time,
			String end_date, String home_name, String away_name, String league_name, String color, String leaguesInfo,
			List<String> leaguesList) {
		super();
		this.game_id = game_id;
		this.league_id = league_id;
		this.home_id = home_id;
		this.away_id = away_id;
		this.game_time = game_time;
		this.end_date = end_date;
		this.home_name = home_name;
		this.away_name = away_name;
		this.league_name = league_name;
		this.color = color;
		this.leaguesInfo = leaguesInfo;
		this.leaguesList = leaguesList;
	}
	
	public Game() {
		super();
	}
	
	
	
	public String getOh() {
		return oh;
	}

	public void setOh(String oh) {
		this.oh = oh;
	}

	public String getOd() {
		return od;
	}

	public void setOd(String od) {
		this.od = od;
	}

	public String getOa() {
		return oa;
	}

	public void setOa(String oa) {
		this.oa = oa;
	}

	public String getTodayday() {
		return this.game_time.substring(0, 10);
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
	
	public Integer getHome_id() {
		return home_id;
	}
	
	public void setHome_id(Integer home_id) {
		this.home_id = home_id;
	}
	
	public Integer getAway_id() {
		return away_id;
	}
	
	public void setAway_id(Integer away_id) {
		this.away_id = away_id;
	}
	
	public String getGame_time() {
		return game_time;
	}
	
	public void setGame_time(String game_time) {
		game_time = game_time.substring(0, 19);
		this.game_time = game_time;
	}
	
	public String getEnd_date() throws ParseException {
		String game_time = this.game_time;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date game = sdf.parse(game_time);
		long end = game.getTime()-5*60*1000;
		Date end_date = new Date(end);
		return sdf.format(end_date).toString();
	}
	
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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
	
	public String getLeaguesInfo() {
		return leaguesInfo;
	}
	
	public void setLeaguesInfo(String leaguesInfo) {
		this.leaguesInfo = leaguesInfo;
	}
	
	public List<String> getLeaguesList() {
		return leaguesList;
	}
	
	public void setLeaguesList(List<String> leaguesList) {
		this.leaguesList = leaguesList;
	}
	
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public String getFlag() {
		return this.game_id.toString().substring(0, 6);
	}
	
	
	public String getScreen() {
		String screen = this.game_id.toString().substring(6);
		int i = screen.indexOf("0");
		if(screen.indexOf("0") == 0) {
			screen = screen.substring(1);
		}
		return screen;
	}
	
	public String getSimple_end_time() throws ParseException {
		return this.getEnd_date().split(" ")[1];
	}

	@Override
	public String toString() {
		return "Game [game_id=" + game_id + ", league_id=" + league_id + ", home_id=" + home_id + ", away_id=" + away_id
				+ ", game_time=" + game_time + ", end_date=" + end_date + ", home_name=" + home_name + ", away_name="
				+ away_name + ", league_name=" + league_name + ", color=" + color + ", start=" + start + ", end=" + end
				+ ", leaguesInfo=" + leaguesInfo + ", leaguesList=" + leaguesList + "]";
	}

}






