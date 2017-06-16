<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<link rel="stylesheet" type="text/css"
	href="/edsystem/static/js/views/modules/home/style.css">

<sec:authorize access="hasRole('user')">
<div class="row">
	<div class="col-md-12 body">
		<div class="row course-active">
			<a href="#!/chapters/chapter_1">
				<div class="progress-bar" role="progressbar" aria-valuenow="60"
					aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
					<span>Chapter_1</span>
				</div>
			</a>
		</div>
		<div class="row course">
			<a href="#!/chapters/chapter_2">
				<div role="progressbar">
					<span><p>Chapter_2</p></span>
				</div>
			</a>
		</div>
	</div>
</div>
</sec:authorize>
