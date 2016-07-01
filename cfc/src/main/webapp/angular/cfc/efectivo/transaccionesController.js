/**
 * 
 */
angular.module('appCFC').controller('transaccionesController', ['$scope','$http', function($scope,$http){
		
		   //load transacciones datatable  
	    $http({
	        method: 'GET',
	        url: '/cfc/efectivo/getTransacciones',
	        //data: { applicationId: 3 }
	    }).success(function (result) {
	    	$scope.transacciones = result;
	    });
}]);//End controller