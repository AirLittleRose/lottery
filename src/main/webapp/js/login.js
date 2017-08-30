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
});

$(function(){ 
$('.userfun').bind({ 
			focus:function(){ 
			if (this.value == this.defaultValue){ 
			this.value=""; 
		} 
	}, 
blur:function(){ 
			if (this.value == ""){ 
			this.value = this.defaultValue; 
			} 
		} 
	}); 
}) 



