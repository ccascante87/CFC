'use strict'

angular.module('appCFC').controller('SidebarController', function($scope){
	$scope.sidearState=false;
	
	$scope.toggleSidebarState = function(){
		$scope.sidearState= !$scope.sidearState;
	}
});