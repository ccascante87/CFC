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
		//TODO Load the default branch (and currency)
	}
	
	var loadData = function() {
		var promise = currencyHttpServices.getCurrencies();
		promise.then(function(result) {
			$scope.currency = result;
			$scope.selectedCurrency = result[0];
			$rootScope.currencies = result;
		});

		var promiseBranch = branchHttpServices.getBranches();
		promiseBranch.then(function(result) {
			$scope.sucursales = result;
			$scope.selectedBranch = result[0];
		});
	};

	$scope.updateModel = function() {
		$scope.$broadcast('parametersChange');
	}
}]);// End controller
