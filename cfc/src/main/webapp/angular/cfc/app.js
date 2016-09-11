angular.module('appCFC', [ 'ngRoute', 'nvd3', 'datatables', 'ngMessages' ])
		.config(function($routeProvider) {
			$routeProvider.when('/login', {
				templateUrl : 'app/snippets/login.html'
			}).when('/graph', {
				templateUrl : 'app/snippets/graphColones.html'
			}).when('/transac', {
				templateUrl : 'app/snippets/transacciones.html'
			}).when('/detalles', {
				templateUrl : 'app/snippets/detalles.html'
			}).when('/sucursales', {
				templateUrl : 'app/snippets/branches.html'
			}).when('/parameters', {
				templateUrl : 'app/snippets/parameters.html'
			});
			$routeProvider.otherwise({
				redirectTo : '/login'
			});
		});
angular.module('appCFC').run(['$rootScope', '$location', 'AuthService', function($rootScope, $location, AuthService){
	$rootScope.$on('$routeChangeStart', function(event, newPath){
		//Chech whether the user is logged in
		if(AuthService.isLoggedIn() || newPath.originalPath == '/login'){
			//TODO Redirect to correct Page
		}else if(AuthService.isLoggedIn() && newPath.originalPath == '/logout'){
			//Real logout
			event.preventDefault();
	        AuthService.setUser(undefined);
            $location.path('/login');
		}
		else{
			//When the user is not logged in, redirect to the login view
			event.preventDefault();
            $location.path('/login');
		}
	})
}])