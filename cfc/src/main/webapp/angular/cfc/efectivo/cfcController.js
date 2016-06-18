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
	
	$scope.loadDataModel = function(){
		loadGraphic();
	}

    function loadGraphic(){    	 
		x++;
    	y++;    	
    	$http({
            method: 'GET',
            url: '/cfc/efectivo/getGraphData'
        }).success(function (result) {
        	jsonData = result.graphData;
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
	 		angular.forEach(jsonData.labels, function(item){
	 			$scope.data.push({ values: [], key: item });
//	 			console.log(item)
	 			values = jsonData.yAxisValues[item];
	 			 
	 			for(index = 0; index < xAxisValues.length;index++){
	 				$scope.data[x].values.push({x: xAxisValues[index], y: Math.random()*Math.random() + 2 });
	 				y= index;
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
		graphService.configureGraph();
		$scope.options = graphService.graphOptions;			
		var jsonData = {};
		loadGraphic();	
	    setInterval(function(){
	    	loadGraphic();
	    }, 30000); 
	    	$scope.selectedCurrency = "¢";
//	    	$scope.selectedBranch = $scope.sucursales[0].nomAgencia;
	   $scope.mainData.loggedUserName = 'Bruce Wayne';
	};
        
    //load currency dropdown    
    $scope.currency = ["¢", "$", "€"];
    
    //load sucursales
    //TODO: implement to extract sucursales from database and load the dropdown
    
    $http({
        method: 'GET',
        url: '/cfc/efectivo/getSucursales',
        //data: { applicationId: 3 }
    }).success(function (result) {
    	$scope.sucursales = result;
    	$scope.selectedBranch = $scope.sucursales[0].nomAgencia;
    });
    //$scope.sucursales= ["Central","Puntarenas","San Jose"]

    init();
}]);//End controller