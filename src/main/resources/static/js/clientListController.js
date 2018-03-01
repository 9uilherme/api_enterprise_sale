app.controller("clientListController", function ($scope, $window, clientRepository, help1){

	$scope.help1 = help1;
	$scope.isFiltros = false;
	$scope.filtro = {};
	$scope.clientChecked =  {
			id: null,
			name: null,
			email: null,
			birthDate: null
	};
	$scope.clients = [];

	function findAllClients(){
		clientRepository.findAllClients(function(result){
			$scope.clients = result;
		})
	};

	function findClientByName (name) {
		clientRepository.findClientByName(name, function(result){
			$scope.clients = [];
			angular.forEach(result, function(client){
				$scope.clients.push(client);
			});
		})
	}
	function findClientByEmail (email) {
		clientRepository.findClientByEmail(email, function(result){
			$scope.clients = [];
			angular.forEach(result, function(client){
				$scope.clients.push(client);
			});
		})
	}
	function findClientByNameAndEmail (name, email) {
		clientRepository.findClientByNameAndEmail(name, email, function(result){
			$scope.clients = [];
			angular.forEach(result, function(client){
				$scope.clients.push(client);
			});
		})
	}
	
	findAllClients();

	$scope.deleteClient = function(){
		clientRepository.deleteClient($scope.clientChecked.id, function(result){
			if(result){
				$scope.clients.splice($scope.clients.indexOf($scope.clientChecked),1);
				$scope.clientChecked =  {
						id: null,
						name: null,
						email: null,
						birthDate: null
				};
				$scope.success = 'sucesso ao deletar cliente!';
				$scope.erro = null;
			}else{
				$scope.erro = 'falha ao deletar cliente! Verifique se há algum vínculo deste cliente em outro cadastro!';
				$scope.success = null;
			}
		})
	}

	$scope.filtroControle = function(){
		$scope.isFiltros = !$scope.isFiltros;
	};

	$scope.buscarFiltros = function (){
		if($scope.filtro.name){ 
			if($scope.filtro.email){
				findClientByNameAndEmail($scope.filtro.name, $scope.filtro.email);
			}else{
				findClientByName($scope.filtro.name);
			}
		}else if($scope.filtro.email){
			findClientByEmail($scope.filtro.email);
		}
		 
	};

	$scope.limparFiltros = function () {
		$scope.filtro = {};
		findAllClients();
	};


});