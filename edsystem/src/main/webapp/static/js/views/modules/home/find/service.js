angular.module('app').service('FindChapterService',
		[ '$resource', function($resource) {
			return $resource('themes/:tId',{tId : '@id'},{
				query:{method: 'GET', isArray:true}
			});
		} ]);