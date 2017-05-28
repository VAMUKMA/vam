<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="app">
<head>
<link rel="stylesheet" type="text/css"
	href="/edsystem/resources/css/bootstrap.min.css">
<link rel="shortcut icon" href="/edsystem/resources/img/favicon.ico"
	type="image/ico">

<script src="/edsystem/resources/js/jquery.js"></script>

<!--If login or password is incorrect-->
<c:if test="${not empty msg}">
	<script type="text/javascript">
		$(window).on('load', function() {
			$('#myModal').modal('show');
		});
	</script>
</c:if>

</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container"></div>
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

	<script src="/edsystem/resources/js/bootstrap.min.js"></script>
	<script src="/edsystem/resources/angular/angular.js"></script>
	<script src="/edsystem/resources/angular-resource/angular-resource.js"></script>
	<script src="/edsystem/resources/angular-route/angular-route.js"></script>
	<script src="/edsystem/static/js/views/main.js"></script>
	<script src="/edsystem/static/js/views/routes.js"></script>
	<script src="/edsystem/static/js/views/modules/signup/controller.js"></script>
	<script src="/edsystem/static/js/views/modules/signin/controller.js"></script>
</body>
</html>
