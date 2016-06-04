angular.module('appCFC').controller('cfcController', ['$scope', 'graphService', function($scope,graphService){
	
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
        saldoActual : "C10,000,00.00",         
        ocioso : "C10,000,00.00",
        codigoSucursal : "San Jose",
        saldoAutorizado : "C10,000,00.00",
        puntoReorden : "C10,000,00.00",
        porcentajeUtilización : "%10"
	});
	
	var startController = function(){
		$scope.mainData = datos;
//		console.log("jajaj");
	} ;
	//////
//	var loadHome = function loadHome() {
//		var homepageHtml = 'graphColones';
//		loadHTML(homepageHtml);
//	}

//	function loadHTML(htmlFile) {
//		var wrapper = $('#content-wrapper');
//		if (htmlFile != undefined) {
//			console.log("adfadfadsf");
//			var htmlSnippet = 'app/snippets/' + htmlFile + '.html';
//			$.ajax({
//				url : htmlSnippet,
//				type : 'GET',
//				cache : false,
//				success : function(html) {
//					wrapper.html(html);
//				}
//			});
//		}
//		$scope.$apply();
//	}
	////////////////////////
	
	//TODO Move to proper location...
//	$scope.options = {
//	        chart: {
//	            type: 'stackedAreaChart',
//	            height: 180,
//	            margin : {
//	                top: 20,
//	                right: 20,
//	                bottom: 40,
//	                left: 55
//	            },
//	            x: function(d){ return d.x; },
//	            y: function(d){ return d.y; },
//	            useInteractiveGuideline: true,
//	            duration: 1000,    
//	            yAxis: {
//	                tickFormat: function(d){
//	                   return d3.format('.01f')(d);
//	                }
//	            }
//	        }
//	    };
	
	function loadData(){
		$scope.data = [{ values: [], key: 'Random Walk' },{ values: [], key: 'Trail running' }];
	}
	
	    
    $scope.run = true;
	var init = function () {
		console.log("init")
		startController();
		
		graphService.configureGraph();
		console.log("sdfasdfasdfasdf");
		console.log(graphService.graphOptions);
		$scope.options = graphService.graphOptions;
//		$scope.$apply();
//		loadHome();
//		
//		
	    loadData();
	    var x = 0;
	    setInterval(function(){
		    if (!$scope.run) return;
		    $scope.data[0].values.push({ x: x,	y: Math.random() - 0.5});
		    $scope.data[1].values.push({ x: x,	y: Math.random() + 0.5});
	      if ($scope.data[0].values.length > 20) $scope.data[0].values.shift();
		    x++;
//		    console.log("por a a a a " + x)
	      $scope.$apply(); // update both chart
	    }, 500);        
//        startController();
    };

    init();
}]);//End controller