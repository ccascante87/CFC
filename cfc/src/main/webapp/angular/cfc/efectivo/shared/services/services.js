angular.module('appCFC').factory('graphService', function() {
	var cashFlowOptions = {};
	var cashVarOptions = {};
	var service = {};
	
//TODO Find out how to  make this more reusable and not one variable per graph
	service.cashFlowOptionsConfig = function() {
		this.cashFlowOptions = {
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
									 + new Date(1467691414948)  + ', Valor long: ' 
									  + d);
//							var Date dt = new Date();
//							dt.setTime(d)
//							console.log(dt);
							return d3.time.format('%X')(new Date(Number(d)));
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
				yDomain1 : [0, 50000000],
				yDomain2 : [0, 50000000],
				legendRightAxisHint : ''
			}
		}

	};
	
	
	
	service.cashVarOptionsConfig = function() {
		this.cashVarOptions = {
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
									 + new Date(1467691414948)  + ', Valor long: ' 
									  + d);
//							var Date dt = new Date();
//							dt.setTime(d)
//							console.log(dt);
							return d3.time.format('%X')(new Date(Number(d)));
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
				yDomain1 : [0, 25000000],
				yDomain2 : [0, 25000000],
				legendRightAxisHint : ''
			}
		}

	};
	
	
	
	return service;
})