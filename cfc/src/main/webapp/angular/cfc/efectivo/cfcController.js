'use strict'
angular.module('appCFC').controller('cfcController',[ '$scope', 'httpService', '$rootScope', 'branchHttpServices','currencyHttpServices','AuthService',
				function($scope, httpService, $rootScope, branchHttpServices, currencyHttpServices,AuthService) {
	$scope.userLoggedin = AuthService.isLoggedIn();
	    
	$rootScope.loadInitData = function(){
		loadData();
		//refreshUser();
	}
	$rootScope.refreshUser= function(){
		$scope.userLoggedin = AuthService.isLoggedIn();
	}
	
	var loadData = function() {
		var promise = currencyHttpServices.getCurrencies();
		promise.then(function(result) {
			$scope.currency = result;
			$scope.selectedCurrency = $scope.currency[0];
		});

		var promiseBranch = branchHttpServices.getBranches();
		promiseBranch.then(function(result) {
			$scope.sucursales = result;
			$scope.selectedBranch = $scope.sucursales[0];
		});
	};

	$scope.updateModel = function() {
		$scope.$broadcast('parametersChange');
	}
}]);// End controller
