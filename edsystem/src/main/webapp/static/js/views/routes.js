angular.module('app').config([ '$routeProvider','$locationProvider', function($routeProvider, $locationProvider) {
	$routeProvider
		.when('/signin', {templateUrl: '/edsystem/static/js/views/modules/signin/template.jsp'})
		.when('/signup', {templateUrl: '/edsystem/static/js/views/modules/signup/template.jsp', controller: 'SignUpController'})
		.when('/home', {templateUrl: '/edsystem/static/js/views/modules/home/template.jsp', controller: 'ChapterListController'})
		.when('/main', {templateUrl: '/edsystem/static/js/views/modules/main/template.jsp'})
		.when('/themes/:id', {templateUrl: '/edsystem/static/js/views/modules/home/chapters/template.jsp', controller: 'LessonListController'})
		.when('/chapters/chapter_1', {templateUrl: '/edsystem/static/js/views/modules/home/chapters/chapter_1/chapter_1.jsp'})
		.when('/chapters/chapter_2', {templateUrl: '/edsystem/static/js/views/modules/home/chapters/chapter_2/chapter_2.jsp'});
	window.location = '/edsystem/#!/signin';
	$locationProvider.hashPrefix('!');
} ]);