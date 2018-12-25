<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/jsp_header.jsp"%>

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
<title><fmt:message key="questions.show"></fmt:message></title>
<%@ include file="/WEB-INF/views/layouts/common.jsp"%>
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
							<fmt:message key="questions.show"></fmt:message>
						</h1>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="row">
								<div class="col-sm-1">
									<a href="questions/${requestScope.question.id }/edit"
										type="button" class="btn btn-info"><fmt:message
											key="btn.edit"></fmt:message></a>
								</div>
								<div class="col-sm-1">
									<a href="questions" type="button" class="btn btn-warning"><fmt:message
											key="btn.back"></fmt:message></a>
								</div>

								<div class="col-sm-2 info-title">
									<fmt:message key="question.createTime"></fmt:message>
									：
								</div>
								<div class="col-sm-2 info-ctn">${requestScope.question.createTime }</div>
								<div class="col-sm-2 info-title">
									<fmt:message key="question.utilityTime"></fmt:message>
									：
								</div>
								<div class="col-sm-2 info-ctn">${requestScope.question.utilityTime }</div>
								<div class="col-sm-2 info-ctn">
									<c:choose>
										<c:when test="${ question.status == 0 }">
											<fmt:message key="question.status.pending.title"></fmt:message>
										</c:when>
										<c:otherwise>
											<fmt:message key="question.status.approved.title"></fmt:message>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<form class="form-horizontal">
										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="question.title"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">${requestScope.question.title }</div>
										</div>
										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="question.content"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">${requestScope.question.content }</div>
										</div>
										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="question.answer"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">${requestScope.question.answer }</div>
										</div>

										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="question.analysis"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">${requestScope.question.analysis }</div>
										</div>
										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="subject.name"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">
												<c:if test="${!empty question.subject }">
												${ question.subject.name }
											</c:if>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="level.name"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">
												<c:if test="${!empty question.level }">
												${ question.level.name }
											</c:if>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-2 info-title">
												<fmt:message key="examPoint.name"></fmt:message>
												：
											</div>
											<div class="col-md-10info-ctn">
												<c:if test="${!empty question.examPoint }">
												${ question.examPoint.name }
											</c:if>
											</div>
										</div>
									</form>
								</div>
								<div class="col-md-2">
									<c:if test="${!empty requestScope.question.attachments }">
										<c:forEach items="${ requestScope.question.attachments }"
											var="file">
											<img id="blah" src="${file.file }" class="img-rounded">
										</c:forEach>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>