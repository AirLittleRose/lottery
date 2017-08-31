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
		}else{
			
		}		
}

function checkPassAga(){
		var pass = document.getElementById("regpass").value;
		var passaga = document.getElementById("regpassaga").value;		
		
		if(pass==passaga&&passaga!=""){
			$("#aug").html("<img src='images/right.png' />");
			var sh=$("#dologin");
			sh.removeAttr("disabled");
			sh.css("backgroundColor","#CD4F39");
			 
		}else{
			$("aug").html("<img src='images/wrong.png' />");
			var sh=$("#dologin");
			sh.attr("disabled","true");
			sh.css("backgroundColor","#CD8162");
		}		
}







