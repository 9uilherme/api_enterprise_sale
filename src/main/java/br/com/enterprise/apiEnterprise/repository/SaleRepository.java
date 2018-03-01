package br.com.enterprise.apiEnterprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enterprise.apiEnterprise.model.Client;
import br.com.enterprise.apiEnterprise.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	public List<Sale> findByClientNameContainingIgnoreCase(String clientName);
	public Sale findById(Long id);
	
}
