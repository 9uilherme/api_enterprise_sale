app.controller("saleListController", function ($scope, $http, $window, saleRepository, help1, $timeout){

	$scope.help1 = "Os produtos da venda são exibidos ao editar. " + help1;
	$scope.isFiltros = false;
	$scope.filtro = {id: null, client : {name: null}};
	$scope.saleChecked =  {
			id: null,
			client: null,
			products: []
	};
	$scope.sales = [];

	function findAllSales(){
		saleRepository.findAllSales(function(result){
			$scope.sales = result;
		})
	};

	function findSaleById (id){
		saleRepository.findSaleById(id, function(result){
			$scope.sales = [];
			$scope.sales.push(result);
		})
	}

	function findByClientName (name) {
		saleRepository.findByClientName(name, function(result){
			$scope.sales = [];
			angular.forEach(result, function(sale){
				$scope.sales.push(sale);
			});
		})
	}
	function findIndexElementById(arr, val){
		for(var i = 0; i < arr.length; i++){
			if(arr[i].id == val)
				return i;
		}
	}

	findAllSales();

	$scope.deleteSale = function(){
		saleRepository.deleteSale($scope.saleChecked.id, function(result){
			if(result){
				var valToSplice = findIndexElementById($scope.sales, $scope.saleChecked.id);
				if(valToSplice != undefined && valToSplice >= 0){
					$scope.sales.splice(valToSplice, 1);
				}

				$scope.saleChecked = {	id: null,
						client: null,
						products: []};
				$scope.success = 'sucesso ao deletar venda!';
				$scope.erro = null;
			}else{
				$scope.erro = 'falha ao deletar venda!';
				$scope.success = null;
			}
		})
	}

	$scope.filtroControle = function(){
		$scope.isFiltros = !$scope.isFiltros;
	};

	$scope.buscarFiltros = function (){
		if($scope.filtro.id){ 
			findSaleById($scope.filtro.id);
		}else if($scope.filtro.client.name){
			findByClientName($scope.filtro.client.name);
		}
	};

	$scope.limparFiltros = function () {
		$scope.filtro = {};
		findAllSales();
	};


});