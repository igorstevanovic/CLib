cityLibApp.controller('AuthorCtrl', function($scope, $http, $routeParams, $location){
	console.log('This is Author controller');
	var loadAuthor = function(){
		authorsPromise = $http.get('/api/authors/'+$routeParams.id);
		authorsPromise.then(function(resp){
			$scope.author = resp.data;
		}, function(resp){
			console.log(data);
		});

	}

	loadAuthor();

	var loadBooksByAuthor = function(id){
		booksByAuthorPromise = $http.get('/api/authors/'+$routeParams.id+'/books/');
		booksByAuthorPromise.then(function(resp){
			$scope.booksByAuthor = resp.data;
		}, function(resp){
			console.log(data);
		});
	}

	loadBooksByAuthor();

	$scope.deleteAuthor = function(id){
		console.log('data');
		$http.delete('/api/authors/'+id).then(function(){
			$location.path('/authors/');
		});
	}

});