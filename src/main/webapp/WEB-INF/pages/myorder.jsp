<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<link rel="stylesheet" href="css/myLott.css">

<article class="docBody clearfix">

  <aside class="sider">
    <div class="sider_con">
      <div class="wybInfor">
        <div class="userName"> 
        	<strong class="fs14">用户名 ：${users.username }</strong>
          	<strong class="fs14">电话号码 ：${users.tel }</strong>
          	<strong class="fs14">邮箱 ：${users.email } </strong>
        </div>
       
      </div>
      <ul class="leftManu">
        <li class="active"><a target="_self" onclick="showOrder()">我的订单</a><i>&gt;</i></li>  
        <li class="active"><a target="_self" onclick="showInfo()">个人信息</a><i>&gt;</i></li>        
      </ul>
     
    </div>
  </aside>
  <div id="myOd" class="rightModule" style="display:block;">
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
  
  
  
  <div id="myIf" class="rightModule" style="display:none;">
    <ul class="redTab">
      <li class="active"><a target="_self" href="">个人信息</a></li>
     
    </ul>
    <div class="orderDataBox grayBorder"> 
        <div  id="userInfo">
      		用户名 ：${users.username }<br/>
          	电话号码 ：${users.tel }<br/>
          	邮箱 ：${users.email }<br/>
      	</div>
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

<%@ include file="../../bottom.jsp" %>