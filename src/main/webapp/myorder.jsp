<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<link rel="stylesheet" href="css/myLott.css">

<article class="docBody clearfix">

  <aside class="sider">
    <div class="sider_con">
      <div class="wybInfor">
        <div class="userName"> 
        	<strong class="fs14">用户名 ：abc</strong>
          	<strong class="fs14">电话号码 ：11112223455</strong>
          	<strong class="fs14">邮箱 ：1234567833@qq.com</strong>
        </div>
       
      </div>
      <ul class="leftManu">
        <li class="active"><a target="_self" href="myorder.html">我的订单</a><i>&gt;</i></li>  
        <li class="active"><a target="_self" href="mylottery.html">个人信息</a><i>&gt;</i></li>        
      </ul>
     
    </div>
  </aside>
  <div class="rightModule">
    <ul class="redTab">
      <li class="active"><a target="_self" href="">投注记录</a></li>
     
    </ul>
    <div class="orderDataBox grayBorder">
      <div class="selectBox clearfix">
       <span class="mcSelectBox btnAuto"> 
        	 <select class="text" name="lotteryType" id="lotteryType">
        	 	<option value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</option>
				<option value="1">双色球</option>
				<option value="2">足&nbsp;&nbsp;&nbsp;&nbsp;彩</option>
				<option value="3">大乐透</option>
			</select>        
        </span> 
       
        <span class="mcSelectBox">
        	 <select class="text" name="issue" id="issue">
        	 	<option value="0">全&nbsp;&nbsp;&nbsp;&nbsp;部</option>
        	 	<c:forEach items="${ssqIssueList }" var="ssq">
        	 		<option value="1">${ssq.ssq_issue }</option>
        	 	</c:forEach>				
			</select>
        </span> 
       
        <input value="" style="margin-left: 20px;" type="checkbox" id="winOrder">
        <label for="winOrder">中奖订单</label>
        &nbsp;
        <input value="" type="checkbox" id="waitOrder">
        <label for="waitOrder">等待开奖</label>
      </div>
      <table class="tableData">
        <colgroup>
        <col width="10%">
        <col width="15%">
        <col width="14%">
        <col width="12%">
        <col width="20%">
        <col width="19%">
        <col>
        </colgroup>
        <tbody>
          <tr>
            <th>时间</th>
            <th>彩种</th>
            <th>订单信息</th>
            <th class="tr">订单金额(元)</th>
            <th>状态</th>
            <th>奖金(元)</th>
            <th>操作</th>
          </tr>
        </tbody>
      </table>
      <div class="noData_order"> <i class="ico_book"></i><strong>没有任何订单</strong> </div>
    </div>
    <section class="grayBorder mt10">
      <h2 class="tit">热门彩种</h2>
      <ul class="clearfix hotLott">
        <li style="background: url(images/ssqt.png) -10px -6px no-repeat;" class="hot_ssq">
         <a style="background-image:url(images/ssqt.png);" id="bgis" href="" target="" title="双色球"> 双色球 </a> 
         <i class="redBtn25">立即投注</i> 
        </li>
        <li class="hot_jczq"> 
        	<a style="background-image:url(images/jczqt.png);" id="bgij" href="" target="" title="竞彩足球"> 竞彩足球<br>
          	</a> 
        <i class="redBtn25">立即投注</i> </li>
      </ul>
    </section>
  </div>
</article>

大家下午好，我是唐爱玲，我来自湖南工学院，很荣幸在这里向大家介绍自己 。
为了即将踏入新生活我蓄力已久，我相信我的专业知识和实践水平可以支撑我走入社会。
夸奖自己的漂亮话谁都会说，谁都希望从公司得到什么，而我更要问自己，作为一名员工，除了和同事相处，完成工作任务以外，我还能为公司做什么？
我觉得，我可以做到以下几点：
第一，学习，我永远不知道在未来等着我的是什么，所以我要不断的充实自己。
二、打开狭隘的视野，站在公司的角度思考，公司希望我怎么做。
三、不求做到最好，但求做到最合适
对于未来的憧憬有很多，我相信我会有事业、有家庭。
到某一天，我只需站在那里，别人会感觉得，看，她是不同的。
漂亮的皮囊千篇一律，有趣的灵魂万里挑一。
古人以铜为镜正衣冠，我愿成为公司的一面铜镜。




<%@ include file="bottom.jsp" %>