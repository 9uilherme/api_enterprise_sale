package br.com.enterprise.apiEnterprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enterprise.apiEnterprise.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findById(Long id);
	public List<Product> findByNameContainingIgnoreCase(String name);
	public List<Product> findByDescriptionContainingIgnoreCase(String description);
	public List<Product> findByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(String name, String description);
	
}
