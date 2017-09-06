<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<%@ include file="header_login.jsp" %>


<link rel="stylesheet" href="css/register.css" media="all">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/register.js"></script>

<script type="text/javascript">
$(function(){
	$("#dologin").click(function(){	
		$.ajax({
			type:"POST",
			data:$("#myRegister").serialize(),
			url:"user_register.action",
			dataType:"JSON",
			success:function(data){
				if(data.code== 1){
					alert("注册成功！");	
					location.href="http://localhost:8080/lottery/toLogin.action";
				}else{
					alert("注册失败！原因"+data.msg);
				}
			}
		});
	});	
});

function checkUser(username){
		var name = document.getElementById("userreg").value;
		var reg = /^[0-9a-zA-Z\u4e00-\u9fa5_]{4,16}$/;
		
		if(name.match(reg)&&name!=""){
			$.ajax({
				url:"user_isUsernameExist.action",
				data:"username="+encodeURIComponent(username),
				type:"POST",
				dataType:"JSON",
				success:function(data){
					if(data.code==1){
						$("#aur").html("<img src='images/right.png' />");													
					}else{
						$("#aur").html("<img src='images/wrong.png' />用户名重复");									    		
					}
				}
			});			
				
		}else{
			$("#aur").html("<img src='images/wrong.png' />");    			
		}	
	
}


</script>
<body id="body">

<div class="login">
		<span>
   		 <a href="main.html" class="close-login">
         	<img class="image" src="images/close.png"/>
   		 </a>
    	</span>

		  <form id="myRegister">

          <h4 id="userregister">用户名：</h4>
          <div id="user">
              <input type="text" class="userfun" name="username" id="userreg" onblur="checkUser(this.value)" placeholder="请输入用户名"/>
              <a class="con" id="aur">可使用英文,数字,汉字,下划线,长度为4-16,申请之后不能修改！</a>
          </div>

          
      
          <h4 id="userregpass">密码：</h4>
          <div id="userpassword"> 
            <input type="password"  class="userfun" name="password" id="regpass" onblur="checkPass()" placeholder="请输入6-16位密码"/>
            <a class="con" id="aup"></a>
          </div>
          
          <h4 id="agapass">确认密码：</h4>
          <div id="regpassdiv"> 
            <input type="password"  class="userfun" id="regpassaga" onblur="checkPassAga()"
             onfocus="checkPassAga()" placeholder="请再次确认密码"/>
            <a class="con" id="aug"></a>
          </div>
          
          <h4 id="tel">手机：</h4>
          <div id="teldiv"> 
            <input type="text"  class="userfun" name="tel" id="tele" onblur="checkTel()" placeholder="请输入手机号"/>
            <a class="con" id="aut" ></a>
          </div>
          
          <h4 id="eml">邮箱：</h4>
          <div id="emldiv"> 
            <input type="text"  class="userfun" name="email" id="ema" onblur="checkEmail()" placeholder="请输入邮箱"/>
            <a class="con" id="aue"></a>
          </div>
          
          <h4 id="idc">身份证号：</h4>
          <div id="idcdiv"> 
            <input type="text"  class="userfun" name="idcard" id="idca" onblur="checkId()" placeholder="请输入身份证号"/>
             <a class="con" id="aui"></a>
          </div>
          
          <div id="choose"> 
            	<input id="dochoose" type="checkbox" onblur="reaAga()" onchange="rea()" value=""/>&nbsp;阅读并接受《各种无理由条款》
          </div>
          
          <div id="dosubmit">
             <input id="dologin" type="button" value="注&nbsp;&nbsp;册" disabled="true"/>
          </div>
          
          <div id="toother">
          	<a href="index.action" id="tologin">→_→去主页</a>
          </div>
         
        
       </form>
</div>
<div class="login-bg"></div>



</body>
</html>