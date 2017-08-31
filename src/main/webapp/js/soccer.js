//日期递减
function reduceDate(days) {
	var d = new Date();
	d.setDate(d.getDate() - days);
	var m = d.getMonth() + 1;
	return d.getFullYear() + '-' + m + '-' + d.getDate();
}
function reduceMinutes(dd,minutes){
	var a = new Date(dd)
	a = a.valueOf()
	a = a - minutes * 60 * 1000
	a = new Date(a)
	return a;
}

Date.prototype.format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

// 请求联赛信息
function find_league() {
	$.ajax({
		type : "POST",
		url : "find_all_league.action",
		dataType : "JSON",
		cache : true,	//使用缓存
		success : function(data) {
			if (data.code == 1) {
				$("#leagueUl").html("");
				$(data.rows).each(
						function(index, item) {

							var str = "<li leagueid='" + item.league_id
									+ "'title='关注赛事将置顶显示'>" + "<i></i>"
									+ item.league_name + "</li>";
							$("#leagueUl").html($("#leagueUl").html() + str);
						});
			} else {
				$("#leagueUl").html("");
				var str = "<option>暂无联赛信息</option>"
				$("#leagueUl").html(str);
			}
		}
	});
}

// 点击 联赛  显示信息
function show_leagues(){
	$(".gameSeleList").toggle();
}

function find_games(){
	$.ajax({
		type : "POST",
		url : "findGames.action",
		dataType : "JSON",
		cache : true,
		success : function(data){
			if (data.code == 1) {
				var str = "";
				var date = "";//用于判断是否添加隐藏栏
				$(data.rows).each(function(index, item){	
					var flag = item.flag;
					if(date == "" || flag != date){
						date = flag;
						str += "<dt> &nbsp;&nbsp;<span class='matchSize'></span>"+item.game_time.substring(0,10)
							+"&nbsp;&nbsp;&nbsp;(该日11:30-次日11:30)<span class='cuspText'>隐藏<i class='cusp'></i></span></dt>";
					}
					//获取场次
					var screen = item.game_id.toString().substring(6);
					var i = screen.indexOf("0");
					if(screen.indexOf("0") == 0) {
						screen = screen.substring(1);
					}
					//获取代购截止时间
					var game_time = item.game_time;
					game_time = game_time.replace(/-/g,   "/");
					var result = reduceMinutes(game_time,5);
				    var end_time = result.format("yyyy-MM-dd hh:mm:ss");
				    var simple_end_time = result.format("hh:mm");
				    
					str += "<dd game_id='" + item.game_id + "'league_id='" + item.league_id + "'league_name='" + item.league_name + "'home_id='" + item.home_id + "'home_name='" + item.home_name
						+ "'away_id='" + item.away_id + "'away_name='" + item.away_name + "'oh='" + item.oh + "'od='" + item.od 
						+ "'oa='" + item.oa + "'game_time='" + item.game_time + "'color='" + item.color + "'><span class='co1'><i class='jtip'>" + screen + "</i></span><span class='co2'style='background:" + item.color 
						+ "'><a href='javascript:void(0)'target='_blank'>" + item.league_name + "</a></span><span class='co3 gameTime'><i class='jtip'inf='截止时间："+ end_time +"&lt;br/&gt;开赛时间："+ item.game_time 
						+ "'>"+ simple_end_time + "</i></span><span class='co4'><a href='javascript:void(0)'target='_blank'class='c_ffca6e'>"
						+ "<em class='hostTeam'title='"+ item.home_name +"'><b>" + item.home_name + "</b></em><em class='guestTeam'title='" + item.away_name + "'><b>" + item.away_name + "</b>"
						+ "</em></a></span><span class='co6 btnBox '><div class='line1'><em index='0'gametype='spf'sp='" + item.od + "'>" + item.od + "</em>"
						+ "<em index='1'gametype='spf'sp='" + item.oh + "'>" + item.od + "</em><em index='2'gametype='spf'sp='" + item.oa + "'class='lastOne'>" + item.oa 
						+ "</em></div></span></dd>"
				});
				$("#gamesInfo").html(str);
			}
		}
	});
}

$(function() {
	find_league();
	find_games();

});




function doChose() {
	var strs = new Array();
	jQuery('.select').each(function(key, value) {
		strs[key] = $(this).attr("leagueid");
	});
	var str = strs.join(",");
	$.ajax({
				type : "POST",
				url : "test.action?match_date_cn=" + $("#choice_date").text(),
				data : "leaguesInfo=" + str,
				dataType : "JSON",
				cache : true,
				success : function(data) {
					$("#gamesInfo").html("");
					var str = "<dt>" + $
					{
						date
					}
					+"&nbsp;&nbsp; <span class='matchSize'>" + $
					{
						data.total
					}
					+"</span> 场比赛可投注 <span class='cuspText'>隐藏"
							+ "<i class='cusp'></i></span> </dt>";
					$("#gamesInfo").html("str");
					if (data.code == 1) {
						$(data.rows)
								.each(
										function(index, item) {
											var str = "<dd game_id='" + $
											{
												game.game_id
											}
											+"' league_id='" + $
											{
												game.league_id
											}
											+"' league_name='" + $
											{
												game.league_name
											}
											+"'season_id='" + $
											{
												game.season_id
											}
											"' home_id='" + $
											{
												game.home_id
											}
											+"' home_name='" + $
											{
												game.home_name
											}
											+"'away_id='" + $
											{
												game.away_id
											}
											+"' away_name='" + $
											{
												game.away_name
											}
											+"' home_score='" + $
											{
												game.home_score
											}
											+"'away_score='" + $
											{
												game.away_score
											}
											+"' game_status='" + $
											{
												game.game_status
											}
											+"' match_date_cn='" + $
											{
												game.match_date_cn
											}
											+"'league_name='" + $
											{
												game.league_name
											}
											+"'>"
													+ "<span class='co1'><i class='jtip'>"
													+ index
													+ 1
													+ "</i></span>"
													+ "<span class='co2' style='background:'"
													+ item.color
											"'>"
													+ "<a href='javascript:void(0)' target='_blank'>"
													+ item.league_name
													+ "</a>"
													+ "</span><span class='co3 gameTime'>"
													+ "<i class='jtip' inf='截止时间："
													+ item.end_date
													+ "&lt;br/&gt;开赛时间："
													+ item.match_date_cn
													+ "'>"
													+ item.end_date_short
													+ "</i>"
													+ "</span><span class='co4'>"
													+ "<a href='#match.html?mId=1306228&amp;hId=52&amp;vId=98'target='_blank' class='c_ffca6e'>"
													+ "<em class='hostTeam' title="
													+ item.home_name + "><b>"
													+ item.home_name + "</b>";
											if (item.home_score != null) {
												str += "<i class='c_939393'>"
														+ item.home_score
														+ "</i>";
											}
											str += "</em>:<em class='guestTeam' title="
													+ item.away_name + ">";
											if (item.game.away_score != null) {
												str += "<i class='c_939393'>"
														+ item.away_score
														+ "</i>";
											}
											str += "<b>"
													+ item.away_name
													+ "</b></em></a></span><span class='co6 btnBox '>"
													+ "<div class='line1'><em index='0' gametype='spf' sp='1.17'>1.17<i class='c_090'>↓</i></em>"
													+ "<em index='1' gametype='spf' sp='5.25'>5.25<i class='c_e24949'>↑</i></em>"
													+ "<em index='2' gametype='spf' sp='12.00' class='lastOne'>12.00<i class='c_e24949'>↑</i></em>"
													+ "</div></span><span class='co7 towLine'><div class='line1 odds'>"
													+ "<em aa='0' gametype='spf' index='0' sp='1.17'><a href='javascript:;' class='maxNum'>0.00</a></em>"
													+ "<em aa='0' gametype='spf' index='1' sp='5.25'><a href='javascript:;' class='maxNum'>0.00</a></em>"
													+ "<em aa='0' gametype='spf' index='2' sp='12.00'><a href='javascript:;' class='maxNum'>0.00</a></em>"
													+ "</div></span><span class='co8'><a href='javascript:;' class='ico_square moreData'>简</a>"
													+ "<a href='#' target='_blank' class='ico_square'>析</a></span></dd>";
											$("#gamesInfo").html(
													$("#gamesInfo").html()
															+ str);
										});
					}
				}

			});
}
