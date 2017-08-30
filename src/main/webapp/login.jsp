<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="header_login.jsp" %>

<script type="text/javascript">



</script>


<div class="login">
		<span>
   		 <a href="main.jsp" class="close-login">
         	<img src="images/close.png"/>
   		 </a>
    	</span>
	<img  id="first" src="images/first1.png"/>
		<form action="users_login.action" id="myform" method="post">
          <div id="user">
            <img src='images/people.png' height="40px" style="float:left"/>
            <input type="text" class="userfun" id="username" value="请输入用户账号" />
          </div>
          
        
          <div id="userpassword"> 
            <img src='images/lock.png' height="40px" style="float:left"/>
            <input type="text"  class="userfun" id="password" value="6-16位密码,区分大小写" />
          </div>
          
          <div id="zccode">
            <img src='images/slider.png' height="30px"/>
            <div id="zccodein">拖动滑块,完成验证</div>
          </div>
          
          <div id="dosubmit">
             <input id="dologin" type="button" value="登&nbsp;&nbsp;录"/>
          </div>
          
          <div id="toother">
            <a id="forgetpwd" href="">忘记密码?&nbsp;&nbsp;</a>|
            <a id="toregister" href="">&nbsp;&nbsp;去注册</a>
          </div>
       </form>
</div>
<div class="login-bg"></div>
</body>
</html>
