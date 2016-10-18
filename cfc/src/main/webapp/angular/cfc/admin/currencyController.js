'use strict'
angular.module('appCFC').controller('currencyController',['$scope', 'cfcConfigurationService', 'currencyHttpServices', '$window',
			function($scope, cfcConfigurationService, currencyHttpServices, $window) {
				$scope.currencyTableOptions = cfcConfigurationService.tableOptionsConfig();
				var init = function() {
					var promise = currencyHttpServices.getCurrencies();
					promise.then(function(results) {
						$scope.currencies = results;
					});
					$scope.showForm = false;
				}

				var reset = function() {
					$scope.selectedCurrency = {
						id: '',
						descripcion : '',
						simbolo : ''
					}
				}

				$scope.cancel = function() {
					reset();
					$scope.showForm = false;
				}
					
				$scope.saveOrUpdate = function() {
						var promise = currencyHttpServices.saveOrUpdate($scope.selectedCurrency);
						promise.then(function(results) {
							$scope.currencies = results;
							$scope.showForm = false;
						});
				}
				
				$scope.addNew = function() {
					reset();
					$scope.showForm = true;
				}

				$scope.edit = function(currency) {
					$scope.selectedCurrency = currency;
					$scope.showForm = true;
				}
				
				$scope.confirmDelete = function(currency){
					var deleteUser = $window.confirm('Está seguro de eliminar la moneda seleccionada?');

				    if (deleteUser) {
				      var promise = currencyHttpServices.deleteCurrency(currency.id);
				      promise.then(function(results){
				    	  $scope.currencies = results;
				      });
				    }
				}
	init();
}]);// End controller
