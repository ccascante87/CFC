angular.module('appCFC').factory('graphService', function() {
	var cashFlowOptions = {};
	var cashVarOptions = {};
	var service = {};
	var currencyFormat = '';

	// TODO Find out how to make this more reusable and not one variable per
	// graph
	service.cashFlowOptionsConfig = function(currency) {
		currencyFormat = '' + currency + ',.1f';
		this.cashFlowOptions = {
			chart : {
				useInteractiveGuideline : true,
				type : 'multiChart',
				height : 450,
				margin : {
					top : 20,
					right : 90,
					bottom : 40,
					left : 90
				},
				color : [ 'red', 'green', 'yellow', 'pink', 'black' ],
				legendColor : [ 'red', 'green', 'yellow', 'pink', 'black' ],
				duration : 0,
				xAxis : {
					tickFormat : function(d) {
						return d3.time.format('%X')(new Date(d));
					}
				},
				yAxis1 : {
					tickFormat : function(d) {
						return d3.format(currencyFormat)(d);
					}
				},
				yAxis2 : {
					tickFormat : function(d) {
						return d3.format(',.1f')(d);
					}
				},
				interactiveLayer : {
					tooltip : {
						headerFormatter : function(d) {
							return d3.time.format('%X')(new Date(Number(d)));
						}
					}
				},
				tooltip : {
					useInteractiveGuideline : true,
					headerFormatter : function(d) {
						return d3.time.format('%x')(new Date(d));
					}
				},
				yDomain1 : [ 0, 50000000 ],
				yDomain2 : [ 0, 50000000 ],
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
					right : 90,
					bottom : 40,
					left : 90
				},
				color : [ 'red', 'green', 'yellow', 'pink', 'black' ],
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
				},
				interactiveLayer : {
					tooltip : {
						headerFormatter : function(d) {
							return d3.time.format('%X')(new Date(Number(d)));
						}
					}
				},
				tooltip : {
					useInteractiveGuideline : true,
					headerFormatter : function(d) {
						return d3.time.format('%x')(new Date(d));
					}
				},
				yDomain1 : [ 0, 20000000 ],
				yDomain2 : [ 0, 20000000 ],
				legendRightAxisHint : ''
			}
		}
	};
	return service;
})