angular.module('appCFC').controller('cfcController', ['$scope','$http', 'graphService', function($scope,$http,graphService){
	function MainData(args) {
		this.usuario = args.usuario;// exercises || [];
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

	}	
	
    function loadData(){    	 
		x++;
    	y++;    	
    	$http({
            method: 'GET',
            url: '/cfc/efectivo/getGraphData'
        }).success(function (result) {
        	jsonData = result.compEfectivoGraph;
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
            
        	xAxisValues = jsonData.xAxisValues;
        	x = 0;
	 		y = 0;
	 		$scope.data = [];		
	 		angular.forEach(jsonData.yAxisValues, function(item){
//	 			console.log(item)
	 			$scope.data.push({ values: [], key: item.label, type: item.type,yAxis: item.type == "line" ? 2:1 ,
	 				originalKey: item.label,
	 				seriesIndex: x });
//	 			console.log("item:");
//	 			console.log(item.itemValues)
	 			
	 			for(index = 0; index < xAxisValues.length;index++){
//	 				if(item.type == "line" ){
//	 					$scope.data[x].values.push({x: xAxisValues[index], y: 7	 });	
//	 				}
//	 				else
//	 				console.log( item.itemValues[index] )
	 				$scope.data[x].values.push({x: xAxisValues[index], y: Number( item.itemValues[index])});
////	 				y= index;C
	 				
//	 				if(item.type == "line" ){
//	 					$scope.data[x].values.push({x: xAxisValues[index], y: 7	 });	
//	 				}
//	 				else
//	 					$scope.data[x].values.push({x: xAxisValues[index], y: Math.random()   * 100000000});
	 				
	 			}
	 		    x++;
	 		});
	 		
	 		jsonData = result.varEfectivoGraph;
	 		xAxisValues = jsonData.xAxisValues;
        	x = 0;
	 		y = 0;
	 		$scope.data2 = [];		
	 		angular.forEach(jsonData.yAxisValues, function(item){
	 			console.log(item)
	 			$scope.data2.push({ values: [], key: item.label, type: item.type,yAxis: item.type == "line" ? 2:1 ,
	 				originalKey: item.label,
	 				seriesIndex: x });
	 			for(index = 0; index < xAxisValues.length;index++){
//	 				if(item.type == "line" ){
//	 					$scope.data2[x].values.push({x: xAxisValues[index], y: 7	 });	
//	 				}
//	 				else
	 					$scope.data2[x].values.push({x: xAxisValues[index], y:Number( item.itemValues[index])});
//	 				y= index;C
	 			}
	 		    x++;
	 		});
	 		});
	};
    
	
	var datos = new MainData({
		
	});
	
	var startController = function(){
		$scope.mainData = datos;
	} ;
	
	

	
	    
    $scope.run = true;
    var values =[];
	var xAxisValues  ;//jsonData.xAxisValues;
	var x = 0;
	var y = 0;
	var init = function () {		
		startController();		
		graphService.cashFlowOptionsConfig();
		graphService.cashVarOptionsConfig();		
		$scope.cashFlowOptions = graphService.cashFlowOptions;
		$scope.cashVarOptions = graphService.cashVarOptions;
		
		
		
		
		var jsonData = {};
		loadData();	
	    setInterval(function(){
	    	loadData();
	    }, 5000); 
	    	$scope.selectedCurrency = "¢";
	   $scope.mainData.loggedUserName = 'Bruce Wayne';
	   
	};
        
    //load currency dropdown    
    //$scope.currency = ["¢", "$", "€"];
    $http({
        method: 'GET',
        url: '/cfc/efectivo/getMonedas',
        //data: { applicationId: 3 }
    }).success(function (resultMoneda) {
    	console.log("resultmoneda");
    	console.log(resultMoneda);
    	$scope.currency = resultMoneda;
    	$scope.selectedCurrency = $scope.currency[0];
    });
    
    $http({
        method: 'GET',
        url: '/cfc/efectivo/getSucursales',
        //data: { applicationId: 3 }
    }).success(function (result) {
    	$scope.sucursales = result;
    	$scope.selectedBranch = $scope.sucursales[0];
    });
    //$scope.sucursales= ["Central","Puntarenas","San Jose"]

    init();
}]);//End controller