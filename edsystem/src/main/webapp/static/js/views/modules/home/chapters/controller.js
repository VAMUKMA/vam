angular.module('app').controller(
		'LessonListController',
		[ '$scope', '$routeParams','FindChapterService',
				function($scope, $routeParams, FindChapterService) {
					$scope.chapter = FindChapterService.get({tId: $routeParams.id});
				}
		]);