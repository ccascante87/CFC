'use strict'
angular.module('appCFC').controller('loginController', ['$scope', '$rootScope','$location', 'AuthService', function($scope,$rootScope, $location, AuthService){
	$scope.loginName;
	$scope.loginPass;
	$scope.showError = false;
	$scope.login = function(){
		// TODO Real login...
		// Test login values:
		// admin/admin Admin user
		// user/user Regular user;
		// Check for not nulls,
		// Then call the logig service from the server
		// Thenset the user in sesion
		var user = {
				username: $scope.loginName,
				userpass: $scope.loginPass,
				isadmin: false,
				defaultBranch: 1,
				defaultCurrency : 1
			};
		
		console.log('algo de texto aqui............' + $scope.userLoggedin)
			if ($scope.loginName == 'admin' && $scope.loginPass == 'admin') {
				user.isadmin = true;
				AuthService.setUser(user);
				$scope.userLoggedIn = true;
				$scope.showError = false;
				$rootScope.loadInitData();
				$rootScope.refreshUser();
				$location.path('/graph');
			} else if ($scope.loginName == 'user' && $scope.loginPass == 'user') {
				AuthService.setUser(user);
				$scope.userLoggedIn = true;
				$scope.showError = false;
			} else {
				$scope.loginPass = '';
				$scope.userLoggedIn = false;
				$scope.showError = true;
			}
	}

//    $rootScope.refreshUser();
}])