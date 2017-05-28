angular.module('app').config([ '$routeProvider','$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/signin', {templateUrl: '/edsystem/static/js/views/modules/signin/template.jsp'})
		.when('/signup', {templateUrl: '/edsystem/static/js/views/modules/signup/template.jsp'});
	window.location = '#!/signin';
	$locationProvider.hashPrefix('!');
} ]);