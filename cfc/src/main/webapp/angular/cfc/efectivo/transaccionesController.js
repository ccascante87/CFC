'use strict'
angular.module('appCFC').controller('transaccionesController',
		transaccionesController);// {

function transaccionesController($scope, $http, DTOptionsBuilder,
		DTColumnBuilder) {
	
	
	$scope.outerDefaults = {
//	        sPaginationType: "simple_numbers",
//	        bRetrieve: true,
//	        bDestroy: true,
//	        aaSorting: [[1, "asc"]],
//	        sDom: 'ftilp',
	        language: { // not withLanguage wich is from DTOptionsBuilder
	        	 sLengthMenu:     "Mostrar _MENU_ filas"
	        }
	    };
	
	
	$scope.dtOptions ={
	    sEmptyTable:     "No data available in table",
	    sInfo:           "Showing _START_ to _END_ of _TOTAL_ entries",
	    sInfoEmpty:      "Showing 0 to 0 of 0 entries",
	    sInfoFiltered:   "(filtered from _MAX_ total entries)",
	    sInfoPostFix:    "",
	    sInfoThousands:  ",",
	    sLengthMenu:     "Mostrar _MENU_ filas",
	    sLoadingRecords: "Loading...",
	    sProcessing:     "Processing...",
	    sSearch:         "Search:",
	    sZeroRecords:    "No matching records found",
	    oPaginate: {
	        sFirst:    "First",
	        sLast:     "Last",
	        sNext:     "Next",
	        sPrevious: "Previous"
	    },
	    oAria: {
	        sSortAscending:  ": activate to sort column ascending",
	        sSortDescending: ": activate to sort column descending"
	    },
	    
	    language: { // not withLanguage wich is from DTOptionsBuilder
            sSearch:"search test"
        }
	};
	
	
	
//	var vm = this;
//	vm.dtColumns = [];
//	
//	vm.dtColumns = [
////	  				DTColumnBuilder.newColumn('id').withTitle('ID'),
//	  				DTColumnBuilder.newColumn('codTransaccion').withTitle('First name'),
//	  				DTColumnBuilder.newColumn('descTransaccion').withTitle('Last name'),
//	  				DTColumnBuilder.newColumn('fecha').withTitle('Last name'),
//	  				DTColumnBuilder.newColumn('monto').withTitle('Last name') ];
	// var vm= this;
	// $scope.showTable = false;
	//	
	//	
	// function init() {
	// // usSpinnerService.spin('spinner-1');
	// console.log('Init transaccionesController nonononononononono');
	// // load transacciones datatable
	 $http({
	 method : 'GET',
	 url : '/cfc/efectivo/getTransacciones',
	 // data: { applicationId: 3 }
	 }).success(function(result) {
//		 var dtOptions = DTOptionsBuilder.fromSource(result)
//	        .withPaginationType('full_numbers');
//		
//		this.dtColumns = [
//				DTColumnBuilder.newColumn('id').withTitle('ID'),
//				DTColumnBuilder.newColumn('codTransaccion').withTitle('First name'),
//				DTColumnBuilder.newColumn('descTransaccion').withTitle('Last name'),
//				DTColumnBuilder.newColumn('fecha').withTitle('Last name'),
//				DTColumnBuilder.newColumn('monto').withTitle('Last name') ];
		console.log($scope)
	 $scope.transacciones = result;
	 // $scope.$apply();
//	 $scope.showTable = true;
	 // usSpinnerService.stop('spinner-1');
	 });
	console.log(' transaccionesController  ')

	
	console.log(' transaccionesController  END')

	//		
	// }
	//
	// init();
}
// End controller
