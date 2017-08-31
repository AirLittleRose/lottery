$(function () {
    H_login = {};
    H_login.openLogin = function(){
    
            $('.login').show();
            $('.login-bg').show();
      
    };
    H_login.closeLogin = function(){
        $('.close-login').click(function(){
            $('.login').hide();
            $('.login-bg').hide();
        });
    };
    H_login.run = function () {
        this.closeLogin();
        this.openLogin();
    };
    H_login.run();

	$("#username").focus(function(){ 
		$("#username").css("color","#2E2E2E");
		$("#user").css("border-color","#009ACD");
	}); 
	
	$("#username").blur(function(){ 
		$("#username").css("color","#2E2E2E");
		$("#user").css("border-color","#999");
	}); 
	
	$("#password").focus(function(){ 
		$("#password").css("color","#2E2E2E");
		$("#userpassword").css("border-color","#009ACD")
	}); 
	
	$("#password").blur(function(){ 
		$("#password").css("color","#2E2E2E");
		$("#userpassword").css("border-color","#999")
	}); 

	$("#close").mouseover(function(){
		  $("#close").css("-moz-transform","rotate(200deg)");
		});

});


function getStyle(obj,attr){
			//功能性检查
			if(obj.currentStyle){
				return div.currentStyle[attr];	
			}else{
				return getComputedStyle(obj,null)[attr]	
			}
		}	

function checkPass(){
		var name = document.getElementById("regpass").value;
		var reg = /^([0-9]|[a-zA-Z]){6,16}$/;
		
		if(name.match(reg)&&name!=""){
			$("#aup").html("<img src='images/right.png' />");						
			return true;
		}else{		
			$("#aup").html("<img src='images/wrong.png' />"); 	
			return false;
		}		
}

function checkPassAga(){
		var pass = document.getElementById("regpass").value;
		var passaga = document.getElementById("regpassaga").value;		
		
		if(pass==passaga&&passaga!=null&&passaga!=""){
			$("#aug").html("<img src='images/right.png' />");
			return true;
		
		}else{
			$("#aug").html("<img src='images/wrong.png' />");
			return false;
		}		
}

function checkTel(){
		var name = document.getElementById("tele").value;
		var reg = /^1(3|4|5|7|8)\d{9}$/;
		
		if(name.match(reg)&&name!=""){
			$("#aut").html("<img src='images/right.png' />");
			return true;
		}else{			
			$("#aup").html("<img src='images/wrong.png' />");		
			return false;
		}	
}

function checkEmail(){
		var name = document.getElementById("ema").value;
		var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
		
		if(name.match(reg)&&name!=""){
			$("#aue").html("<img src='images/right.png' />");
			return true;
		}else{
			$("#aup").html("<img src='images/wrong.png' />");
			return false;
		}	
}

function checkId(){
		var name = document.getElementById("idca").value;
		var reg=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{4}$/;
		
		if(name.match(reg)&&name!=""){
			$("#aui").html("<img src='images/right.png' />");
			return true;
		}else{			
			$("#aup").html("<img src='images/wrong.png' />");	
			return false;
		}			
}
function rea(){
	var val = document.getElementById("dochoose").checked;
	if(val==true){
		var pass = checkPass();
		var passAga = checkPassAga();
		var tel = checkTel();
		var ema = checkEmail();
		var cid = checkId();
		if(pass==true&&passAga==true&&tel==true&&ema==true&&cid==true){
			var sh=$("#dologin");
			sh.removeAttr("disabled");
			sh.css("backgroundColor","#CD4F39");
		}		
	}else{
		var sh=$("#dologin");
		sh.attr("disabled","true");
		sh.css("backgroundColor","#CD8162");
		alert("请完善信息!");		
		var ch = $("#dochoose");
		ch.removeAttr("checked");
	}	
}

function reaAga(){	
	var pass = checkPass();
	var passAga = checkPassAga();
	var tel = checkTel();
	var ema = checkEmail();
	var cid = checkId();
	if(pass==false&&passAga==false&&tel==false&&ema==false&&cid==false){
		var sh=$("#dologin");
		sh.attr("disabled","true");
		sh.css("backgroundColor","#CD8162");
		alert("请完善信息!");		
		var ch = $("#dochoose");
		ch.removeAttr("checked");
	}		
}








  

