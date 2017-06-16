<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html ng-app="app">
<head>
<link rel="stylesheet" type="text/css"
	href="/edsystem/resources/css/bootstrap.min.css">
<link rel="shortcut icon" href="/edsystem/resources/img/favicon.ico"
	type="image/ico">
<script src="/edsystem/resources/js/jquery.js"></script>

</head>
<body style="background: #E0EEE0;">
	<sec:authorize access="isAuthenticated()">
		<nav class="navbar navbar-default navbar-static-top">
			<div class="container-fluid">
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<a class="navbar-brand" href="#!/home"><span
						class="glyphicon glyphicon-home"></span> Home</a>
					<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value='/logout'/>"><span class="glyphicon glyphicon-log-out"></span>
						Logout: ${pageContext.request.userPrincipal.name}</a></li>
			</ul>
				</div>
			</div>
		</nav>
	</sec:authorize>
	<div class="container">
		<ng-view> </ng-view>
	</div>

	<script src="webjars/angularjs/1.6.4/angular.js"></script>
	<script src="webjars/angularjs/1.6.4/angular-animate.js"></script>
	<script src="webjars/angularjs/1.6.4/angular-resource.js"></script>
	<script src="webjars/angularjs/1.6.4/angular-route.js"></script>
	<script src="/edsystem/static/js/views/main.js"></script>
	<script src="/edsystem/static/js/views/routes.js"></script>
	<script src="/edsystem/static/js/views/modules/signup/controller.js"></script>

</body>
</html>
