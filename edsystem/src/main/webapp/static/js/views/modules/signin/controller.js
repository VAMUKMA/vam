angular.module('app').controller('SignInController', [
    '$scope', '$routeParams', '$window', '$http',
    function ($scope, $routeParams, $window, $http) {

		$scope.item = { email: '', password: '' };

		$scope.submit = submit;

		function submit () {
			$http.post('http://localhost:8080/edsystem/home', $scope.item)
				.then(function (response) {
					$window.location.href = '#!/home';
				});
		}
    }
]);
