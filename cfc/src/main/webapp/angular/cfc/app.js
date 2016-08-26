angular.module('appCFC', [ 'ngRoute', 'nvd3', 'datatables' ]).config(
function($routeProvider) {
	$routeProvider.when('/index', {
		templateUrl : 'app/snippets/graphColones.html',
		
	}).when('/transac', {
		templateUrl : 'app/snippets/transacciones.html',
		
	}).when('/detalles', {
		templateUrl : 'app/snippets/detalles.html'
	}).when('/sucursales', {
		templateUrl : 'app/snippets/branches.html'
	});
	$routeProvider.otherwise({
		redirectTo : '/index'
	});
});