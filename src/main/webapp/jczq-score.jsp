<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>
<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/core.css">
<link rel="stylesheet" href="css/analyTab.css">
<link rel="stylesheet" href="css/jczqGray_V1.css">
<link rel="stylesheet" href="css/soccer.css">

<div class="wrapper">

	<script>
		window.Game && window.Game.config
				&& (window.Game.config.gameEn = "jczq_mix_p");
		window.Core && window.Core.config
				&& (window.Core.config.maxBetTimes = "500000");
		window.Core && window.Core.config && (window.Core.config.bgConfig = {});
		window.Core && window.Core.config
				&& (window.Core.config.isNewUser = "");
		window.Core && window.Core.config
				&& (window.Core.config.currentTheme = "gray");
	</script>

	<article class="docBody clearfix" id="docBody">
		<header class="game_header ">
			<div class="headerBox clearfix">
				<span class="cz_logo cz_jczq"></span>
				<h1>
					<a href="#">竞彩足球</a>
				</h1>
				<span class="text"><i>提示：投注为全场90分钟（含伤停补时）的比分结果，不含加时赛及点球结果</i></span>
			</div>
			<ul class="gameMenu clearfix">
				<li><a href="soccer.jsp" hidefocus="true">混合投注</a></li>
				<li class="J_dggd active"><a href="jczq-score.jsp" hidefocus="true">足球比分</a></li>
			</ul>
			<div class="headerBg"></div>
		</header>

		<section class="main spfDcjs onlySpf clearfix onlyOdds">
			<nav class="betNav">
				<div class="moreLinks">
					<a target="_blank" href="#">最新开奖</a> <a target="_blank" href="#">资料库</a> <a target="_blank" href="#">玩法说明</a> <a target="_blank" href="#">奖金计算</a>
				</div>
			</nav>
			
			<iframe src='http://data.nowscore.com/free.htm' width='100%' height='500' frameborder="0"></iframe>
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

<%@ include file="bottom.jsp"%>