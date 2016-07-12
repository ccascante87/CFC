'useS strict'
angular.module('appCFC').controller('cfcController',['$scope','$http','graphService','httpService',function($scope, $http, graphService, httpService) {
	
	var init = function() {
		var promise = httpService.getCurrencies();
			promise.then(function(result){
				$scope.currency = result;
				$scope.selectedCurrency = $scope.currency[0];
			});
		    
		 var promiseBranch = httpService.getBranches();
		 promiseBranch.then(function(result){
			 $scope.sucursales = result;
			 $scope.selectedBranch = $scope.sucursales[0];
		 });	 
	};
	init();
}]);// End controller
