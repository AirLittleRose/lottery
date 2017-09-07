<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../../header.jsp" %>
<link rel="stylesheet" href="css/annos.css" media="all">

<center>
	<p id="title">${as.title}</p><br/>
	<p id="auth">公告作者:${as.auth} &nbsp;&nbsp;&nbsp; 发布时间:${as.adate}</p>
	
	<p id="content">公告内容:${as.content}</p>
</center>

