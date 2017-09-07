<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header_login.jsp" %>


<link rel="stylesheet" href="css/login.css" media="all">
<link rel="stylesheet" href="css/drag.css" media="all">
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/login.js" type="text/javascript"></script>
<script src="js/drag.js" type="text/javascript"></script>


<script type="text/javascript">
$(function(){
	$("#doManaLogin").click(function(){
		$.ajax({
			type:"POST",
			data:$("#manaform").serialize(),	
			url:"mana_login.action",
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					alert("登录成功！");
					location.href="managemain.action";
				}else{
					alert("登录失败！原因"+data.msg);
				}
			}
		});
	});	
});

</script>


<body id="loginBack">

<div class="login">
		<span>
   		  <a href="main.action" class="close-login">
         	<img class="close" src="images/close.png"/>
   		 </a>
    	</span>
	<img  id="first" src="images/first1.png"/>
		<form id="manaform"  autocomplete="on">
          <div id="mana">
            <img src='images/people.png' height="40px" style="float:left"/>
            <input type="text" class="userfun" name="mname" id="mname"  placeholder="请输入管理员名"/>
          </div>
          
        
          <div id="manapwd"> 
            <img src='images/lock.png' height="40px" style="float:left"/>
            <input type="password"  class="userfun" name="pwd" id="pwd" placeholder="请输入密码"/>
          </div>
          
          <div id="drag" ></div>
          
          <div id="dosubmit">
             <input id="doManaLogin" type="button" value="登&nbsp;&nbsp;录" disabled="disabled"/>
          </div>          
         
       </form>
</div>
<div class="login-bg"></div>

<script>
$('#drag').drag();

function check(){
	if($("#mname").val()==""||$("#pwd").val()==""){
	    var sh=$("#dologin");
		sh.attr("disabled","true")
		sh.css("backgroundColor","#CD8162");
		alert("管理员名和密码不能为空！");
		location.reload(); 
	}else{
		if(flag=1){
			var sh=$("#doManaLogin");
			sh.removeAttr("disabled");
			sh.css("backgroundColor","#CD4F39");
		}
	}
}

</script>

</body>
</html>
