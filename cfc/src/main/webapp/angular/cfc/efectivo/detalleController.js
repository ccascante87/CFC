'use strict'
angular.module('appCFC').controller('detalleController',['$scope', '$http', 'cfcConfigurationService', 'DTOptionsBuilder', 'DTColumnBuilder', 
                                                         function($scope, $http,cfcConfigurationService, DTOptionsBuilder,DTColumnBuilder){

	function init() {
		$scope.dtOptions =cfcConfigurationService.tableOptionsConfig();
		// load the details data talble
		// TODO Move the rest call to a service
		$http({
			method : 'GET',
			url : '/cfc/efectivo/getDetalles',
		}).success(function(result) {
			$scope.detalles = result;
		});
	}
	init();
} ]);// End controller