<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="css/analyTab.css">
<link rel="stylesheet" href="css/jczqGray_V1.css">
<script src="js/jquery-1.js"></script>
<script src="js/easyCore.js"></script>
<script src="js/game.js"></script>
<script src="js/pt.js"></script>
<script src="js/jselect.js"></script>
<script src="js/dialog.js"></script>
<script src="js/core-1.js"></script>
<script src="js/common.js"></script>
<script src="js/spfDgp.js"></script>
<script src="js/jscrollpane.js"></script>
<script src="js/mousewheel.js"></script>
<script type="text/javascript" src="js/ntes.js"></script>
<div class="wrapper">

	<script>
	window.Game && window.Game.config && (window.Game.config.gameEn="jczq_mix_p");
	window.Core && window.Core.config && (window.Core.config.maxBetTimes="500000");
	window.Core && window.Core.config && (window.Core.config.bgConfig={});
	window.Core && window.Core.config && (window.Core.config.isNewUser="");
	window.Core && window.Core.config && (window.Core.config.currentTheme="gray");
	</script>

	<article class="docBody clearfix" id="docBody">
		<header class="game_header ">
			<div class="headerBox clearfix">
				<span class="cz_logo cz_jczq"></span>
				<h1><a href="#">竞彩足球</a></h1>
				<span class="text"><i>提示：投注为全场90分钟（含伤停补时）的比分结果，不含加时赛及点球结果</i></span>
			</div>
			<ul class="gameMenu clearfix">
				<li class="active"><a href="#" hidefocus="true">混合投注</a></li>        
			</ul>
			<div class="headerBg"></div>
		</header>
		
		<section class="main spfDcjs onlySpf clearfix onlyOdds">
			<nav class="betNav">
				<div class="huntou_SelectBox">
					<span class="text">选择玩法</span>
					<div class="mcSelectBox" id="changeGame">
						<span class="optionList"><a href="#">猜一场</a></span>
						<a href="#" class="imitateSelect" currentgame="spfdgp">猜一场</a><em class="fgx"></em><em class="arrow"></em>
					</div>
				</div>
				<div class="moreLinks">
					<a target="_blank" href="#">最新开奖</a>
					<a target="_blank" href="#">资料库</a> 
					<a target="_blank" href="#">玩法说明</a> 
					<a target="_blank" href="#">奖金计算</a> 
				</div>
			</nav>
			
			<aside class="asideBox">

				<div class="eventTips">
					<em class="arrow"></em>
					<ul>
						<li class=""><a href="#" target="_blank">暴力鸟离队恒大能否7连冠?</a></li>
						<li><a href="#" target="_blank">法甲:摩纳哥主力流失仍可信</a></li>
						<li><a href="#" target="_blank">周日推荐:费雷拉主场抢分</a></li>
						<li><a href="#" target="_blank">西超杯推荐:梅西苏神不可挡</a></li>
						<li><a href="#" target="_blank">英超推荐:热刺后防有隐忧</a></li>
					</ul>
				</div>
				
				<div style="position: relative; z-index: 3;" class="floatBox">
					<div id="poolStep1" class="select">
						<h2>
							<i>1</i>
							选号明细
						</h2>
						<table>
							<colgroup>
								<col width="65">
								<col>
								<col width="30">
								<col>
							</colgroup>
							<thead>
								<tr>
								<th>场次</th>
								<th colspan="3">主队　VS　客队</th>
								</tr>
							</thead>
						</table>
						
						<div class="scrollMoni jspScrollable" style="overflow: hidden; padding: 0px; height: 138px; width: 240px;" tabindex="0">
							<div class="jspContainer" hidefocus="true" style="width: 240px; height: 138px;">
								<div class="jspPane" hidefocus="true" style="padding: 0px; top: 0px; width: 229px;">
									<table id="selectGamePool">
										<colgroup>
											<col width="65">
											<col>
											<col width="20">
											<col>
										</colgroup>
										<tbody>
											
										</tbody>
									</table>
								</div>
								<div class="jspVerticalBar">
									<div class="jspCap jspCapTop"></div>
									<div class="jspTrack" style="height: 138px;">
										<div class="jspDrag" style="height: 99px; top: 0px;">
											<div class="jspDragTop"></div>
											<div class="jspDragBottom"></div>
										</div>
									</div>
									<div class="jspCap jspCapBottom"></div>
								</div>
							</div>
						</div>
						<div class="unSeleTips">请在左侧列表选择投注比赛</div>
					</div>
					
					<div class="select" id="poolStep2">
						<h2><i>2</i>过关方式</h2>
						<div class="methodContent">
							 
								<ul class="guoguanList clearfix" methodtype="m_1">
									
									<li inf="猜中一场比赛就有奖" class="jtip"><i class="icoDx icoDx_active"></i>猜一场</li>
									
								</ul>
						<div class="unSeleTips" id="poolErrorTips">请在左侧列表选择投注比赛</div>
						</div>
					</div>
					<div class="select" id="poolStep3">
						<h2><i>3</i>确认投注</h2>
						
						<div class="qrtzBlock">
							<div class="dott">
								我要买
								<span class="addSubtract" id="betTimes">
									<a class="subtract" hidefocus="true" rel="nofollow" href="javascript:;"></a>
										<input style="ime-mode: disabled;" value="10" type="text">
									<a class="add" hidefocus="true" rel="nofollow" href="javascript:;"></a>
								</span>倍  
								<a href="javascript:void(0);" inf="系统自动配对后，为了更好地分配奖金  以达到最优效果，投注倍数最小为5倍，建议为10倍以上." class="jtip">最少5倍?</a>
							</div>

							<p>
								<a href="#" class="fr" id="btnclear">清空</a>
								您选择了： <strong id="gameNumber" class="c_f6c15a"> 0 </strong> 场比赛，
								共<strong id="gameZhu" class="c_f6c15a"> 0 </strong> 注
							</p>
							<p>总金额：<strong class="c_f6c15a totalMoney"><span id="totalMoney"> 0.00 </span>元</strong></p>
						
							<p><span id="bonusLabel">参考奖金：</span><strong class="c_f6c15a"><span id="maxbonus"> 0 </span>元</strong></p>
							<p><a href="#" id="openDetailBonus">奖金明细</a></p>
						
							<div class="tzBtnBox">
								<a class="tjfaBtn" href="javascript:;"></a>
							</div>
							<p>风险提示
								<i class="questionMark jtip" inf="•为避免投注退票风险，建议您尽早提交投注(大额订单建议赛前20分钟完成投注)&lt;br /&gt;•官方存在夜间停售时段变化赔率情况，夜间提交订单请，请以出票成功出票赔率为准。"></i>
							</p>
							<p class="orderRule">
								<label id="orderRule"><i class="icoFx icoFx_active"></i> 我已经阅读并同意</label>
								<a target="_blank" href="#">委托投注规则</a>
							</p>
							<input value="2013070515YX00602010" id="gameId" name="gameId" type="hidden"> 
						</div>
					</div>
					<div class="maskWrap" style="display:none;" id="tipMark"><div class="mask"></div></div>
				</div>

			</aside>
			
			<section class="bettingBox">
				<div class="selectBox">
					<div class="mcSelectBox" id="changeDate">
						<span style="display: none;" class="optionList">
								<a href="#">当前日期</a>
								<a href="#">2017-08-12</a>
								<a href="#">2017-08-11</a>
								<a href="#">2017-08-10</a>
								<a href="#">2017-08-09</a>
								<a href="#">2017-08-08</a>
								<a href="#">2017-08-07</a>
								<a href="#">2017-08-06</a>
								<a href="#">2017-08-05</a>
								<a href="#">2017-08-04</a>
						</span>
						<a class="imitateSelect" href="#">当前日期</a><em class="fgx"></em><em class="arrow"></em>

					</div>
					
					<label id="hotGame"><i class="icoFx"></i>热门赛事</label>
					<label id="stopGame"><i class="icoFx "></i>已截止(1)</label>
					<i class="fgx">|</i> <label id="chooseGame"><i class="icoFx"></i>已选择比赛</label>

				</div>
				
				<dl style="position: relative; z-index: 3; top: auto;" class="dataHead">
					<dd class="co1">场次</dd>
					<dd class="co2 attentionMenu">赛事<em class="arrow"></em>
						<div class="gameSeleList">
							<ul class="clearfix">
								<li leagueid="138" title="关注赛事将置顶显示"><i></i>J1联赛</li>
								<li leagueid="154" title="关注赛事将置顶显示"><i></i>韩K联</li>
								<li leagueid="16" title="关注赛事将置顶显示"><i></i>德国杯</li>
								<li leagueid="162" title="关注赛事将置顶显示"><i></i>墨联秋</li>
								<li leagueid="19" title="关注赛事将置顶显示"><i></i>意超级杯</li>
								<li leagueid="21" title="关注赛事将置顶显示"><i></i>英冠</li>
								<li leagueid="22" title="关注赛事将置顶显示"><i></i>英甲</li>
								<li leagueid="29" title="关注赛事将置顶显示"><i></i>西超级杯</li>
								<li leagueid="30" title="关注赛事将置顶显示"><i></i>葡超</li>
								<li leagueid="33" title="关注赛事将置顶显示"><i></i>比甲</li>
								<li leagueid="34" title="关注赛事将置顶显示"><i></i>瑞典超</li>
								<li leagueid="35" title="关注赛事将置顶显示"><i></i>挪超</li>
								<li leagueid="4" title="关注赛事将置顶显示"><i></i>英超</li>
								<li leagueid="5" title="关注赛事将置顶显示"><i></i>法甲</li>
								<li leagueid="5434" title="关注赛事将置顶显示"><i></i>智利甲</li>
								<li leagueid="55" title="关注赛事将置顶显示"><i></i>俄超</li>
								<li leagueid="56" title="关注赛事将置顶显示"><i></i>巴甲</li>
								<li leagueid="6" title="关注赛事将置顶显示"><i></i>荷甲</li>
								<li leagueid="70" title="关注赛事将置顶显示"><i></i>法乙</li>
							</ul>
							<i class="fuzhu"></i>
							<div class="btnBox">
								<label><i class="isSave icoFx icoFx_active"></i>记住我关注的赛事</label>
								<a href="javascript:;" class="makeSure">确定</a>
							</div>
						</div>
					</dd>
					
					<dd class="co3" id="changeTime">
						<a href="#" class="imitateSelect">代购截止</a><em class="arrow"></em>
						<div class="optionList">
							<a href="#1">开赛时间</a> <a href="#2">代购截止</a>
						</div>
					</dd>
					
					<dd class="co4">[排名]主队 　 　 客队[排名]</dd>
					
					<dd class="co6">
						<span>投注区</span>
						<span class="btnBox1"><em>主胜</em><em>平</em><em class="lastOne">主负</em></span>
					</dd>
					
					<dd class="co7" id="betAn">
						<span>
							<a class="imitateSelect" href="#">指数分析</a>
							<em class="arrow"></em>
							<div style="display: none;" class="optionList"> 
								<a class="iSelectHover" href="#3">指数分析</a> 
							</div>
						</span>
						<span class="line2"><em>主胜</em><em>平</em><em class="lastOne">主负</em></span>
					</dd>
					
					<dd class="co8">分析</dd>
				</dl>

				<div style="height: 60px; width: 750px; display: none;"></div>
				
				<div class="gameSelect">
					<div class="dataBody  attentionOuter">            
						<div class="attentionInner" style="display:none">
							<div class="attentionTit">我关注的赛事 (0场比赛)</div>
						</div>
					</div>
					
					<div class="dataBody  unAttention">
						<dl gamedate="20170813">
							<dt>2017-08-13　周日12:00 -- 周一12:00　
								<span class="matchSize">56</span> 场比赛可投注
								<span class="cuspText">隐藏<i class="cusp"></i></span>
							</dt>

							<dd isstop="0" matchcode="201708137025" matchnumcn="周日025" starttime="1502636400000" endtime="1502636280000"
								isattention="0" isdg="0,1,1,1,0" hostname="曼联" guestname="西汉姆联" leagueid="4"
								hostteamid="52" visitteamid="98" matchid="1306228" leaguename="英超"
								class="league_4  even" ishot="1" score="-2">
								
								<span class="co1"><i class="jtip" inf="周日025">025</i></span>
								<span class="co2" style="background:#FF1717">
									<a href="#league/4.html?mid=1306228" target="_blank">英超</a>
								</span>
								<span class="co3 gameTime">
									<i class="jtip" inf="截止时间：2017-08-13 22:58&lt;br/&gt;开赛时间：2017-08-13 23:00">22:58</i>
								</span>

								<span class="co4">
									<a href="#match.html?mId=1306228&amp;hId=52&amp;vId=98" target="_blank" class="c_ffca6e">
										<em class="hostTeam" title="曼联"><i class="c_939393">[13]</i><b>曼联</b></em>
										
										<em class="guestTeam" title="西汉姆联"><b>西汉姆联</b><i class="c_939393">[19]</i></em>
									</a>
								</span>

								<span class="co6 btnBox ">
									<div class="line1">
										<em index="0" gametype="spf" sp="1.17">1.17<i class="c_090">↓</i></em>
										<em index="1" gametype="spf" sp="5.25">5.25<i class="c_e24949">↑</i></em>
										<em index="2" gametype="spf" sp="12.00" class="lastOne">12.00<i class="c_e24949">↑</i></em>
									</div>
								</span>
								
								<span class="co7 towLine">
									
									<div class="line1 odds">
										<em aa="0" gametype="spf" index="0" sp="1.17"><a href="javascript:;" class="maxNum">0.00</a></em>
										<em aa="0" gametype="spf" index="1" sp="5.25"><a href="javascript:;" class="maxNum">0.00</a></em>
										<em aa="0" gametype="spf" index="2" sp="12.00"><a href="javascript:;" class="maxNum">0.00</a></em> 
									</div>
									
								</span>
								<span class="co8">
									<a href="javascript:;" class="ico_square moreData">简</a>
									<a href="#" target="_blank" class="ico_square">析</a>
								</span>
					
							</dd>


							<dd isstop="0" matchcode="201708137057" matchnumcn="周日057" starttime="1502643600000" endtime="1502643420000"
								isattention="0" isdg="0,1,1,1,0" hostname="泽尼特" guestname="格罗兹尼" leagueid="55"
								hostteamid="11065" visitteamid="13506" matchid="1309208" leaguename="俄超"
								class="league_55  even" ishot="0" score="-1">
							
								<span class="co1">
									<i class="jtip" inf="周日057">057</i>
								</span>
								
								<span class="co2" style="background:#9773e5">
									<a href="#" target="_blank">俄超</a>
								</span>
								
								<span class="co3 gameTime">
									<i class="jtip" inf="截止时间：2017-08-14 00:57&lt;br/&gt;开赛时间：2017-08-14 01:00">00:57</i>
								</span>

								<span class="co4">
									<a href="#13506" target="_blank">
										<em class="hostTeam" title="泽尼特"><i class="c_939393">[1]</i><b>泽尼特</b></em>
										
										<em class="guestTeam" title="格罗兹尼"><b>格罗兹尼</b><i class="c_939393">[6]</i></em>
									</a>
								</span>

								<span class="co6 btnBox ">
									<div class="line1">
										<em index="0" gametype="spf" sp="1.34">1.34<i class="c_e24949">↑</i></em>
										<em class="" index="1" gametype="spf" sp="4.20">4.20</em>
										<em index="2" gametype="spf" sp="6.90" class="lastOne">6.90<i class="c_090">↓</i></em>
									</div>
								</span>
								
								<span class="co7 towLine">
									
									<div class="line1 odds">
										<em aa="7.2" gametype="spf" index="0" sp="1.34"><a href="javascript:;">1.441</a></em>
										<em class="" aa="7.2" gametype="spf" index="1" sp="4.20"><a href="javascript:;">4.068</a></em>
										<em aa="7.2" gametype="spf" index="2" sp="6.90"><a href="javascript:;">7.2</a></em>
									</div>
									
								</span>
								
								<span class="co8">
									<a href="javascript:;" class="ico_square moreData">简</a>
									<a href="#" target="_blank" class="ico_square">析</a>
								</span>
							</dd>
						</dl>
						
						<dl gamedate="20170814">
							<dt>2017-08-14　周一12:00 -- 周二12:00　
								<span class="matchSize">11</span> 场比赛可投注
								<span class="cuspText">隐藏<i class="cusp"></i></span>
							</dt>

							<dd isstop="0" matchcode="201708141002" matchnumcn="周一002" starttime="1502729100000" endtime="1502726220000"
								isattention="0" isdg="0,1,1,1,0" hostname="洛里昂" guestname="沙托鲁" leagueid="70"
								hostteamid="1385" visitteamid="3625" matchid="1307406" leaguename="法乙"
								class="league_70  even" ishot="1" score="-1">    
								
								<span class="co1">
									<i class="jtip" inf="周一002">002</i>
								</span>
								<span class="co2" style="background:#ACA96C">
									<a href="#307406" target="_blank">法乙</a>
								</span>
								<span class="co3 gameTime">
									<i class="jtip" inf="截止时间：2017-08-14 23:57&lt;br/&gt;开赛时间：2017-08-15 00:45">23:57</i>
								</span>

								<span class="co4">
									<a href="#" target="_blank" class="c_ffca6e">
									<em class="hostTeam" title="洛里昂"><i class="c_939393">[12]</i><b>洛里昂</b></em>
									
									<em class="guestTeam" title="沙托鲁"><b>沙托鲁</b><i class="c_939393">[8]</i></em>
									</a>
								</span>

								<span class="co6 btnBox ">
									<div class="line1">
										<em index="0" gametype="spf" sp="1.57">1.57</em>
										<em index="1" gametype="spf" sp="3.25">3.25</em>
										<em index="2" gametype="spf" sp="5.45" class="lastOne">5.45</em>
									</div>
								</span>
								
								<span class="co7 towLine">
									<div class="line1 odds">
										<em aa="5.091" gametype="spf" index="0" sp="1.57"><a href="javascript:;">1.663</a></em>
										<em aa="5.091" gametype="spf" index="1" sp="3.25"><a href="javascript:;">3.48</a></em>
										<em aa="5.091" gametype="spf" index="2" sp="5.45"><a href="javascript:;">5.091</a></em> 
									</div>
								</span>
								
								<span class="co8"><a href="javascript:;" class="ico_square moreData">简</a>
									<a href="#" target="_blank" class="ico_square">析</a>
								</span>
							</dd>

						</dl>
			
					</div>
				</div>
				
				<div class="tzTips">
					<h2>投注提示</h2>
					<span class="cuspText">隐藏<i class="cusp"></i></span>
					<ul class="betTips">
						<li><em>1、</em>猜一场：用户在竞彩足球胜平负过关游戏中只需选择一场比赛，系统会自动选择另一场比赛进行配对，组成竞彩足球“2串1”投注方案。再也不必为多场比赛而发愁。一场命中，就能盈利！</li>
						<li><em>2、</em>配对原则： 系统会选择时间距离用户所选比赛最近的，且总体赔付率最高的比赛”进行配对。保证您第一时间获得最高的奖金回报。</li>
						<li><em>3、</em>让球符号含义，"+"为客让主，"-"为主让客。让球数含义，即（主队得分±让球数）减客队得分，大于0为胜，等于0为平，小于0为负。</li>
						<li><em>4、</em>竞彩足球的官方销售时间为：周一至周五09:00-00:00，周六至周日09:00-01:00。</li>
						<li><em>5、</em>竞彩足球彩果，以比赛90分钟内比分（含伤停补时）结果为准。其中投注赛事取消、中断或改期，官方比赛彩果公布或确认取消将延后36小时，对应场次奖金派发或退款将同步延后处理；取消比赛的任何结果都算对，固定奖金按照1计算。2场过关投注，单注最高奖金限额为20万元；</li>
					</ul>
				</div>
			</section>
			
			
		</section>
	</article>
</div>

<div class="guideList">
    <ul>
        <li class="howGet" data-ctype="howGet"><a href="javascript:;"><i></i>如何兑奖</a></li>
        <li class="howCal" data-ctype="howCal"><a href="javascript:;"><i></i>如何算奖</a></li>
        <li class="gameIntr last" data-ctype="gameIntr"><a href="javascript:;"><i></i>玩法说明</a></li>
    </ul>
</div>


<script>Core && Core.fastInit && Core.fastInit("1");</script>
<script src="js/ntes.js"></script>
<script>try{_ntes_nacc=window.top===window.self?"caipiao":"cpiframe";neteaseTracker();neteaseClickStat();}catch(e){}</script>


<%@ include file="bottom.jsp" %>