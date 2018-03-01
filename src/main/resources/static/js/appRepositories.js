var appRepositories = angular.module('appRepositories', []);

appRepositories.constant('urlRequest', 'http://localhost:9090');

appRepositories.factory('empresaRepository', ['$http', 'urlRequest', function($http, urlRequest){
	return {
		findAllEmpresas: function(callback){
			$http({
				method: 'GET',
				url: urlRequest + '/empresa/findAll'
			}).then(function successCallback(response) {
				callback(response.data);
			}, function errorCallback(response) {
			});
		},
		findEmpresasByRazaoSocial: function(param, callback){
			var url = urlRequest + '/empresa/findByRazaoSocial/' + param;
			$http({
				method: 'GET',
				url: url
			}).then(function successCallback(response) {
				callback(response.data)
			}, function errorCallback(response) {
				console.log("Fail to get url /empresa/findByRazaoSocial");
			});
		}

	}	
}])

appRepositories.factory('clientRepository', ['$http', 'urlRequest', function ($http, urlRequest){
	return {
		findAllClients : function(callback){
			$http({
				method : 'GET',
				url: urlRequest + '/client/findAll'
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findClientById : function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/client/findById/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		saveClient : function(param, callback){
			$http({
				url: urlRequest + '/client/save',
				method: "POST",
				data: param
			})
			.then(function(response) {
				callback(true);
			}, 
			function(response) { 
				callback(false);
			});	
		},
		deleteClient : function (param, callback){
			$http({
			    method: 'DELETE',
			    url: urlRequest + "/client/delete/" + param,
			    headers: {
			        'Content-type': 'application/json;charset=utf-8'
			    }
			})
			.then(function(response) {
				callback(param);
			}, function(response) {
				callback(response.data);
			});
		},
		findClientByName:  function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/client/findByName/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findClientByEmail:  function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/client/findByEmail/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findClientByNameAndEmail:  function(param1, param2, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/client/findByNameAndEmail/' + param1 + '/' + param2
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		}
	}
}])


appRepositories.factory('productRepository', ['$http', 'urlRequest', function ($http, urlRequest){
	return {
		findAllProducts : function(callback){
			$http({
				method : 'GET',
				url: urlRequest + '/product/findAll'
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findProductById : function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/product/findById/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		saveProduct : function(param, callback){
			$http({
				url: urlRequest + '/product/save',
				method: "POST",
				data: param
			})
			.then(function(response) {
				callback(true);
			}, 
			function(response) { 
				callback(false);
			});	
		},
		deleteProduct : function (param, callback){
			$http({
			    method: 'DELETE',
			    url: urlRequest + "/product/delete/" + param,
			    headers: {
			        'Content-type': 'application/json;charset=utf-8'
			    }
			})
			.then(function(response) {
				callback(param);
			}, function(response) {
				callback(response.data);
			});
		},
		findProductByName:  function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/product/findByName/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findProductByDescription:  function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/product/findByDescription/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findProductByNameAndDescription:  function(param1, param2, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/product/findByNameAndDescription/' + param1 +'/'+param2
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		}
	}
}])

appRepositories.factory('saleRepository', ['$http', 'urlRequest', function ($http, urlRequest){
	return {
		findAllSales: function(callback){
			$http({
				method : 'GET',
				url: urlRequest + '/sale/findAll'
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		findSaleById: function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/sale/findById/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		},
		saveSale: function(param, callback){
			$http({
				url: urlRequest + '/sale/save',
				method: "POST",
				data: param
			})
			.then(function(response) {
				callback(true);
			}, 
			function(response) { 
				callback(false);
			});	
		},
		deleteSale: function (param, callback){
			$http({
			    method: 'DELETE',
			    url: urlRequest + "/sale/delete/" + param,
			    headers: {
			        'Content-type': 'application/json;charset=utf-8'
			    }
			})
			.then(function(response) {
				callback(param);
			}, function(rejection) {
				callback(false);
			});
		},
		findByClientName: function(param, callback){
			$http({
				method : 'GET',
				url: urlRequest + '/sale/findByClient/' + param
			}).then(function success(response){
				callback(response.data);
			}, function error(response){
				callback("fail");
			})
		}

	}
}])

