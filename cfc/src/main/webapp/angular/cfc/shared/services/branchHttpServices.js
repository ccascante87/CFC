'use strict'
angular.module('appCFC').factory('branchHttpServices', function($http, $q){
	return{
		getBranches : function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/branches/getSucursales',
			}).success(function(result) {
				deferred.resolve(result);
			}).error(function(msg, code){
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		saveOrUpdateBranch : function(branch){
			var deferred = $q.defer();
			console.log(branch);
			console.log('....................')
			$http({
				method : 'POST',
				url : '/cfc/branches/saveOrUpdate',
				data: branch,
				headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
			}).success(function(result){
				deferred.resolve(result);
			}).error(function ( msg, code){
				deferred.reject(msg);
			}
			)
		}
	}
})