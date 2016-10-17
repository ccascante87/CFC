'use strict'
angular.module('appCFC').controller('parametersController',['$scope','cfcConfigurationService','paramsHttpServices',
				function($scope, cfcConfigurationService, paramsHttpServices) {
					

					var init = function() {
						$scope.paramsTableConfig = cfcConfigurationService
						.tableOptionsConfig();
						console.log($scope.paramsTableConfig);
						var promise = paramsHttpServices.getParameters();
						promise.then(function(results) {
							$scope.parameters = results;
						});
						$scope.showForm = false;
					}
					var resetParam = function() {
						$scope.selectedParam = {
							idParm : '',
							shortDesc : '',
							paramKey : '',
							paramValue : ''
						}
					}

					$scope.cancel = function() {
						resetParam();
						$scope.showForm = false;
					}
					$scope.saveParam = function() {
						var promise = paramsHttpServices
								.updateParam($scope.selectedParam);
						promise.then(function(results) {
							$scope.parameters = results;
							$scope.showForm = false;
						});
					}
					$scope.editParam = function(selectedParam) {
						$scope.selectedParam = selectedParam;
						$scope.showForm = true;
					}
					init();
				} ])