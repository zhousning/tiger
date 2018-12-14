<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/jsp_header.jsp"%>



<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title>列表</title>
<%@ include file="/WEB-INF/views/layouts/common.jsp"%>

</head>
<body>
	<shiro:principal/>
<%-- 		<c:if test="${!empty requestScope.current_user }">
		<div>
			<h2>
				${ requestScope.current_user.email}
			</h2>
		</div>
	</c:if> --%>
	
<a href="users/sign_in">用户登录</a>
<a href="shiro/logout">退出登录</a>

<a href="users/sign_up">用户注册</a>
<a href="users" class="btn btn-primary">用戶列表</a>
</body>
</html>