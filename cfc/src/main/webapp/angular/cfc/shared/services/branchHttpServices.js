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
					"idSucursal" : branch.idSucursal,
					"codigoAgencia" : branch.codigoAgencia,
					"horaApertura" : branch.horaApertura,
					"horaCierre" : branch.horaCierre,
					"montoAsegurado" : branch.montoAsegurado,
					"montoAutorizado" : branch.montoAutorizado,
					"nomAgencia" : branch.nomAgencia
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