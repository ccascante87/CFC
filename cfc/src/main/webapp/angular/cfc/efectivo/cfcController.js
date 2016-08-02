'useS strict'
angular.module('appCFC').controller('cfcController',['$scope','$http','httpService',function($scope, $http, httpService) {
	
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
	
	
	$scope.updateModel = function(){
		 $scope.$emit('someEvent', this);
	}
	init();
}]);// End controller
