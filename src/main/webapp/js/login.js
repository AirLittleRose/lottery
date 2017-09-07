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
	
	$("#mname").focus(function(){ 
		$("#mname").css("color","#2E2E2E");
		$("#mana").css("border-color","#009ACD");
	}); 
	
	$("#mname").blur(function(){ 
		$("#mname").css("color","#2E2E2E");
		$("#mana").css("border-color","#999");
	}); 
	
	$("#pwd").focus(function(){ 
		$("#pwd").css("color","#2E2E2E");
		$("#manapwd").css("border-color","#009ACD")
	}); 
	
	$("#pwd").blur(function(){ 
		$("#pwd").css("color","#2E2E2E");
		$("#manapwd").css("border-color","#999")
	}); 

});




