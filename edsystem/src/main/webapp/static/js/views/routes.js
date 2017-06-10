angular.module('app').config([ '$routeProvider','$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/signin', {templateUrl: '/edsystem/static/js/views/modules/signin/template.jsp', controller: 'SignInController'})
		.when('/signup', {templateUrl: '/edsystem/static/js/views/modules/signup/template.jsp', controller: 'SignUpController'})
		.when('/home', {templateUrl: '/edsystem/static/js/views/modules/home/template.jsp'});
	window.location = '/#!/signin';
	$locationProvider.hashPrefix('!');
} ]);