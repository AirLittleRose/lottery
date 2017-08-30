<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="css/analyTab.css">
<link rel="stylesheet" href="css/jczqGray_V1.css">




<script type="text/javascript" src="js/soccer.js"></script>
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
				<div class="moreLinks">
					<a target="_blank" href="#">最新开奖</a>
					<a target="_blank" href="#">资料库</a> 
					<a target="_blank" href="#">玩法说明</a> 
					<a target="_blank" href="#">奖金计算</a> 
				</div>
			</nav>
			
			<aside class="asideBox">

				
				
				<div style="position: relative; z-index: 3;" class="floatBox">
					<div id="poolStep1" class="select_1">
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
					
					<div class="select_1" id="poolStep2">
						<h2><i>2</i>过关方式</h2>
						<div class="methodContent">
							 
								<ul class="guoguanList clearfix" methodtype="m_1">
									
									<li inf="猜中一场比赛就有奖" class="jtip"><i class="icoDx icoDx_active"></i>猜一场</li>
									
								</ul>
						<div class="unSeleTips" id="poolErrorTips">请在左侧列表选择投注比赛</div>
						</div>
					</div>
					<div class="select_1" id="poolStep3">
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
					<label id="stopGame"><i class="icoFx "></i>已截止(1)</label>
				</div>
				
				<dl style="position: relative; z-index: 3; top: auto;" class="dataHead">
					<dd class="co1">场次</dd>
					<dd class="co2 attentionMenu" onclick="show_leagues()">赛事
						<em class="arrow"></em>
						<div class="gameSeleList">
							<ul class="clearfix" id="leagueUl">
								
							</ul>
							<i class="fuzhu"></i>
							<div class="btnBox">
								<a href="javascript:;" onclick=doChose()>确定</a>
							</div>
						</div>
					</dd>
					
					<dd class="co3" id="changeTime">
						<a href="javascript:void(0)" class="imitateSelect">代购截止</a>
					</dd>
					
					<dd class="co4">主队 　    	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 　 客队</dd>
					
					<dd class="co6">
						<span>投注区</span>
						<span class="btnBox1"><em>主胜</em><em>平</em><em class="lastOne">主负</em></span>
					</dd>
					

				</dl>

				<div style="height: 60px; width: 750px; display: none;"></div>
				
				<div class="gameSelect">
					<div class="dataBody  attentionOuter">            
						<div class="attentionInner" style="display:none">
							<div class="attentionTit">我关注的赛事 (0场比赛)</div>
						</div>
					</div>
					
					<div class="dataBody  unAttention">
						<dl id="gamesInfo">
							
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