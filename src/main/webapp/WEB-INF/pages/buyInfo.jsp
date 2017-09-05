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
			<a href="ssq.jsp">继续购买</a>&emsp;&emsp;&emsp;
			<a href="user/toMyorder.action">仅显示前五条 → 查看更多请点击</a>			
		</p>
		
	</div>
	
	<table id="ownerRanks" class="ranking_table" style="width: 600px;font-size:22px;font-family:华文新魏;">
		<tbody id="buyInfo">
			<tr bgcolor="f7f7f7">
								
				<th>&emsp;&emsp;&emsp;
				您好，${userssq.username}，您的双色球购买信息如下：</th>
				
				
			</tr>
			<tr>
				
				<td>&emsp;&emsp;&emsp;
				期号 ：
				&emsp;&emsp;&emsp;
				${userssq.ssq_issue}</td>
				
				
			</tr>
			<tr  bgcolor="f7f7f7">
				
				<td>&emsp;&emsp;&emsp;
				订购时间 ：
				&nbsp;&nbsp;&nbsp;&nbsp;
				${userssq.ordertime}</td>
				
				
			</tr>
			<tr>
				<td>&emsp;&emsp;&emsp;
				订单号 ：
				&emsp;&emsp;
				${userssq.orderid}</td>
				
				
			</tr>
			<c:forEach items="${betssqlist }" var="list"  varStatus="status">
				<c:if test="${status.index < 5 }">
					<c:if test="${status.index %2==0 }">
						<tr  bgcolor="f7f7f7">
							
							<td>&emsp;&emsp;&emsp;
								
									<strong class="c_ba2636">${list.redball }</strong>
									|
									<strong class="c_1e50a2">${list.blueball }</strong>
									&ensp;&emsp;
									单注： ${list.sigprice } 元
									   倍数：   ${list.multinum }  
								
							</td>
							
						</tr>
					</c:if>
					<c:if test="${status.index %2!=0 }">
						<tr>
							
							<td>&emsp;&emsp;&emsp;
								
									<strong class="c_ba2636">${list.redball }</strong>
									|
									<strong class="c_1e50a2">${list.blueball }</strong>
									&ensp;&emsp;
									单注： ${list.sigprice } 元
									   倍数：   ${list.multinum }  
								
							</td>
							
						</tr>
					</c:if>
				</c:if>			
			</c:forEach>
		</tbody>
	</table>
	
</div>
</article>
姑娘你要出嫁
离开了你的家
天边的余晖啊
裁一片做头纱
姑娘你要出嫁
明天它太远啊
天边的白云飞
采一朵做白马
灯火茫茫千万家 
柴米油盐酱醋茶
一身红妆你给了他
来日游历夕阳下
举案齐眉梦里花
莫忘往事里有个家

<%@ include file="../../bottom.jsp" %>