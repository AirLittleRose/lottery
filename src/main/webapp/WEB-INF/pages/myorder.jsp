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
		var checkValue=$("#lotteryType").val();
		$("#lotteryType").change(function(){
			checkValue=$("#lotteryType").val();
			if(checkValue=="1"){
				findAwardInfo(pages);
			}
			if(checkValue == "2"){
				findJczqOrder(pages);
			}
		}); 
		if(checkValue=="1"){
			findAwardInfo(pages);
		}
		if(checkValue=="2"){
			findJczqOrder(pages)
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

	function toJczqOrder(){
		$.ajax({
			url : "user/toJczqOrder.action",
			dateType : 'HTML',
			success : function(data) {
				$("#orderDataBox").html(data);
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
        <li class="active"><a target="_self" href="myorder.html">双色球订单</a><i>&gt;</i></li>  
        <li class="active"><a target="_self" href="javascript:void(0)" onclick="toJczqOrder()">竞彩足球订单</a><i>&gt;</i></li>        
      </ul>
     
    </div>
  </aside>
  <div class="rightModule">
    <ul class="redTab">
      <li class="active"><a target="_self" href="">投注记录</a></li>
    </ul>
    <div class="orderDataBox grayBorder" id="orderDataBox">
		
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