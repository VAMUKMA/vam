angular.module('app').controller(
		'SignUpController',
		[ '$scope', '$routeParams', '$window', '$http',
				function($scope, $routeParams, $window, $http) {

					$scope.item = {
						email : '',
						password : ''
					};

					$scope.signup = signup;

					function signup() {
						$http.post('http://localhost:8080/edsystem/user', $scope.item);
						alert("You have been registered!");
						$window.location.href = '/edsystem/#!/signin';
					}
				} ]);