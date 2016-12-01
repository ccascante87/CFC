'use strict'
angular.module('appCFC').controller('loginController',
		['$scope','$rootScope','$location','AuthService','userHttpServices',
				function($scope, $rootScope, $location, AuthService, userHttpServices) {
	$scope.loginName;
	$scope.loginPass;
	$scope.showError = false;
	$rootScope.hideMenu = false;
	
	$scope.login = function(){
		if ( ($scope.loginName == 'admin' && $scope.loginPass == 'admin') ||
			($scope.loginName == 'user' && $scope.loginPass == 'user') ){
			
			var promise = userHttpServices.getUser($scope.loginName);
			promise.then(function(result){
				var user =result;
				AuthService.setUser(user);
				$scope.userLoggedIn = true;
				$scope.showError = false;
				$rootScope.loadInitData();
				$rootScope.refreshUser();
				$location.path('/graph');
			}, function(error){
				$scope.showError = true;
			})			
		} else {
			$scope.loginPass = '';
			$scope.userLoggedIn = false;
			$scope.showError = true;
		}
	}
}])