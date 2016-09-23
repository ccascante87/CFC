'use strict'
angular.module('appCFC').controller('cfcController',[ '$scope', 'httpService', '$rootScope', 'branchHttpServices','currencyHttpServices','AuthService',
				function($scope, httpService, $rootScope, branchHttpServices, currencyHttpServices,AuthService) {
	$scope.userLoggedin = AuthService.isLoggedIn();
	$scope.user = {};    
	$rootScope.loadInitData = function(){
		loadData();
	}
	$rootScope.refreshUser = function(){
		$scope.userLoggedin = AuthService.isLoggedIn();
		$scope.user = AuthService.getCurrentUser();
	}
	
	var loadData = function() {
		var promise = currencyHttpServices.getCurrencies();
		promise.then(function(result) {
			$scope.currency = result;
		});

		var promiseBranch = branchHttpServices.getBranches();
		promiseBranch.then(function(result) {
			$scope.sucursales = result;
		});
	};

	$scope.updateModel = function() {
		$scope.$broadcast('parametersChange');
	}
}]);// End controller
