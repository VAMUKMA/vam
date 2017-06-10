angular.module('app').controller('SignInController', [
    '$scope', '$routeParams', '$window', '$http',
    function ($scope, $routeParams, $window, $http) {

		$scope.item = { email: '', password: '' };

		$scope.submit = submit;

		function submit () {
			$http.post('/edsystem/home', $scope.item)
				.then(function (response) {
					store.set('token', response.data.token);
					$window.location.href = '/edsystem/#!/home';
				});
		}
    }
]);
