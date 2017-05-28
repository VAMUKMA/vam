<div class="container">
	<div id="signupbox"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2"
		style="margin-top: 150px;">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign Up</div>
				<div
					style="float: right; font-size: 85%; position: relative; top: -10px">
					<a id="signinlink" href="#!/signin">Sign In</a>
				</div>
			</div>
			<div class="panel-body">
				<form id="signupform" class="form-horizontal" role="form">

					<div id="signupalert" style="display: none"
						class="alert alert-danger">
						<p>Error:</p>
						<span></span>
					</div>


					<div class="form-group">
						<label for="email" class="col-md-3 control-label">Email</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="email"
								placeholder="Email Address" required autofocus ng-model="item.email">
						</div>
					</div>

					<div class="form-group">
						<label for="password" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="passwd"
									placeholder="Password" required autofocus ng-model="item.password">
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<button id="btn-signup" type="button" class="btn btn-info" ng-click="signup()">
								<i class="icon-hand-right"></i>Sign Up
							</button>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>
