<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>
<script src="js/pageBar.js"></script>
<script>

</script>
<style>
table{
	border-style: dotted;
	border-color: #ED2240;
	border-width: 3px;
	overflow:hidden
}
tr{
	height: 40px;
}
tr:hover {
	background-color: #fecaad;
}

</style>

<article class="docBody clearfix" style="background-color: #fff;border:1px solid #d3d3d3" >

<div style="margin-left: 50px;margin-bottom: 50px;" id="">
	<div style="margin-left: 350px;margin-top: 50px;margin-bottom: 20px;">
		<p style="line-height:52px;font-family:华文新魏;font-size:40px;color: #ED2240;">购买成功！！！</p>
		<p style="font-size:12px;">
			<a href="soccer.jsp">继续购买</a>&emsp;&emsp;&emsp;
			<a href="#">查看所有订单</a>	
		</p>
		
	</div>
	
	<table id="ownerRanks" class="ranking_table" style="width: 600px;font-size:22px;font-family:华文新魏;">
		<tbody id="buyInfo">
		
			<tr bgcolor="f7f7f7">
								
				<th>&emsp;&emsp;&emsp;
				您好，${users.username}，您的"竞彩足球"订单信息如下：</th>
				
				
			</tr>
			
			<tr>
				
				<td>&emsp;&emsp;&emsp;
				订单号 ：
				${jczq_order.order_id}</td>
				
				
			</tr>
			
			<tr bgcolor="f7f7f7">
				
				<td>&emsp;&emsp;&emsp;
				订购时间 ：
				${jczq_order.buy_time}</td>
				
				
			</tr>
			

			
			<tr>
				
				<td>&emsp;&emsp;&emsp;
				过关类型 ：
				${jczq_order.guoguan_type}串1</td>
				
				
			</tr>
			
			<tr bgcolor="f7f7f7">
				
				<td>&emsp;&emsp;&emsp;
				过关场数：
				${info.num}场</td>
				
				
			</tr>
			
			<tr>
				
				<td>&emsp;&emsp;&emsp;
				总金额：
				${jczq_order.amount}元</td>
				
				
			</tr>

		</tbody>
	</table>
	
</div>
</article>

<%@ include file="../../bottom.jsp" %>