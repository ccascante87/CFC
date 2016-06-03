angular.module('appCFC').controller('cfcController', ['$scope', function($scope	){
	
//	var startController = function(){
//		
//	} ;
//	
//	var loadGraphic = function(){
//		
//	};
	
	
	//////
//	var loadHome = function loadHome() {
//		var homepageHtml = 'graphColones';
//		loadHTML(homepageHtml);
//	}

//	function loadHTML(htmlFile) {
//		var wrapper = $('#content-wrapper');
//		if (htmlFile != undefined) {
//			console.log("adfadfadsf");
//			var htmlSnippet = 'app/snippets/' + htmlFile + '.html';
//			$.ajax({
//				url : htmlSnippet,
//				type : 'GET',
//				cache : false,
//				success : function(html) {
//					wrapper.html(html);
//				}
//			});
//		}
//		$scope.$apply();
//	}
	////////////////////////
	
	$scope.options = {
	        chart: {
	            type: 'stackedAreaChart',
	            height: 180,
	            margin : {
	                top: 20,
	                right: 20,
	                bottom: 40,
	                left: 55
	            },
	            x: function(d){ return d.x; },
	            y: function(d){ return d.y; },
	            useInteractiveGuideline: true,
	            duration: 500,    
	            yAxis: {
	                tickFormat: function(d){
	                   return d3.format('.01f')(d);
	                }
	            }
	        }
	    };
	$scope.data = [{ values: [], key: 'Random Walk' }];
    
    $scope.run = true;
	var init = function () {
		console.log("init")
//		$scope.$apply();
//		loadHome();
//		
//		
//	    
	    var x = 0;
	    setInterval(function(){
		    if (!$scope.run) return;
		    $scope.data[0].values.push({ x: x,	y: Math.random() - 0.5});
	      if ($scope.data[0].values.length > 20) $scope.data[0].values.shift();
		    x++;
		    console.log("por a a a a " + x)
	      $scope.$apply(); // update both chart
	    }, 500);        
//        startController();
    };

    init();
}]);//End controller