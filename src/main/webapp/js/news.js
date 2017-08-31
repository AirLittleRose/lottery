	
function show1(){
	$("#forecast").css("backgroundColor","white");
	$("#forecast").toggleClass("active",true);
	$("#topForecast").css("display","block");
	
	$("#notice").css("backgroundColor","#F5F5F5");
	$("#notice").toggleClass("active",false);
	$("#topNotice").css("display","none");
}

function show2(){
	$("#notice").css("backgroundColor","white");
	$("#notice").toggleClass("active",true);
	$("#topNotice").css("display","block");
	
	$("#forecast").css("backgroundColor","#F5F5F5");
	$("#forecast").toggleClass("active",false);
	$("#topForecast").css("display","none");
}

