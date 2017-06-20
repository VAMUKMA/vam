angular.module('app').controller('ChapterListController', [
    '$scope', '$routeParams', 'ChapterListService',
    function ($scope, $routeParams, ChapterListService) {
        $scope.chapters = ChapterListService.query();
    }
]);