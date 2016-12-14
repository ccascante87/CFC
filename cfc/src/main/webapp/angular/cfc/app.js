angular.module('appCFC', [ 'ngRoute', 'nvd3', 'datatables', 'ngMessages' ])
		.config(function($routeProvider) {
			$routeProvider.when('/login', {
				templateUrl : 'app/snippets/login.html'
			}).when('/graph', {
				templateUrl : 'app/snippets/data/graphColones.html'
			}).when('/transac', {
				templateUrl : 'app/snippets/data/transacciones.html'
			}).when('/detalles', {
				templateUrl : 'app/snippets/data/detalles.html'
			}).when('/sucursales', {
				templateUrl : 'app/snippets/admin/branches.html'
			}).when('/parameters', {
				templateUrl : 'app/snippets/admin/parameters.html'
			}).when('/sucursales', {
				templateUrl : 'app/snippets/admin/branches.html'
			}).when('/monedas', {
				templateUrl : 'app/snippets/admin/currencies.html'
			}).when('/usuarios', {
				templateUrl : 'app/snippets/admin/users.html'
			});
			$routeProvider.otherwise({
				redirectTo : '/login'
			});
		});
angular.module('appCFC').run(['$rootScope','$location', 'AuthService',
				function($rootScope, $location, AuthService) {
					$rootScope.$on('$routeChangeStart',
							function(event, newPath) {
								// Chech whether the user is logged in
								if (AuthService.isLoggedIn() || newPath.originalPath == '/login') {
										//$rootScope.hideMenu = newPath.originalPath.includes ('/admin')
										console.log(newPath);
								} else if (AuthService.isLoggedIn() && newPath.originalPath == '/logout') {
									// Real logout
									event.preventDefault();
									AuthService.setUser(undefined);
									$location.path('/login');
								} else {
									// When the user is not logged in, redirect
									// to the login view
									event.preventDefault();
									$location.path('/login');
								}
							})
				} ])
//Formatter for timestamp to time
angular.module('appCFC').directive('bindTimestamp', function () {
  return {
    restrict: 'A',
    require: 'ngModel',
    link: function (scope, element, attrs, ngModel) {
      ngModel.$formatters.push(function (value) { console.log(value);
        return new Date(value);
      });
    }
  };
});