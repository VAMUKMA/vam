angular.module('app', ['ngResource', 'ngRoute']).run(
		[ '$rootScope', '$window', function($rootScope, $window) {

			$rootScope.isLoggedIn = false;
			$rootScope.logout = logout;

			function logout() {
				$window.location.href = '#!/signin';
			}

		} ]);