<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<title><fmt:message key="users.index.title"></fmt:message></title>
<%@ include file="/WEB-INF/views/layouts/common.jsp"%>
<link href="static/stylesheets/users.css" rel="stylesheet">
<script src="static/javascripts/users.js"></script>



</head>
<body class=".users.index">
	<form action="" method="POST">
		<input type="hidden" name="_method" value="DELETE" />
	</form>

 <div class="container">
        <h1><fmt:message key="users.index.title"></fmt:message></h1>
        <table id="table" 
					data-toggle="table"
					data-filter-control="true"
					data-height="600"
           			data-pagination="true"
           			data-page-size="20"
           			data-page-list="[5,8,10]"
           			data-pagination-first-text="First"
           			data-pagination-pre-text="Previous"
           			data-pagination-next-text="Next"
           			data-pagination-last-text="Last"
           			data-toolbar="#toolbar"
     				data-search="true"
     				data-trim-on-search="true"  
     				data-align="center"        
					class="table table-hover text-center">
					<thead>
						<tr class="text-center">
							<th  data-field="id">id</th>
							<th  data-field="name"  data-filter-control="input"><fmt:message key="user.name"></fmt:message></th>
							<th  data-field="email" data-filter-control="select"><fmt:message key="user.email"></fmt:message></th>
							<th> <a href="users/new" class="btn btn-primary btn-block"><fmt:message key="btn.add"></fmt:message></a> </th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ !empty requestScope.users }">
							<c:forEach items="${ requestScope.users }" var="user"
								varStatus="status">
								<tr>
									<td>${ status.index + 1 }</td>
									<td>${ user.name }</td>
									<td>${ user.email }</td>
									<td>
										<a href="users/${user.id }/edit" class="btn btn-success"><fmt:message key="btn.edit"></fmt:message></a>
										<a href="users/${user.id}" class="delete btn btn-danger"><fmt:message key="btn.delete"></fmt:message></a>
									</td>
								</tr>

							</c:forEach>
						</c:if>
					</tbody>
				</table>
    </div>
</body>
</html>