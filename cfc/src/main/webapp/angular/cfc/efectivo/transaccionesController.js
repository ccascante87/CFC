'use strict'
angular.module('appCFC').controller('transaccionesController',['$scope','httpService','cfcConfigurationService','DTOptionsBuilder','DTColumnBuilder',
				function($scope, httpService, cfcConfigurationService,DTOptionsBuilder, DTColumnBuilder) {
 
	/**
	 * Call the service to get the updated transaction data and populates the table with it
	 */
	function loadData(branchId, currencyId){
//		console.log(branchId );
		var promise = httpService.getTransactions(branchId, currencyId);
		promise.then(function (result){
			$scope.transacciones = result;
		});
	}
	
	/**
	 * Perform the controller initialization.
	 */
	function init(){
		$scope.dtOptions = cfcConfigurationService.tableOptionsConfig();
		loadData(1, 2);
	}	
	
	/**
	 * Captures the broadcasted event to update the page data with the new selected data.
	 */
	 $scope.$on('someEvent', function(e) {
		 console.log('Broadcasted evente caoruted by transacciones');
		 loadData($scope.selectedBranch.idSucursal, $scope.selectedCurrency.id);
	 });	 
	init();
}]);
// End controller
