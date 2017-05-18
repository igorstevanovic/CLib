var cityLibApp = angular.module('cityLibApp', ['ngRoute'])

.config(['$routeProvider', function($routeProvider){
	$routeProvider.
	when('/', {
		templateUrl: '/static/app/html/partial/home.html',
		controller: 'MainCtrl'
	}).
	when('/books', {
		templateUrl: '/static/app/html/partial/books.html',
		controller: 'BooksCtrl'
	}).
	when('/authors', {
		templateUrl: '/static/app/html/partial/authors.html',
		controller: 'AuthorsCtrl'
	}).
	when('/author/:id', {
		templateUrl: '/static/app/html/partial/author.html',
		controller: 'AuthorCtrl'
	}).
	otherwise({
		redirectTo: '/'
	})
}]);

