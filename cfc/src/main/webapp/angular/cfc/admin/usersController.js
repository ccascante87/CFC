'use strict'
angular.module('appCFC').controller('usersController',['$scope', 'cfcConfigurationService', 'userHttpServices', '$window',
			function($scope, cfcConfigurationService, userHttpServices,$window) {
				$scope.usersOptionGraph = cfcConfigurationService.tableOptionsConfig();
				var init = function() {
					var promise = userHttpServices.getUsers();
					promise.then(function(results) {
						$scope.users = results;
					});
					$scope.showForm = false;
				}

				var resetUser = function() {
					$scope.selectedUser = {
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
					resetUser();
					$scope.showForm = false;
				}
					
				$scope.saveOrUpdate = function() {
					console.log($scope.selectedUser)
						var promise = userHttpServices.saveUser($scope.selectedUser);
						promise.then(function(results) {
							$scope.users = results;
							$scope.showForm = false;
						});
				}
				
				$scope.addNew = function() {
					resetUser();
					$scope.showForm = true;
				}

				$scope.editUser= function(user) {
					$scope.selectedUser = user;
					$scope.showForm = true;
					console.log(user);
				}
				
				$scope.confirmDelete = function(user){
					var deleteUser = $window.confirm('Está seguro de eliminar el usuario seleccionado?');

//				    if (deleteUser) {
//				      var promise = userHttpServices.deleteBranch(user.idSucursal);
//				      promise.then(function(results){
//				    	  $scope.users = results;
//				      });
//				    }
				}
	init();
}]);// End controller
