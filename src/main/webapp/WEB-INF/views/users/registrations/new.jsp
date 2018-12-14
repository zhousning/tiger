<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/jsp_header.jsp"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>用户注册</title>
<%@include file="/WEB-INF/views/layouts/common.jsp"%>
</head>
<body>

<%@ include file="/WEB-INF/views/users/registrations/_form.jsp"%>

<a href="users/sign_in">登录</a>
	
</body>
</html>