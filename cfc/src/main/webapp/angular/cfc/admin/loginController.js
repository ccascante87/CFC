'use strict'
angular.module('appCFC').controller('loginController', ['$scope', '$rootScope','$location', 'AuthService', function($scope,$rootScope, $location, AuthService){
	$scope.loginName;
	$scope.loginPass;
	$scope.invalidLogin = false;
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
			}
			if ($scope.loginName == 'admin' && $scope.loginPass == 'admin') {
				user.isadmin = true;
				AuthService.setUser(user);
				$scope.invalidLogin = false;
				$rootScope.loadInitData();
				$location.path('/graph');
			} else if ($scope.loginName == 'user' && $scope.loginPass == 'user') {
				AuthService.setUser(user);
				$scope.invalidLogin = false;
			} else {
				$scope.loginPass = '';
				$scope.invalidLogin = true;
			}
	}

//    $rootScope.refreshUser();
}])