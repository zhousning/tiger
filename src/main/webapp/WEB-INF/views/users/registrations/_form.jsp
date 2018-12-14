<form:form action="users/sign_up" method="POST" modelAttribute="user">
	<!-- <form:errors path="*"></form:errors> -->

	<c:if test="${user.id != null }">
		<form:hidden path="id" />
		<input type="hidden" name="_method" value="PUT" />
	</c:if>
	Name: <form:input path="name" />
	<form:errors path="name"></form:errors>
	Email: <form:input path="email" />
	<form:errors path="email"></form:errors>
	Password: <form:input path="password" type="password" />
	<form:errors path="password"></form:errors>

	<input type="submit" value="sign up" />
</form:form>