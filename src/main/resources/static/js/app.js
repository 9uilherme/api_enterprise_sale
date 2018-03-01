
angular.module('appRepositories', []);

var app = angular.module("App", ['ngRoute', 
	'appRepositories' ])

app.constant('help1', 'Para Editar ou Remover, selecione um registro abaixo para que o menu apareça :)');

app.config(function($routeProvider, $locationProvider) {
	$routeProvider
	.when("/clientList", {templateUrl: 'view/clientList.html', controller: 'clientListController'})
	.when("/productList", {templateUrl: 'view/productList.html', controller: 'productListController'})
	.when("/saleList", {templateUrl: 'view/saleList.html', controller: 'saleListController'})
	.when("/clientEdit", {templateUrl: 'view/clientEdit.html', controller: 'clientEditController'})
	.when("/productEdit", {templateUrl: 'view/productEdit.html', controller: 'productEditController'})
	.when("/saleEdit", {templateUrl: 'view/saleEdit.html', controller: 'saleEditController'})
	.when("/clientEdit/:clientId", {templateUrl: '/view/clientEdit.html', controller: 'clientEditController'})
	.when("/productEdit/:productId", {templateUrl: '/view/productEdit.html', controller: 'productEditController'})
	.when("/saleEdit/:saleId", {templateUrl: '/view/saleEdit.html', controller: 'saleEditController'})

	.when("/empresaEdit/:empresaId", {templateUrl: '/view/empresaEdit.html', controller: 'empresaEditController'})
	.when("/empresaEdit", {templateUrl: 'view/empresaEdit.html', controller: 'empresaEditController'})
	.otherwise({redirectTo:'/clientList'});
	 $locationProvider.hashPrefix('');
	$locationProvider.html5Mode(
			{
				enabled: true,
				requireBase: false
			}
	);


})

