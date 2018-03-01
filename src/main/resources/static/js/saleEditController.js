app.controller("saleEditController", function ($scope, $http, $routeParams, saleRepository, clientRepository, productRepository) {


	$scope.resetForm = function () {
		$scope.sale =  {
				id: null,
				products:[{id:null, name:null, quantity: null, product: {id: null, name: null}}],
					
		};

		$scope.clientList = [];
		$scope.productList = [];
	}

	function findAllClients(){
		clientRepository.findAllClients(function(result){
			$scope.clientList = result;
		})
	}
	function findAllProducts(){
		productRepository.findAllProducts(function(result){
			$scope.productList = result;
		})
	}

	function findSaleById (id){
		saleRepository.findSaleById(id, function(result){
			$scope.sale = result;
		})
	}

	$scope.addProduct = function () {
		$scope.sale.products.push(
				{id:null,
					name:null, 
					quantity: null, 
					product: {id: null, name: null}});
	}
	$scope.removeProduct = function (product) {
		$scope.sale.products.splice($scope.sale.products.indexOf(product), 1);

	}
	function saveSale (sale) {
		saleRepository.saveSale(sale, function(result){
			if(result){
				$scope.success = 'sucesso ao salvar!';
				$scope.erro = null;
			}else{
				$scope.erro = 'falha ao salvar!';
				$scope.success = null;
			}
		});
	}

	$scope.save = function () {
		var form = $scope.formSale;
		$scope.warning = null;
		$scope.erro = null;
		$scope.success = null;
		if(form.$valid){
			if($scope.sale.products && $scope.sale.products.length > 0){
				var save = true;
				angular.forEach($scope.sale.products, function(saleProduct){
					if(saleProduct.product && !saleProduct.product.id){
						save = false;
						$scope.warning = "Selecionar o produto é obrigatório, caso não queira adicioná-lo, clique em Remover produto";
					}
				})
				if(save){
					saveSale($scope.sale);
				}
			}else{
				$scope.warning = "Pelo menos um produto deve ser adicionado, por favor clique em Adicionar produto";
			}
		}else{
			if(form.$error && form.$error.required){
				if(form.$error.required[0] && form.$error.required[0].$name){
					var arrStr = form.$error.required[0].$name.split(".");
					if(arrStr[1] && arrStr[1] == 'client'){
						$scope.warning = "Nome de cliente é obrigatório, por favor selecione um";
					}
				}
			}
		}
	}

	$scope.resetForm();
	findAllClients();
	findAllProducts();


	if($routeParams.saleId){
		findSaleById($routeParams.saleId);

		$routeParams.saleId = null;
		
		
	}

});