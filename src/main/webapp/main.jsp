<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>

<script>if(window.top != window.self)window.top.location.href = window.location.href;</script>

<article class="docBody clearfix">
	<section class="siderBox">
		<div id="games">
			<div id="lotteryLists" style="display: block;">
				<div class="lotteryListWraps">
					<ul>
						<li class="zyGame">
							<a gid="jczq" href="toSoccer.action">
								<em class="cz_logo35 logo35_jczq"></em>
								<strong>竞彩足球</strong>
								<span class="grayWords">比你想的容易中</span>
							</a>
						</li>
						<li class="zyGame">
							<a gid="ssq" href="ssq.jsp">
								<em class="cz_logo35 logo35_ssq"></em>
								<strong>双色球</strong>
								<span class="grayWords">心动</span>
								<span class="redWords"><i class="arrowsIcon"></i>中2亿</span>
							</a>
						</li>
						<li style="border: 0px none;" class="zyGame "></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="analysisTool">
			<h2 class="grayTitle"><a href="#" target="_blank">彩票走势图</a></h2>
			<dl class="chartList clearfix">
				<dt><a href="#" target="_blank">彩票走势图</a></dt>
			</dl>
		</div>
		
		<div id="rankingList">
			<dl class="grayTitle clearfix" id="ranksTab">
				<dd rel="#ownerRanks" class="active">扩展1</dd>
			</dl>
			<div class="ranking_con">
				<table class="ranking_table" id="ownerRanks">
					<colgroup>
						<col width="">
						<col width="35%">
						<col width="35%">
						<col width="15%">
					</colgroup>
					<tbody>
						<tr>
							<th></th>
							<th>用户名</th>
							<th class="t_r">中奖金额</th>
							<th>跟单</th>
						</tr>
						
						<tr bgcolor="f7f7f7">
							<td>
								<span class="xh_top">
								1
								</span>
							</td>
							<td>
								<span class="nickNames">
									<a target="_blank" href="#用户1" rel="nofollow">用户1</a>
								</span>
							</td>
							<td class="t_r">5722万元</td>
							<td>
								<a class="dingzhi" href="#去投注" target="_blank" rel="nofollow">去投注</a>
							</td>
						</tr>
						
						
						<tr>
							<td>
								<span class="xh_top">
								2
								</span>
							</td>
							<td>
								<span class="nickNames">
									<a target="_blank" href="#用户2" rel="nofollow">用户2</a>
								</span>
							</td>
							<td class="t_r">3650万元</td>
							<td>
								<a class="dingzhi" href="#去投注" target="_blank" rel="nofollow">去投注</a>
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
		</div>
		
	</section>

	<section class="maincontent">
		
		<div id="promotion">
			<div class="clearfix">
			
				<div class="awardBox">
					<div class="js-other">
						<div class="awardDetail">开奖提醒：
							<a href="ssq.jsp" style="margin:0" target="_blank">
								<strong class="gameEn"> 双色球 </strong>
							</a> 
							第<strong class="c_ba2636"> 2017091 </strong>期 			
								<em class="smallRedball">05</em>
								<em class="smallRedball">07</em>
								<em class="smallRedball">10</em>
								<em class="smallRedball">23</em>
								<em class="smallRedball">28</em>
								<em class="smallRedball">29</em>
								<em class="smallBlueball">03</em>&nbsp;
							<span class="awardtime"> 08-06 (周日) 21:15</span>&nbsp;
							<a target="_blank" href="#开奖详情(扩展)">详情</a>
							<i>|</i>
							<a target="_blank" href="#">走势</a>
						</div>
						<div class="buylinks">
							<a class="awardBox_Btn" target="_blank" href="#">立即购买</a>
						</div>
					</div>
				</div>
				
				
				<div class="promotion_picture" id="cpIndexAdBox" style="overflow: hidden; width: 510px;">  图片轮换
					<ul class="adList" style="width: 7650px; margin-left: -3570px;">
						<li class="clone" style="float: left;">
						<a href="#" ii="1" target="_blank">
							<img src="images/1493982455065_1.jpg" alt="彩票" title="彩票">
						</a>
						</li>
						<li class="clone" style="float: left;">
							<a href="#" ii="2" target="_blank">
								<img src="images/1493982455065_1.jpg" alt="贵金属" title="贵金属">
							</a>
						</li>
						<li class="clone" style="float: left;">
							<a href="#" ii="3" target="_blank">
								<img src="images/1493982455065_1.jpg" alt="网易考拉" title="网易考拉">
							</a>
						</li>
						<li class="clone" style="float: left;">
							<a href="#" ii="4" target="_blank">
								<img src="images/1493982455065_1.jpg" alt="立马理财" title="立马理财">
							</a>
						</li>
						<li class="clone" style="float: left;">
							<a href="#" ii="5" target="_blank">
								<img src="images/1493982455065_1.jpg" alt="新闻" title="新闻">
							</a>
						</li>
					</ul>
					<!-- 
					#cpIndexAdBox .ctrol{
						background: rgba(110, 110, 110, 0.3) none repeat scroll 0 0;
						border-radius: 10px;
						bottom: 5px;
						display: block;
						float: left;
						height: 24px;
						padding-left: 3px;
						position: absolute;
						right: 5px;
						width: auto;
						z-index: 2;
					}
					-->
					<div class="ctrol">
						<a class="" target="_blank" ii="1" title="彩票" href="#">1</a>
						<a class="" target="_blank" ii="2" title="贵金属" href="#">2</a>
						<a class="" target="_blank" ii="3" title="网易考拉" href="#">3</a>
						<a class="active" target="_blank" ii="4" title="立马理财" href="#">4</a>
						<a class="" target="_blank" ii="5" title="新闻" href="#">5</a>
					</div>
				</div>
				<script>window.Core && window.Core.loadIndexAD && window.Core.loadIndexAD();</script>
				
				<div class="promotionText">
					<ul class="grayTitle" id="topInfoTab">
						<li class="" rel="#topForecast">彩票资讯</li>
					</ul>
					
					<div class="promotion_con" id="topForecast" style="display: block;">
						<ul class="promotion_list">
							<li>·<a href="#" target="_blank" title="资讯标题1">资讯标题1</a></li>
							<li>·<a href="#" target="_blank" title="资讯标题2">资讯标题2</a></li>
						</ul>
					</div>
					
					<p class="helplinks">
						<a href="#帮助" target="_blank">新手入门</a>
						<a href="#" target="_blank">安全保障</a>
						<a href="#" target="_blank">领奖指南</a>
					</p>
				</div>
			</div>
		</div>
		<!-- 一元购模块 -->

		<div id="quickbuyBox">

			<div class="quickbuy_title">
				<h2><a href="#">购买彩票</a></h2>
				<span class="accruingAmounts"> 本站累计中奖：
					<strong>
						<em data-number="1">1</em>
						<em data-number="0">0</em>
						<em data-number="0">0</em>亿
						
						<em data-number="2">2</em>
						<em data-number="8">8</em>
						<em data-number="9">9</em>
						<em data-number="6">6</em>万元
					</strong>
				</span>
			</div>
			
			<div class="quickbuy_con clearfix">
				<div class="bettingBox4">
					<div class="bet_title">
					
					<ul class="quickbuy_menu" id="quickBetTab">
						<li rel="#quickBetSSQ" class="active"><a href="ssq.jsp">双色球</a></li>
					</ul>
					<p style="display: none;" class="popularize" id="advertShuzi">
						<a target="_blank" href="ssq.jsp"></a>
					</p>
					</div>
					<dl class="szcBet_con">
					
						<dd style="display: block;" class="clearfix" id="quickBetSSQ">
							<div class="buyLottery quickbuy_ssq" style="display:block" guid="1">
								<div class="buyBody">
									<form action="#买双色球" method="post" target="_self">
										<div class="czTitle clearfix">
											<h2 class="czLogo icon_ssq"><a href="ssq.jsp"></a></h2>
											<div class="czTimes">
												<p class="periods"><a href="ssq.jsp"><strong>双色球</strong>&nbsp;&nbsp;第<em>
												2017092
												</em>期</a> <span class="awardtoday"><i></i>今日开奖</span></p>
												<p class="totalPool">奖池：<strong>795,913,308元</strong></p>
												<p class="endtime"><span class="retime" rel="12,826,301"><em>03</em>小时<em>33</em>分<em>07</em>秒</span>后截止</p>
											</div>
										</div>
										  
										<div class="czContent clearfix">
											<div class="inputBox">
												<div class="inputTip clearfix">
													<p class="redtip">红球：从<strong class="c_ba2326">1-33</strong>中选<strong>6</strong>个不重复的整数<i></i></p>
													<p class="bluetip">蓝球：从<strong class="c_1e50a2">1-16</strong>中选<strong>1</strong>个不重复的整数<i></i></p>
												</div>
												
												<div class="inputArea">
													<input class="redball" maxlength="2" max="33">
													<input class="redball" maxlength="2" max="33">
													<input class="redball" maxlength="2" max="33">
													<input class="redball" maxlength="2" max="33">
													<input class="redball" maxlength="2" max="33">
													<input class="redball" maxlength="2" max="33">
													<input class="blueball" maxlength="2" max="16">
												</div>
											</div>
											<div class="btnBox2 clearfix">
												<span class="submitbox">
													<button class="btnSubmint" title="立即投注" type="submit"></button>
												</span>
												<span class="toolbox">
													<input class="btnRandom" value="换一注" type="button">								  
												</span>
											</div>
											<p class="intr_foot" game_en="ssq" style="float: left;">
												每注<strong class="c_ba2636">2元</strong>，
												最高可中<strong class="c_ba2636">1000万</strong>
											</p>
										</div>
										  
										  <input name="gameId" value="2010032416YX00000001" type="hidden"/>
										  <input name="betTimes" value="1" type="hidden"/>
										  <input name="activityType" value="16" type="hidden"/>
										  <input name="stakeNumber" type="hidden"/>
										  <input value="5" name="followBuyPeriods" type="hidden"/>
									</form>
								</div>
								<div class="timeout">
									<div class="leftImg"></div>
									<div class="rightTips">
									  <p class="timeoutTitle">本期投注已截止</p>
									  <p>第<span class="c_ba2326"> 2017093 </span>期投注将于：<span class="c_ba2326"> 2017-8-8 20:00:00 </span>开始</p>
									</div>
								</div>
							</div>
						
						</dd>
					</dl>
				
					<div class="bet_title">
						<ul id="quickBetJJTab" class="quickbuy_menu">
							<li class="active" rel="#quickBetSPF">
								<a href="#">竞彩足球</a>
							</li>
						</ul>
					</div>
					<dl class="jjcBet_con">
						<dd id="quickBetSPF">
							<div class="clearfix">
								<h3 class="czLogo icon_jczq">
									<a title="" href="#"></a>
								</h3>
								<div class="jjc_main">
									<p class="jjc_title">
										<a href="#">
											<strong>竞彩足球</strong>
											  当前
											<strong> 94 </strong>
											场销售中
										</a>
									</p>
									<p class="jjc_con">
										<a href="#">
											<span class="teamlist">
												<span class="leagueName">法乙</span>
												<em class="teamName">瓦朗谢纳</em>
												<i class="icon_vs"></i>
												<em class="teamName">克莱蒙</em>
											</span>
											<span class="teamlist">
												<span class="leagueName">比甲</span>
												<em class="teamName">瓦雷赫姆</em>
												<i class="icon_vs"></i>
												<em class="teamName">布鲁日</em>
											</span>
										</a>
									</p>
								</div>
								<div class="jjc_betBtn">
									<a class="btnSubmint" title="立即投注" href="#"></a>
								</div>
							</div>
						</dd>
					</dl>
				</div>
				<div class="betinfoBox3">
					<h3><strong>大奖直播室</strong><a href="#" target="_blank">试试手气</a></h3>
					<ul class="betinfo_list">
						<li class="clearfix first">
							<a href="#" target="_blank">
								<img src="images/2015010111TT70187513.jpg" alt="" class="betinfo_img"/>
								<span class="betinfo_text">
									<strong>2亿!史上最大奖</strong>最牛双色球大奖花落网易!易友擒48注双色球头奖!
								</span>
							</a>
						</li>
						<li class="clearfix">·<a href="#" target="_blank">小伙儿刚入福地便中658万大乐透</a></li>
						<li class="clearfix">·<a href="#" target="_blank">90帅哥摇一摇豪取633万双色球</a></li>
						<li class="clearfix">·<a href="#" target="_blank">美女教师守号6年终揽1941万</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="advertCenter" style="clear:both">
		</div>
	</section>
</article>

<%@ include file="bottom.jsp" %>