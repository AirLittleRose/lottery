<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../header_login.jsp" %>

<script type="text/javascript" src="ckeditor/ckeditor.js"></script>


<script type="text/javascript">
	
	function Ckupdate() {
	    for(instance in CKEDITOR.instances){
	        CKEDITOR.instances[instance].updateElement();
	    }
	}

	$(function(){
		$("#addBtn").click(function(){
			Ckupdate();
			$.ajax({
				type:"POST",
				url:"newsAdd.action",
				data:$("#addNewsForm").serialize(),
				dataType:"json",  
				success:function(data){
					if(data.code==1){
						alert(content);
						alert('添加成功');
					}else{
						alert('添加失败,'+data.errorMsg);
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

	
		
		<form id="addNewsForm" enctype="multipart/form-data">
			<div style="text-align:left; ">					
			
				标题：<input type="text" name="title" id="title"/><br/>
				
				内容：			
				<textarea class="ckeditor" name="content"></textarea>			
				
				<input type="button" id="addBtn" value="添加"  />
				
			</div>			
		
		</form>
	
</body>
</html>