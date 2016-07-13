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
	
	
	$scope.updateModel = function(){
		 $scope.$emit('someEvent', this);
    	console.log('initin.............')
	}
	init();
}]);// End controller
