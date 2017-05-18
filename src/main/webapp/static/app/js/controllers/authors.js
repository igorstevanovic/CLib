cityLibApp.controller('AuthorsCtrl', function($scope, $http, $location){
	console.log('This is Authors controller');
	var loadAuthors = function(){
		authorsPromise = $http.get('/api/authors/');
		authorsPromise.then(function(resp){
			$scope.authors = resp.data;
		}, function(resp){
			console.log(data);
		});

	}

	loadAuthors();

	
});