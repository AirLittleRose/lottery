<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="com.yc.utils.*,java.util.*"%>

<%
	//配合ckeditor的文件上传

	FileUpload fu=new FileUpload();
   	Map<String,String> map= fu.uploadFiles(pageContext, request);   // 完成上传文件的保存，请求实体的参数的读取,  返回了所有的参数及上传文件的信息( url, destination,oldfilename)

	//取出回调函数名 :   jsonp技术
	response.setContentType("text/html; charset=UTF-8");
   	
   	// function show()      因为  CKEditorFuncNum参数是在地址栏中，即以  GET方式传到服务器中的，所以可以使用  HttpServletRequest来接收.
	String callback = request.getParameter("CKEditorFuncNum");
	
	//将结果以客户端指定的函数的形式，以javascript代码写到客户端去，这样客户端的   浏览器的js引擎就可以运行
	out.println("<script type=\"text/javascript\">");
	out.println("window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + map.get("upload_weburl") + "','')");
	out.println("</script>");
	out.flush();
%>