!function(e, t, i, n, a, o) {
	if ("5" == t.getUrlPara("orderType")) {
		e.location.replace("/order/ssq/jixuan.html" + e.location.search);
		return
	}
	var r = n.alert, s = n.confirm, l = n.ssq.core;
	t
			.extend(
					i,
					{
						config : {
							zhuihaoAjax : "/bet/queryBetType_newfollowBuy.html?gameId={gameId}",
							hemaiAjax : "/bet/queryBetType_newgroupBuy.html?gameId={gameId}",
							numAjax : "/bet/queryBetType_getnumStatistic.html?gameEn=ssq&periodNum={0}",
							maxRedNum : l.maxRedNum || 20
						},
						quickInit : function() {
							t.each(this.config, function(e, t) {
								if ("string" == typeof t)
									i.config[e] = t.replace(/\{gameId\}/g,
											n.config.gameId)
							});
							t(document)
									.delegate(
											'#login_pswUrl,#login_reg,.goOld,[href*="/ssq/danshi.html"],.thirdPartyLoginBtn',
											"mousedown", function() {
												i.saveData2LS()
											});
							this.initMainTab().betTimerInit()
									.groupbuyTimerInit().numberStatInit()
									.betAreaInit().betPoolInit()
									.dantuoAreaInit().dingDanShaHaoAreaInit()
									.betButtonInit().buyButtonInit()
									.initBuyTab();
							n.checkGamePause("ssq");
							this.betTimer.start(this.betTimer.initTime
									- n.COMS.PT.Timer.getPageRunTime());
							this.bindModule({
								"loadPoolFav savePoolFav" : {
									css : "css2/lotteryBet/collect.css",
									js : "js2/game/fav/poolFav.js"
								}
							});
							i.gameAct
									.is(
											"zhuihaoTip",
											"iconZhuihaoTip",
											function(e) {
												e
														&& t("#zhuihaoTab")
																.prepend(
																		'<span class="iconZhuihaoTip"></span>')
											});
							i
									.bindModule({
										newbieGuideInit : {
											js : [ "js2/guide.js",
													"js2/activity/ssqNewbieGuide201312/ssqNewbieGuide201312.js" ],
											css : "css2/activity/ssqNewbieGuide201312/ssqNewbieGuide201312.css"
										}
									});
							if ("true" === t.hash("xinshou").trim()
									&& !t.cookie("ssqNewbieGuide"))
								i.newbieGuideInit(this.betArea, this.betPool);
							i.bindModule({
								resolveGuideNavClick : {
									js : [ "js2/lottery/ssq/guideNav.js" ]
								}
							});
							t(".guideNavBox").delegate("a", "click",
									function() {
										i.resolveGuideNavClick(this);
										return false
									});
							new i.CompareHistory(t(".selected_history a"),
									"ssq", "双色球", t.proxy(i.betPool.serialize,
											i.betPool), t.proxy(
											i.betPool.random, i.betPool))
						},
						myInit : function() {
							this.luckyBuyInit();
							var n = e
									.setTimeout(
											function() {
												t(".selected_btnbox")
														.append(
																'<i class="randomImgTip">试试手气，随机选一注</i>')
														.find(".randomImgTip")
														.one(
																"click",
																function() {
																	i.betPool
																			.random(1)
																})
											}, 6e4);
							this.betPool.onChange(function() {
								e.clearTimeout(n);
								t(".randomImgTip").remove()
							});
							this.initShotEnter();
							!new function() {
								var e = t.getPara("bet"), n = e
										.match(/^([\s\d]*)[\:]?([\s\d]*)$/), a = n
										&& n[1], o = n && n[2];
								if (n) {
									a = a.split(/\s+/);
									o = o.split(/\s+/)
								}
								i.betArea.push("red", a);
								i.betArea.push("blue", o)
							};
							!new function() {
								var e = t.getPara("bet_random");
								if ("1" == e) {
									i.betArea.random("red", 6);
									i.betArea.random("blue", 1)
								}
							};
							var a = i.jfb || {}, o = a.showTip, r = a.rel, s = a.ygtime;
							if ("1" == o) {
								t(".betBtnBox > .betBtns").prepend(
										"<i class='getJfb'></i>");
								t(".betBtnBox > .betBtns")
										.prepend(
												"<a href="
														+ r
														+ " class='aHref' target='_balank'></a>");
								t(".aHref").click(function() {
									t(".getJfb").hide();
									t(".aHref").hide();
									t(".betting_Btn").trigger("click")
								})
							}
						},
						initShotEnter : function() {
							this.betPool.beiNumber
									.set(+this.config.quickBetTimes || 1);
							this.betPool.periodNumber
									.set(+this.config.quickBetPeriods || 1);
							this.loadLSData(true);
							if (this.initData)
								this.scrollWhenNeed(".bettingBox_ssq");
							var e = (this.config.orderType
									|| t.getPara("buyType") || t
									.getPara("orderType")).replace(/\D/g, ""), i = this.helper.gameType, n = false, a = this.config;
							t.each(this.initGroupData || {}, function(e, t) {
								if (t)
									n = true
							});
							e = "2" != e && n ? "3" : e;
							if (("2" == e || "3" == e) && (2 == i || 3 == i)) {
								this.helper.setBuyType(+e, true);
								this.scrollWhenNeed([ ".ballarea",
										".dantuo_com" ][i - 2])
							}
							var o = +(t.getPara("random").replace(/\D/g, "") || 0);
							if (o > 0 && !this.initData)
								this.betPool.random(Math.min(o, 99));
							this.activityType = t.getUrlPara("activityType")
									.replace(/\D/g, "") || 24;
							if ("yes" == t.getPara("goodnum")) {
								var r = l.random("", 1)[0];
								this.betArea.push("red", r[0]).push("blue",
										r[1])
							}
							if (a.followMode)
								this.betPool.addactionalBet.setMode(
										a.followMode, a.stopAwardAmount);
							delete this.initShotEnter
						},
						giveFocus : function(e) {
							if (t(e)[0])
								try {
									var i, n = jQuery(e)[0], a = jQuery(n).is(
											"input:text,textarea") ? jQuery(n)
											.attr("readonly") ? false : n
											.createTextRange() ? true : false
											: false;
									if (a) {
										i = n.createTextRange();
										i
												.moveStart("character",
														n.value.length);
										i.collapse(true);
										i.select()
									}
								} catch (n) {
									t(e)[0].focus();
									return true
								}
						},
						helper : {
							gameType : 1,
							buyType : 1
						},
						initMainTab : function() {
							var e = t(".gameMenu_ssq"), n = t("#docBody"), a = t("#mainPanels"), o = t(".navList"), r, s = function() {
								var t = i.helper.gameType;
								e.find(".active").removeClass("active");
								switch (t) {
								case 1:
								case 6:
									if (1 == t) {
										n[0].className = "docBody clearfix kuaijie";
										e.find("li:first").addClass("active");
										a.find(">div").addClass("hide").eq(0)
												.removeClass("hide");
										i.betArea.onChange()
									} else if (6 == t) {
										n[0].className = "docBody clearfix luckyBuy";
										e.find("li:eq(2)").addClass("active");
										a.find(">div").addClass("hide").eq(3)
												.removeClass("hide");
										i.luckyBuy && i.luckyBuy.onChange()
									}
									break;
								case 2:
									r = i.betArea.onChange();
								case 3:
									r = i.dantuoArea.onChange();
								case 4:
									r = i.dingDanShaHaoArea.onChange();
								case 5:
									n[0].className = 4 === t ? "docBody kill clearfix"
											: "docBody clearfix putong";
									e.find("li:eq(1)").addClass("active");
									a.find(">div").addClass("hide").eq(t - 2)
											.removeClass("hide");
									o.find(".active").removeClass().end().find(
											"li:eq(" + (t - 2) + ")").addClass(
											"active");
									r && r.onChange();
									i.helper.syncBuyType(true)
								}
								i.updateBetCountInfo()
							}, l = function() {
								var t = e.find(".active").attr("rel");
								if ("2" == t)
									t = o.find(".active").attr("rel") || 2;
								return i.helper.gameType = +t
							};
							e.delegate("li", "click focusin", function(e) {
								var n = (t(this).attr("rel") || "").replace(
										/\D/g, "");
								if (n) {
									if ("2" == n)
										n = o.find(".active").attr("rel") || 2;
									i.helper.setGameType(+n);
									e.preventDefault()
								}
							});
							o.delegate("li", "click focusin", function(e) {
								var n = (t(this).attr("rel") || "").replace(
										/\D/g, "");
								if (n) {
									i.helper.setGameType(+n);
									e.preventDefault()
								}
							});
							this.helper.syncGameType = s;
							this.helper.readGameType = l;
							this.helper.setGameType = function(e) {
								this.gameType = +(e || 1);
								this.syncGameType()
							};
							l();
							delete this.initMainTab;
							return this
						},
						initBuyTab : function() {
							var e = t("#moreOperateBox"), i = e.find(".tips"), n = t(".moreOperate_con>div"), a = this, o = t(".betresult"), r = function(
									r) {
								var s = a.helper.buyType, l = e.find("dd[rel="
										+ s + "]"), u = l.attr("info"), c = l
										.attr("pnl");
								n.addClass("hide");
								c && t("#" + c).removeClass("hide");
								i.html(u);
								switch (s) {
								case 1:
									a.updateBetCountInfo();
									break;
								case 2:
									a.loadHtmlAndInit(c, a.config.zhuihaoAjax,
											a.mulitiBuyInit,
											a.updateBetCountInfo);
									r || a.scrollWhenNeed("#select_list_box");
									break;
								case 3:
									a.loadHtmlAndInit(c, a.config.hemaiAjax,
											a.groupBuyInit,
											a.updateBetCountInfo);
									r || a.scrollWhenNeed("#select_list_box")
								}
								o[0].className = "betresult buyType" + s;
								a.betPool.onChange()
							}, s = function() {
								var t = e.find("[name=operate]:checked")
										.closest("dd").attr("rel");
								return a.helper.buyType = +t
							};
							e.delegate("dd", "click", function(e) {
								var i = (t(this).attr("rel") || "").replace(
										/\D/g, "");
								if (i)
									a.helper.setBuyType(+i)
							});
							this.helper.syncBuyType = r;
							this.helper.readBuyType = s;
							this.helper.setBuyType = function(e, t) {
								this.buyType = +(e || 1);
								this.syncBuyType(t)
							};
							r();
							delete this.initMainTab;
							return this
						},
						getNumberHtml : function(e) {
							return "<em>"
									+ n.fillZero(e, 2).split("").join(
											"</em><em>") + "</em>"
						},
						betTimerInit : function() {
							var i = t(".betTimer"), a = t(".betTimer2"), o = this, s = function(
									e, t, i, n, a) {
								var r = "", s = a ? function(e) {
									return e
								} : o.getNumberHtml;
								if (1 == e && 0 == t) {
									e = 0;
									t = 24
								}
								if (1 == t && 0 == i) {
									t = 0;
									i = 60
								}
								if (e > 0)
									r = s(e) + " 天 " + s(t) + " 时";
								else if (t > 0)
									r = s(t) + " 时 " + s(i) + " 分";
								else
									r = s(i) + " 分 " + s(n) + " 秒";
								return r
							};
							var l = n.createCom("COMS.PT.Timer", {
								autoSaveKey : "ssqBetTimer2"
							}).onRunning(function(e, t, n, o) {
								var r = s(e, t, n, o);
								if (r != this._ssqBetTimer2HTML) {
									i.html("本期已截止，距下期开售还剩: " + s(e, t, n, o));
									a.html(s(e, t, n, o, true));
									this._ssqBetTimer2HTML = r
								}
							}).onStop(function() {
								if (!n.gameStop)
									if (l.initTime > 0 || u.initTime > 0) {
										o.saveData2LS();
										e.location.reload(true)
									}
							});
							l.initTime = +(i.attr("rel2") || 0);
							var u = n
									.createCom("COMS.PT.Timer", {
										autoSaveKey : "ssqBetTimer"
									})
									.onRunning(function(e, t, n, a) {
										var o = s(e, t, n, a);
										if (o != this._ssqBetTimerHTML) {
											i.html("本期投注剩余时间: " + o);
											this._ssqBetTimerHTML = o
										}
									})
									.onStop(
											function() {
												if (!n.gameStop) {
													t.dialog();
													var e = "您好，第 <span class='c_ba2636'>"
															+ n.config.period
															+ "</span>期已截止";
													if (n.config.nextPeriod)
														e += "，当前是停售时间，下一期开售时间为 "
																+ n.config.nextPeriodSaleStartTime
																+ "，请休息片刻，再来博取大奖。";
													r(e);
													l
															.start(l.initTime
																	- n.COMS.PT.Timer
																			.getPageRunTime())
												}
											});
							u.initTime = +(i.attr("rel") || 0);
							delete this.betTimerInit;
							this.betTimer = u;
							return this
						},
						groupbuyTimerInit : function() {
							var e = n
									.createCom("COMS.PT.Timer", {
										autoSaveKey : "ssqGroupTimer"
									})
									.onStop(
											function() {
												i.groupBuyStop = 1;
												var e = i.submitOrderType;
												if (!n.gameStop
														&& (3 == e || 5.1 == e)) {
													t.dialog();
													r("您好，第 <span class='c_ba2636'>"
															+ n.config.period
															+ "</span> 期合买投注已截止，请采用<br>其他投注方式 ， 其他投注方式截止时间：<span class='c_ba2636'>"
															+ n.config.periodBetSaleEndTime
															+ "</span><br> ，下一期开售时间为 "
															+ n.config.nextPeriodSaleStartTime
															+ "；")
												}
											}), a = n.createCom(
									"COMS.PT.Timer", {
										autoSaveKey : "ssqGroupTimer2"
									}).onStop(function() {
								i.groupBuyStop = 2
							});
							timerWrap = t(".groupbuyTimer"), lib = this;
							e.initTime = +(timerWrap.attr("rel") || 0);
							e.start(e.initTime
									- n.COMS.PT.Timer.getPageRunTime());
							a.initTime = +(timerWrap.attr("rel2") || 0);
							a.start(a.initTime
									- n.COMS.PT.Timer.getPageRunTime());
							this.groupbuyTimer = e;
							this.groupbuyTimer2 = a;
							delete this.groupbuyTimerInit;
							return this
						},
						numberStatInit : function() {
							var n = {}, a = this, o = function(e) {
								e.find("[name=statPeriods]").change(function() {
									r(e, t(this).val())
								});
								e.find(".showType[value=" + e[0]._index + "]")
										.click()
							}, r = function(i, r) {
								var s = +r, l = i[0].id;
								if (n[s]) {
									i.html(t.format(n[s], {
										showTypeName : "showTypeFor" + l
									}));
									o(i)
								} else {
									var u = e
											.setTimeout(
													function() {
														i
																.html("<div class='statHolder'><span>数据加载中，请稍候...</span></div>")
													}, 500);
									a
											.get(
													t.format(a.config.numAjax,
															s),
													function(a, r) {
														u && e.clearTimeout(u);
														var c = a ? "<div class='statHolder statErr'><span>数据加载失败，请稍后重试。</span></div>"
																: r;
														i
																.html(t
																		.format(
																				c,
																				{
																					showTypeName : "showTypeFor"
																							+ l
																				}));
														if (!a) {
															n[s] = r;
															o(i)
														}
													}, "stat")
								}
							};
							t("#mainPanels .selectNum .hmtj")
									.each(
											function() {
												var e = t(this), n = t("#"
														+ e.attr("cid")), s = 0;
												n
														.delegate(
																".showType",
																"click",
																function() {
																	var e = +this.value;
																	n[2 == e ? "addClass"
																			: "removeClass"]
																			("showHotCold");
																	n[0]._index = e
																})
														.delegate(
																".redballs a,.redNums a",
																"click",
																function() {
																	var e = [ +t(
																			this)
																			.html() ];
																	if (3 == a.helper.gameType)
																		i.dantuoArea
																				.push(
																						"dan",
																						"red",
																						e);
																	else if (4 == a.helper.gameType)
																		i.dingDanShaHaoArea
																				.dan(
																						"red",
																						e);
																	else
																		a.betArea
																				.push(
																						"red",
																						e)
																})
														.delegate(
																".blueballs a,.blueNums a",
																"click",
																function() {
																	var e = [ +t(
																			this)
																			.html() ];
																	if (3 == a.helper.gameType)
																		i.dantuoArea
																				.push(
																						"tuo",
																						"blue",
																						e);
																	else if (4 == a.helper.gameType)
																		i.dingDanShaHaoArea
																				.dan(
																						"blue",
																						e);
																	else
																		a.betArea
																				.push(
																						"blue",
																						e)
																});
												o(n);
												t(this)
														.toggle(
																function() {
																	t(this)
																			.addClass(
																					"active");
																	n
																			.removeClass("hide");
																	r(
																			n,
																			s || 100)
																},
																function() {
																	t(this)
																			.removeClass(
																					"active");
																	n
																			.addClass("hide")
																})
														.setControlEffect(
																"down")
											});
							delete this.numberStatInit;
							return this
						},
						betAreaInit : function() {
							var e = t(".ballarea"), a = e
									.find(".selectInfo span"), o = n
									.createCom("COMS.PT.BetArea", e)
									.onBallChange(
											function(e, t, a) {
												var o = i.config.maxRedNum;
												if (o < 33 && "red" == e
														&& 1 == t) {
													var s = n.unique(this
															.get("red"), a), l = s.length <= o;
													if (!l)
														r("红球数量不能超过" + o + "！");
													return l
												}
											})
									.onChange(
											function() {
												var e = this.get("red").length, t = this
														.get("blue").length, i = n
														.c(e, 6)
														* t;
												a
														.html([
																'您当前选中了<strong class="c_ba2636">',
																e,
																"</strong>个红球，",
																'<strong class="c_1e50a2">',
																t,
																"</strong>个蓝球，",
																'共<strong class="c_ba2636">',
																i,
																"</strong>注，",
																'共<strong class="c_ba2636">',
																2 * i,
																"</strong>元" ]
																.join(""))
											});
							this.initBetAreaCtrl(e, o);
							delete this.initBetAreaCtrl;
							delete this.betAreaInit;
							this.betArea = o;
							return this
						},
						initBetAreaCtrl : function(i, n) {
							t
									.each(
											[ "Red", "Blue" ],
											function(a, o) {
												var r = o.toLowerCase();
												i
														.find(
																"."
																		+ r
																		+ "BallBox")
														.delegate(".clearing",
																"click",
																function() {
																	n.clear(r)
																})
														.delegate(
																".radom_" + r
																		+ "btn",
																"click",
																function() {
																	n
																			.random(
																					r,
																					+t(
																							this)
																							.prev()
																							.val())
																})
														.find("select")
														.change(
																function() {
																	var i = +t(
																			this)
																			.val();
																	n.random(r,
																			i);
																	e.LS
																			.set(
																					"ssq"
																							+ o
																							+ "RandomSel",
																					i)
																});
												var s = [ 6, 1 ][a];
												i
														.find("."
																+ r
																+ "BallBox select option[value="
																+ (e.LS
																		.get("ssq"
																				+ o
																				+ "RandomSel") || s)
																+ "]")[0].selected = true
											})
						},
						dingDanShaHaoAreaInit : function() {
							var e = t("#mainPanels>.dingdan"), i = e
									.find(".selectInfo span"), a = n
									.createCom("COMS.PT.DingDanShaHaoArea", e)
									.onBallChange(
											function(e, t, i) {
												var a, o = this, l = true;
												if ("red" == e && 1 == t) {
													a = n.unique(this
															.get("red")["dan"],
															i),
															l = a.length <= 5;
													if (!l)
														s(
																"您好，红球最多只能定5个胆码。<br/>是否把（"
																		+ i[0]
																		+ "）做为杀号选择？",
																[ "*确定", "取消" ],
																function(t) {
																	if (t)
																		o
																				.sha(
																						e,
																						i)
																});
													return l
												}
												if (t == -1) {
													var u = {
														red : {
															name : "红球",
															count : 27
														},
														blue : {
															name : "蓝球",
															count : 15
														}
													}[e];
															a = n
																	.unique(
																			this
																					.get(e)["sha"],
																			i),
															l = a.length <= u.count;
													if (!l)
														r("您好，" + u.name
																+ "最多可杀"
																+ u.count
																+ "个号码！");
													return l
												}
											}).onChange(function() {
										o("red");
										o("blue")
									});
							t.each([ "Red", "Blue" ], function(t, i) {
								var n = i.toLowerCase();
								e.find("select." + n + "_random_count_select")
										.change(l);
								e.find("select.zu_count_select").change(u)
							});
							function o(t) {
								var i = e.find("select." + t
										+ "_random_count_select"), n = i.val(), o = n == i
										.find("option:eq(0)").val(), r = a
										.get(t), s = [
										+i.find("option").first().val(),
										+i.find("option").last().val() ], c = "red" == t ? [
										6, 20 ]
										: [ 1, 16 ], d = [], h = "red" == t ? 33
										: 16;
								d[0] = c[0] - r.dan.length;
								d[0] = d[0] < 0 ? 0 : d[0];
								d[1] = h - r.sha.length - r.dan.length;
								d[1] = d[1] > c[1] ? c[1] : d[1];
								if (d[0] === s[0] && d[1] === s[1]) {
									u();
									return
								}
								var f = [];
								for (var p = d[0]; p <= d[1]; ++p)
									f
											.push('<option val="'
													+ p
													+ '" '
													+ (!o && p == n ? 'selected="selected"'
															: "") + ">" + p
													+ "</option>");
								i.html(f.join(""));
								if (i.val() != n)
									l();
								u()
							}
							function l() {
								var i = a.get(), o = e
										.find("select.red_random_count_select"), r = e
										.find("select.blue_random_count_select"), s = e
										.find("select.zu_count_select"), l = s
										.val(), c = 33 - i[0].dan.length
										- i[0].sha.length, d = 16
										- i[1].dan.length - i[1].sha.length, h = (n
										.c(c, o.val()) || 1)
										* (n.c(d, r.val()) || 1), f = [ 1, 2,
										5, 10, 20, 50, 100 ], p = [];
								t.each(f, function(e, t) {
									if (t <= h)
										p.push(t)
								});
								s
										.html(t
												.map(
														p,
														function(e) {
															return '<option value="'
																	+ e
																	+ '" '
																	+ (e == l ? 'selected="selected"'
																			: "")
																	+ ">"
																	+ e
																	+ "</option>"
														}).join(""));
								u()
							}
							function u() {
								var t = a.get(), o = e
										.find("select.red_random_count_select"), r = e
										.find("select.blue_random_count_select"), s = e
										.find("select.zu_count_select"), l = t[0].dan.length
										+ +o.val(), u = t[1].dan.length
										+ +r.val(), c, d;
								if (t[0].dan.length > 0 && l > 6)
									c = n.c(+o.val(), 6 - t[0].dan.length) * u
											* s.val();
								else
									c = n.c(l, 6) * u * s.val();
								i.html([ "您当前选中了", '<strong class="c_ba2636">',
										c, "</strong>注，",
										'共<strong class="c_ba2636">', 2 * c,
										"</strong>元" ].join(""))
							}
							delete this.dingDanShaHaoAreaInit;
							this.dingDanShaHaoArea = a;
							return this
						},
						dantuoAreaInit : function() {
							var e = t("#mainPanels>.dantuo"), a = e
									.find(".selectInfo span"), o = n
									.createCom("COMS.PT.DantuoArea", e)
									.onBallChange(
											function(e, t, i, a) {
												if ("dan" == e && "red" == t
														&& 1 == i) {
													var o = n.unique(this.get(
															"dan", "red"), a), s = o.length <= 5;
													if (!s)
														r("最多可选择5个红球胆码！");
													return s
												}
											})
									.onChange(
											function() {
												var e = this.get(), t = e[0].length, n = e[2].length, o = t
														+ n, r = e[3].length, s = i.poolConfig
														.counter(e)[0];
												a
														.html([
																'您选择了<strong class="c_ba2636">',
																o,
																"</strong>个红球",
																"(",
																t,
																"个胆码，",
																n,
																"个拖码)，",
																'<strong class="c_1e50a2">',
																r,
																"</strong>个蓝球，",
																'共<strong class="c_ba2636">',
																s,
																"</strong>注，",
																'共<strong class="c_ba2636">',
																2 * s,
																"</strong>元" ]
																.join(""))
											});
							delete this.dantuoAreaInit;
							this.dantuoArea = o;
							return this
						},
						luckyBuyInit : function() {
							n.createCom("ssq.luckyBuy", {
								wrap : ".luckbuyBox",
								currentPeriod : n.config.period
							}, function(e) {
								var n = t(".betbtnBox"), a = n.find(".betbtn");
								e.onChange(function(e) {
									if ("num" != e && 6 == i.helper.gameType) {
										var t = this.getKey();
										a[t.key ? "removeClass" : "addClass"]
												("disabled")
									}
								});
								i.luckyBuy = e;
								e.onChange()
							});
							delete this.luckyBuyInit;
							return this
						},
						betButtonInit : function() {
							var e = t(".betbtnBox"), n = e.find(".betbtn");
							n.click(this.betButtonClick);
							this.betArea.onChange(function() {
								if (i.helper.gameType <= 2) {
									var e = this.get("red").length, t = this
											.get("blue").length;
									n[e >= 6 && t > 0 ? "removeClass"
											: "addClass"]("disabled").attr(
											"title", "确认选号")
								}
							});
							this.dantuoArea
									.onChange(function() {
										if (3 == i.helper.gameType) {
											var e = this.get(), t = e[0].length, a = e[2].length, o = t
													+ a, r = e[3].length;
											n[o > 6 && t > 0 && t < 6 && a > 1
													&& r > 0 ? "removeClass"
													: "addClass"]("disabled")
													.attr("title", "确认选号")
										}
									});
							if (4 == i.helper.gameType)
								n.removeClass("disabled").attr("title", "开始机选");
							this.dingDanShaHaoArea.onChange(function() {
								if (4 == i.helper.gameType)
									n.removeClass("disabled").attr("title",
											"开始机选")
							});
							this.syncBetButton = function() {
								var t = i.betPool, n = i.helper.gameType, a = t.editType, o = t.inEditDataGuid, r = false;
								switch (a) {
								case "normal":
									if (n < 3 && o)
										r = true;
									break;
								case "dantuo":
									if (3 == n && o)
										r = true
								}
								e[r ? "addClass" : "removeClass"](
										"revisebtnBox").attr(
										"title",
										4 == i.helper.gameType ? "开始机选"
												: "确认选号")
							};
							delete this.betButtonInit;
							return this
						},
						betButtonClick : function() {
							var e = i.helper.readGameType(), n, a = i.betPool, o = i.betArea, l, u, c = "", d, h, f, p, m, g = i.config.maxRedNum, b = function(
									e, t) {
								return {
									red : "<span class='c_ba2636'>" + t
											+ "</span>",
									blue : "<span class='c_1e50a2'>" + t
											+ "</span>"
								}[e]
										|| t
							};
							switch (e) {
							case 1:
							case 2:
								n = o.onChange();
								l = n.get("red"), u = n.get("blue");
								d = l.length, h = u.length;
								if (d >= 6 && d <= g && h >= 1) {
									if (a.inEditDataGuid
											&& "normal" == a.editType) {
										a.edit(a.inEditDataGuid, [ l, u ]);
										delete a.inEditDataGuid
									} else
										a.push([ l, u ]);
									n.clear();
									i.scrollWhenNeed(".bettingBox_ssq");
									return
								}
								if (0 == d && 0 == h) {
									s("至少选择1注号码才能投注，是否机选1注碰碰运气？", [ "*机选1注",
											"取消" ], function(e) {
										if (e)
											a.random(1)
									});
									return
								}
								c = d > g ? "至多能选择" + g + "个红球<br/>" : "";
								if (d < 6 || 0 == h) {
									c += "您选了（"
											+ b("red", d)
											+ "红 + "
											+ b("blue", h)
											+ "蓝），请至少再选择 "
											+ (d < 6 ? b("blue", 6 - d)
													+ " 个红球 " : "")
											+ (0 == h ? b("blue", 1) + " 个蓝球"
													: "");
									s(c, [ "*机选补全", "手工选号" ], function(e) {
										if (e) {
											d < 6 && o.random("red", 6);
											0 == h && o.random("blue", 1);
											i.betButtonClick()
										}
									});
									return
								}
								break;
							case 3:
								n = i.dantuoArea.onChange();
								f = n.get(), p = f[0].length, m = f[2].length,
										d = p + m, h = f[3].length;
								if (d > 6 && p > 0 && p < 6 && m > 1 && h > 0) {
									if (a.inEditDataGuid
											&& "dantuo" == a.editType) {
										a.edit(a.inEditDataGuid, f);
										delete a.inEditDataGuid
									} else
										a.push(f);
									n.clear();
									i.scrollWhenNeed(".bettingBox_ssq");
									return
								}
								if (0 == d && 0 == h) {
									s("至少选择1注号码才能投注，是否机选1注碰碰运气？", [ "*机选一注",
											"取消" ], function(e) {
										e && i.betPool.random(1)
									});
									return
								}
								c = 0 == p ? "请至少选择一个红球胆码"
										: p > 5 ? "至多能选择5个红球胆码"
												: m < 2 ? "请至少选择2个红球拖码"
														: d < 7 ? "红球胆码 + 红球拖码至少需要7个"
																: 0 == h ? "请至少选择一个篮球"
																		: "";
								break;
							case 6:
								if (i.luckyBuy) {
									f = i.luckyBuy.getData();
									if (f.data.length) {
										a.push2(f.data);
										i.scrollWhenNeed(".bettingBox_ssq")
									} else
										c = f.err
								}
								break;
							case 4:
								n = i.dingDanShaHaoArea.onChange();
								var y = t("#mainPanels>.dingdan"), v = y
										.find("select.red_random_count_select"), T = y
										.find("select.blue_random_count_select"), B = y
										.find("select.zu_count_select"), C = +v
										.val(), P = +T.val(), k = [];
								for (var S = 0, _ = +B.val(); S < _; ++S) {
									f = n.random(C, P);
									k.push(f)
								}
								a.push.apply(a, k);
								n.clear();
								i.scrollWhenNeed(".bettingBox_ssq");
								return
							}
							c && r(c)
						},
						initAddactionalBet : function() {
							var e = t(".additionalTip"), n = e
									.find('[name="stopWhenFeed"]'), a = e
									.find('[name="stopMoney"]'), o = this.betPool, r = o.periodNumber;
							n.attr("checked", false);
							a.val(5e3);
							r.onChange(function() {
								var t = this.get() || 1;
								t > 1 ? e.addClass("additionalTipShow")
										.removeClass("additionalTipHide") : e
										.addClass("additionalTipHide")
										.removeClass("additionalTipShow")
							});
							n
									.click(function() {
										t(this).parent().find("span")[this.checked ? "show"
												: "hide"]()
									});
							i.loadCdnJS("js2/liveCheck.js", function() {
								return !!t.fn.bindLiveCheck
							}, function() {
								a.bindNumberLiveCheck()
							});
							o.addactionalBet = {
								getStopMoney : function() {
									return +a.val() || 0
								},
								setStopMoney : function(e) {
									e = +e;
									e && a.val(e)
								},
								isStopWhenFeed : function() {
									return n.attr("checked")
								},
								setMode : function(e, t) {
									switch (parseInt(e)) {
									case 1:
									case 2:
										n.click();
										if (2 == e)
											this.setStopMoney(t || 0)
									}
								}
							};
							return this
						},
						betPoolInit : function() {
							var e = t(".betresult"), a = e.find(".betNumCount"), o = e
									.find(".betMoneyCount"), r = n.createCom(
									"COMS.PT.BetPool", this.poolConfig)
									.onDelete(function(e) {
										if (e.guid == this.inEditDataGuid) {
											var t = e.guid;
											s("该条投注数据正在编辑！确定删除吗？", function(e) {
												if (e) {
													delete r.inEditDataGuid;
													r.del(t)
												}
											});
											return false
										}
									}).onEdit(function(e) {
										if (e.guid == this.inEditDataGuid)
											delete this.inEditDataGuid
									}).onChange(function() {
										i.updateBetCountInfo(this)
									}).onRandom(function() {
										i.scrollWhenNeed(".bettingBox_ssq")
									});
							r.resultDom = {
								wrap : e,
								betNum : a,
								betMoney : o
							};
							this.initPoolCtrl(r);
							r.beiNumber = n.createCom("COMS.PT.iNumber", {
								wrap : e.find(".beiNumWrap"),
								min : 1,
								max : 99999
							}).onChange(function() {
								i.updateBetCountInfo(r)
							});
							r.periodNumber = n.createCom("COMS.PT.iNumber", {
								wrap : e.find(".periodNumWrap"),
								min : 1,
								max : 154
							}).onChange(
									function() {
										i.updateBetCountInfo(r);
										i.groupBuy
												&& i.groupBuy
														.setFollowPeriods(this
																.get())
									});
							delete this.betPoolInit;
							delete this.initPoolCtrl;
							this.betPool = r;
							this.initAddactionalBet();
							return this
						},
						poolConfig : t.extend({}, l, {
							edit : function(e, n) {
								var a = i.helper.gameType;
								if (2 == n.length) {
									if (a > 2)
										i.helper.setGameType(2);
									i.betArea.set(n);
									i.betPool.editType = "normal"
								} else {
									i.helper.setGameType(3);
									i.dantuoArea.set(n);
									i.betPool.editType = "dantuo"
								}
								i.betPool.inEditDataGuid = e;
								i.scrollWhenNeed(".bettingBox_ssq", true);
								i.syncBetButton();
								t.sendMsg("startEdit")
							}
						}),
						initPoolCtrl : function(e) {
							var a = ".randomBtn_ssq label input", o = ".randomBtn_ssq label span";
							t("#select_list_box")
									.next(".selected_btnbox")
									.delegate(
											".selected_btn",
											"click",
											function() {
												var n = t(this).attr("num"), a;
												switch (n) {
												case "u":
													a = +(t(this).parent()
															.find("input")
															.val().replace(
																	/\D/g, "") || 5);
													e.random(a);
													break;
												case "x":
													a = e.getData().length;
													if (a > 0)
														s(
																"您确定删除所有选号？",
																function(t) {
																	if (t) {
																		e
																				.clear();
																		if (i.betPool.inEditDataGuid)
																			delete i.betPool.inEditDataGuid;
																		i
																				.syncBetButton()
																	}
																});
													break;
												default:
													a = +n.replace(/\D/g, "");
													e.random(a)
												}
											})
									.find(a)
									.focus(
											function() {
												t(this).parent().find("span")
														.hide();
												this.value = this.value
														.replace(/\D/g, "");
												i.giveFocus(this)
											})
									.blur(
											function() {
												var e = this.value.replace(
														/\D/g, "");
												if (!e)
													t(this).parent().find(
															"span").show();
												else
													this.value = e + "注"
											})
									.keyup(
											function() {
												var e = this.value.replace(
														/\D/g, ""), t;
												if (e != this.value)
													this.value = e;
												if (e) {
													t = +e < 1 ? 1
															: +e > 99 ? 99 : +e;
													if (t + "" != this.value)
														this.value = t
												}
											})
									.end()
									.delegate(o, "click", function() {
										t(this).parent().find("input").focus()
									})
									.delegate(
											".storeUpBtn",
											"click",
											function() {
												var e = l
														.serialize(
																i.betPool
																		.getData())
														.replace(/t[^\,]+/g, "");
												i.savePoolFav(n.config.gameId,
														e, i.numberHelper,
														"双色球")
											}).delegate(
											".exportBtn",
											"click",
											function() {
												i.loadPoolFav(n.config.gameId,
														i.numberHelper,
														function(e) {
															i.betPool.push2(l
																	.parse(e))
														})
											});
							if (t(".beitouTip_ssq a").length)
								t(".beitouTip_ssq a")[0].onclick = function() {
									var e = t(".beitouTip_ssq strong").html();
									i.betPool.beiNumber.set(e);
									t(".beitouTip_ssq").remove();
									i
											.virualViewStat(
													"http://caipiao.163.com/beitouTip/ssq/",
													"立即掏空");
									i.updateBetCountInfo()
								};
							t(a)[0].value = ""
						},
						numberHelper : function(e) {
							var i = l.parse(e), n = [ 0, 0 ];
							t.each(i, function(e, t) {
								var i = l.counter(t);
								n[0] += i[0];
								n[1] += i[1]
							});
							return n
						},
						updateBetCountInfo : function(e) {
							var t = e || this.betPool, i = t.resultDom, a = t
									.getCount(), o, r, s, l = this.helper.gameType, u = this.helper.buyType;
							switch (l) {
							case 1:
							case 6:
								o = t.beiNumber.get();
								r = t.periodNumber.get();
								break;
							case 2:
							case 3:
							case 4:
							case 5:
								switch (u) {
								case 1:
									o = t.beiNumber.get();
									r = t.periodNumber.get();
									break;
								case 2:
									o = 1;
									r = 1;
									break;
								case 3:
									o = t.beiNumber.get();
									r = t.periodNumber.get();
									this.groupBuy
											&& this.groupBuy
													.setFollowPeriods(t.periodNumber
															.get())
								}
							}
							i.betNum.html(a[0]);
							i.betMoney.html(n.getMoneyText(a[1] * o * r));
							this.syncBetButton()
						},
						loadLSData : function(t) {
							var i = this.initData || e.LS.get("ssqPoolCache");
							if (i)
								this.betPool.push2(this.poolConfig.parse(i));
							if (t)
								e.LS.remove("ssqPoolCache")
						},
						saveData2LS : function() {
							e.LS.set("ssqPoolCache", this.betPool.serialize())
						},
						loadHtmlAndInit : function(e, i, n, a) {
							var o = t("#" + e), r = this;
							if (!o[0])
								return this;
							if (o[0].loaded) {
								t.isFunction(a) && a.call(r);
								return this
							}
							this
									.get(
											i,
											function(e, i) {
												if (o[0]) {
													var s = e ? "<div class='loadingData'>数据加载失败，请稍候再试。</div>"
															: i;
													if (!e)
														o[0].loaded = true;
													o.html(s);
													if (t.isFunction(n))
														n.call(r, a);
													else
														t.isFunction(a)
																&& a.call(r)
												}
											}, e);
							return this
						},
						mulitiBuyInit : function(e) {
							var a = t("#zhuihaoWrap"), r = this.config, s = this, l;
							if (!a[0] || !a[0].loaded)
								return this;
							r.followPeriods = r.followPeriods
									.replace(/\D/g, "").replace(/^0*/, "");
							if (r.followBetTimes) {
								l = r.followBetTimes.split(",");
								r.followPeriods = l.length
							}
							n.createCom("COMS.PT.MultiBuy", {
								wrap : a,
								beiNum : this.betPool.beiNumber.get(),
								chooseNum : r.followPeriods || 20,
								gameId : n.config.gameId,
								gameCn : "双色球",
								stopWhenFeed : !!{
									1 : 1,
									2 : 1
								}[r.followMode],
								stopMoney : {
									2 : 1
								}[r.followMode] ? r.stopAwardAmount : o
							}, function(t) {
								var n = i;
								n.betPool.onChange(function() {
									if (2 == n.helper.buyType)
										t.setBaseMoney(n.betPool.getCount()[1])
								});
								n.betTimer.onStop(function() {
									t.setCurPeriod(true)
								});
								if (l)
									t.setBetTimes(l);
								n.mulitiBuy = t;
								n.betPool.onChange();
								e.call(n)
							});
							delete this.mulitiBuyInit;
							return this
						},
						groupBuyInit : function(e) {
							var a = t("#groupbuyWrap");
							if (!a[0] || !a[0].loaded)
								return this;
							n.createCom("COMS.PT.GroupBuy", a, function(n) {
								var a = i;
								a.betPool.onChange(function() {
									if (3 == a.helper.buyType)
										n.setBaseMoney(this.getCount()[1]
												* a.betPool.beiNumber.get())
								});
								a.betPool.beiNumber.onChange(function() {
									if (3 == a.helper.buyType)
										n.setBaseMoney(a.betPool.getCount()[1]
												* this.get())
								});
								a.betTimer.onStop(function() {
								});
								a.groupBuy = n;
								a.betPool.onChange();
								t.each(a.initGroupData || {}, function(e, t) {
									n.set(e, t)
								});
								e.call(a)
							});
							delete this.groupBuyInit;
							return this
						},
						buyButtonInit : function() {
							var e = t("#normalBtnBox"), i = t("#groupbuyEndBtnBox"), n = t("#waitBtnBox"), a = t(".betBtns>span"), o = function(
									t) {
								var o = {
									1 : e,
									2 : i,
									3 : n
								}[t];
								if (o) {
									a.addClass("hide");
									o.removeClass("hide")
								}
							};
							e.find(".betting_Btn").click(this.buyButtonClick);
							this.betTimer.onStop(function() {
								o(3)
							});
							this.changeBtnBox = o;
							delete this.buyButtonInit;
							return this
						},
						buyButtonClick : function() {
							if (n.gameStop)
								return;
							var e = i, a = e.helper.buyType, o = e.helper.gameType, l = a, u, c, d, h, f, p, m, g = false, b, y = {
								gameId : n.config.gameId,
								activityType : e.activityType,
								stakeNumber : e.betPool.serialize()
							};
							if (!t("#agree_rule").is(":checked")) {
								r("请先阅读并同意《委托投注规则》后才能继续");
								return
							}
							b = function(t, i, n) {
								var a = t || 1, o = i || "至少选择" + a
										+ "注号码才能投注，是否机选" + a + "注碰碰运气？";
								s(o, n || [ "*机选1注", "取消" ], function(t) {
									t && e.betPool.random(a, function() {
										e.buyButtonClick()
									})
								})
							};
							if (!y.stakeNumber)
								if (!t(".betbtnBox .betbtn").hasClass(
										"disabled")) {
									t(".betbtnBox .betbtn").click();
									y.stakeNumber = e.betPool.serialize()
								} else
									g = true;
							a = l = 1 == o || 6 == o ? 1 : l;
							a = 2 == a && !e.mulitiBuy ? 1 : 3 == a
									&& !e.groupBuy ? 1 : a;
							switch (a) {
							case 1:
								if (g) {
									b();
									return
								}
								y.betTimes = e.betPool.beiNumber.get();
								p = e.betPool.periodNumber.get();
								if (p > 1) {
									y.followBuyPeriods = p;
									y.betWay = "ZHUIHAO";
									y.followName = "双色球 追号" + p + "期";
									l = 2.1
								}
								c = e.betPool.addactionalBet;
								y.followMode = !c.isStopWhenFeed() ? 0 : c
										.getStopMoney() > 0 ? 2 : 1;
								if (2 == y.followMode)
									y.stopAwardAmount = c.getStopMoney();
								break;
							case 2:
								if (g) {
									b();
									return
								}
								u = e.mulitiBuy.getData(), c = e.mulitiBuy
										.getInfo(), m = 0, f = [];
								t.each(u, function(e, t) {
									m++;
									y[e + "_times"] = t;
									f.push(e)
								});
								if (0 == m) {
									r("追号金额不能为空！");
									return
								}
								h = e.mulitiBuy.getCurPeriod();
								if (1 == m && u[h]) {
									delete y[h + "_times"];
									y.betTimes = u[h];
									l = 1
								} else {
									y.selectPeriods = f.join(",");
									y.followMode = !c.stopWhenFeed ? 0
											: c.stopMoney > 0 ? 2 : 1;
									if (2 == y.followMode)
										y.stopAwardAmount = c.stopMoney;
									y.followType = 1;
									y.betWay = "ZHUIHAO";
									y.followName = "双色球 追号" + f.length + "期";
									d = e.mulitiBuy.getSkipPeriod();
									if (d.skiped > 0) {
										s("您的追号中，没有选择<br/>" + d.join(",")
												+ "<br/>期次，真的要这样做么？", function(
												e) {
											e && i.payOrder(l, y)
										});
										return
									}
								}
								break;
							case 3:
								if (1 == i.groupBuyStop) {
									r("当前期次的合买已经截止，请稍后再试。");
									return
								}
								y.betTimes = i.betPool.beiNumber.get();
								var v = e.betPool.getCount()[1] * y.betTimes;
								if (v < 8) {
									var T = Math.ceil((8 - v) / y.betTimes / 2);
									b(T, "发起合买的投注金额不能少于8元，是否机选" + T + "注碰碰运气？",
											[ "*机选" + T + "注", "取消" ]);
									return
								}
								c = e.groupBuy.selfCheck();
								if (true !== c)
									return;
								u = e.groupBuy.getData();
								y.caseTitle = u.title;
								y.caseDesc = u.desc;
								y.totalPieces = u.totalPieces;
								y.createrBuyPieces = u.createrBuyPieces;
								y.proportion = u.feeType;
								y.secretLevel = u.secretLevel;
								y.guarantee = u.baodi;
								if (u.followPeriods > 1) {
									y.followBuyPeriods = u.followPeriods;
									l = 5.1
								}
							}
							i.payOrder(l, y)
						},
						payOrder : function(e, n) {
							var a = n;
							if (n.selectPeriods) {
								a = [];
								t.each(n.selectPeriods.split(","), function(e,
										t) {
									a.push("selectPeriods=" + t)
								});
								t.each(n, function(e, t) {
									if ("selectPeriods" !== e)
										a.push(e + "=" + t)
								});
								a = "@" + a.join("&")
							}
							i.submitOrderType = +e;
							this.loadJS(this.cdnUrl + "/js2/pay/pay.js",
									function() {
										return !!i.pay
									}, function() {
										i.pay.toPay({
											data : a,
											orderType : e,
											payCallBack : t.noop
										})
									})
						}
					})
}(window, jQuery, Core, Game, easyNav);