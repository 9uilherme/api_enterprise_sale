package br.com.enterprise.apiEnterprise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.enterprise.apiEnterprise.model.Client;
import br.com.enterprise.apiEnterprise.service.ClientService;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@GetMapping(value="/client/findAll")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Client>>(clientService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/client/save")
	public ResponseEntity<?> save(@RequestBody Client client){
		try {
			if(client.getId() == null) {
				return new ResponseEntity<Client>(clientService.save(client), HttpStatus.OK);
			}else {
				return new ResponseEntity<Client>(clientService.update(client), HttpStatus.OK);
			}			
		}catch(NullPointerException e) {
			return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/client/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			Client clientToDelete = clientService.findById(id);
			clientService.delete(clientToDelete);
			return new ResponseEntity<Client> (clientToDelete, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Boolean> (Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value="/client/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return new ResponseEntity<Client>(clientService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value="/client/findByName/{name}")
	public ResponseEntity<List<Client>> findByName(@PathVariable String name) {
		return new ResponseEntity<List<Client>>(clientService.findByName(name), HttpStatus.OK);
	}

	@GetMapping(value="/client/findByEmail/{email}")
	public ResponseEntity<List<Client>> findByEmail(@PathVariable String email) {
		return new ResponseEntity<List<Client>>(clientService.findByEmail(email), HttpStatus.OK);
	}
	
	@GetMapping(value="/client/findByNameAndEmail/{name}/{email}")
	public ResponseEntity<List<Client>> findByNameAndEmail(@PathVariable String name, @PathVariable String email) {
		return new ResponseEntity<List<Client>>(clientService.findByNameAndEmail(name, email), HttpStatus.OK);
	}
	
	
}
