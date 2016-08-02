'use strict'
angular.module('appCFC').controller('transaccionesController',['$scope','$http','cfcConfigurationService','DTOptionsBuilder','DTColumnBuilder',
				function($scope, $http, cfcConfigurationService,DTOptionsBuilder, DTColumnBuilder) {
 
	function init(){
		$scope.dtOptions = cfcConfigurationService.tableOptionsConfig();
		// load transacciones datatable
		//TODO Move the rest call to proper file
		$http({
			method : 'GET',
			url : '/cfc/efectivo/getTransacciones',
		}).success(function(result) {
			$scope.transacciones = result;
		});
	}
	init();
}]);
// End controller
