!function(e, t, i, n, a) {
	"use strict";
	Class.Base.Event
			.extend(
					"Game.COMS.JC.BetView",
					{
						config : {
							oneGameId : "matchcode",
							oneGameRelId : "relation",
							oneDayId : "gamedate",
							oneDaySelect : "dl[gamedate]",
							oneGameSelect : "dd[matchcode],dd[relation]",
							oneOptionSelect : "em[index][gametype], td[index][gametype]",
							oneOptionIndex : "index",
							oneOptionGameType : "gametype",
							oneOptionSp : "sp",
							hoverGame : "even",
							hoverOption : "hover",
							selectOption : "active",
							gameWrapSelector : ".gameSelect",
							isStopSelOptPropagation : false
						},
						init : function(e, n) {
							var a, d, u = /(\S+)Selector$/, m = this;
							this.config = t.extend({}, this.config, e);
							this.cache = d = {};
							a = this.config;
							this.betArea = n;
							for ( var p in a)
								if ("string" == i.getType(p) && u.test(p))
									d[RegExp.$1] = t(a[p]);
							if (!d.gameWrap || !d.gameWrap.length) {
								
								return this
							}
							this.callSuper("onRender");
							o = {};
							t.each(s, function(e) {
								o[e] = t.proxy(s[e], m)
							});
							f.call(this);
							l.call(this);
							c.call(this);
							r.call(this);
							h.call(this)
						},
						chaneDomMap : function(e) {
							var i = {}, n = this;
							if (e && e.length && e.each)
								e
										.each(function() {
											var e = t(this), a, o;
											a = e.attr(n.config.oneGameId);
											o = e.attr(n.config.oneGameRelId);
											if (a)
												i[a] ? i[a].ele ? i[a].ele = i[a].ele
														.add(e)
														: i[a].ele = e
														: i[a] = {
															ele : e
														};
											if (o)
												i[o] ? i[o].relationEle ? i[o].relationEle = i[o].relationEle
														.add(e)
														: i[o].relationEle = e
														: i[o] = {
															relationEle : e
														}
										});
							return i
						},
						show : function() {
							this.cache.gameWrap.show();
							return this
						},
						hide : function() {
							this.cache.gameWrap.hide();
							return this
						},
						destory : function() {
							var e = this.cache.gameWrap, t = this.config;
							e.undelegate(t.oneOptionSelect, "click", o.selOp);
							e.undelegate(t.oneOptionSelect,
									"mouseenter mouseleave", o.hoverOne);
							e.undelegate(t.oneGameSelect,
									"mouseenter mouseleave", o.hoverGame);
							e.undelegate(t.oneDaySelect + " .cuspText",
									"click", o.titleDisplay);
							e.html("");
							return this
						},
						render : function() {
							var e = this.config, i = this.cache, n, a, o = this.betArea, s = this.chaneDomMap
									.call(this, i.gameWrap
											.find(e.oneGameSelect));
							for (a in s)
								if (a) {
									var n = s[a], c = s[a].ele, r = c
											.attr("score"), l = c
											.attr("starttime"), h = c
											.attr("endtime"), f = c
											.attr("isstop"), d = c
											.attr("matchnumcn"), u = c
											.attr("hostname"), m = c
											.attr("guestname"), p = c
											.attr("leagueid"), g = c
											.attr("leaguename"), v = c
											.attr("hostteamid"), C = c
											.attr("visitteamid"), y = c
											.attr("ishot"), S = c
											.attr("matchid"), D = c
											.attr("isdg"), w;
									f = "1" == f ? true : false;
									y = "1" == y ? true : false;
									w = {
										matchCode : a,
										score : r,
										startTime : l,
										endTime : h,
										matchnumcn : d,
										hostName : u,
										guestName : m,
										isStop : f,
										isHot : y,
										leagueId : p,
										hostTeamId : v,
										visitTeamId : C,
										matchId : S,
										leagueName : g,
										ele : c
									};
									if (n.relationEle)
										w.relationEle = n.relationEle;
									if (D) {
										w.isDg = D.split(",");
										if (1 == w.isDg.length)
											w.isDg = w.isDg[0]
									}
									w.option = c.find(e.oneOptionSelect);
									if (w.relationEle)
										w.option = w.option.add(w.relationEle
												.find(e.oneOptionSelect));
									w.optionMap = {};
									w.spData = {};
									w.option
											.each(function(i, n) {
												var a = t(this), o = a
														.attr(e.oneOptionGameType), s = a
														.attr(e.oneOptionIndex), c = +a
														.attr(e.oneOptionSp);
												if (o && c >= 0 && s >= 0) {
													w.optionMap[o] = w.optionMap[o]
															|| {};
													w.spData[o] = w.spData[o]
															|| [];
													if (w.optionMap[o][s])
														w.optionMap[o][s] = w.optionMap[o][s]
																.add(a);
													else
														w.optionMap[o][s] = a;
													w.spData[o][s] = c
												}
											});
									w.wrap = w.ele.closest(e.oneDaySelect);
									w.gameDate = w.wrap.attr(e.oneDayId);
									o.addOneMatch(w)
								}
							this.trigger("onRender")
						}
					});
	var o = {}, s = {
		selOp : function(e) {
			var i = this.config, n = t(e.currentTarget), a = this.betArea, o = n
					.closest(i.oneGameSelect), s = o.attr("matchcode")
					|| o.attr("relation"), c = n.attr(i.oneOptionGameType), r = n
					.attr(i.oneOptionIndex), l = i.selectOption;
			r = +r;
			if (n.hasClass(l))
				a.removeOption(s, c, r);
			else
				a.selectOption(s, c, r);
			if (i.isStopSelOptPropagation)
				e.stopPropagation()
		},
		hoverOne : function(e) {
			var i = this.config, n, a = this.betArea, o = t(e.currentTarget), s = i.hoverOption, c = i.selectOption, r = o
					.parents(i.oneGameSelect), l = r.attr("matchCode")
					|| r.attr("relation"), h = o.attr(i.oneOptionIndex), f = o
					.attr(i.oneOptionGameType), d = a.getOneGameInfo(l);
			if (!l || d && d.isStop)
				return;
			if (!o.hasClass(c)) {
				n = a.findGameOption(l, f, h);
				if (!n || !n.length)
					return;
				if ("mouseover" == e.type)
					n.addClass(s);
				else
					n.removeClass(s)
			}
		},
		hoverGame : function(e) {
			var i = this.config, n = i.hoverGame, a = t(e.currentTarget), o = a
					.attr("matchCode")
					|| a.attr("relation");
			if (!o)
				return;
			if ("mouseout" == e.type)
				a.removeClass(n);
			else
				a.addClass(n)
		},
		titleDisplay : function(e) {
			var i = this.config, n = this.betArea, a = t(e.currentTarget), o = {}, s, c = a
					.parents(i.oneDaySelect);
			if (c.hasClass("closeData")) {
				c.removeClass("closeData");
				s = true;
				a.html('隐藏<i class="cusp"></i>')
			} else {
				c.addClass("closeData");
				s = false;
				a.html('展开<i class="cusp"></i>')
			}
			c.find(i.oneGameSelect).filter("[" + i.oneGameId + "]").each(
					function() {
						var e = this.getAttribute("matchcode"), t;
						if (e) {
							t = n.getOneGameInfo(e);
							if (t)
								o[e] = s
						}
					});
			n.callEvent("onDisplay", o, false)
		}
	}, c = function() {
		var e = this, t = e.config, i = this.cache;
		i.gameWrap.delegate(t.oneOptionSelect, "click", o.selOp);
		return this
	}, r = function() {
		this.cache.gameWrap.delegate(this.config.oneOptionSelect,
				"mouseenter mouseleave", o.hoverOne)
				.delegate(this.config.oneGameSelect, "mouseenter mouseleave",
						o.hoverGame);
		return this
	}, l = function() {
		this.betArea.onDisplay(function(e, t) {
			var n = (new Date).getTime();
			var a, o, s, c;
			if (!e || false === t)
				return this;
			for (a in e) {
				s = e[a];
				o = this.getOneGameInfo(a);
				if (!o && "boolean" != i.getType(s))
					return this;
				o.ele.css("display", s ? "" : "none");
				o.relationEle && o.relationEle.css("display", s ? "" : "none")
			}
		})
	}, h = function() {
		var e = this.config;
		this.betArea.onSelectOption(function(t, i, n) {
			var a = this.findGameOption(t, i, n);
			a && a.addClass(e.selectOption).removeClass(e.hoverOption)
		}).onRemoveOption(function(t, i, n) {
			var a = this.findGameOption(t, i, n);
			a && a.length && a.removeClass(e.selectOption)
		}).onClear(function() {
			var t, i, n;
			this.eachSelectGameInfo(function(a, o) {
				t = this.findGameOption(a);
				if (t)
					for (i in t)
						for (n in t[i])
							t[i][n].removeClass(e.selectOption)
			})
		}).onDel(function(t) {
			var i, n, a;
			i = this.findGameOption(t);
			if (i)
				for (n in i)
					for (a in i[n])
						i[n][a].removeClass(e.selectOption)
		}).onBeforeDelGame(function(e, t) {
			if (t) {
				if (t.relationEle)
					t.relationEle.remove();
				if (t.ele)
					t.ele.remove()
			}
		})
	}, f = function() {
		var e = this, t = this.config, i = this.betArea, n = this.cache;
		this.cache.gameWrap.delegate(t.oneDaySelect + " .cuspText", "click",
				o.titleDisplay);
		return this
	}
}(Core, jQuery, Game, window);
!function(e, t, i, n, a) {
	"use strict";
	i
			.regBaseCom2Lib(
					"COMS.JC.BetArea",
					"onBeforeInit onDisplay onPosition onSelectOption onRemoveOption onDel onClear onChange onAddGame onDelGame onBeforeAddGame onBeforeDelGame onBeforeDestory",
					{
						config : {
							attentionView : null,
							attentionViewConfig : {},
							betView : Class.Game.COMS.JC.BetView,
							betViewConfig : {},
							gameTypes : null,
							gameId : null,
							attentionSortFun : null,
							gameWrapSelector : ".gameSelect"
						},
						init : function(n) {
							var a, o, s = /(\S+)Selector$/, c = this, r, h;
							this.config = t.extend({}, this.config, n);
							o = {
								gameInfo : {},
								gameDateInfo : {},
								matchSize : 0,
								stopMatchSize : 0,
								selectGameInfo : {
									length : 0
								}
							};
							this.cache = o;
							a = this.config;
							for ( var f in a)
								if ("string" == i.getType(f) && s.test(f))
									o[RegExp.$1] = t(a[f]);
							if (!a.gameTypes || !a.gameTypes.length) {
								alert("betArea初始化错误，没有找到玩法类型");
								return this
							}
							l.call(this);
							this.callEvent("onBeforeInit");
							if (!a.betView || !a.betView.create)
								alert("betArea 初始化错误，必须设置view");
							h = a.betView.create(a.betViewConfig, c);
							var r = [ "show", "hide", "destory", "render" ];
							t.each(r, function(e, t) {
								if (!h[t]) {
									alert("betArea 初始化错误，betView缺少方法 " + h[t]);
									return this
								}
							});
							this.betView = h;
							h
									.onRender(function() {
										e
												.loadCdnJS(
														"js2/sportGame2/COMS/attentionView.js",
														function() {
															return !!(Class.Game
																	&& Class.Game.COMS
																	&& Class.Game.COMS.JC && Class.Game.COMS.JC.Attention)
														},
														function() {
															a.attentionView = Class.Game.COMS.JC.Attention;
															try {
																if (a.attentionView
																		&& a.attentionView.create) {
																	a.attentionViewConfig.gameId = a.gameId;
																	a.attentionViewConfig.attentionSortFun = a.attentionSortFun;
																	c.attentionView = a.attentionView
																			.create(
																					a.attentionViewConfig,
																					c)
																}
															} catch (e) {
																console.log(e)
															}
														})
									});
							h.render()
						},
						get : function() {
							var e = this;
							return {
								selectGameInfo : e.cache.selectGameInfo,
								gameInfo : e.cache.gameInfo
							}
						},
						getGameInfo : function() {
							return this.cache.gameInfo
						},
						getSelectGameInfo : function() {
							return this.cache.selectGameInfo
						},
						getOneGameInfo : function(e) {
							return this.cache.gameInfo[e]
						},
						getOneDateInfo : function(e) {
							return this.cache.gameDateInfo[e]
						},
						getOneSelectGameInfo : function(e) {
							return this.cache.selectGameInfo[e]
						},
						getMatchSize : function() {
							return this.cache.matchSize
						},
						getStopMatchSize : function() {
							return this.cache.stopMatchSize
						},
						eachGameInfo : function(e) {
							var t = this.cache.gameInfo;
							for ( var i in t)
								if ("length" != i)
									if (false === e.call(this, i, t[i], t))
										return this
						},
						eachSelectGameInfo : function(e) {
							var t = this.cache.selectGameInfo;
							for ( var i in t)
								if ("length" != i)
									if (false === e.call(this, i, t[i], t))
										return this
						},
						each : function(e, t) {
							if (e)
								for ( var i in e)
									if ("length" != i)
										if (false === t.call(this, i, e[i], e))
											return this
						},
						getMapKeyList : function(e) {
							var i = [];
							if (!e || !t.isPlainObject(e))
								return i;
							for ( var n in e)
								if ("length" != n)
									i.push(n);
							return i
						},
						findGameOption : function(e, t, i) {
							var n = this.cache, a = this.config, o, s = n.gameInfo;
							i = +i;
							if (!e || !s[e])
								return;
							o = s[e].optionMap;
							if (!o)
								return;
							if (!t)
								return o;
							if (!(i >= 0))
								return o[t];
							if (o[t] && o[t][i])
								return o[t][i]
						},
						updateOptionMap : function(e, n, a, o) {
							var s = this.cache, c = this.config, r, l = this.config.gameTypes, h = s.gameInfo;
							if (!e || !h[e])
								return;
							r = h[e].optionMap;
							if (!r)
								r = h[e].optionMap = {};
							if (t.isPlainObject(n)) {
								o = n;
								n = null;
								a = null
							}
							if (t.isPlainObject(a)) {
								o = a;
								a = null
							}
							if (o) {
								if (!n) {
									h[e].optionMap = o;
									return this
								}
								if (i.indexOf(l, n) > -1) {
									r = r[n];
									if (null == a || !(+a >= 0)) {
										h[e].optionMap[n] = o;
										return this
									} else {
										if (!r)
											r = h[e].optionMap[n] = {};
										r[a] = o;
										return this
									}
								}
							}
							return this
						},
						findGameOptionSp : function(e, t, i) {
							var n = this.cache, a = this.config, o, s = n.gameInfo;
							i = +i;
							if (!e || !s[e])
								return this;
							o = s[e].spData;
							if (t && i >= 0) {
								if (o[t] && o[t][i] >= 0)
									return o[t][i]
							} else
								return o;
							return this
						},
						setSpData : function(e, t, n, a) {
							var o = this.cache, s = this.config, c, r = o.gameInfo;
							if ("array" == i.getType(n)) {
								a = n;
								n = null
							}
							if (!e || !r[e])
								return this;
							c = r[e];
							if (c.spData[t]) {
								if (n && c.spData[t][n]) {
									a += a;
									if (a >= 0)
										c.spData[t][n] = +a
								}
								if ("array" == i.getType(a))
									c.spData[t] = a
							}
							return this
						},
						selectOption : function(e, t, n) {
							return i.getStopRecursionFn(o, this)(e, t, n)
						},
						removeOption : function(e, t, n) {
							return i.getStopRecursionFn(s, this)(e, t, n)
						},
						del : function(e) {
							return i.getStopRecursionFn(c, this)(e)
						},
						clear : function() {
							return i.getStopRecursionFn(r, this)()
						},
						addMatch : function(e) {
							var i = this, n;
							if (e && e.length)
								for (n = 0; n < e.length; n++)
									i.addOneMatch(e[n]);
							if (e && t.isPlainObject(e))
								for ( var a in e)
									i.addOneMatch(e[a]);
							return this
						},
						addOneMatch : function(e) {
							var i = this.cache.gameInfo, n = this.cache.gameDateInfo, a = this.cache.selectGameInfo, o;
							if (!e.matchCode)
								return;
							if (false === this.callEvent("onBeforeAddGame",
									e.matchCode, e))
								return this;
							if (t.isPlainObject(e) && e.matchCode && e.ele
									&& e.ele.length && e.optionMap) {
								if (a[e.matchCode])
									this.del(e.matchCode);
								if (i[e.matchCode])
									i[e.matchCode] = t
											.extend(e, i[e.matchCode]);
								else
									i[e.matchCode] = e;
								o = e.gameDate;
								if (o) {
									if (!n[o])
										n[o] = {
											game : {}
										};
									n[o]["game"][e.matchCode] = e.ele
								}
								this.callEvent("onAddGame", e.matchCode, e)
							}
							return this
						},
						delAllGame : function() {
							this.eachGameInfo(function(e) {
								this.delOneMatch(e)
							})
						},
						delOneMatch : function(e) {
							var i = this.cache, n = i.gameInfo, a = n[e], o, s;
							if (e && a) {
								if (false === this.callEvent("onBeforeDelGame",
										e, a))
									return this;
								this.del(e);
								s = a.gameDate;
								if (s) {
									o = i.gameDateInfo[s];
									if (o && o.game[e])
										delete o.game[e];
									if (t.isEmptyObject(o.game))
										delete i.gameDateInfo[s]
								}
								delete n[e];
								this.callEvent("onDelGame", e)
							}
							return this
						},
						destory : function() {
							if (false === this.callEvent("onBeforeDestory"))
								return false;
							var e = this.cache, i = this;
							this.betView.destory();
							this.clear();
							e.gameDateInfo = {};
							e.gameInfo = {};
							e.matchSize = {};
							var n = [ "onBeforeInit", "onDisplay",
									"onPosition", "onSelectOption",
									"onRemoveOption", "onDel", "onClear",
									"onChange", "onAddGame", "onDelGame",
									"onBeforeAddGame", "onBeforeDelGame",
									"onBeforeDestory" ];
							t.each(n, function(e, t) {
								i.unbind(t)
							});
							return this
						},
						show : function() {
							this.betView.show();
							return this
						},
						hide : function() {
							this.betView.hide();
							return this
						},
						display : function(e, t) {
							e = +e;
							if (!e)
								return this;
							switch (e) {
							case 1:
								this.displayByGameInfo(t);
								break;
							case 2:
								this.displayByLeagueid(t);
								break;
							case 3:
								this.displayByMap(t)
							}
							return this
						},
						displayByGameInfo : function(e) {
							var t = i.getType(e), n = {};
							if ("object" != t)
								return this;
							var a, o, s, c, r = this.cache.gameInfo, l = this.cache.selectGameInfo, h = e.isRq, f = e.isFrq, d = e.isStop, u = e.isSelect, m, p = e.isHot;
							for ( var g in r) {
								a = true;
								o = true;
								s = true;
								c = true;
								m = r[g];
								if (true === u && (!l || !l.length || !l[g]))
									c = false;
								if (m.isStop && "boolean" == i.getType(d))
									a = d;
								if ("boolean" == i.getType(h)
										&& "boolean" == i.getType(f)
										&& "undefined" != i.getType(m.score))
									o = 0 == m.score ? f : h;
								if (true === p
										&& "boolean" == i.getType(m.isHot))
									s = m.isHot;
								n[g] = a && o && s && c
							}
							this.callEvent("onDisplay", n);
							return this
						},
						displayByLeagueId : function(e) {
							var t = i.getType(e), n, a, o = {}, s = this.cache.gameInfo;
							if ("object" != t)
								return this;
							this.eachGameInfo(function(t) {
								for (a in e)
									if (s[t].leagueId == a)
										o[t] = !!e[a]
							});
							this.callEvent("onDisplay", o);
							return this
						},
						displayByMap : function(e) {
							var t = i.getType(e), n = {}, a, o = this.cache.gameInfo;
							if ("object" != t)
								return this;
							for (a in e)
								if (o[a])
									n[a] = !!e[a];
							this.callEvent("onDisplay", n);
							return this
						},
						displayAllGame : function() {
							var e = this.cache.attentionGameInfo, t = {}, i, n, a = this, o;
							this.eachGameInfo(function(e) {
								t[e] = true
							});
							this.callEvent("onDisplay", t);
							return this
						}
					});
	var o = function(e, t, n) {
		var a = this.cache, o, s, c = a.selectGameInfo, r = this.config, l = c[e];
		n = +n;
		if (!e || !t || n < 0)
			return this;
		o = this.findGameOptionSp(e, t, n);
		o = +o;
		if (!(o >= 0) || c[e] && c[e][t] && c[e][t][n] >= 0)
			return this;
		if (!c[e] && c.length > 14) {
			i.alert("啊偶，选择的比赛不能超过15场哦");
			return this
		}
		s = this.getOneGameInfo(e);
		if (!s || s.isStop)
			return this;
		if (i.indexOf(r.gameTypes, t) == -1)
			alert("gameTypes或者oneOptionSelect配置错误");
		if (false === this.callEvent("onSelectOption", e, t, n, o, c))
			return this;
		if (!a.selectGameInfo)
			a.selectGameInfo = {
				length : 0
			};
		if (!l) {
			l = {};
			a.selectGameInfo[e] = l;
			a.selectGameInfo.length += 1
		}
		if (!l[t])
			l[t] = {
				length : 0
			};
		l[t][n] = o;
		l[t].length += 1;
		this.callEvent("onChange", e, t, n, o)
	}, s = function(e, t, i) {
		var n = this.cache, a = n.selectGameInfo, o = a[e];
		i = +i;
		if (!e || !t || i < 0)
			return this;
		if (o && o[t] && o[t][i] >= 0)
			if (1 == this.getMapKeyList(o).length && 1 == o[t].length)
				this.del(e);
			else {
				if (false === this.callEvent("onRemoveOption", e, t, i, a))
					return this;
				if (1 == o[t].length)
					delete o[t];
				else {
					delete o[t][i];
					o[t].length -= 1
				}
				this.callEvent("onChange", e, t, i)
			}
	}, c = function(e) {
		var t = this.cache, i, n, a;
		if (!e || !t.selectGameInfo[e])
			return this;
		if (1 == t.selectGameInfo.length)
			this.clear();
		else {
			if (false === this.callEvent("onDel", e, t.selectGameInfo))
				return this;
			delete t.selectGameInfo[e];
			t.selectGameInfo.length -= 1;
			this.callEvent("onChange", e)
		}
		return this
	}, r = function() {
		var e, t = this.cache, i, n = t.selectGameInfo, a, o;
		if (!n.length)
			return this;
		if (false === this.callEvent("onClear", this.getMapKeyList(n), n))
			return this;
		t.selectGameInfo = {
			length : 0
		};
		this.callEvent("onChange");
		return this
	}, l = function() {
		this.onAddGame(function(e, t) {
			this.cache.matchSize += 1;
			if (t.isStop)
				this.cache.stopMatchSize += 1
		});
		this.onBeforeDelGame(function(e, t) {
			if (t.isStop)
				this.cache.stopMatchSize -= 1
		});
		this.onDelGame(function() {
			this.cache.matchSize -= 1
		})
	}
}(Core, jQuery, Game, window);
!function(e, t, i, n, a) {
	"use strict";
	i
			.regBaseCom2Lib(
					"COMS.JC.BetPool",
					"onChange onDel onSelectOption onRemoveOption onClear onChangeDan onBeforeDestory",
					{
						config : {
							wrapSelector : "#selectGamePool",
							clearBtnSelector : "#btnclear",
							oneOptionSelect : "a[gametype][index]",
							delBtnSelect : ".icoDel",
							danBtnSelect : ".icoDan",
							danActiveCls : "icoDanSele",
							danDisabledCls : "icoDanDis",
							optionWrapSelect : ".gameOption[matchCode]",
							optionListWrapSelect : ".betList",
							oneGameTitleSelect : ".gameTitle[matchCode]",
							wrapBodySelect : "tbody",
							teamData : null,
							gameTypes : null,
							oneGameTmp : [
									'<tr matchcode="{matchCode}" class="gameTitle">',
									"<th>",
									'<a class="icoDel" href="javascript:;"></a>{matchnumcn}',
									"</th>",
									'<th class="tr">{hostName}</th>',
									"{VS}",
									'<th class="tl">{guestName}</th>',
									"{dan}",
									"</tr>",
									'<tr class="gameOption" matchCode={matchCode}>',
									"{option}", "</tr>" ].join(""),
							VSTmp : "<th></th>",
							danTmp : '<th><a href="javascript:;" class="icoDan"></a></th>',
							selectOptionTmp : '<a index="{0}" gameType={1} matchcode={2} href="javascript:;" class="{3}">{4}</a>',
							optionTmp : [
									'<td colspan="{colspan}" class="betList">',
									"{optionList}", "</td>" ].join(""),
							isDan : true,
							serialize : null
						},
						init : function(e) {
							var n, a = this, o, s = /(\S+)Selector$/;
							this.config = t.extend({}, this.config, e);
							n = this.config;
							o = {
								selectGameInfo : {
									length : 0
								},
								wrap : null,
								wrapBody : null
							};
							this.cache = o;
							for ( var c in n)
								if ("string" === i.getType(c) && s.test(c))
									o[RegExp.$1] = t(n[c]);
							if (!o.wrap || !o.wrap.length) {
								alert("betPool组件初始化错误，容器加载有误");
								return this
							}
							if (n.wrapBodySelect)
								o.wrapBody = o.wrap.find(n.wrapBodySelect);
							else
								o.wrapBody = o.wrap;
							if (!o.wrapBody.length) {
								alert("betPool组件初始化错误，容器加载有误");
								return this
							}
							if (!n.teamData) {
								alert("betPool组件初始化错误，teamData必须配置");
								return this
							}
							if (!n.gameTypes) {
								alert("betPool组件初始化错误，gameTypes必须配置");
								return this
							}
							m = {};
							t.each(p, function(e) {
								m[e] = t.proxy(p[e], a)
							});
							d.call(this);
							u.call(this)
						},
						get : function() {
							return this.cache.selectGameInfo
						},
						getMapKeyList : function(e) {
							var i = [];
							if (!e || !t.isPlainObject(e))
								return i;
							for ( var n in e)
								if ("length" !== n)
									i.push(n);
							return i
						},
						selectOption : function(e, t, n, a, s, c, r, l) {
							return i.getStopRecursionFn(o, this)(e, t, n, a, s,
									c, r, l)
						},
						removeOption : function(e, t, n, a, o, c, r) {
							return i.getStopRecursionFn(s, this)(e, t, n, a, o,
									c, r)
						},
						del : function(e) {
							return i.getStopRecursionFn(c, this)(e)
						},
						clear : function() {
							return i.getStopRecursionFn(r, this)()
						},
						setDisableDan : function(e) {
							var n = this, a = this.cache.selectGameInfo, o = this.config, s = false, c = function(
									e, t, i) {
								if (true === i) {
									e.attr("disabled", "disabled").addClass(
											o.danDisabledCls);
									if (e.hasClass(o.danActiveCls)) {
										s = true;
										e.attr("checked", "").removeClass(
												o.danActiveCls);
										a[t].isDan = false
									}
								} else if (false === i)
									e.attr("disabled", "").removeClass(
											o.danDisabledCls)
							};
							if ("object" === i.getType(e)) {
								this.cache.wrapBody.find(
										this.config.danBtnSelect).each(
										function() {
											var i = t(this), n = i.closest(
													"[matchcode]").attr(
													"matchcode");
											c(i, n, e[n])
										});
								s && n.callEvent("onChangeDan")
							}
							if ("boolean" === i.getType(e)) {
								this.cache.wrapBody.find(
										this.config.danBtnSelect).each(
										function() {
											var i = t(this), n = i.closest(
													"[matchcode]").attr(
													"matchcode");
											c(i, n, e)
										});
								s && n.callEvent("onChangeDan")
							}
							return this
						},
						setDan : function(e) {
							var i = this.cache.selectGameInfo, n = this.config;
							this.cache.wrapBody
									.find(this.config.danBtnSelect)
									.each(
											function() {
												var a = t(this), o = a.parents(
														"[matchcode]").attr(
														"matchcode");
												if (true === e[o]) {
													a
															.attr("checked",
																	"checked")
															.addClass(
																	n.danActiveCls)
															.attr("disabled",
																	"")
															.removeClass(
																	n.danDisabledCls);
													i[o].isDan = true
												} else if (false === e[o]
														|| false === e) {
													a
															.attr("checked", "")
															.removeClass(
																	n.danActiveCls);
													i[o].isDan = false
												}
											});
							this.callEvent("onChangeDan")
						},
						serialize : function() {
							var e = this.cache, n, a, o, s, c = this.config.teamData, r, l = e.selectGameInfo, h, f, d = [], u, m = this.config.serialize;
							if (t.isFunction(m))
								return m(l);
							else {
								u = this.getMapKeyList(l);
								i.sortNum(u);
								for (s = 0; s < u.length; s++) {
									n = u[s];
									f = [];
									f.push(n);
									h = [];
									for (a in l[n].sp) {
										r = c[a];
										for (o in l[n].sp[a]) {
											if ("length" === o)
												continue;
											h.push(r[o][2])
										}
									}
									f.push(h.join("."));
									if (l[n].isDan)
										f.push(1);
									else
										f.push(0);
									d.push(f.join(":"))
								}
								return d.join(" ")
							}
						},
						destory : function() {
							if (false === this.callEvent("onBeforeDestory"))
								return false;
							var e = this.cache, i = this, n = this.config;
							this.clear();
							e.selectGameInfo = {
								length : 0
							};
							e.clearBtn.unbind("click", m.clearClick);
							e.wrap.undelegate(n.oneOptionSelect, "click",
									m.removeClick).undelegate(n.delBtnSelect,
									"click", m.delGameClick);
							e.wrapBody.undelegate(this.config.danBtnSelect,
									"click", m.danSel).html();
							var a = [ "onChange", "onDel", "onSelectOption",
									"onRemoveOption", "onClear", "onChangeDan",
									"onBeforeDestory" ];
							t.each(a, function(e, t) {
								i.unbind(t)
							})
						},
						show : function() {
							this.cache.wrap.show()
						},
						hide : function() {
							this.cache.wrap.hide()
						}
					});
	var o = function(e, t, n, a, o, s, c, r) {
		var l = this.config, h = this.cache, d = h.selectGameInfo, u = h.gameInfo, m = d[e];
		n = +n;
		r = +r;
		isNaN(r) && (r = "");
		a = +a;
		if (!e || !t || n < 0 || !o || !s || !c || !(a >= 0))
			return this;
		if (d[e] && d[e]["sp"] && d[e]["sp"][t] && d[e]["sp"][t][n] >= 0)
			return this;
		if (false === this.callEvent("onSelectOption", e, t, n, a, d))
			return this;
		if (!m) {
			m = {
				matchnumcn : o,
				hostName : s,
				guestName : c,
				isDan : false,
				sp : {}
			};
			if ("number" === i.getType(r))
				m.score = r;
			h.selectGameInfo[e] = m;
			h.selectGameInfo.length += 1
		}
		if (!m["sp"][t])
			m["sp"][t] = {
				length : 0
			};
		a = +a || 0;
		m["sp"][t][n] = a;
		m["sp"][t].length += 1;
		f.call(this, e);
		this.callEvent("onChange", e, t, n, a)
	}, s = function(e, t, i, n, a, o, s) {
		var c = this.cache, r = this.config, l, h = c.selectGameInfo, d = h[e];
		i = +i;
		if (!e || !t || i < 0 || !n || !a || !o)
			return this;
		if (h[e] && h[e]["sp"][t] && h[e]["sp"][t][i] >= 0)
			if (1 === this.getMapKeyList(d["sp"]).length
					&& 1 === d["sp"][t].length)
				this.del(e);
			else {
				if (false === this.callEvent("onRemoveOption", e, t, i, h))
					return this;
				if (1 === d["sp"][t].length)
					delete d["sp"][t];
				else {
					delete d["sp"][t][i];
					d["sp"][t].length -= 1
				}
				f.call(this, e);
				this.callEvent("onChange", e, t, i)
			}
	}, c = function(e) {
		var t = this.cache, i = this.config, n;
		if (!e || !t.selectGameInfo[e])
			return this;
		if (1 == t.selectGameInfo.length)
			this.clear();
		else {
			if (false === this.callEvent("onDel", e))
				return this;
			delete t.selectGameInfo[e];
			t.selectGameInfo.length -= 1;
			t.wrapBody.find(i.optionWrapSelect).filter(
					'[matchCode="' + e + '"]').remove();
			t.wrapBody.find(i.oneGameTitleSelect).filter(
					'[matchCode="' + e + '"]').remove();
			this.callEvent("onChange", e)
		}
		return this
	}, r = function() {
		var e, t = this.cache, i = this.config, n = t.wrapBody, a = t.selectGameInfo;
		if (a.length) {
			if (false === this.callEvent("onClear", this.getMapKeyList(a)))
				return this;
			t.selectGameInfo = {
				length : 0
			};
			n.html("");
			this.callEvent("onChange")
		}
		return this
	}, l = function(e, n) {
		var a = [], o, s, c, r, l, h, f = this.config, d = this.cache, u = f.selectOptionTmp, m = f.gameTypes, p = f.teamData;
		for (c = 0; c < m.length; c++) {
			l = n["sp"][m[c]];
			h = p[m[c]];
			if (l && h) {
				s = this.getMapKeyList(l);
				i.sortNum(s);
				for (r = 0; r < s.length; r++)
					a.push(t.format(u,
							[ s[r], m[c], e, h[s[r]][0], h[s[r]][1] ]))
			}
		}
		return a.join("")
	}, h = function(e, n) {
		var a = "", o = this.config, s = this.cache, c = +n.score, r = t
				.format(o.oneGameTmp, {
					VS : o.VSTmp
				});
		a = t
				.format(r,
						{
							matchCode : e,
							matchnumcn : n.matchnumcn,
							hostName : (n.hostName || "").substring(0, 4),
							guestName : (n.guestName || "").substring(0, 4),
							score : "number" == i.getType(c) && !isNaN(c)
									&& 0 != c ? '<strong><font color="'
									+ (c > 0 ? "red" : "green") + '">'
									+ (c > 0 ? "+" + c : c)
									+ "</font></strong>" : "VS",
							option : t.format(o.optionTmp, {
								optionList : l.call(this, e, n),
								colspan : o.isDan ? 5 : 4
							}),
							dan : o.isDan ? o.danTmp : ""
						});
		return a
	}, f = function(e) {
		var t = "", n = this.config, a = this.cache, o, s, c, r = a.selectGameInfo, f = r[e], d, u = i
				.sortNum(this.getMapKeyList(r)), m = a.wrapBody;
		if (!e || !f)
			return "";
		o = m.find(n.oneGameTitleSelect);
		s = o.filter('[matchCode="' + e + '"]');
		if (s.length) {
			c = m.find(n.optionWrapSelect).filter('[matchCode="' + e + '"]');
			o = c.find(n.optionListWrapSelect);
			if (!o.length)
				o = c;
			o.html(l.call(this, e, f))
		} else {
			t = h.call(this, e, f);
			d = i.indexOf(u, e);
			d = d > -1 ? d : 0;
			o = o.eq(d);
			if (o.length)
				o.before(t);
			else
				m.append(t)
		}
		return this
	}, d = function() {
		var e = this, t = this.cache, i = this.config;
		t.clearBtn.click(m.clearClick);
		t.wrap.delegate(i.oneOptionSelect, "click", m.removeClick).delegate(
				i.delBtnSelect, "click", m.delGameClick);
		return this
	}, u = function() {
		this.cache.wrapBody.delegate(this.config.danBtnSelect, "click",
				m.danSel);
		return this
	}, m = {}, p = {
		danSel : function(e) {
			var i = t(e.currentTarget), n = i.parents("[matchcode]").attr(
					"matchcode"), a = this.cache.selectGameInfo, o = this.config;
			if (i.hasClass(o.danDisabledCls))
				return;
			if (a[n])
				if (!i.hasClass(o.danActiveCls)) {
					i.attr("checked", "checked").addClass(o.danActiveCls);
					a[n].isDan = true
				} else {
					i.attr("checked", "").removeClass(o.danActiveCls);
					a[n].isDan = false
				}
			this.callEvent("onChangeDan")
		},
		clearClick : function(e) {
			this.clear();
			e.preventDefault()
		},
		removeClick : function(e) {
			var i = t(e.currentTarget), n = i.attr("matchCode"), a = i
					.attr("gameType"), o = i.attr("index"), s = this.cache.selectGameInfo[n];
			o = +o;
			if (!n || o < 0 || !s || !a)
				return;
			this.removeOption(n, a, o, s.matchnumcn, s.hostName, s.guestName,
					s.score)
		},
		delGameClick : function(e) {
			var i = t(e.currentTarget), n = i.parents("tr[matchCode]").attr(
					"matchCode");
			this.del(n)
		}
	}
}(Core, jQuery, Game, window);
!function(e, t, i, n, a) {
	"use strict";
	i
			.regBaseCom2Lib(
					"COMS.JC.BetMethod",
					"onMethodChange onTabChange onBeforeDestory",
					{
						config : {
							wrapSelector : "#poolStep2",
							wrapTitleSelect : ".guoguanTab li[methodtype]",
							wrapContentSelect : ".guoguanList[methodtype]",
							activeTitle : "active",
							checkSelect : ".icoFx[data-method]",
							radioSelect : ".icoDx[data-method]",
							checkAactive : "icoFx_active",
							checkDisabled : "icoFx_disable",
							radioActive : "icoDx_active",
							radioDisabled : "icoDx_disable",
							method : null,
							methodType : null,
							methodTmp : {
								m_1 : '<li inf="{4}" class="jtip"><i class="icoFx {3}" value="{0}" data-method="{0}"></i>{1}</li>',
								m_n : '<li inf="{4}" class="jtip"><i class="icoDx {3}" value="{0}" data-method="{0}"></i>{1}</li>'
							},
							serialize : null
						},
						init : function(e) {
							var n, a, l, h = this, f = /(\S+)Selector$/;
							this.config = t.extend({}, this.config, e);
							n = this.config;
							a = {
								wrap : null,
								wrapTitle : null,
								wrapContent : null,
								selectMethod : [],
								currentMethod : [],
								activeTab : null
							};
							this.cache = a;
							for ( var d in n)
								if ("string" == i.getType(d) && f.test(d))
									a[RegExp.$1] = t(n[d]);
							if (!a.wrap || !a.wrap.length) {
								alert("BetMethod组件初始化错误，容器加载有误");
								return this
							}
							a.wrapTitle = a.wrap.find(n.wrapTitleSelect);
							a.wrapContent = a.wrap.find(n.wrapContentSelect);
							if (!a.wrapTitle.length || !a.wrapContent) {
								alert("BetMethod组件初始化错误，容器加载有误");
								return this
							}
							if (!n.method) {
								alert("BetMethod组件初始化错误，method必须配置");
								return this
							}
							if (!n.methodType && !n.methodType.length)
								alert("BetMethod组件初始化错误，methodType必须配置");
							for (l = 0; l < n.methodType.length; l++)
								if (!n.methodType[l].length)
									alert("methodType组件初始化错误，methodType配置错误");
								else
									i.sortNum(n.methodType[l]);
							c = {};
							t.each(r, function(e) {
								c[e] = t.proxy(r[e], h)
							});
							o.call(this);
							s.call(this);
							return this
						},
						get : function() {
							return {
								selectMethod : this.cache.selectMethod.slice(0),
								currentMethod : this.cache.currentMethod
										.slice(0)
							}
						},
						changeMethod : function(e, n) {
							var a = this.cache, o = this.config, s, c, r, l = o.method, h = o.methodType
									|| {}, f = o.methodTmp, d = a.selectMethod, u = [], m = [], p = {
								m_1 : [],
								m_n : []
							}, g;
							e = +e;
							n = +n || 1;
							if (e >= 0) {
								for (s in l)
									for (r = 0; r < l[s].length; r++) {
										c = +l[s][r].split("_")[0];
										if (c <= e && c >= n) {
											g = "至少猜中"
													+ h[l[s][r]][h[l[s][r]].length - 1]
													+ "场可中奖" || "";
											m.push(l[s][r]);
											if (i.indexOf(d, l[s][r]) > -1) {
												u.push(l[s][r]);
												p[s]
														.push(t
																.format(
																		f[s],
																		[
																				l[s][r],
																				l[s][r]
																						.replace(
																								/^1_1$/,
																								"单关")
																						.replace(
																								"_",
																								"串"),
																				'checked="checked"',
																				"m_1" === s ? o.checkAactive
																						: o.radioActive,
																				g ]))
											} else
												p[s].push(t.format(f[s], [
														l[s][r],
														l[s][r].replace(
																/^1_1$/, "单关")
																.replace("_",
																		"串"),
														"", "", g ]))
										}
									}
								a.wrapContent.filter('[methodtype="m_1"]')
										.html(p["m_1"].join(""));
								a.wrapContent.filter('[methodtype="m_n"]')
										.html(p["m_n"].join(""));
								var v = a.selectMethod, C = a.currentMethod, y = false;
								a.selectMethod = u;
								a.currentMethod = m;
								y = v.join(" ") !== u.join(" ")
										|| C.join(" ") !== m.join(" ");
								if (y)
									this.callEvent("onMethodChange",
											a.selectMethod)
							}
							return this
						},
						setDisabledMethod : function(e) {
							var n = this, o, s = this.config, c = this.cache, r = function(
									e, r, l) {
								var h = t(this), f = "m_1" == l ? s.checkDisabled
										: s.radioDisabled, d = "m_1" == l ? s.checkAactive
										: s.radioActive;
								if (e != a)
									if (true === e) {
										h.attr("checked", "").attr("disabled",
												"disabled").removeClass(d)
												.addClass(f);
										o = i.indexOf(c.selectMethod, r);
										if (o > -1) {
											c.selectMethod.splice(o, 1);
											n.callEvent("onMethodChange",
													c.selectMethod)
										}
									} else
										h.attr("disabled", "").removeClass(f)
							};
							if ("object" == i.getType(e)) {
								c.wrapContent.find(s.checkSelect).each(
										function() {
											var t = this.getAttribute("value")
													|| this.value;
											r.call(this, e[t], t, "m_1")
										});
								c.wrapContent.find(s.radioSelect).each(
										function() {
											var t = this.getAttribute("value")
													|| this.value;
											r.call(this, e[t], t, "m_n")
										})
							}
							if ("boolean" == i.getType(e)) {
								c.wrapContent.find(s.checkSelect).each(
										function() {
											var t = this.getAttribute("value")
													|| this.value;
											r.call(this, e, t, "m_1")
										});
								c.wrapContent.find(s.radioSelect).each(
										function() {
											var t = this.getAttribute("value")
													|| this.value;
											r.call(this, e, t, "m_n")
										})
							}
							return this
						},
						setActiveTab : function(e) {
							var t = this.config, i = this.cache, n;
							if ("m_1" == e || "m_n" == e)
								n = e;
							else
								n = 1 == e ? "m_n" : "m_1";
							if (n == this.cache.currentType)
								return this;
							i.wrapContent.css("display", "none").filter(
									'[methodtype="' + n + '"]').css("display",
									"");
							i.wrapContent.filter('[methodtype="m_1"]').find(
									t.checkSelect).removeClass(t.checkAactive)
									.removeClass(t.checkDisabled);
							i.wrapContent.filter('[methodtype="m_n"]').find(
									t.radioSelect).removeClass(t.radioActive)
									.removeClass(t.radioDisabled);
							i.wrapTitle.removeClass(t.activeTitle).filter(
									'[methodtype="' + n + '"]').addClass(
									t.activeTitle);
							i.selectMethod = [];
							this.cache.currentType = n;
							this.callEvent("onTabChange", e);
							this.callEvent("onMethodChange", i.selectMethod);
							return this
						},
						serialize : function() {
							var e = this.config, i = this.cache, n = e.serialize;
							if (t.isFunction(n))
								return n(i.selectMethod);
							else
								return i.selectMethod.join(",")
						},
						setMethod : function(e) {
							var n = this, a = this.cache, o = this.config, s = [];
							if ("array" != i.getType(e))
								return this;
							e = e.slice(0);
							a.wrapContent.filter('[methodtype="m_1"]').find(
									o.checkSelect).each(
									function() {
										var n = t(this), a = n.attr("value")
												|| this.value;
										if (i.indexOf(e, a) > -1) {
											n.addClass(o.checkAactive)
													.removeClass(
															o.checkDisabled)
													.attr("check", "checked");
											s.push(a)
										} else
											n.removeClass(o.checkAactive)
													.removeClass(
															o.checkDisabled)
													.attr("check", "")
									});
							a.wrapContent.filter('[methodtype="m_n"]').find(
									o.radioSelect).each(
									function() {
										var n = t(this), a = n.attr("value")
												|| this.value;
										if (i.indexOf(e, a) > -1) {
											n.addClass(o.radioActive)
													.removeClass(
															o.radioDisabled)
													.attr("check", "checked");
											s.push(a)
										} else
											n.removeClass(o.radioActive)
													.removeClass(
															o.radioDisabled)
													.attr("check", "")
									});
							a.selectMethod = s;
							this.callEvent("onMethodChange", a.selectMethod);
							return this
						},
						destory : function() {
							if (false === this.callEvent("onBeforeDestory"))
								return false;
							var e = this.cache, i = this, n = this.config;
							this.changeMethod(0);
							e.selectMethod = [];
							e.currentMethod = [];
							e.activeTab = null;
							e.wrap.undelegate(n.wrapTitleSelect, "click",
									c.changeTab);
							e.wrapContent.undelegate("li", "click",
									c.methodClick).each(function() {
								t(this).html("")
							});
							var a = [ "onMethodChange", "onTabChange",
									"onBeforeDestory" ];
							t.each(a, function(e, t) {
								i.unbind(t)
							})
						},
						show : function() {
							thia.cache.wrap.show()
						},
						hide : function() {
							thia.cache.wrap.hide()
						}
					});
	var o = function() {
		var e = this, t = this.config, i = this.cache;
		i.wrap.delegate(t.wrapTitleSelect, "click", c.changeTab);
		return this
	}, s = function() {
		var e = this, t = this.cache;
		t.wrapContent.delegate("li", "click", c.methodClick);
		return this
	}, c = {}, r = {
		changeTab : function(e) {
			this.setActiveTab(e.currentTarget.getAttribute("methodtype"))
		},
		methodClick : function(e) {
			var i = t(e.currentTarget), n = this.config, a = [], o, s = this.cache, c = i
					.find(n.radioSelect), r = i.find(n.checkSelect);
			if (r.length && !r.hasClass(n.checkDisabled)) {
				r.toggleClass(n.checkAactive);
				s.wrapContent.find(n.checkSelect).each(
						function() {
							var e = t(this);
							if (e.hasClass(n.checkAactive)
									|| e.hasClass(n.radioActive)) {
								o = this.getAttribute("value") || this.value;
								a.push(o)
							}
						});
				s.selectMethod = a;
				this.callEvent("onMethodChange", s.selectMethod)
			}
			if (c.length && !c.hasClass(n.radioDisabled)
					&& !c.hasClass(n.radioActive)) {
				s.wrapContent.find(n.radioSelect).each(function() {
					var e = t(this);
					if (e.hasClass(n.radioActive)) {
						e.removeClass(n.radioActive);
						return false
					}
				});
				c.addClass(n.radioActive);
				s.selectMethod = [ c.attr("value") || c.val() ];
				this.callEvent("onMethodChange", s.selectMethod)
			}
		}
	}
}(Core, jQuery, Game, window);
!function(e, t, i, n, a) {
	var o = i
			.regBaseCom2Lib(
					"COMS.JC.iNumber",
					"onChange",
					{
						config : {
							wrap : "",
							addSelector : ".add",
							reduceSelector : ".subtract",
							addDisCss : "addDisable",
							addDownCss : "addDown",
							reduceDisCss : "subtractDisable",
							reduceDownCss : "subtractDown",
							min : 1,
							max : 99999,
							step : 1,
							editable : true
						},
						init : function(n) {
							var a = i.getType(n), o = this;
							switch (a) {
							case "string":
							case "element":
								this.config = t.extend({}, this.config, {
									wrap : n
								});
								break;
							case "object":
								if (n.jquery) {
									this.config = t.extend({}, this.config, {
										wrap : n
									});
									break
								}
								this.config = t
										.extend({}, this.config, n || {});
								break;
							default:
								return
							}
							var s = t(this.config.wrap);
							if (!s[0]) {
								alert("数字容器设置错误，初始化失败！", "num001");
								return
							}
							this.cache = {
								wrap : s,
								input : s.find("input"),
								add : s.find(this.config.addSelector)
										.disableDrag(),
								reduce : s.find(this.config.reduceSelector)
										.disableDrag()
							};
							this.cache.input.val(this.get());
							this.__initCtrl(this.config.addSelector,
									+o.config.step, this.config.addDownCss)
									.__initCtrl(this.config.reduceSelector,
											-o.config.step,
											this.config.reduceDownCss);
							if (this.config.editable)
								e
										.loadCdnJS(
												"js2/liveCheck.js",
												function() {
													return !!t.fn.bindLiveCheck
												},
												function() {
													o.cache.input
															.bindLiveCheck(
																	/\D/g,
																	function() {
																		var e = o
																				.get(true), t = this.value;
																		if (e
																				+ "" != t
																				&& t)
																			this.value = e;
																		t
																				&& o
																						.callEvent(
																								200,
																								"onChange",
																								+t)
																	})
															.blur(
																	function() {
																		o
																				.set(this.value)
																	})
															.disableIME()
												});
							else
								this.cache.input.attr("readonly", "readonly");
							o.onChange(o.__checkCtrl);
							o.__checkCtrl()
						},
						__initCtrl : function(e, i, a) {
							var o = function() {
								this.ctimer && n.clearTimeout(this.ctimer);
								this.stimer && n.clearInterval(this.stimer)
							}, s = this;
							this.cache.wrap.delegate(e, "click", function(e) {
								o.call(this);
								return s.__ctrlClick(this, e, i)
							}).delegate(e, "mousedown", function(e) {
								var t = this;
								this.ctimer = n.setTimeout(function() {
									t.stimer = n.setInterval(function() {
										s.__ctrlClick(t, e, i)
									}, 150)
								}, 400)
							}).delegate(e, "mouseleave", function(e) {
								o.call(this)
							});
							if (t.fn.setControlEffect && a)
								this.cache.wrap.find(e).setControlEffect(a);
							return this
						},
						__ctrlClick : function(e, i, n) {
							if (t(e).hasClass("disabled"))
								return;
							this.set(this.get() + n)
						},
						__convert : function(e, t) {
							var i = (e + "").replace(/\D/g, ""), n = this.config.min, a = this.config.max, o;
							if (!i.length)
								i = n;
							o = +i;
							if (t)
								o = o > a ? a : o;
							else
								o = o < n ? n : o > a ? a : o;
							return o
						},
						__checkCtrl : function() {
							var e = this.config, t = e.min, i = e.max, n = this
									.get();
							this.cache.add[i == n ? "addClass" : "removeClass"]
									(e.addDisCss);
							this.cache.reduce[t == n ? "addClass"
									: "removeClass"](e.reduceDisCss)
						},
						get : function(e) {
							return this.__convert(this.cache.input[0].value, e)
						},
						set : function(e) {
							var t = this.__convert(e), i = this.cache.input[0];
							if (t + "" != i.value) {
								i.value = t;
								this.callEvent("onChange", t)
							}
							return this
						},
						hide : function() {
							this.config.wrap.hide();
							return this
						},
						show : function() {
							this.config.wrap.show();
							this.onChange();
							return this
						},
						updateConfig : function(e) {
							t.extend(this.config, e);
							this.set(this.get()).__checkCtrl()
						}
					})
}(Core, jQuery, Game, window);