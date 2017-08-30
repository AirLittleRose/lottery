!
function(e, t, i, o, n) {
	"use strict";
	var l = e.Common,
	a = e.EleConfig,
	c = e.Helper,
	s = e.Tools;
	e.config = t.extend(e.config || {},
	{
//		detailBoundUrl: null,
//		spURL: "/jc/jcquery_spFtl.html",
//		submitResolutionUrl: "/dgp/preBet.html",
//		groupBuyUrl: "/bet/queryBetType_newgroupBuy.html",
		teamData: {
			rfspf: [["blockWin", "让球胜", "3"], ["blockPing", "让球平", "1"], ["blockFu", "让球负", "0"]],
			spf: [["blockWin", "胜", "3"], ["blockPing", "平", "1"], ["blockFu", "负", "0"]],
			bf: [["blockYel", "1:0", "10"], ["blockYel", "2:0", "20"], ["blockYel", "2:1", "21"], ["blockYel", "3:0", "30"], ["blockYel", "3:1", "31"], ["blockYel", "3:2", "32"], ["blockYel", "4:0", "40"], ["blockYel", "4:1", "41"], ["blockYel", "4:2", "42"], ["blockYel", "5:0", "50"], ["blockYel", "5:1", "51"], ["blockYel", "5:2", "52"], ["blockYel", "胜其他", "90"], ["blockYel", "0:0", "00"], ["blockYel", "1:1", "11"], ["blockYel", "2:2", "22"], ["blockYel", "3:3", "33"], ["blockYel", "平其他", "99"], ["blockYel", "0:1", "01"], ["blockYel", "0:2", "02"], ["blockYel", "1:2", "12"], ["blockYel", "0:3", "03"], ["blockYel", "1:3", "13"], ["blockYel", "2:3", "23"], ["blockYel", "0:4", "04"], ["blockYel", "1:4", "14"], ["blockYel", "2:4", "24"], ["blockYel", "0:5", "05"], ["blockYel", "1:5", "15"], ["blockYel", "2:5", "25"], ["blockYel", "负其他", "09"]],
			zjq: [["blockYel", "0", "0"], ["blockYel", "1", "1"], ["blockYel", "2", "2"], ["blockYel", "3", "3"], ["blockYel", "4", "4"], ["blockYel", "5", "5"], ["blockYel", "6", "6"], ["blockYel", "7+", "7"]],
			bqc: [["blockYel", "胜胜", "33"], ["blockYel", "胜平", "31"], ["blockYel", "胜负", "30"], ["blockYel", "平胜", "13"], ["blockYel", "平平", "11"], ["blockYel", "平负", "10"], ["blockYel", "负胜", "03"], ["blockYel", "负平", "01"], ["blockYel", "负负", "00"]]
		},
		methodType: {
			"1_1": [1],
			"2_1": [2],
			"3_1": [3],
			"4_1": [4],
			"5_1": [5],
			"6_1": [6],
			"7_1": [7],
			"8_1": [8],
			"9_1": [9],
			"10_1": [10],
			"11_1": [11],
			"12_1": [12],
			"13_1": [13],
			"14_1": [14],
			"15_1": [15],
			"2_3": [2, 1],
			"3_3": [2],
			"3_4": [3, 2],
			"3_6": [2, 1],
			"3_7": [3, 2, 1],
			"4_4": [3],
			"4_5": [4, 3],
			"4_6": [2],
			"4_10": [2, 1],
			"4_11": [4, 3, 2],
			"4_14": [3, 2, 1],
			"4_15": [4, 3, 2, 1],
			"5_5": [4],
			"5_6": [5, 4],
			"5_10": [2],
			"5_15": [2, 1],
			"5_16": [5, 4, 3],
			"5_20": [3, 2],
			"5_25": [3, 2, 1],
			"5_26": [5, 4, 3, 2],
			"5_30": [4, 3, 2, 1],
			"5_31": [5, 4, 3, 2, 1],
			"6_6": [5],
			"6_7": [5, 6],
			"6_15": [2],
			"6_20": [3],
			"6_21": [2, 1],
			"6_22": [6, 5, 4],
			"6_35": [3, 2],
			"6_41": [3, 2, 1],
			"6_42": [6, 5, 4, 3],
			"6_50": [4, 3, 2],
			"6_56": [4, 3, 2, 1],
			"6_57": [6, 5, 4, 3, 2],
			"6_62": [5, 4, 3, 2, 1],
			"6_63": [6, 5, 4, 3, 2, 1],
			"7_7": [6],
			"7_8": [7, 6],
			"7_21": [5],
			"7_35": [4],
			"7_120": [7, 6, 5, 4, 3, 2],
			"7_127": [7, 6, 5, 4, 3, 2, 1],
			"8_8": [7],
			"8_9": [8, 7],
			"8_28": [6],
			"8_56": [5],
			"8_70": [4],
			"8_247": [8, 7, 6, 5, 4, 3, 2],
			"8_255": [8, 7, 6, 5, 4, 3, 2, 1]
		},
		selectOptionTmp: '<a index="{0}" gameType={1} matchcode={2} href="javascript:;" class="{3}">{4}</a>',
		gameTypes: ["rfspf", "spf", "bf", "zjq", "bqc"],
		playType: "spfdgp",
		dataDanalysisTmp: '<dd style="" class="analyTab clearfix"></dd>',
		activityType: "",
		submitBtnSelector: "#poolStep3 .tjfaBtn",
		openDetailBonusSelector: "#openDetailBonus"
	});
	t.extend(e, {
		cache: {},
		quickInit: function() {
			a.init();
			var e = this.config,
			o = this.cache,
			n = /(\S+)Selector$/;
			for (var l in e) if ("string" == i.getType(l) && n.test(l)) o[RegExp.$1] = t(e[l]);
			this.initBetArea().initPoolArea().initMethodArea().initBetTimes()
		},
		myInit: function() {
			l.init();
			this.initSubmitBtn();
			e.cache.floatBox.find(".unSeleTips").html("请在左侧列表选择投注比赛")
		},
		initBetTimes: function() {
			var e = this;
			this.betTime = i.createCom("COMS.JC.iNumber", {
				wrap: "#betTimes",
				min: 5,
				max: +e.config.maxBetTimes || 5e5
			});
			this.betTime.onChange(function(t) {
				e.updateGameInfo()
			});
			return this
		},
		initBetArea: function() {
			var e = this,
			t;
			t = i.createCom("COMS.JC.BetArea", {
				oneOptionSelect: "em[index][gametype], td[index][gametype]",
				gameTypes: e.config.gameTypes,
				gameId: e.cache.gameId.val(),
				attentionGameWrapSelect: ".attentionInner",
				unAttentionGameWrapSelect: ".unAttention",
				attentionTitSelector: ".attentionTit",
				attentionMenuSelector: ".attentionMenu"
			});
			t.extend(r).extend({
				initMoreData: l.initMoreData
			}).initMoreData().reloadSp().onDel(function(t) {
				e.betPool.del(t)
			}).onSelectOption(function(t, i, o, n, l) {
				var a = this.cache.gameInfo,
				c = a[t];
				if (!c) return;
				e.betPool.selectOption(t, i, o, n, c.matchnumcn, c.hostName, c.guestName, c.score)
			}).onRemoveOption(function(t, i, o, n) {
				var l = this.cache.gameInfo,
				a = l[t];
				if (!a) return;
				e.betPool.removeOption(t, i, o, a.matchnumcn, a.hostName, a.guestName, a.score)
			}).onClear(function() {
				e.betPool.clear()
			});
			this.betArea = t;
			return this
		},
		initPoolArea: function() {
			var e = this,
			o = i.createCom("COMS.JC.BetPool", {
				teamData: e.config.teamData,
				gameTypes: e.config.gameTypes,
				isDan: false
			});
			if (! (t.browser.msie && +t.browser.version < 7)) o.scrollBar = s.initScrollBar(e.cache.scrollPoolPane);
			o.onChange(function(t, i, o, n) {
				var a, s = this.get();
				if (s.length) {
					e.cache.poolStep1.addClass("select").removeClass("unselect");
					e.cache.poolStep2.addClass("select").removeClass("unselect");
					e.cache.poolStep3.addClass("select").removeClass("unselect")
				} else {
					e.cache.poolStep1.removeClass("select").addClass("unselect");
					e.cache.poolStep2.addClass("unselect").removeClass("select");
					e.cache.poolStep3.addClass("unselect").removeClass("select")
				}
				e.updateGameInfo();
				c.messageTip();
				l.reSetRightSideHeight && l.reSetRightSideHeight();
				c.moveOptionAnimation(t, i, o, n)
			}).onRemoveOption(function(t, i, o, n, l) {
				e.betArea.removeOption(t, i, o)
			}).onClear(function() {
				e.betArea.clear();
				var t = e.cache
			}).onDel(function(t) {
				e.betArea.del(t)
			}).onChangeDan(function() {
				e.dan();
				e.updateGameInfo()
			});
			this.betPool = o;
			return this
		},
		initMethodArea: function() {
			this.betMethod = {
				get: function() {
					return {
						currentMethod: ["1_1"],
						selectMethod: ["1_1"]
					}
				},
				serialize: function() {
					return "1_1"
				}
			};
			return this
		},
		updateGameInfo: function() {
			var e, t = this,
			i = this.cache,
			o = this.betMethod,
			n = this.betPool,
			l = o.get().selectMethod,
			a = n.get(),
			c = t.config.methodType,
			s = n.config.gameTypes,
			r = n.config.teamData,
			u = i.gameZhu,
			h = i.totalMoney,
			m = i.betTimes,
			f = this.betTime.get(),
			p = i.maxbonus,
			b = 0;
			e = this.getTotalNum(l, a, c, s);
			i.gameNumber.html(a.length || 0);
			b = e[0] || 0;
			u.html(b);
			h.html((2 * b * f).toFixed(2));
			p.html(this.calcMaxBonus())
		},
		baseCheck: function() {
			var e = this.cache,
			o = this.betArea,
			n = this.betPool,
			l = this.betMethod,
			a = e.gameZhu;
			if (!t("#orderRule i.icoFx").hasClass("icoFx_active")) {
				i.alert("请先阅读并同意《委托投注规则》后才能继续");
				return false
			}
			if (! (n.get().length > 0)) {
				c.messageTip("请在左侧列表选择投注比赛");
				return false
			}
			if (!l.get().selectMethod.length) {
				c.messageTip('请选择过关方式&nbsp;&nbsp;<i inf="N串1，即将N场比赛串联成一注，猜对N场即可中奖" class="questionMark jtip"></i>');
				return false
			}
			var s = this.betTime.get();
			if (!s) {
				c.messageTip("方案倍数不正确");
				return false
			}
			if (s < 5) {
				c.messageTip("方案倍数至少选择5倍");
				return false
			}
			return true
		},
		calcMaxBonus: function() {
			var e = this.betPool.get();
			var t = this.betTime.get();
			if (e.length < 1 || t < 5) return 0;
			var i = 0;
			var o = 1 / 0;
			var n = .89;
			var l = 0;
			this.__each(e,
			function(e, t) {
				var n = 0;
				var a = 1 / 0;
				this.__each(t.sp.spf,
				function(e, t) {
					l++;
					if (t > n) n = t;
					if (t < a) a = t
				});
				i += n;
				o = o < a ? o: a
			});
			i = (2 * i * n * t).toFixed(2);
			o = (2 * o * n * t).toFixed(2);
			if (l > 1 && i != o) return o + " - " + i;
			return i
		},
		initSubmitBtn: function() {
			var e = this;
			this.cache.submitBtn.click(function() {
				return e.submitResolution()
			});
			this.cache.openDetailBonus.click(function() {
				return e.submitResolution()
			})
		},
		submitResolution: function() {
			if (!this.baseCheck()) return false;
			var e, t, o, n;
			e = this.betTime.get();
			if (e > 5e5) {
				i.alert("请选择500000注以下进行投注");
				return false
			}
			n = +this.cache.gameZhu.text();
			var l = {
				gameId: this.cache.gameId.val(),
				primaryStakeNumber: this.betPool.serialize(),
				primaryBetTimes: e,
				primaryGameExtra: "2_1",
				primaryIsSupportPassWay: "1",
				primarySchemeAmount: 2 * n * e + "",
				totalAmount: 2 * n * e + ""
			};
			this.postByForm(this.config.submitResolutionUrl, l, true);
			return false
		},
		postByForm: function(e, t, i) {
			var o = document.createElement("form");
			o.target = i ? "_blank": "_self";
			o.action = e;
			o.method = "GET";
			this.__each(t,
			function(e, t) {
				var i = document.createElement("input");
				i.type = "hidden";
				i.name = e;
				i.value = t;
				o.appendChild(i)
			});
			document.body.appendChild(o);
			o.submit();
			i && setTimeout(function() {
				document.body.removeChild(o);
				o = null
			},
			1e3)
		},
		__each: function(e, t) {
			if ("function" !== typeof t) return;
			for (var i in e) if (e.hasOwnProperty(i) && "length" !== i) t.call(this, i, e[i])
		}
	});
	var r = {
		reloadSp: function() {
			var t = [],
			i = e.config,
			n = this,
			l = this.cache.gameInfo,
			a = e.cache.gameId.val(),
			c = "jczqspfmixp",
			s = i.spURL;
			if (!i.spURL) return this;
			for (var r in l) if (!l[r].isStop) t.push(r);
			t = t.toString();
			var u = function() {
				e.post(s, {
					no: t,
					gameId: a,
					playType: c
				},
				function(e, t) {
					if (e) return;
					try {
						t = t.split("&");
						var i, o, n, l;
						n = t[0];
						l = t[1];
						n = n.split("|");
						l = l.split("|");
						h("spf", n);
						h("rfspf", l)
					} catch(a) {}
				})
			},
			h = function(e, t) {
				var i = 0,
				o, n, a, c, s, r, u, h, m, f, p;
				for (i = 0; i < t.length; i++) {
					o = t[i];
					o = o || "";
					o = o.split(":");
					if (2 == o.length) {
						h = o[0];
						n = o[1].split(",");
						a = n.slice(3);
						n = n.slice(0, 3);
						if (!l[h] || l[h].isStop) continue;
						c = l[h].optionMap;
						r = c[e];
						if (r) for (s = 0; s < n.length; s++) if (r[s]) {
							u = r[s];
							m = u.attr("index"),
							f = u.attr("sp"),
							p = +n[m];
							if ("--" == p) {
								l[h].ele.attr("isStop", "1");
								l[h].isStop = true
							} else if (p && f && "undefined" != typeof a[m]) {
								u = u.eq(0);
								if ("3" == a[m]) {
									u.html(n[m] + '<i class="c_e24949">↑</i>');
									u.attr("sp", n[m])
								} else if ("0" == a[m]) {
									u.html(n[m] + '<i class="c_090">↓</i>');
									u.attr("sp", n[m])
								}
							}
						}
					}
				}
			};
			o.setTimeout(function() {
				u()
			},
			1e3);
			o.setInterval(function() {
				u()
			},
			21e4);
			return this
		}
	}
} (Core, jQuery, Game, window);