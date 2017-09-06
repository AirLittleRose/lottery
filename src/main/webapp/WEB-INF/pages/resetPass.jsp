<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link rel="stylesheet" href="css/resetPass.css">
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/resetPass.js"></script>

<script type="text/javascript">

function updatePass(password){	
			$.ajax({
				url:"user_updatePass.action",
				data:$("#myform").serialize(),
				type:"POST",
				dataType:"JSON",
				success:function(data){
					if(data.code==1){
						alert("密码设定成功!");	
						location.href="http://localhost:8080/lottery/toLogin.action";
					}else{
						alert("密码修改失败！原因"+data.msg);
					}
				}
			});		
}		

</script>

<body id="body">


<div class="login">
		<span>
   		 <a href="main.html" class="close-login">
         	<img class="image" src="images/close.png"/>
   		 </a>
    	</span>
          
          
          <h4 id="userregpass">新密码：</h4>
          <div id="userpassword"> 
            <input type="password"  class="userfun" name="password" id="regpass" onblur="checkPass()" placeholder="请输入6-16位密码"/>
            <a id="aup"></a>
          </div>
          
          <form id="myform">
          
          <h4 id="agapass">确认密码：</h4>
          <div id="regpassdiv"> 
            <input type="password"  class="userfun" name="password" id="regpassaga" onblur="checkPassAga()"
             onchange="checkPassAga()" placeholder="请再次确认密码"/>
            <a id="aug"></a>
          </div>                  
          
          <div id="dosubmit">
         　　　　　     <input type="hidden" name="username" value="${param.username}"/>
             <input id="dologin" type="button" value="确&nbsp;&nbsp;认" onclick="updatePass(this.value)" disabled="true"/>
          </div>         
        
       </form>
</div>
<div class="login-bg"></div>
</body>
</html>