'use strict'
angular.module('appCFC').controller('graphController', ['$scope','$http', 'cfcConfigurationService', 'httpService', function($scope,$http,cfcConfigurationService,httpService){
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
        
        this.loggedUserName = args.loggedUserName;

        this.cashVariations = {};
        this.cashValHistory = {};
	}	
	
	
	/*
	 * Updates the graph data according to the selected options.
	 */
	
	$scope.$on('someEvent', function(event, args) {
		
		console.log(' another ')
	});
	  // another controller or even directive
	
    function loadData(){    	 
    	x++;
    	y++;
    	//TODO get this data from dropdown
//    	var promise = httpService.getGraphData($scope.selectedBranch.idSucursal, $scope.selectedCurrency.id);
    	var promise = httpService.getGraphData(1150,1);
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
//          }
//	          , 
//	          function(errorPayload) {
//	        	  console.log(errorPayload);
          });
	
	};
    
	
	var datos = new MainData({
		
	});
	
	var startController = function(){
		$scope.mainData = datos;
	} ;
	
	var currencyFormat = function(d){
		return $scope.selectedCurrency.simbolo + d3.format(',.2f')(new Number(d));
	}
	    
    $scope.run = true;
    var values =[];
	var xAxisValues  ;//jsonData.xAxisValues;
	var x = 0;
	var y = 0;
	var init = function () {	
		
		startController();		
		$scope.cashFlowOptions = cfcConfigurationService.cashFlowOptionsConfig();
		$scope.cashVarOptions = cfcConfigurationService.cashVarOptionsConfig();		
		 
		$scope.cashFlowOptions.chart.yAxis1.tickFormat = currencyFormat;
		$scope.cashVarOptions.chart.yAxis1.tickFormat = currencyFormat;
		
		var jsonData = {};
		loadData();	
	    setInterval(function(){
	    	loadData();
	    }, 5000); 
	   $scope.mainData.loggedUserName = 'Bruce Wayne';
	   
	};
    init();
}]);//End controller