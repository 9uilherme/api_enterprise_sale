package br.com.enterprise.apiEnterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enterprise.apiEnterprise.model.Client;
import br.com.enterprise.apiEnterprise.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	

	public List<Client> findAll(){
		return clientRepository.findAll();
		
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
		
	}
	
	public Client update(Client client) {
		Client clientSaved = clientRepository.findOne(client.getId());
		
		createClient(clientSaved, client);
		
		return clientRepository.save(clientSaved);
		
	}

	public void delete(Client client) {
		clientRepository.delete(client.getId());
	}
	
	public Client findById(Long id) {
		return clientRepository.findById(id);
	}
	
	public List<Client> findByName(String name){
		return clientRepository.findByNameContainingIgnoreCase(name);
	}
	
	public List<Client> findByEmail(String email){
		return clientRepository.findByEmailContainingIgnoreCase(email);
	}

	public List<Client> findByNameAndEmail(String name, String email){
		return clientRepository.findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(name, email);
	}
	
	private void createClient(Client clientSaved, Client client) {
		clientSaved.setName(client.getName());
		clientSaved.setEmail(client.getEmail());
		clientSaved.setBirthDate(client.getBirthDate());
	}
}
