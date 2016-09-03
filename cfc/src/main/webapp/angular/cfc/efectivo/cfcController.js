'use strict'
angular.module('appCFC').controller('cfcController',[ '$scope', 'httpService', '$rootScope', 'branchHttpServices','currencyHttpServices',
				function($scope, httpService, $rootScope, branchHttpServices, currencyHttpServices) {
	
	$rootScope.$on('$stateChangeStart', function () {
		console.log('$stateChangeStart');
//	      if(!authFactory.isAuthed()){
//	        $state.go('login')
//	      }
	    })
	    
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
