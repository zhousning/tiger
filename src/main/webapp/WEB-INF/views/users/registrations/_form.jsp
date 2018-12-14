<form:form action="users/sign_up" method="POST" modelAttribute="user"
	class="login-form">
	<c:if test="${user.id != null }">
		<form:hidden path="id" />
		<input type="hidden" name="_method" value="PUT" />
	</c:if>
	<div class="form-group">
		<label for="exampleInputEmail1" class="text-uppercase">Email</label>
		<form:input class="form-control" placeholder="" path="email" />
		<form:errors path="email"></form:errors>
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1" class="text-uppercase">Password</label>
		<form:input  type="password" path="password" class="form-control" placeholder="" />
		<form:errors path="password"></form:errors>
	</div>
	<div class="form-group">
		<div class="col-md-4">
			<input type="submit" name="commit" value="Sign
			up"
				class="btn btn-block btn-login float-right">
		</div>
		<div class="col-md-4 col-md-offset-3">
			<a class="btn btn-success btn-block" href="users/sign_in">Sign in</a> <br>
		</div>
	</div>
</form:form>