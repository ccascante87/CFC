angular.module('appCFC').factory('cfcConfigurationService', function() {
	var cashFlowOptions = {};
	var cashVarOptions = {};
	var service = {};
	var tableOptions = {};

	service.cashFlowOptionsConfig = function() {
		this.cashFlowOptions = {
			chart : {
				useInteractiveGuideline : true,
				type : 'multiChart',
				height : 450,
				showLegend: false,
				margin : {
					top : 20,
					right : 20,
					bottom : 40,
					left : 90
				},
				duration : 0,
				xAxis : {
					tickFormat : function(d) {
						console.log((new Date(new Number(d))));
						return d3.time.format('%H:%M')(new Date(new Number(d)));
					}
				},
				yAxis1 : {
					tickFormat : function(d) {
						return d;
					}
				},
				interactiveLayer : {
					tooltip : {
						headerFormatter : function(d) {
							return d3.time.format('%H:%M')(new Date(new Number(d)));
						}
					}
				},
				tooltip : {
					useInteractiveGuideline : true
					
				},
				yDomain1 : [ 0, 100000000 ],
				legendRightAxisHint : ''
			}
		}; 
		return this.cashFlowOptions;
	};

	service.cashVarOptionsConfig = function() {
		this.cashVarOptions = {
			chart : {
				useInteractiveGuideline : true,
				type : 'multiChart',
				height : 450,
				showLegend: false,
				margin : {
					top : 20,
					right : 20,
					bottom : 40,
					left : 90
				},
				duration : 0,
				xAxis : {
					tickFormat : function(d) {
						return d3.time.format('%H:%M')(new Date(new Number(d)));
					}
				},
				yAxis1 : {
					tickFormat : function(d) {
						return d;
					}
				},
				interactiveLayer : {
					tooltip : {
						headerFormatter : function(d) {
							return d3.time.format('%H:%M')(new Date(new Number(d)));
						}
					}
				},
				tooltip : {
					useInteractiveGuideline : true
					
				},
				yDomain1 : [ 0, 20000000 ],
				legendRightAxisHint : ''
			}
		};
		return this.cashVarOptions;
	};
	
	service.tableOptionsConfig = function (){
		this.tableOptions = {
			
		    oAria: {
		        sSortAscending:  ": activate to sort column ascending",
		        sSortDescending: ": activate to sort column descending"
		    }
		    , searching: false
		    
		    ,language: { // not withLanguage wich is from DTOptionsBuilder
		    	sEmptyTable:     'No se encontraron datos',
			    sInfo:           "Mostrando _START_ a _END_ de _TOTAL_ registros",
			    sInfoEmpty:      "Mostrando 0 a 0 de 0 registros",
			    sInfoFiltered:   "(filtrado de _MAX_ registros)",
			    sInfoPostFix:    "",
			    sInfoThousands:  ",",
			    sLengthMenu:     'Mostrar _MENU_ filas',
			    sLoadingRecords: "Cargando...",
			    sProcessing:     "Procesando...",
			    sSearch:         "Buscar:",
			    sZeroRecords:    "No se encontraron registros",
			    oPaginate: {
			        sFirst:    "Primero",
			        sLast:     "&Uacute;ltimo ",
			        sNext:     "Siguiente",
			        sPrevious: "Anterior"
			    }
	        }
		};
		return this.tableOptions;
	}
	return service;
})