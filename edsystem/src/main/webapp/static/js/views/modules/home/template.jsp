<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="/edsystem/static/js/views/modules/home/style.css">

<sec:authorize access="hasRole('user')">
<div class="row">
	<div class="col-md-12 body">
		<div class="row course-active">
			<a href="#!/home">
				<div class="progress-bar" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
					<span>Name of course</span>
				</div>
			</a>
		</div>
		<div class="row course">
			<a href="#!/home">
				<div role="progressbar">
					<span><p>Name of course</p></span>
				</div>
			</a>
		</div>
		<div class="row course">
			<a href="#!/home">
				<div role="progressbar" aria-valuenow="0" aria-valuemin="0"
					aria-valuemax="100">
					<span><p>Name of course</p></span>
				</div>
			</a>
		</div>
		<div class="row course">
			<a href="#!/home">
				<div role="progressbar" aria-valuenow="0" aria-valuemin="0"
					aria-valuemax="100">
					<span><p>Name of course</p></span>
				</div>
			</a>
		</div>
		<div class="row course">
			<a href="#!/home">
				<div role="progressbar" aria-valuenow="0" aria-valuemin="0"
					aria-valuemax="100">
					<span><p>Name of course</p></span>
				</div>
			</a>
		</div>
	</div>
</div>
</sec:authorize>
