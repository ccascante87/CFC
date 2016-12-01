'use strict'
angular.module('appCFC').controller('graphController', ['$scope','$interval', 'cfcConfigurationService', 'httpService', 'AuthService',
                                                        function($scope,$interval,cfcConfigurationService,httpService, AuthService){
	function MainData(args) {
		this.usuario = args.usuario;;
		this.montoAsegurado = args.montoAsegurado;
		this.saldoActual = args.saldoActual;
		this.ocioso = args.ocioso;
		this.codigoSucursal = args.codigoSucursal;
		this.saldoAutorizado = args.saldoAutorizado;
		this.puntoReorden = args.puntoReorden;
		this.porcentajeUtilización = args.porcentajeUtilización;
		this.cashBehaviorDetail = {};
		this.currentBalanceHistory = {};
		
        this.byDateToday = args.byDateToday;
        this.byDateTomorrow = args.byDateTomorrow;
        this.byDayToday = args.byDayToday;
        this.byDayTomorrow = args.byDayTomorrow;

        this.cashVariations = {};
        this.cashValHistory = {};
	}	
	
	/** Variable used to hold the promise returned by the $interval service*/
	var intervalPromise;
    function loadData(){    
    	x++;
    	y++;
    	var brach = $scope.selectedBranch == undefined ? '1' : $scope.selectedBranch.id;
    	var currency = $scope.selectedCurrency == undefined ? '1' : $scope.selectedCurrency.id;
//    	var promise = httpService.getGraphData($scope.selectedBranch.idSucursal, $scope.selectedCurrency.id);
    	var promise = httpService.getGraphData(brach,currency);
	    promise.then(function(result) { 
            var jsonData = result.compEfectivoGraph;
          	datos.cashBehaviorDetail = result.cashBehaviorDetail;        	
        	datos.montoAsegurado = result.insuredAmount;
        	datos.saldoActual = result.currentBalance;
        	datos.ocioso = result.lazyAmount;
        	datos.saldoAutorizado = result.autorizedBalance;
        	datos.puntoReorden = result.reorderPoint;
        	datos.porcentajeUtilización = result.utilizationRate;
        	datos.currentBalanceHistory = result.currentBalanceHistory;
        	datos.byDateToday = result.forecast.byDateToday;
        	datos.byDateTomorrow = result.forecast.byDateTomorrow;
        	datos.byDayToday = result.forecast.byDayToday;
        	datos.byDayTomorrow = result.forecast.byDayTomorrow;
        	
        	datos.cashVariations = result.cashVariations;
        	datos.cashValHistory = result.cashValHistory;
            
        	xAxisValues = jsonData.xAxisValues;
        	x = 0;
	 		y = 0;
	 		$scope.data = [];		
	 		angular.forEach(jsonData.yAxisValues, function(item){
	 			$scope.data.push({ values: [], key: item.label, type: item.type,yAxis: 1 ,
	 		 		originalKey: item.label,  seriesIndex: x });

	 			for(var index = 0; index < xAxisValues.length;index++){
	 				//console.log(xAxisValues[index]);
	 				$scope.data[x].values.push({x: xAxisValues[index], y: Number( item.itemValues[index])});
	 			}
	 		    x++;
	 		});
	 		
	 		jsonData = result.varEfectivoGraph;
	 		xAxisValues = jsonData.xAxisValues;
        	x = 0;
	 		y = 0;
	 		$scope.data2 = [];		
	 		angular.forEach(jsonData.yAxisValues, function(item){
	 			$scope.data2.push({ values: [], key: item.label, type: item.type,yAxis: 1 ,
	 				originalKey: item.label,
	 				seriesIndex: x });
	 			for(var index = 0; index < xAxisValues.length;index++){
	 					$scope.data2[x].values.push({x: xAxisValues[index], y:Number( item.itemValues[index])});
	 			}
	 		    x++;
	 		});
          });
	};
	
	var datos = new MainData({
		
	});
	/*Utility function to create the currency format for the graphs*/	
	var currencyFormat = function(d){
		return $scope.user.defaultCurrency.simbolo + d3.format(',.2f')(new Number(d));
	}
	
	 $scope.$on('parametersChange', function(e) {
	     loadData();
	    });
	 
	    
	 
	 /**
	  * Cancel the interval whenever navigate away from the graph page
	  */
	 $scope.$on('$destroy', function() {
         $interval.cancel(intervalPromise);
         intervalPromise =  undefined;
       });
	 
	 
    $scope.run = true;
    var values =[];
	var xAxisValues;
	var x = 0;
	var y = 0;
	var init = function () {	
		$scope.mainData = datos;
		var user = AuthService.getCurrentUser().applicationParameters;
		console.log(user.graphUpdateInterval);
		$scope.cashFlowOptions = cfcConfigurationService.cashFlowOptionsConfig();
		$scope.cashVarOptions = cfcConfigurationService.cashVarOptionsConfig();		
		 
		$scope.cashFlowOptions.chart.yAxis1.tickFormat = currencyFormat;
		$scope.cashVarOptions.chart.yAxis1.tickFormat = currencyFormat;
		
		var jsonData = {};
		loadData();	
		intervalPromise = $interval(
				function (){
				//	/loadData();
				}, new Number(user.graphUpdateInterval));
	};
    init();
}]);//End controller