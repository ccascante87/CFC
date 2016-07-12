angular.module('appCFC', [ 'ngRoute', 'nvd3'/*, 'datatables'*/ ]).config(
function($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl : 'app/snippets/graphColones.html',
		
	}).when('/transac', {
		templateUrl : 'app/snippets/transacciones.html'
	});
	$routeProvider.otherwise({
		redirectTo : '/index'
	});
});