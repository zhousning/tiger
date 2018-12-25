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
<title><fmt:message key="examPapers.show"></fmt:message></title>
<%@ include file="/WEB-INF/views/layouts/common.jsp"%>
<link href="static/stylesheets/examPapers.css" rel="stylesheet">
<script src="static/javascripts/examPapers.js"></script>
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
							<fmt:message key="examPapers.show"></fmt:message>
						</h1>
					</div>
					<div class="row">
					<div class="col-md-12">
					<ul class="list-group">
						<c:if test="${!empty examPaper.questions }">
						<c:forEach items="${examPaper.questions }" var="question">
							<li class="list-group-item">
								${question.title }
							</li>
						</c:forEach>
						</c:if>
					</ul>
					</div>
						<div class="col-md-4 col-md-offset-4">
							<form class="form-horizontal">
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.major"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.major }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.date"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.date }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.duration"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.duration }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.space"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.space }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.introduction"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.introduction }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.partAInfo"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.partAInfo }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.partBInfo"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.partBInfo }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="subject.name"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.subject.name }</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4 info-title"><fmt:message
											key="examPaper.status"></fmt:message>：</div>
									<div class="col-sm-8 info-ctn">${examPaper.status }</div>
								</div>
								<div class="form-group">
								<div class="col-sm-offset-2 col-sm-4">
										<a href="examPapers/${examPaper.id }/edit" type="button" class="btn btn-info"><fmt:message
												key="btn.edit"></fmt:message></a>
									</div>
									<div class="col-sm-offset-2 col-sm-4">
										<a href="examPapers" type="button" class="btn btn-warning"><fmt:message
												key="btn.back"></fmt:message></a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>