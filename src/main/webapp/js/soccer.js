//日期递减
function reduceDate(days) {
	var d = new Date();
	d.setDate(d.getDate() - days);
	var m = d.getMonth() + 1;
	return d.getFullYear() + '-' + m + '-' + d.getDate();
}

//时间的分钟加(减)
function reduceMinutes(dd,minutes){
	var a = new Date(dd)
	a = a.valueOf()
	a = a - minutes * 60 * 1000
	a = new Date(a)
	return a;
}

//日期格式化
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

//组合算法  从m中选n个
function combination(m,n){
	var up = 1;
	var down = 1;
	for(var i=0; i<n; i++){
		up = up * (m-i);
	}
	for(var j=1; j<=n; j++){
		down = down * j;
	}
	var result = up/down;
	return result;
}

//动态加载js或css
function loadJsCss(filename, filetype){
    if (filetype=="js")
    {
      var fileref=document.createElement('script')//创建标签
      fileref.setAttribute("type","text/javascript")//定义属性type的值为text/javascript
      fileref.setAttribute("src", filename)//文件的地址
    }
    else if (filetype=="css")
    { 
      var fileref=document.createElement("link")
      fileref.setAttribute("rel", "stylesheet")
      fileref.setAttribute("type", "text/css") 
      fileref.setAttribute("href", filename)
    }
    if (typeof fileref!="undefined")
    {
      document.getElementsByTagName("head")[0].appendChild(fileref)
    }
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
	$(".gameSeleList").toggle(250);
}

//隐藏-显示 游戏信息
function hide_gamesInfo(id){
	var obj = "#" + id;
	var text = "#s" + id; 
	$(obj).siblings("dd").toggle(500);
	if($(text).text() == "隐藏"){
		$(text).text("显示");
	}else{
		$(text).text("隐藏");
	}
}


//请求 球赛 信息
function find_games(){
	$.ajax({
		type : "POST",
		url : "findGames.action",
		dataType : "JSON",
		cache : true,
		success : function(data){
			if (data.code == 1) {
				var str = "";
				var date = data.rows[0].game_id.toString();
				date = date.substring(0,6);
				$(data.rows).each(function(index, item){	
					var flag = item.game_id.toString().substring(0,6);
					if(index == 0 || flag != date){
						date = flag;
						if(index != 0){
							str += "</dl>"
						}
						str += "<dl><dt id='" + date + "'> &nbsp;&nbsp;<span class='matchSize'></span>"+date.substring(2,4)+"-"+date.substring(4,6)
							+"&nbsp;&nbsp;&nbsp;(该日11:30&nbsp;-&nbsp;次日11:30)<span class='cuspText' onclick='hide_gamesInfo(" + date + ")' ><span id='s"+ date +"'>隐藏</span></span></dt>";
						
					}
					//获取比赛的场次
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
						+ "'><a href='javascript:void(0)'target='_blank'>" + item.league_name + "</a></span><span class='co3 gameTime'><i class='jtip' inf='截止时间："+ end_time +"&lt;br/&gt;开赛时间："+ item.game_time 
						+ "'>"+ simple_end_time + "</i></span><span class='co4'><a href='javascript:void(0)'target='_blank'class='c_ffca6e'>"
						+ "<em class='hostTeam'title='"+ item.home_name +"'><b>" + item.home_name + "</b></em><em class='guestTeam'title='" + item.away_name + "'><b>" + item.away_name + "</b>"
						+ "</em></a></span><span class='co6 btnBox '><div class='line1'><em index='0'gametype='spf'sp='" + item.od + "' class='soccer_option' >" + item.od + "</em>"
						+ "<em index='1'gametype='spf'sp='" + item.oh + "' class='soccer_option'>" + item.oh + "</em><em index='2'gametype='spf'sp='" + item.oa + "' class='soccer_option'>" + item.oa 
						+ "</em></div></span></dd>"
				});
				str += "</dl>";
				$("#gamesInfo").html(str);
			}
		}
	});
}

//下注 选择 点击事件
function choice_soccer(){
	$(".soccer_option").each(function(){
		$(this).click(
			function(){
				xiazhu(this);
				$(this).css("background", "#B12034");
				$(this).unbind("mouseout");  
	            $(this).unbind("mouseover");
	            $(this).unbind("click");
			});
	});
}

//下注  列表的事件初始化
function choice_init(){
	$(".soccer_option").css("background", "#FFFFFF");
	$(".soccer_option").mouseover(function () {
		$(this).css("background", "#B12034");
	});
	$(".soccer_option").mouseout(function () {
		$(this).css("background", "#FFFFFF");
	});
}


//下注
function xiazhu(obj){
	//比赛id
	var game_id = $(obj).parent().parent().parent().attr("game_id").toString();
	//比赛时间
	var game_time = $(obj).parent().parent().parent().attr("game_time").toString();
	//场次
	var cc = game_id.substring(2,4)+"-"+game_id.substring(4,6)+"-"+game_id.substring(7,9);
	//主队名
	var home_name = $(obj).parent().parent().parent().attr("home_name").toString();
	if(home_name.length>4){
		home_name = home_name.substring(0,4);
	}
	//客队名
	var away_name = $(obj).parent().parent().parent().attr("away_name").toString();
	if(away_name.length>4){
		away_name = away_name.substring(0,4);
	}
	//胜平负
	var index = $(obj).attr("index");
	//赔率
	var Odds = $(obj).attr("sp");
	var result = "";
	var block = "";
	switch(index){
	case "0":
		result = "胜";
		block = "Win";
		break;
	case "1": 
		result = "平";
		block = "Ping";
		break;
	case "2":
		result = "负";
		block = "Fu";
		break;
	}
	
	//用于判断添加类型  添加比赛,或添加胜平负
	var temp = 0;
	//该场次是否存在
	$(".gameTitle").each(function(){
		if($(this).attr("matchcode") == game_id){
			temp = 1;	//1->只添加胜平负
			var str = $(this).next().children().html();
			str += "<a class='block" + block + "' Odds='" + Odds + "' href='javascript:;' matchcode='" + game_id + "' gametype='spf' index='" + index + "'onclick='remove_xiazhu_2(this)'>" + result + "</a>"
			$(this).next().children().html(str);
			//修改index
			var temp_index = $(this).attr("index").toString();
			temp_index += ","+index;
			$(this).attr("index",temp_index);
			return "";
		} 
	});
	if(temp == 0){
		var str = $("#selectGamePool").children("tbody").html() + "<tr matchcode='" + game_id + "'class='gameTitle' index='" + index + "' game_time='" + game_time + "'><th><a class='icoDel'href='javascript:;' onclick='remove_xiazhu_1(this)'></a>" + game_id.substring(2) + "</th><th class='tr'>" + home_name + "</th><th></th><th class='tl'>" + away_name + "</th><th><a href='javascript:;'class='icoDan icoDanDis'disabled='disabled'></a></th></tr><tr class='gameOption'matchcode='" + game_id + "'><td colspan='5'class='betList'><a index='" + index + "'gametype='spf'matchcode='" + game_id + "'href='javascript:;'class='block" + block + "' Odds='" + Odds + "'onclick='remove_xiazhu_2(this)'>" + result + "</a></td></tr>"
		$("#selectGamePool").children("tbody").html(str);
	}
	xiazhu_type();
}

//取消下注 (整场)
function remove_xiazhu_1(obj){

	//场次
	var match_code = $(obj).parent().parent().attr("matchcode").toString();
	//获取index  给选项框消除  "红色背景"
	var index = $(obj).parent().parent().attr("index").toString();
	var indexs = index.split(",");
	$("#gamesInfo").children("dl").find("dd").each(function(){
		var str = $(this).attr("game_id").toString();
		if(str == match_code){
			$(this).children("span.co6").children("div.line1").children().each(function(){
				for(var i=0; i<indexs.length; i++){
					if($(this).attr("index").toString() == indexs[i]){
						$(this).css("background", "#FFFFFF");
						$(this).mouseover(function () {
							$(this).css("background", "#B12034");
						});
						$(this).mouseout(function () {
							$(this).css("background", "#FFFFFF");
						});
						$(this).click(function () {
								xiazhu(this);
								$(this).css("background", "#B12034");
								$(this).unbind("mouseout");  
					            $(this).unbind("mouseover");
					            $(this).unbind("click");
						});
					}
				}
			});
		}
	});
	$(obj).parent().parent().next().remove();
	$(obj).parent().parent().remove();
	xiazhu_type();
}

//取消单个胜平负下注(如只有一个选项就整场取消)
function remove_xiazhu_2(obj){
	//场次
	var game_id = $(obj).attr("matchcode");
	//下标
	var index = $(obj).attr("index");
	
	if($(obj).siblings().size() == 0){
		remove_xiazhu_1($(obj).parent().parent().prev().children().first().children(".icoDel"));
	}else{
		$("#gamesInfo").children("dl").find("dd").each(function(){
			//获取当前的game_id
			var str = $(this).attr("game_id").toString();
			if(str == game_id){
				$(this).children("span.co6").children("div.line1").children().each(function(){
					if($(this).attr("index").toString() == index){
						$(this).css("background", "#FFFFFF");
						$(this).mouseover(function () {
							$(this).css("background", "#B12034");
						});
						$(this).mouseout(function () {
							$(this).css("background", "#FFFFFF");
						});
						$(this).click(function () {
								$(this).css("background", "#B12034");
								$(this).unbind("mouseout");  
					            $(this).unbind("mouseover");
					            $(this).unbind("click");
						});
					}
				});
			}
		});
		$(obj).remove();
	}
}

// 生成"通关类型"
function xiazhu_type(){
	// 下注的场数
	var num = $(".gameTitle").size();
	$("#gameNumber").text(num);
	if(num>1){
		var str = "";
		for(var i=2; i<=num; i++){
			str += "<li inf='至少猜中" + i + "场可中奖' class='jtip' onclick='choice_type(this)'><i class='icoFx ' value='" + i + "_1' data-method='" + i + "_1' disabled='disabled'></i>" + i + "串1</li>";
		}
		$("#guoguan_type").html("");
	}else{
		var str = "<span>&lt;&lt;&lt;&nbsp;&nbsp;请在左侧选择场次</span>";
	}
	$("#guoguan_type").html(str);
	choice_type();
}

// 选择 "通关类型"
function choice_type(obj){
	$(obj).children().toggleClass("icoFx_active");
	zhu_num();
	amount();
}

//减 倍数
function subtract(){
	var value = $("#betTimes").children("input").attr("value");
	if(value > 5){
		value--;
		$("#betTimes").children("input").attr("value",value);
		amount();	//结算金额
	}
}

// 加 倍数
function add(){
	var value = $("#betTimes").children("input").attr("value");
	value++;
	$("#betTimes").children("input").attr("value",value);
	amount();	//结算金额
} 

//计算  注 数 (显示)
function zhu_num(){
	//下注场数
	var num = $(".gameTitle").size();
	//通关类型
	var type = $(".icoFx_active").attr("value");
	if(type != null){
		var n = Number(type.split("_")[0]);
		var zhu_num = combination(num,n);
		$("#gameZhu").text(zhu_num);
	}else{
		$("#gameZhu").text(0);
	}
}

//计算总金额
function amount(){
	//注数
	var zhu_num = parseInt($("#gameZhu").text());
	//倍数
	var bet = parseInt($("#betTimes").children("input").attr("value"));
	var amount = zhu_num * bet * 2;
	$("#totalMoney").text(amount);
}

//计算奖金
function bonus(){
	
}


//下注信息 对象定义
function xiazhu_info(game_id, game_time, home_name, away_name, sp, odds, num, type, pel, amount){
	this.game_id = game_id;		//比赛id
	this.game_time = game_time;	//开赛时间	
	this.home_name = home_name;	//主队
	this.away_name = away_name;	//客队
	this.sp = sp;		//预测结果 012 -> 胜平负
	this.odds = odds;	//赔率
	this.num = num;		//场数
	this.type = type;	//过关方式
	this.pel = pel;		//倍数
	this.amount = amount;	//总金额
}

//胜平负转换
function turnSp(sp){
	var str = "";
	switch(sp){
	case "0":
		str += "胜";
		break;
	case "1":
		str += "平";
		break;
	case "2": 
		str += "负";
		break;
	}
	return str;
}

//过关类型转化
function turnType(sp){
	var str = sp + "串1";
	return str;
}

//下注
function to_xiazhu(){
	var game_id = new Array();		//Id
	var game_time = new Array();	//时间
	var home_name = new Array();	//主队
	var away_name = new Array();	//客队
	var sp = new Array();			//预测
	var odds = new Array();			//赔率
	var i = 0;
	$(".gameTitle").each(function(){
		game_id[i] = $(this).attr("matchcode");
		game_time[i] = $(this).attr("game_time");
		home_name[i] = $(this).children(".tr").text();
		away_name[i] = $(this).children(".tl").text();
		sp[i] = $(this).next().children(".betList").children().attr("index");
		odds[i] = $(this).next().children(".betList").children().attr("odds");
		i++;
	})
	var num = $("#gameNumber").text();		//场数
	var type = $(".icoFx_active").attr("value").toString().split("_")[0];	//过关类型
	var pel = $("#betTimes").children("input").attr("value");		//倍数
	var amount = $("#totalMoney").text();				//总金额
	var info=new xiazhu_info(game_id, game_time, home_name, away_name, sp, odds, num, type, pel, amount);

		$.ajax({
		type: "POST",
		url: "to_xiazhu.action",
		data:  {
	        "game_id": game_id,
	        "game_time": game_time,
	        "home_name": home_name,
	        "away_name": away_name,
	        "sp": sp,
	        "odds": odds,
	        "num": num,
	        "type": type,
	        "pel": pel,
	        "amount": amount
	    },
	    traditional: true,//这里设置为true
		dataType: "JSON",
		success:function(data){
			$("#info_tbody").html("");
			var str = "";
			for(var i=0; i<parseInt(num); i++){
				str += "<tr data-id='" + game_id[i] + "' data-i='" + i + "' data-rs=''>  ";
				str += "<td>" + game_id[i] + "</td> <td>" + game_time[i] + "</td>";
				str += "<td>" + home_name[i] + "&nbsp;&nbsp;VS&nbsp;&nbsp;" + away_name[i] + "</td><td>胜平负</td>";
				str += "<td><span class='f-gray'>—</span></td><td class='betItemTd'><a href='javascript:;' class='betItem ' data-i='0'>";
				str += turnSp(sp[i]) + "" + odds[i] + "<i class='icon icon_gold'></i></a></td></tr>";
			}
			$("#info_tbody").html(str);
			$(".matchNum").text(num);
			$(".betTimes").text(pel);
			$(".methods").text(turnType(type));
			$("#amount").text(amount);
			ShowDiv('MyDiv','fade');
		}
	});
	

}

//弹出隐藏层
function ShowDiv(show_div,bg_div){
 document.getElementById(show_div).style.display='block';
 document.getElementById(bg_div).style.display='block' ;
 var bgdiv = document.getElementById(bg_div);
 bgdiv.style.width = document.body.scrollWidth; 
 // bgdiv.style.height = $(document).height();
 $("#"+bg_div).height($(document).height());
 choice_type();
};

//关闭弹出层
function CloseDiv(show_div,bg_div)
{
 document.getElementById(show_div).style.display='none';
 document.getElementById(bg_div).style.display='none';
 choice_type();

};

//页面加载后运行
$(function() {
	//查找联赛
	find_league();
	//查找比赛
	find_games();
	//比赛新增初始化
	setTimeout('choice_soccer()',900); 
	setTimeout('choice_init()',850);
});









