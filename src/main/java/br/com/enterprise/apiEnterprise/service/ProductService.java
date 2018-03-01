package br.com.enterprise.apiEnterprise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enterprise.apiEnterprise.model.Product;
import br.com.enterprise.apiEnterprise.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Product> findAll(){
		return productRepository.findAll();
		
	}
	
	public Product save(Product product) {
		return productRepository.save(product);
		
	}
	
	public Product update(Product product) {
		Product productSaved = productRepository.findOne(product.getId());
		
		createProduct(productSaved, product);
		
		return productRepository.save(productSaved);
		
	}

	public void delete(Product product) {
		productRepository.delete(product.getId());
	}
	
	public Product findById(Long id) {
		return productRepository.findById(id);
	}
	
	public List<Product> findByName(String name){
		return productRepository.findByNameContainingIgnoreCase(name);
	}

	public List<Product> findByDescription(String description){
		return productRepository.findByDescriptionContainingIgnoreCase(description);
	}
	
	public List<Product> findByNameAndDescription(String name, String description){
		return productRepository.findByNameContainingIgnoreCaseAndDescriptionContainingIgnoreCase(name, description);
	}

	private void createProduct(Product productSaved, Product product) {
		productSaved.setName(product.getName());
		productSaved.setDescription(product.getDescription());
		productSaved.setPrice(product.getPrice());
	}
}
