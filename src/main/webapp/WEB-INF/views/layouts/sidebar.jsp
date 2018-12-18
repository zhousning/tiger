<div class="nav-side-menu">
	<div class="brand">
		<shiro:principal />
	</div>
	<i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse"
		data-target="#menu-content"></i>

	<div class="menu-list">

		<ul id="menu-content" class="menu-content collapse out">
			<li><a href="#"> <i class="fa fa-dashboard fa-lg"></i>
					Dashboard </li>

			<li data-toggle="collapse" data-target="#users"
				class="collapsed active"><a><i class="fa fa-gift fa-lg"></i>
					<fmt:message key="users.manage"></fmt:message> <span class="arrow"></span></a>
			</li>
			<ul class="sub-menu collapse" id="users">
				<!-- <li class="active"><a href="#">CSS3 Animation</a></li> -->
				<li><a href="users"><fmt:message key="users.index"></fmt:message></a></li>
				<li><a href="users/new"><fmt:message key="users.new"></fmt:message></a></li>
			</ul>

			<li data-toggle="collapse" data-target="#subjects"
				class="collapsed active"><a><i class="fa fa-gift fa-lg"></i>
					<fmt:message key="subjects.manage"></fmt:message> <span
					class="arrow"></span></a></li>
			<ul class="sub-menu collapse" id="subjects">
				<!-- <li class="active"><a href="#">CSS3 Animation</a></li> -->
				<li><a href="subjects"><fmt:message key="subjects.index"></fmt:message></a></li>
				<li><a href="subjects/new"><fmt:message key="subjects.new"></fmt:message></a></li>
			</ul>

			<li data-toggle="collapse" data-target="#roles" class="collapsed
			active">
			<a><i class="fa fa-gift fa-lg"></i>
					<fmt:message key="roles.manage"></fmt:message> <span
					class="arrow"></span></a></li>
			<ul class="sub-menu collapse" id="roles">
				<!-- <li class="active"><a href="#">CSS3 Animation</a></li> -->
				<li><a href="roles"><fmt:message key="roles.index"></fmt:message></a></li>
				<li><a href="roles/new"><fmt:message key="roles.new"></fmt:message></a></li>
			</ul>


			<li data-toggle="collapse" data-target="#questions" class="collapsed">
				<a><i class="fa fa-globe fa-lg"></i> <fmt:message
						key="questions.manage"></fmt:message> <span class="arrow"></span></a>
			</li>
			<ul class="sub-menu collapse" id="questions">
				<li><a href="questions"><fmt:message key="questions.index"></fmt:message></a></li>
				<li><a href="questions/new"><fmt:message
							key="questions.single.manage"></fmt:message></a></li>
				<li><a href="questions/new"><fmt:message
							key="questions.multiple.manage"></fmt:message></a></li>
				<li><a href="questions/new"><fmt:message
							key="questions.essay.manage"></fmt:message></a></li>
			</ul>


			<li data-toggle="collapse" data-target="#new" class="collapsed">
				<a href="#"><i class="fa fa-car fa-lg"></i> New <span
					class="arrow"></span></a>
			</li>
			<ul class="sub-menu collapse" id="new">
				<li>New New 1</li>
				<li>New New 2</li>
				<li>New New 3</li>
			</ul>


			<li><a href="#"> <i class="fa fa-user fa-lg"></i> Profile
			</a></li>

			<li><a href="#"> <i class="fa fa-users fa-lg"></i> Users
			</a></li>
		</ul>
	</div>
</div>