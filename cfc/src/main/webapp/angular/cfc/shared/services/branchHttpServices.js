'use strict'
angular.module('appCFC').factory('branchHttpServices', function($http, $q) {
	return {
		getBranches : function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/branches/getSucursales',
			}).success(function(result) {
				deferred.resolve(result);
			}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		saveOrUpdateBranch : function(branch) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : '/cfc/branches/saveOrUpdate',
				data : {
					"id" : branch.id,
					"codigoSucursal" : branch.codigoSucursal,
					"horaApertura" : branch.horaApertura,
					"horaCierre" : branch.horaCierre,
					"nomSucursal" : branch.nomSucursal,
					"sucursalMontoMonedas" : branch.sucursalMontoMonedas,
					"sucursalPorcents" : branch.sucursalPorcents
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
		},
		deleteBranch : function(branchId){
			var deferred = $q.defer();
			$http({
				method: 'POST',
				url: '/cfc/branches/deleteBranch',
				data:
					 branchId
				
			}).success(function(result){
				deferred.resolve(result);
			}).error(function(msg, code){
				deferred.reject(msg);
			})
			return deferred.promise;
		}
	}
})