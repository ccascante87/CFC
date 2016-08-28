'use strict'
angular.module('appCFC').factory('currencyHttpServices', function($http, $q) {
	return {
		getCurrencies : function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/currency/getMonedas',
			}).success(function(resultMoneda) {
				deferred.resolve(resultMoneda);
			}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		saveOrUpdate : function(currency) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : '/cfc/currency/saveOrUpdate',
				data : {
					"id" : currency.id,
					"descripcion" : currency.descripcion,
					"simbolo" : currency.simbolo

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
		deleteCurrency : function(currencyId) {
			var deferred = $q.defer();
			$http({
				method: 'POST',
				url: '/cfc/currency/deleteBranch',
				data:
					currencyId				
			}).success(function(result){
				deferred.resolve(result);
			}).error(function(msg, code){
				deferred.reject(msg);
			})
			return deferred.promise;
		}
	}
})