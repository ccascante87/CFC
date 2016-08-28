'use strict'
angular.module('appCFC').controller('cfcController',[ '$scope', 'httpService', 'branchHttpServices','currencyHttpServices',
				function($scope, httpService, branchHttpServices, currencyHttpServices) {
	
	var init = function() {
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
	init();
}]);// End controller
