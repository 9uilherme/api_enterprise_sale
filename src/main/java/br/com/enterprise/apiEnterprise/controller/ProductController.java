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

import br.com.enterprise.apiEnterprise.model.Product;
import br.com.enterprise.apiEnterprise.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping(value="/product/findAll")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/product/save")
	public ResponseEntity<?> save(@RequestBody Product product){
		try {
			if(product.getId() == null) {
				return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
			}else {
				return new ResponseEntity<Product>(productService.update(product), HttpStatus.OK);
			}			
		}catch(NullPointerException e) {
			return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/product/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			Product productToDelete = productService.findById(id);
			productService.delete(productToDelete);
			return new ResponseEntity<Product> (productToDelete, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Boolean> (Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value="/product/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value="/product/findByName/{name}")
	public ResponseEntity<List<Product>> findByName(@PathVariable String name) {
		return new ResponseEntity<List<Product>>(productService.findByName(name), HttpStatus.OK);
	}

	@GetMapping(value="/product/findByDescription/{description}")
	public ResponseEntity<List<Product>> findByDescription(@PathVariable String description) {
		return new ResponseEntity<List<Product>>(productService.findByDescription(description), HttpStatus.OK);
	}
	@GetMapping(value="/product/findByNameAndDescription/{name}/{description}")
	public ResponseEntity<List<Product>> findByNameAndDescription(@PathVariable String name, @PathVariable String description) {
		return new ResponseEntity<List<Product>>(productService.findByNameAndDescription(name, description), HttpStatus.OK);
	}
}
