<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<link rel="stylesheet" href="css/myLott.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/pageBar.js"></script>
<script type="text/javascript">
	$(function(){
		gopage(1);
		
	});
	
	function gopage( pages ){
		var checkValue="1";
		$("#lotteryType").change(function(){
			checkValue=$("#lotteryType").val();
			console.log("------v-----   "+checkValue);
		}); 
		if(checkValue=="1"){
			findAwardInfo(pages);
		}
		if(checkValue=="0"){
			console.log("------v-----   "+checkValue);
		}
		
	}
	
	function findAwardInfo(pages){
		$.ajax({
			type:"POST",
			url:"user/findAwardInfo.action",
			data:"pages="+pages+"&pagesize=5",
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					$("#awardInfoBody").html("");
					$(data.rows).each(
							function(index,item){  
					//for(var i = 0;i<data.obj.length;i++){  var item=data.obj[i]; }
						
								var str = "  <tr ><td>双色球</td>"+
									"<td>"+item.ssq_issue +"</td>"+
									"<td>"+item.ordertime +"</td>"+
									"<td>"+item.orderid +"</td>"+
									"<td>"+item.redball +" | "+item.blueball +"</td>"+
						          	"<td>"+item.multinum +"</td>";
						        if(item.status==1){
						        	str+="<td>已开奖</td>";
						        }else{
						        	str+="<td>未开奖</td>";
						        }
								str+="<td>"+item.grade +"等奖</td>"+
									"<td>"+item.award +"</td></tr>";
								$("#awardInfoBody").html($("#awardInfoBody").html()+str);
							});
					$.createPageBar( data,"pagebardiv" );
					
				}else{
					alert("查询失败！原因"+data.msg);
				}
			}
		});

	}
	
</script>

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
				<option value="1" selected="selected">双色球</option>
				<option value="2">足&nbsp;&nbsp;&nbsp;&nbsp;彩</option>
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
        <select class="text" name="winOrder" id="winOrder">
        	 	<option value="0">未中奖订单</option>
				<option value="1" selected="selected">中奖订单</option>
		</select>
       	
        &nbsp;
        <select class="text" name="winStatus" id="winStatus">
        	 	<option value="0">未开奖</option>
				<option value="1" selected="selected">已开奖</option>
		</select>
      </div>
      <table class="tableData">
        <colgroup>
        <col width="8%">
        <col width="8%">
        <col width="15%">
        <col width="20%">
        <col width="20%">
        <col width="5%">
        <col width="8%">
        <col width="8%">
        <col width="12%">
        </colgroup>
        <thead>
        	<tr>
	          	<th style="width:100px">彩种</th>
	          	<th style="width:100px">期号</th>
	            <th>购彩时间</th>
	            <th>订单号</th>
	            <th>订单信息</th>
	            <th>倍数</th>
	            <th>开奖状态</th>
	            <th>中奖等级</th>
	            <th>奖金(元)</th>
	         </tr>
        
        </thead>
        <tbody class="awardInfoBody" id="awardInfoBody">
         
        </tbody>
      </table>
      <div id="pagebardiv"></div>
      
      <!-- <div class="noData_order"> 
      		<i class="ico_book"></i><strong>没有任何订单</strong>
      		</div>
       -->
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