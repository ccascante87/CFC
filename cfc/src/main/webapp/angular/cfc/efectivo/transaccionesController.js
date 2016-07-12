'use strict'
angular.module('appCFC').controller('transaccionesController', ['$scope', '$http', function($scope, $http) {
	$scope.showTable = false;
	function init() {
//		usSpinnerService.spin('spinner-1');
		console.log('Init transaccionesController nonononononononono');
		// load transacciones datatable
		$http({
			method : 'GET',
			url : '/cfc/efectivo/getTransacciones',
		// data: { applicationId: 3 }
		}).success(function(result) {
			console.log('desde la');
			console.log(result);
			$scope.transacciones = result;
//			$scope.$apply();
			$scope.showTable = true;
//				usSpinnerService.stop('spinner-1');
		});
	}

	init();
} ]);// End controller
