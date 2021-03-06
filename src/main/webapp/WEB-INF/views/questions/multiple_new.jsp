<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="/WEB-INF/views/layouts/jsp_header.jsp"%>


<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<title><fmt:message key="questions.multiple.add"></fmt:message></title>
<%@include file="/WEB-INF/views/layouts/common.jsp"%>
<link href="static/stylesheets/questions.css" rel="stylesheet">
<script src="static/javascripts/questions.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/layouts/header.jsp"%>
	<div class="container-fluid body-container">
		<div class="row body-box">
			<div class="col-md-2 sidebar-container">
				<%@ include file="/WEB-INF/views/layouts/sidebar.jsp"%>
			</div>
			<div class="col-md-10 main-container">
				<div class="container-fluid">
					<div class="page-header">
						<h1>
							<fmt:message key="questions.new"></fmt:message>
						</h1>
					</div>
					<c:choose>
						<c:when test="${ !empty subjects}">
							<div class="row">
								<div class="col-md-8 col-md-offset-2">
									<%@ include
										file="/WEB-INF/views/questions/_question_multiple_form.jsp"%>
								</div>
								<%@ include file="/WEB-INF/views/questions/semblance.jsp"%>
							</div>
						</c:when>
						<c:otherwise>
							<fmt:message key="message.set.subject"></fmt:message>
							<a class="btn btn-primary" href="home"><fmt:message
									key="btn.add"></fmt:message></a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

</body>
</html>