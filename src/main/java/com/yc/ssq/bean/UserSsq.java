package com.yc.ssq.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserSsq implements Serializable {

	private static final long serialVersionUID = 4599949797130817104L;
	/*
	--用户投注双色球
	--usid
	--userid
	--单号	orderid		20170406006293714  --》设想 ：date年4月2日2时2分2秒2毫秒4 + 3位随机数
	--投注时间
	 */
	private Integer usid;
	private Integer userid;
	private String username;
	private String orderid;
	private String ordertime;
	private String ssq_issue;
	private Integer status;
	
	private List<BetSsq> betlists;
	private List<String> ssqs = new ArrayList<String>();
	
	public Integer getUsid() {
		return usid;
	}

	public void setUsid(Integer usid) {
		this.usid = usid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getOrderid() {
		
		return orderid;
	}

	public void setOrderid() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String orderdate = sdf.format(new Date());
		int r = (int)(Math.random()*900+100);
		String rand = Integer.toString(r);
		String orderid = orderdate + rand;
		this.orderid = orderid;
	}

	public String getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}

	public List<BetSsq> getBetlists() {
		return betlists;
	}

	public void setBetlists(List<BetSsq> betlists) {
		this.betlists = betlists;
	}

	public List<String> getSsqs() {
		return ssqs;
	}

	public void setSsqs(List<String> ssqs) {
		this.ssqs = ssqs;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getSsq_issue() {
		return ssq_issue;
	}

	public void setSsq_issue() throws Exception {
		this.ssq_issue = this.SsqIssue(new Date());
	}
	
	public void setSsq_issue(String ssq_issue) throws Exception {
		this.ssq_issue = ssq_issue;
	}

	//获取当某个日期的的期号
		public String SsqIssue(Date nowdate) throws Exception{
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String endDay = sdf.format(nowdate);
			
			String startpre = endDay.substring(0, 4);	//0 到 4 不包括 4
			String startDay = startpre+"-01-01";
			//String endDay = "2017-08-26";
			int tues = this.getMondayNumber(startDay, endDay, 2);
			int thus = this.getMondayNumber(startDay, endDay, 4);
			int suns = this.getMondayNumber(startDay, endDay, 0);
			
			int qh =tues+thus+suns;
			
			//每年春节双色球会休市7天，qh-3,可优化
			if( endDay.startsWith("2019") ){
				if( (endDay.compareTo("2019-02-04") )>=0){
					qh = qh-3;
				}
			}
			if( endDay.startsWith("2018") ){
				if( (endDay.compareTo("2018-02-15") )>=0){
					qh = qh-3;
				}
			}
			if( endDay.startsWith("2017") ){
				if( (endDay.compareTo("2017-01-27") )>=0){
					qh = qh-3;
				}
			}
			if( endDay.startsWith("2016") ){
				if( (endDay.compareTo("2016-02-07") )>=0){
					qh = qh-3;
				}
			}
			
			//如果当前天不是 周日，周二，周四，则qh+1
			Calendar endCalendar = Calendar.getInstance();
			endCalendar.setTime(nowdate);
			int endDayOfWeek = endCalendar.get(Calendar.DAY_OF_WEEK)-1;
			if( endDayOfWeek!=0 && endDayOfWeek!=2 && endDayOfWeek!=4 ){
				qh = qh+1;
			}
			
			String qhstring = null;
			if(qh<100){
				qhstring = "0"+qh;
			}else{
				qhstring = Integer.toString(qh);
			}
			String ssq_issue = startpre+qhstring;
			
			return ssq_issue;
		}

		/**
	     * 查询日期间有几天一周中的某一天
	     * 日期格式 yyyy-MM-dd yyyy-MM-dd 1-7(表示周一到周日) 
	     * @param startDay 准备查询的起始日期          
	     * @param endDay 准备查询的结束日期
	     * @param dayOfWeek 准备查的一周中的某一天(准备查周几？)
	     * @return 包含所查周几的天数
	     * @throws ParseException 不支持跨年查询、不支持结束日期早于起始日期、周几输入错误等
	     */
	    public int getMondayNumber(String startDay,String endDay,int dayOfWeek) throws ParseException{
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        int differenceDay = 0;
	        //转换起始日期
	        Date startDate = sdf.parse(startDay);
	        //转换结束日期
	        Date endDate = sdf.parse(endDay); 
	        //实例化起始和结束Calendar对象
	        Calendar startCalendar = Calendar.getInstance();
	        Calendar endCalendar = Calendar.getInstance();
	        //分别设置Calendar对象的时间
	        startCalendar.setTime(startDate);
	        endCalendar.setTime(endDate);

	        //定义起始日期和结束日期分别属于第几周
	        int startWeek = startCalendar.get(Calendar.WEEK_OF_YEAR);
	        int endWeek = endCalendar.get(Calendar.WEEK_OF_YEAR);
	        
	        //拿到起始日期是星期几
	        int startDayOfWeek = startCalendar.get(Calendar.DAY_OF_WEEK)-1;
	        if(startDayOfWeek == 0)    {
	            //startDayOfWeek = 7;
	        }
	        
	        //拿到结束日期是星期几
	        int endDayOfWeek = endCalendar.get(Calendar.DAY_OF_WEEK)-1;
	        if(endDayOfWeek == 0) {
	            //endDayOfWeek = 7;
	        }
	        
	        //计算相差的周数
	        int differenceWeek = endWeek - startWeek;
	        
	        //开始计算
	        if(startDayOfWeek <= dayOfWeek) {
	            if(endDayOfWeek >= dayOfWeek){
	                differenceDay = differenceWeek + 1;
	            }else {
	                differenceDay = differenceWeek;
	            }
	        }
	        if(startDayOfWeek > dayOfWeek) {
	            if(endDayOfWeek < dayOfWeek){
	                differenceDay = differenceWeek-1;
	            }else {
	                differenceDay = differenceWeek;
	            }
	        }
	        return differenceDay;
	    }

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "UserSsq [usid=" + usid + ", userid=" + userid + ", username=" + username + ", orderid=" + orderid
					+ ", ordertime=" + ordertime + ", ssq_issue=" + ssq_issue + ", status=" + status + ", betlists="
					+ betlists + ", ssqs=" + ssqs + "]";
		}
}
