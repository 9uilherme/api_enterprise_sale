package br.com.enterprise.apiEnterprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enterprise.apiEnterprise.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

	public Client findById(Long id);
	public List<Client> findByNameContainingIgnoreCase(String name);
	public List<Client> findByEmailContainingIgnoreCase(String email);
	public List<Client> findByNameContainingIgnoreCaseAndEmailContainingIgnoreCase(String name, String email);
	
}
