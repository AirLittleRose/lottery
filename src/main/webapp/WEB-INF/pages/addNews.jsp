<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header.jsp" %>

<script type="text/javascript" src="../../ckeditor/ckeditor.js"></script>


<script type="text/javascript">
	$(function(){
		showNewsType();
		$("#addBtn").click(function(){			
			$.ajax({
				type:"POST",
				url:"back/news.action",
				data:$("#addNewsForm").serialize(),
				dataType:"json",  //
				success:function(data){
					if(data.code==1){
						$.messager.alert('Warning','添加成功');
					}else{
						$.messager.alert('Warning','添加失败,'+data.errorMsg);
					}
				}
			});
		});
	});
		
	function showUploadImg(obj,picid){
		if(typeof FileReader == 'undefined'){
			$.messager.alert('Warning',"当前浏览器不支持FileReader接口");
			obj.setAttribute("disabled","disabled");
			return;
		}
		var file=obj.files[0];
		var reader= new FileReader();
		reader.onload=function(e){
			$("#"+picid).attr("src",e.target.result);
		}
		reader.readAsDataURL(file)
	}
</script>

<title>添加公告</title>
</head>
<body>

	<center>
		发布公告
		<hr/>
		<form id="addNewsForm" action="pages/newsAdd.action" method="post" enctype="multipart/form-data">
			<div style="text-align:left; ">
				<input type="hidden" name="op" value="add"/>
				新闻类别：<select id="tid" name="tid">
					
				</select><br/>
				标题：<input type="text" name="title" id="title"/><br/>
				权重：<input type="text" name="weight" id="weight"/><br/>
				首页图片：<input type="file" name="pic" id="pic" onchange="showUploadImg(this,'showpic')" accept="image/*"/><br/>
				<input type="button" value="隐藏图片" onclick="document.getElementById('showpic').style.display='none';"/>
				<input type="button" value="显示图片" onclick="document.getElementById('showpic').style.display='block';"/>
				<br/>
				<img id="showpic"/><br/>
				内容：<input type="submit" id="addBtn" value="添加"  />
			
				<textarea class="ckeditor" name="content" ></textarea>
				<br/>
				<hr/>
				
			</div>
			
		</form>
		</center>


</body>
</html>