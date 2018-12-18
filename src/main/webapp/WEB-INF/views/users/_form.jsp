<form:form action="users" method="POST" modelAttribute="user"
	class="form-horizontal">
	<c:if test="${user.id != null }">
		<form:hidden path="id" />
		<input type="hidden" name="_method" value="PUT" />
	</c:if>
	<!-- <form:errors path="*"></form:errors> -->
	<div class="col-md-4 col-md-offset-2">
		<div class="form-group">
			<label for="name" class="col-sm-2 control-label"><fmt:message
					key="user.name"></fmt:message></label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="name"
					placeholder="name" path="name" />
			</div>
		</div>
		<div class="form-group">
			<label for="phone" class="col-sm-2 control-label"><fmt:message
					key="user.phone"></fmt:message></label>
			<div class="col-sm-10">
				<form:input type="text" class="form-control" id="phone"
					placeholder="phone" path="phone" />
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label"><fmt:message
					key="user.email"></fmt:message></label>
			<div class="col-sm-10">
				<form:input type="email" class="form-control" id="email"
					placeholder="email" path="email" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label"><fmt:message
					key="user.password"></fmt:message></label>
			<div class="col-sm-10">
				<form:input type="password" class="form-control" id="password"
					path="password" />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-4">
				<button type="submit" class="btn btn-success">
					<fmt:message key="btn.save"></fmt:message>
				</button>
			</div>
			<div class="col-sm-offset-2 col-sm-4">
				<a href="users" type="button" class="btn btn-warning"><fmt:message
						key="btn.back"></fmt:message></a>
			</div>
		</div>
	</div>
	<div class="col-md-4 col-md-offset-1">
		<h3>
			<fmt:message key="subject.type"></fmt:message>
		</h3>
	    <form:checkboxes path="subjects" items="${requestScope.subjects}" element="label class='checkbox-inline'" itemLabel="name" itemValue="id"/><br/>
	</div>

</form:form>