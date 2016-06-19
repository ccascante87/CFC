angular.module('appCFC').factory('graphService', function(){
	var graphOptions = {};
	var graphData = {};	
	var service = {};

	//configures the graphic with the default values; 
	service.configureGraph = function(){
		this.graphOptions = {
		        chart: {
		            type: 'stackedAreaChart',
		            height: 400,
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
//		            xScale : d3.time.scale(),
		            yAxis: {
		            	
		                tickFormat: function(d){
		                   return d;//d3.format('$,0.00f')(d);
		                }
		            },
		            
		            
//		            xAxis: {
//		            	ticks : d3.time.minutes,
//	                    tickFormat: function(d) {
//	                    	return new Date(d);
//////	                    	;	
////	                    	if(d == 'NaN:NaN:NaN')
////	                    		return '';
////	                    	else
////	                    		return (new Date(d));
//	                    }
//		            	 showMaxMin: true,
//		            	  ticks: d3.time.miliseconds
//		            	  tickFormat: function(d) {
//		            	    return d3.time.format('%X')(new Date(d));
//		            	  }
//	                },c
//	                showControls :false,	
		            tooltip:{

		            	valueFormatter:function (d) { return 'FF';
		            		//return d3.time.format('%X')(new Date(d));
		            	}
		            }
		        }
		
       
		    };
		
	}
	
	service.loadData = function(data){
		if (data == null || data==={}){
			return;
		}			
	}
	return service;	
})