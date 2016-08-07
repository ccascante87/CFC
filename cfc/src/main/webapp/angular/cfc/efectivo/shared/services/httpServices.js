angular.module('appCFC').factory('httpService', function($http, $q) {
	return {
		getGraphData : function(branch, currency) {
			var deferred = $q.defer();
			var url = '/cfc/efectivo/getGraphData/' + branch + '/' + currency;
			$http({
				method : 'GET',
				url : url
			}).success(function(data) {
				deferred.resolve(data);
			}).error(function(msg, code) {
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		getBranches : function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : '/cfc/efectivo/getSucursales',
			}).success(function(result) {
				deferred.resolve(result);
			}).error(function(msg, code){
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		getCurrencies : function() {
			var deferred = $q.defer();
			$http({
		        method: 'GET',
		        url: '/cfc/efectivo/getMonedas',
		    }).success(function (resultMoneda) {
		    	deferred.resolve(resultMoneda);
		    }).error(function(msg, code){
		    	deferred.reject(msg);
		    });
			return deferred.promise;		    
		},
		getTransactions : function(branch, currency){
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url: '/cfc/efectivo/getTransacciones'
			}).success(function (resultTransaction){
				deferred.resolve(resultTransaction);
			}).error(function (msg, code){
				deferred.reject(msg);
			});
			return deferred.promise;
		},
		getDetails : function(branch, currency){
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url: '/cfc/efectivo/getDetalles'
			}).success(function (rsltDetail){
				deferred.resolve(rsltDetail);
			}).error(function (msg, code){
				deferred.reject(msg);
			});
			return deferred.promise;
		}
	}
})