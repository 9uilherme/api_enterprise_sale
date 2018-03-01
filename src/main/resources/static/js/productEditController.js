app.controller("productEditController", function ($scope, $http, $routeParams, productRepository) {

	$scope.resetForm = function () {
		$scope.product =  {
				id: null,
				name: null,
				description: null,
				price: null
		};

	}

	function findProductById (id){
		productRepository.findProductById(id, function(result){
			$scope.product = result;
		})
	}
	
	function saveProduct (product) {
		productRepository.saveProduct(product, function(result){
			if(result){
				$scope.success = 'sucesso ao salvar!';
				$scope.erro = null;
			}else{
				$scope.erro = 'falha ao salvar!';
				$scope.success = null;
			}
		});
	}
	
	if($routeParams.productId){
		findProductById($routeParams.productId);

		$routeParams.productId = null;
	}

	$scope.save = function () {
		if($scope.formProduct.$valid){
			saveProduct($scope.product);
		}
	}

	$scope.resetForm();

});