angular.module('appCFC', [ 'ngRoute' ,'nvd3']).config(function($routeProvider) {
	console.log("route provider")
	console.log($routeProvider);
	$routeProvider.when('/index', {

		templateUrl : 'app/snippets/graphColones.html',
		controller: 'cfcController' 
	});	
	$routeProvider.otherwise({
		redirectTo : '/index'
	});
});