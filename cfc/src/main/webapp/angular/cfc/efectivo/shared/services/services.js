angular.module('appCFC').factory('graphService', function() {
	var stackedChartOptions = {};
	var multiChartOptions = {};
	var graphData = {};
	var service = {};

	// configures the graphic with the default values;
	service.stackedAreaChartConfig = function() {
		this.stackedChartOptions = {
			chart : {
				type : 'stackedAreaChart',
				height : 470,
				margin : {
					top : 20,
					right : 20,
					bottom : 40,
					left : 55
				},
				x : function(d) {
					return d.x;
				},
				y : function(d) {
					return d.y;
				},
				useInteractiveGuideline : true,
				duration : 0,
				yAxis : {
					tickFormat : function(d) {
						return d3.format(',.2f')(d);
					}
				},
				xAxis : {
					tickFormat : function(d) {
						return d3.time.format('%X')(new Date(d));
					},

				},
				showControls : false,
				interactiveLayer : {
					tooltip : {
						headerFormatter : function(d) {
							return d3.time.format('%X')(new Date(d));
						}
					}

				}
			}
		}
	};

	service.multichartConfig = function() {
		this.multiChartOptions = {
			chart : {
				useInteractiveGuideline : true,
				type : 'multiChart',
				height : 450,
				margin : {
					top : 20,
					right : 80,
					bottom : 40,
					left : 80
				},
				color : ['red', 'green', 'yellow', 'pink', 'black'],
				duration : 0,
				xAxis : {
					tickFormat : function(d) {
						return d3.time.format('%X')(new Date(d));
					}
				},
				yAxis1 : {
					tickFormat : function(d) {
						return d3.format(',.1f')(d);
					}
				},
				yAxis2 : {
					tickFormat : function(d) {
						return d3.format(',.1f')(d);
					}
				}
				,
				interactiveLayer:{
					tooltip:{
						headerFormatter : function(d) { 
							console.log('Valor fecha: ' 
									 + new Date(d)  + ', Valor long: ' 
									  + d);
//							var Date dt = new Date();
//							dt.setTime(d)
//							console.log(dt);
							return d3.time.format('%X')(new Date(d));
						}
					}
				},
//				showControls : true,
					tooltip : {
						useInteractiveGuideline : true,	
						x:function(d){
							console.log('x');
							return 'd';},
						headerFormatter : function(d) {
							console.log('heaer formatter:' + d);
							console.log(new Date(d));
							return d3.time.format('%x')(new Date(d));
						},
						valueFormatter:function (obj) { 
							console.log('kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk')
							console.log(obj)
							return 'ffffffffffff'}
					}

				
				,
				yDomain1 : [0, 500000000],
				yDomain2 : [0, 500000000],
				legendRightAxisHint : ''
			}
		}

	};
	return service;
})