<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<link rel="stylesheet" href="css/myLott.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<style>
tr:hover {
	background-color: #fecaad;
}
</style>
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
        <li class="active"><a target="_self" href="javascript:history.back()">返回</a><i>&gt;</i></li>        
      </ul>
     
    </div>
  </aside>
  <div class="rightModule">
    <ul class="redTab">
      <li class="active"><a target="_self" href="">订单详情</a></li>

    </ul>
    <font size="3px">当前订单号:${order_id }</font>
    <div class="orderDataBox grayBorder" id="orderDataBox">
		<table class="tableData">
	        <colgroup id="headSize">
		        <col width="20%">
		        <col width="10%">
		        <col width="15%">
		        <col width="15%">
		        <col width="10%">
		        <col width="10%">
		        <col width="10%">
		        <col width="10%">
	        </colgroup>
	        <thead id="infoHead">
	        	<tr>
		          	<th>场次</th>
		          	<th>联赛</th>
		            <th>主队</th>
		            <th>客队</th>
		            <th>下注类型</th>
		            <th>赔率</th>
		            <th>倍数</th>
		            <th>结果</th>
		         </tr>
	        
	        </thead>
	        <tbody class="awardInfoBody" id="awardInfoBody">
	        	<c:if test="${detail.code == 1 }">
					<c:forEach items="${detail.rows }" var="v">
						<tr>
							<td>${v.game_id }</td>
							<td>${v.league_name }</td>
							<td>${v.home_name }</td>
							<td>${v.away_name }</td>
							<c:if test="${v.predict == 0 }">
								<td>
									胜
								</td>
							</c:if>
							<c:if test="${v.predict == 1 }">
								<td>
									平
								</td>
							</c:if>
							<c:if test="${v.predict == 2 }">
								<td>
									负
								</td>
							</c:if>
							<td>${v.odds }</td>
							<td>${v.times }</td>
							<c:if test="${v.result == 0 }">
								<td>
									没猜中
								</td>
							</c:if>
							<c:if test="${v.result == 1 }">
								<td>
									已猜中
								</td>
							</c:if>
							<c:if test="${v.result == null }">
								<td>
									未开奖
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</c:if>
	        </tbody>
	      </table>
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