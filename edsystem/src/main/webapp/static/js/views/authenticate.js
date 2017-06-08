angular.module('app.authentication', []).factory('authenticationInterceptor', [
	function () {
		return {
			request: function (config) {
				var token = store.get('token');
				config.headers.Authorization = 'Bearer ' + token;
				return config;
			}
		};
	}
]);