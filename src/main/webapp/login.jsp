<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header_login.jsp" %>


<link rel="stylesheet" href="css/login.css" media="all">
<link rel="stylesheet" href="css/drag.css" media="all">
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/login.js" type="text/javascript"></script>
<script src="js/drag.js" type="text/javascript"></script>
<style>
.black_overlay{
 display: none;
 position: absolute;
 top: 0%;
 left: 0%;
 width: 100%;
 height: 100%;
 background-color: black;
 z-index:1001;
 -moz-opacity: 0.8;
 opacity:.80;
 filter: alpha(opacity=80);
}
.white_content {
 display: none;
 position: absolute;
 top: 10%;
 left: 10%;
 width: 80%;
 height: 80%;
 border: 16px solid lightblue;
 background-color: white;
 z-index:1002;
 overflow: auto;
 position:fixed; 
}
.white_content_small {
 display: none;
 position: absolute;
 top: 20%;
 left: 30%;
 width: 40%;
 height: 50%;
 border: 16px solid lightblue;
 background-color: white;
 z-index:1002;
 overflow: auto;
}
</style>

<script type="text/javascript">
//判断是否敲击了Enter键 
$(document).keyup(function(event){ 
    if(event.keyCode ==13){ 
      $("#dologin").trigger("click"); 
    } 
});
//弹出隐藏层
function ShowDiv(show_div,bg_div){
 document.getElementById(show_div).style.display='block';
 document.getElementById(bg_div).style.display='block' ;
 var bgdiv = document.getElementById(bg_div);
 bgdiv.style.width = document.body.scrollWidth; 
 // bgdiv.style.height = $(document).height();
 $("#"+bg_div).height($(document).height());
 choice_type();
};

//关闭弹出层
function CloseDiv(show_div,bg_div)
{
 document.getElementById(show_div).style.display='none';
 document.getElementById(bg_div).style.display='none';


};
$(function(){
	$("#dologin").click(function(){
		$.ajax({
			type:"POST",
			data:$("#myform").serialize(),	
			url:"users_login.action",
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					alert("登录成功！");					
					//如果通过注册页面进入的登录页面,就跳到主页,剩下的都返回原来的网页
					var fromurl = document.referrer;
					if(fromurl=="http://localhost:8080/lottery/toRegister.action"){
						location.href="http://localhost:8080/lottery/index.action";
					}else{
						history.go(-1);
					}
				}else{
					ShowDiv('MyDiv','fade');
				}
			}
		});
	});	
});

$(function(){
	 
	$("#forgetpwd").click(function(){
		$.ajax({
			type:"POST",
			data:"username="+ $("#username").val(),
			url:"user_forpass.action",
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					alert("邮件已发送！");					
				}else{
					alert("邮件发送失败！原因"+data.msg);
					location.href="http://localhost:8080/lottery/toLogin.action";
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
		<form id="myform"  autocomplete="on">
          <div id="user">
            <img src='images/people.png' height="40px" style="float:left"/>
            <input type="text" class="userfun" name="username" id="username"  placeholder="请输入用户名"/>
          </div>
          
        
          <div id="userpassword"> 
            <img src='images/lock.png' height="40px" style="float:left"/>
            <input type="password"  class="userfun" name="password" id="password" placeholder="请输入6-16位密码"/>
          </div>
          
          <div id="drag" ></div>
          
          <div id="dosubmit">
             <input id="dologin" type="button" value="登&nbsp;&nbsp;录" disabled="disabled"/>
          </div>
          
          <div id="toother">
            <a id="forgetpwd">忘记密码?&nbsp;&nbsp;</a>|
            <a id="toregister" href="toRegister.action">&nbsp;&nbsp;去注册</a>
          </div>
       </form>
</div>
<div class="login-bg"></div>

<script>
$('#drag').drag();

function check(){
	if($("#username").val()==""||$("#password").val()==""){
	    var sh=$("#dologin");
		sh.attr("disabled","true")
		sh.css("backgroundColor","#CD8162");
		alert("用户名和密码不能为空！");
		location.reload(); 
	}else{
		if(flag=1){
			var sh=$("#dologin");
			sh.removeAttr("disabled");
			sh.css("backgroundColor","#CD4F39");
		}
	}
}

</script>
<!-- 弹出层背景层DIV -->
<div id="fade" class="black_overlay"></div>

<!-- 弹出层 -->
<div id="MyDiv" class="white_content">
    <div style="text-align: right; cursor: default; height: 40px;">
        <span style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span>
    </div>
  	<div class="docBody clearfix from_bet" id="bonusCalc">
	    <div class="resultBox">
	       <font>登录失败!!!</font>
	       <a href="login.jsp">确认</a>
	    </div>
	</div>
</div>
</body>
</html>
