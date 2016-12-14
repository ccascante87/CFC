'use strict'
angular.module('appCFC').controller('branchesController',['$scope', 'cfcConfigurationService', 'branchHttpServices', '$window', '$rootScope',
			function($scope, cfcConfigurationService, branchHttpServices,$window, $rootScope) {
				
				var init = function() {
					$scope.brachesOptionGraph = cfcConfigurationService.tableOptionsConfig();
					var promise = branchHttpServices.getBranches();
					promise.then(function(results) {
						$scope.branches = results;
					});
					$scope.showForm = false;
				}

				var resetBranch = function() {
					$scope.selectedBranch = {
						id: '',
						codigoSucursal : '',
						horaApertura : '',
						horaCierre : '',
						nomSucursal : '',
						sucursalMontoMonedas:[],
						sucursalPorcents : []						
					}
				}

				$scope.cancel = function() {
					resetBranch();
					$scope.showForm = false;
				}
					
				$scope.saveOrUpdate = function() {
					console.log($scope.selectedBranch)
						var promise = branchHttpServices.saveOrUpdateBranch($scope.selectedBranch);
						promise.then(function(results) {
							$scope.branches = results;
							resetBranch();
							$scope.showForm = false;
						});
				}
				
				$scope.addNew = function() {
					resetBranch();
					

								for ( var currency in $rootScope.currencies) {
									$scope.selectedBranch.sucursalMontoMonedas
											.push({
												id : '',
												montoAsegurado : '',
												montoAutorizado : '',
												sucursal : null,
												moneda : currency
											});
									$scope.selectedBranch.sucursalPorcents
										.push({
											
											id:'',
											porcenMenudo:'',
											porcenReserva:'',
											sucursal:null,
											moneda:currency
										});
								}
					
					$scope.showForm = true;
				}

				$scope.editBranch = function(branch) {
					$scope.selectedBranch = branch;
					$scope.showForm = true;
					console.log(branch);
				}
				
				$scope.confirmDelete = function(branch){
					var deleteUser = $window.confirm('Está seguro de eliminar la surcursal seleccionada?');

				    if (deleteUser) {
				      var promise = branchHttpServices.deleteBranch(branch.id);
				      promise.then(function(results){
				    	  $scope.branches = results;
				      });
				    }
				}
	init();
}]);// End controller
