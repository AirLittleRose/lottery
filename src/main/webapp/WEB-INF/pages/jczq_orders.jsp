<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	$(function(){
		theBonus();
		setTimeout(gopage(1),200);
		
	});
	
	function theBonus(){
		$.ajax({
			type:"POST",
			url:"user/toCalculateBonus.action"
		});

	}
	
	function gopage( pages ){
		findJczqOrder(pages);
	}
	
	
	function findJczqOrder(pages){
		$.ajax({
			type:"POST",
			url:"findJczqOrder.action",
			data:"pages="+pages+"&pagesize=5",
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					$("#awardInfoBody").html("");
					
					$("#headSize").html("");
					$("#headSize").html("<col width='8%'><col width='15%'><col width='25%'><col width='20%'> <col width='20%'><col width='12%'>");
					
					$("#infoHead").html("");
					var head = "<tr><th>彩种</th><th>购彩时间</th><th>订单号</th><th>过关方式</th><th>最后开奖时间</th><th>已获奖金(元)</th></tr>";
					
					$("#infoHead").html(head);
					var str = ""
					$(data.rows).each(
							function(index,item){ 
								str += "<tr><td>竞彩足球</td>"
									+"<td>"+ item.buy_time.substring(0,19) +"</td>"
									+"<td><a href='user/findDetailByOrderId.action?order_id=" + item.order_id + "'>"+ item.order_id +"</a></td>"
									+"<td>"+ item.guoguan_type +"串1</td>"
									+"<td>"+ addDate(item.last_time.substring(0,10),1) +"</td>"
									+"<td>"+ item.bonus +"</td>";
							});
					$("#awardInfoBody").html(str);
					$.createPageBar( data,"pagebardiv" );
					
				}else{
					alert("查询失败！原因"+data.msg);
				}
			}
		});

	}
	
	function addDate(date,add){
		var s = date;
		s = s.replace(/-/g,"/");
		var d = new Date(s);
		d.setDate(d.getDate() + add);
		var m = d.getMonth() + 1;
		return d.getFullYear() + '-' + m + '-' + d.getDate();
	}
</script>
<body>
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
</body>