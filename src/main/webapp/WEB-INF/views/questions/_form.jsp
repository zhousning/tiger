<form:form action="questions" method="POST" modelAttribute="question"
	class="form-horizontal">
	<!-- <form:errors path="*"></form:errors> -->
	<c:if test="${question.id != null }">
		<form:hidden path="id" />
		<input type="hidden" title="_method" value="PUT" />
	</c:if>
	<div class="form-group">
		<label for="title" class="col-sm-2 control-label"><fmt:message key="question.title"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="text" class="form-control" id="title"
				placeholder="title" path="title" />
		</div>
	</div>
	<div class="form-group">
		<label for="content" class="col-sm-2 control-label"><fmt:message key="question.content"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="text" class="form-control" id="content"
				placeholder="content" path="content" />
		</div>
	</div>
	<div class="form-group">
		<label for="answer" class="col-sm-2 control-label"><fmt:message key="question.answer"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="answer" class="form-control" id="answer"
				placeholder="answer" path="answer" />
		</div>
	</div>
	<div class="form-group">
		<label for="analysis" class="col-sm-2 control-label"><fmt:message key="question.analysis"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="analysis" class="form-control" id="analysis"
				path="analysis" />
		</div>
	</div>
	<div class="form-group">
		<label for="createTime" class="col-sm-2 control-label"><fmt:message key="question.createTime"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="createTime" class="form-control" id="createTime"
				path="createTime" />
		</div>
	</div>
	<div class="form-group">
		<label for="utilityTime" class="col-sm-2 control-label"><fmt:message key="question.utilityTime"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="utilityTime" class="form-control" id="utilityTime"
				path="utilityTime" />
		</div>
	</div>
	<div class="form-group">
		<label for="status" class="col-sm-2 control-label"><fmt:message key="question.status"></fmt:message></label>
		<div class="col-sm-10">
			<form:input type="status" class="form-control" id="status"
				path="status" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-4">
			<button type="submit" class="btn btn-success"><fmt:message key="btn.save"></fmt:message></button>
		</div>
		<div class="col-sm-offset-2 col-sm-4">
			<a href="questions" type="button" class="btn btn-warning"><fmt:message key="btn.back"></fmt:message></a>
		</div>
	</div>
</form:form>