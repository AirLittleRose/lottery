<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header_login.jsp"%>
</head>
<body>
	<script type="text/javascript">
	$(function() {
		$.ajax({
			type : "POST",
			url : "find_all_league.action",
			dataType : "JSON",
			success : function(data) {
				if (data.code == 1) {
					$("#league_list").val("");
					$("#league_list").html("<option value='0'>--请选择--</option>")
					$(data.rows).each(
						function(index, item) {
							var str = "<option value='" + item.league_id + "'>" + item.league_name + "</option>";
							$("#league_list").html($("#league_list").html() + str);
						}
					);
				} else {
					$("#league_list").val("");
					var str = "<option>暂无联赛信息</option>"
					$("#league_list").html(str);
				}
			}
		})
		
		$("#league_list").change(function(){
			 var selectId = $('#league_list>option:selected').val();
			 $.ajax({
					type : "GET",
					url : "findGames.action?league_id=" + selectId,
					dataType : "JSON",
					success : function(data) {
						if (data.code == 1) {
							$("#gamesLi").val();
							$(data.rows).each(
								function(index, item) {
									var str = "<li value='" + item.game_id + "'>" + item.game_id + "</li>";
									$("#gamesLi").html($("#gamesLi").html() + str);
								}
							);
						} else {
							alert("失败")
						}
					}
				});	
		});
		
	});
	</script>

	<form>
		<table>
			<tr>
				<td>联赛:</td>
				<td><select id="league_list">
				</select></td>
			</tr>
			<ur id="gamesLi">
				
			</ur>
		</table>
	</form>
</body>
</html>