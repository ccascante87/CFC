'use strict'
angular.module('appCFC').factory('userHttpController', function($q, $http){
	return {
		getUser: function(loginName) {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/user/getUser/' + loginName,
			}).success(function(result) {
				console.log(result)
				deferred.resolve(result);
			}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		}
	}
})