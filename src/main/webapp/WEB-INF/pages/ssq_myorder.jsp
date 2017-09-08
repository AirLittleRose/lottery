<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="css/myLott.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/pageBar.js"></script>
<script type="text/javascript">

	
	$(function(){
		gopage(1);
	});
	
	function gopage( pages ){
		findAwardInfo(pages);
	}
	
	function findAwardInfo(pages){
		var winStatus = $('#winStatus option:selected').val();
		var winOrder = $('#winOrder option:selected').val();
		$.ajax({
			type:"POST",
			url:"user/findAwardInfo.action",
			data:"pages="+pages+"&pagesize=5"+"&winStatus="+winStatus+"&winOrder="+winOrder,
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					$("#awardInfoBody").html("");
					
					$(data.rows).each(
							function(index,item){  
					//for(var i = 0;i<data.obj.length;i++){  var item=data.obj[i]; }
								var ordertime = (item.ordertime).substring(0,19);
								var str = "  <tr ><td>双色球</td>"+
									"<td>"+item.ssq_issue +"</td>"+
									"<td>"+ordertime +"</td>"+
									"<td>"+item.orderid +"</td>"+
									"<td>"+item.redball +" | "+item.blueball +"</td>"+
						          	"<td>"+item.multinum +"</td>";
						        if(item.status==1){
						        	str+="<td>已开奖</td>";
						        	    if(item.grade==null){
								        	str+="<td>未中奖</td>";
								        }else{
								        	str+="<td>"+item.grade +"等奖</td>"
								        }
								        
								        if(item.award==null){
								        	str+="<td>未中奖</td>";
								        }else{
								        	str+="<td>"+item.award +"</td></tr>";
								        }
						        }else{
						        	str+="<td>未开奖</td>";
						        	str+="<td>未开奖</td>";
						        	str+="<td>未开奖</td>";
						        }
						        
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
    
<div class="selectBox clearfix">
        
        <select class="text" name="winStatus" id="winStatus">
        	 	<option value="0" selected="selected">未开奖</option>
				<option value="1">已开奖</option>
		</select>
        	
        &nbsp;
        <select class="text" name="winOrder" id="winOrder">
        	 	<option value="0">未中奖订单</option>
				<option value="1" selected="selected">中奖订单</option>
		</select>
       
       <input type="button" value="查询" id="findButton"  href="javascript:void(0)" onclick="gopage(1)"/>
        
      </div>
      <table class="tableData">
        <colgroup id="headSize">
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
        <thead id="infoHead">
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
      