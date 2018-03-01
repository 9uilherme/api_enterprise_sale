app.controller("clientEditController", function ($scope, $http, clientRepository, $routeParams) {
	$scope.resetForm = function () {
		$scope.client =  {
				id: null,
				name: null,
				email: null,
				birthDate: null
		};
	}

	function findClientById (id){
		clientRepository.findClientById(id, function(result){
			$scope.client = result;
			if($scope.client.birthDate != null){
				$scope.client.birthDate = new Date($scope.client.birthDate);
			}
		})
	}
	
	function saveClient (client) {
		clientRepository.saveClient(client, function(result){
			if(result){
				$scope.success = 'sucesso ao salvar!';
				$scope.erro = null;
			}else{
				$scope.erro = 'falha ao salvar!';
				$scope.success = null;
			}
		});
	}
	
	if($routeParams.clientId){
		findClientById($routeParams.clientId);

		$routeParams.clientId = null;
	}

	$scope.save = function () {
		if($scope.formClient.$valid){
			saveClient($scope.client);
		}
	}

	$scope.resetForm();
	
});
