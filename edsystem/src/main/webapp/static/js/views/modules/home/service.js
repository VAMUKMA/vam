angular.module('app').service('ChapterListService', [ '$resource',
    function($resource){
        return $resource('themes', {}, {
            query: {method:'GET', isArray:true}
        });
    }
]);