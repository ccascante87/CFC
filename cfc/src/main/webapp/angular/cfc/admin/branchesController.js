'use strict'
angular.module('appCFC').controller('branchesController',['$scope', 'cfcConfigurationService', 'branchHttpServices', '$window',
			function($scope, cfcConfigurationService, branchHttpServices,$window) {
				$scope.brachesOptionGraph = cfcConfigurationService.tableOptionsConfig();
				var init = function() {
					var promise = branchHttpServices.getBranches();
					promise.then(function(results) {
						$scope.branches = results;
					});
					$scope.showForm = false;
				}

				var resetBranch = function() {
					$scope.selectedBranch = {
						idSucursal : '',
						codigoAgencia : '',
						horaApertura : '',
						horaCierre : '',
						montoAsegurado : '',
						montoAutorizado : '',
						nomAgencia : ''
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
							$scope.showForm = false;
						});
				}
				
				$scope.addNew = function() {
					resetBranch();
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
				      var promise = branchHttpServices.deleteBranch(branch.idSucursal);
				      promise.then(function(results){
				    	  $scope.branches = results;
				      });
				    }
				}
	init();
}]);// End controller
