angular.module('appCFC').filter('displayUpDownArrow', function(){
	return function(input){
		if(input.value == input.lastValue)
			return "glyphicon-minus ";
		 if (input.value < input.lastValue)
				return "glyphicon-arrow-down color-red";
		 if (input.value > input.lastValue)
				return "glyphicon-arrow-up color-green";
	}
})