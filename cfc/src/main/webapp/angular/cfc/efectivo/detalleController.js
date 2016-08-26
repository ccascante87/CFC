'use strict'
angular.module('appCFC').controller('detalleController',['$scope', 'httpService', 'cfcConfigurationService', 'DTOptionsBuilder', 'DTColumnBuilder', 
                                                         function($scope, httpService,cfcConfigurationService, DTOptionsBuilder,DTColumnBuilder){

	/**
	 * Call the service to get the updated details data and populates the table with it
	 */
	function loadData(branchId, currencyId){
		var promise = httpService.getDetails(branchId, currencyId);
		promise.then(function (result){
			$scope.detalles = result;
		});
	}
	function init() {
		$scope.dtOptions =cfcConfigurationService.tableOptionsConfig();
		var brach = $scope.selectedBranch == undefined ? '1' : $scope.selectedBranch.idSucursal;
		var currency = $scope.selectedCurrency == undefined ? '1': $scope.selectedCurrency.id;
		loadData(brach, currency);
	}
	
	/**
	 * Captures the broadcasted event to update the page data with the new selected data.
	 */
	 $scope.$on('parametersChange', function(e) {
		var brach = $scope.selectedBranch == undefined ? '1' : $scope.selectedBranch.idSucursal;
		var currency = $scope.selectedCurrency == undefined ? '1': $scope.selectedCurrency.id;
		loadData(brach, currency);
	});
	 
	init();
} ]);// End controller