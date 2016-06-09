angular.module('appCFC').factory('graphService', function(){
	var graphOptions = {};
	var graphData = {};	
	var service = {};

	//configures the graphic with the default values; 
	service.configureGraph = function(){
		this.graphOptions = {
		        chart: {
		            type: 'stackedAreaChart',
		            height: 180,
		            margin : {
		                top: 20,
		                right: 20,
		                bottom: 40,
		                left: 55
		            },
		            x: function(d){ return d.x; },
		            y: function(d){ return d.y; },
		            useInteractiveGuideline: true,
		            duration: 0,    
		            yAxis: {
		                tickFormat: function(d){
		                   return d3.format('.0f')(d);
		                }
		            }
		        }
		    };
	}
	
	service.loadData = function(data){
		if (data == null || data==={}){
			return;
		}
		
//		valores:{
//			tipo : "efectivo",
//			datosX: "86786876",
//			datosY: "54530023"
//		}
			
	}
	
	
	
	return service;
	
	
})