app.controller("productListController", function ($scope, $http, $window, productRepository, help1){

	$scope.help1 = help1;
	$scope.isFiltros = false;
	$scope.filtro = {};
	$scope.productChecked =  {
			id: null,
			name: null,
			description: null,
			price: null
	};
	$scope.products = [];
	
	function findAllProducts(){
		productRepository.findAllProducts(function(result){
			$scope.products = result;
			
		})
	};
	function findProductByName (name) {
		productRepository.findProductByName(name, function(result){
			$scope.products = [];
			angular.forEach(result, function(product){
				$scope.products.push(product);
			});
		})
	}
	function findProductByDescription (description){
		productRepository.findProductByDescription(description, function(result){
			$scope.products = [];
			angular.forEach(result, function(product){
				$scope.products.push(product);
			});
		})
	}
	function findProductByNameAndDescription(name, description){
		productRepository.findProductByNameAndDescription(name, description, function(result){
			$scope.products = [];
			angular.forEach(result, function(product){
				$scope.products.push(product);
			});
		})
	}
	findAllProducts();
	
	function findIndexElementById(arr, val){
		for(var i = 0; i < arr.length; i++){
			if(arr[i].id == val)
				return i;
		}
	}

	$scope.deleteProduct = function(){
		productRepository.deleteProduct($scope.productChecked.id, function(result){
			if(result){

				var valToSplice = findIndexElementById($scope.products, $scope.productChecked.id);
				if(valToSplice != undefined && valToSplice >= 0){
					$scope.products.splice(valToSplice, 1);
				}
				$scope.productChecked =  {
						id: null,
						name: null,
						description: null,
						price: null
				};
				$scope.success = 'sucesso ao deletar produto!';
				$scope.erro = null;
			}else{
				$scope.erro = 'falha ao deletar produto! Verifique se há algum vínculo deste produto em outro cadastro!';
				$scope.success = null;
			}
		})
	}
	$scope.filtroControle = function(){
		$scope.isFiltros = !$scope.isFiltros;
	};

	$scope.buscarFiltros = function (){
		if($scope.filtro.name){ 
			if($scope.filtro.description){
				findProductByNameAndDescription($scope.filtro.name, $scope.filtro.description);
			}else{
				findProductByName($scope.filtro.name);
			}
		}else if($scope.filtro.description){
			findProductByDescription($scope.filtro.description);
		}
	};

	$scope.limparFiltros = function () {
		$scope.filtro = {};
		findAllProducts();
	};


});