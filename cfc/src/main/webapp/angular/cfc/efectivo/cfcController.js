angular.module('appCFC').controller('cfcController', ['$scope','$http', 'graphService', function($scope,$http,graphService){
	
	function MainData(args) {
        this.usuario = args.usuario;//exercises || [];
        this.montoAsegurado = args.montoAsegurado;
        this.saldoActual = args.saldoActual ;            
        this.ocioso=args.ocioso;
        this.codigoSucursal=args.codigoSucursal;
        this.saldoAutorizado=args.saldoAutorizado;
        this.puntoReorden=args.puntoReorden;
        this.porcentajeUtilización=args.porcentajeUtilización;

        
        //TODO Model Pronostico
    };
    
	
//	
	var loadGraphic = function(){
		
	};
    
	
	var datos = new MainData({
		
		usuario : "Jaimito",
        montoAsegurado : "1000000.00",
        saldoActual : "1000000.00",         
        ocioso : "1000000.00",
        codigoSucursal : "San Jose",
        saldoAutorizado : "1000000.00",
        puntoReorden : "1000000.00",
        porcentajeUtilizacion : "10"
	});
	
	var startController = function(){
		$scope.mainData = datos;
	} ;
	
	function loadData(){
		$scope.data = [{ values: [], key: 'Saldo' },
		               { values: [], key: 'Ocioso' },
		               { values: [], key: 'Otrosss' }];		
	}
	
	    
    $scope.run = true;
	var init = function () {
		startController();
		
		graphService.configureGraph();
		$scope.options = graphService.graphOptions;
		
		
		var values =[];
		var xAxisValues  ;//jsonData.xAxisValues;
		var x = 0;
		var y = 0;
		
		
		var jsonData = {};//"yAxisValues":{"Efectivo":["1","2","3","4"],"Monedas":["1","2","3","4"],"Prestamos":["1","2","3","4"]},"xAxisValues":["1","2","3","4"],"labels":["Efectivo","Monedas","Prestamos"]};
		console.log('..............................................');
		$http({
            method: 'GET',
            url: '/cfc/efectivo/getGraphData',
            //data: { applicationId: 3 }
        }).success(function (result) {
        	jsonData = result;
        	console.log(jsonData );
        	xAxisValues = jsonData.xAxisValues;
        	x = 0;
	 		y = 0;
	 		$scope.data = [];		
	 		angular.forEach(jsonData.labels, function(item){
	 			$scope.data.push({ values: [], key: item });
//	 			console.log(item)
	 			values = jsonData.yAxisValues[item];
	 			 
	 			for(index = 0; index < xAxisValues.length;index++){
	 				$scope.data[x].values.push({x: xAxisValues[index], y: values[index] });
	 				y= index;
//	 				console.log(y)
	 			}
	 		    x++;
	 		});
	 		$scope.$apply(); // update both chart
	  });
		console.log('//////////////////');
		
//		$scope.data = [];
////		$scope.data = [{ values: [], key: 'Random Walk' }];		
//		angular.forEach(jsonData.labels, function(item){
//			$scope.data.push({ values: [], key: item });
//			values = jsonData.yAxisValues[item];
//			for(index = 0; index < xAxisValues.length;index++){
//				$scope.data[x].values.push({x: xAxisValues[index], y: values[index] });
//				y= index;
//			}
//		    x++;
////			$scope.data[x].values.push({ x: x,	y: Math.random() });
//		})
//		console.log($scope.data);
//		
		
		
	    setInterval(function(){
	    	x++;
	    	y++;    	
	    	$http({
	            method: 'GET',
	            url: '/cfc/efectivo/getGraphData',
	            //data: { applicationId: 3 }
	        }).success(function (result) {
	        	jsonData = result;
	        	console.log(jsonData );
	        	xAxisValues = jsonData.xAxisValues;
	        	x = 0;
		 		y = 0;
		 		$scope.data = [];		
		 		angular.forEach(jsonData.labels, function(item){
		 			$scope.data.push({ values: [], key: item });
//		 			console.log(item)
		 			values = jsonData.yAxisValues[item];
		 			 
		 			for(index = 0; index < xAxisValues.length;index++){
		 				$scope.data[x].values.push({x: xAxisValues[index], y: values[index] });
		 				y= index;
//		 				console.log(y)
		 			}
		 		    x++;
		 		});
		  });	      
	    	console.log("Updated");
	    }, 5000); 
	    	$scope.selectedCurrency = "¢";
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
    });
    //$scope.sucursales= ["Central","Puntarenas","San Jose"]

    init();
}]);//End controller