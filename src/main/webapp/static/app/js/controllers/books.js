cityLibApp.controller('BooksCtrl', function($scope, $http, $location){
	console.log('This is Books controller');
	var loadBooks = function(){
		booksPromise = $http.get('/api/books/');
		booksPromise.then(function(resp){
			$scope.books = resp.data;
		}, function(resp){
			console.log(data);
		});

	}

	loadBooks();
});