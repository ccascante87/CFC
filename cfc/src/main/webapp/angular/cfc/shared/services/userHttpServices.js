'use strict'
angular.module('appCFC').factory('userHttpServices', function($q, $http) {
	return {
		getUser : function(loginName) {
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
		},
		getUsers : function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/user/getUser/all' ,
			}).success(function(result) {
				console.log(result)
				deferred.resolve(result);
			}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		saveUser : function(user) {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/user/getUser/all',
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