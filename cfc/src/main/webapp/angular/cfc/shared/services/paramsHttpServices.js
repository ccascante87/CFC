'use strict'
angular.module('appCFC').factory('paramsHttpServices', function($q, $http) {
	return {
		getParameters: function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/parameters/findAll',
			}).success(function(result) {
				console.log(result)
				deferred.resolve(result);
			}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		updateParam : function(param) {
			console.log(param)
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : '/cfc/parameters/updateParam',
				data : {
					"id" : param.id,
					"shortDesc" : param.shortDesc,
					"paramKey" : param.paramKey,
					"paramValue" : param.paramValue
				},
				headers : {
					'Content-Type' : 'application/json'
				}
			}).success(function(result) {
				deferred.resolve(result);
			}).error(function(msg, code) {
				deferred.reject(msg);
			})
			return deferred.promise;
		}
	}
})