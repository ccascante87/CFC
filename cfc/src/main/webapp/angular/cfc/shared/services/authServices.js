'use strict'
angular.module('appCFC').factory('AuthService', function() {
	var currentUser;
	return {
		setUser : function(user) {
			// TODO Check for null
			currentUser = user;
		},
		isLoggedIn : function() {
			// TODO Check for the user data
			return (currentUser) ? true: false;
		}
	}
})