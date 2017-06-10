<html ng-app="app">
<head>
<link rel="stylesheet" type="text/css"
	href="/edsystem/resources/css/bootstrap.min.css">
<link rel="shortcut icon" href="/edsystem/resources/img/favicon.ico"
	type="image/ico">
<script src="/edsystem/resources/js/jquery.js"></script>
<!--script type="text/javascript">
		$(window).on('load', function() {
			$('#myModal').modal('show');
		});
	</script-->

</head>
<body>
	<nav class="navbar navbar-default navbar-static-top"
		ng-show="isLoggedIn">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<a class="navbar-brand" href="#!/home"><span
					class="glyphicon glyphicon-home"></span> Home</a>
				<a class="navbar-brand navbar-right" ng-click="logout()"><span class="glyphicon glyphicon-log-out"></span>
					Logout</a>
				<!--ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/logout" />"><span class="glyphicon glyphicon-log-out"></span>
						Logout: ${pageContext.request.userPrincipal.name}</a></li>
			</ul-->
			</div>
		</div>
	</nav>
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="alert alert-danger" role="alert">
						<span class="glyphicon glyphicon-exclamation-sign"
							aria-hidden="true"></span> <span class="sr-only">Error:</span>
						${msg}
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>

	<ng-view> </ng-view>

	<script src="/edsystem/resources/js/angular.js"></script>
	<script src="/edsystem/resources/js/store/dist/store.legacy.min.js"></script>
	<script src="/edsystem/resources/js/angular-resource.js"></script>
	<script src="/edsystem/resources/js/angular-route.js"></script>
	<script src="/edsystem/static/js/views/authentication.js"></script>
	<script src="/edsystem/static/js/views/main.js"></script>
	<script src="/edsystem/static/js/views/routes.js"></script>
	<script src="/edsystem/static/js/views/modules/signup/controller.js"></script>
	<script src="/edsystem/static/js/views/modules/signin/controller.js"></script>
	


</body>
</html>
