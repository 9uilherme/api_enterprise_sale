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
import br.com.enterprise.apiEnterprise.model.Sale;
import br.com.enterprise.apiEnterprise.service.SaleService;

@Controller
public class SaleController {

	@Autowired
	SaleService saleService;
	
	@GetMapping(value="/sale/findAll")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<Sale>>(saleService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value="/sale/save")
	public ResponseEntity<?> save(@RequestBody Sale sale){
		try {
			if(sale.getId() == null) {
				return new ResponseEntity<Sale>(saleService.save(sale), HttpStatus.OK);
			}else {
				return new ResponseEntity<Sale>(saleService.update(sale), HttpStatus.OK);
			}			
		}catch(NullPointerException e) {
			return new ResponseEntity<Boolean>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping(value="/sale/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			Sale saleToDelete = saleService.findById(id);
			saleService.delete(saleToDelete);
			return new ResponseEntity<Sale> (saleToDelete, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Boolean> (Boolean.FALSE, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value="/sale/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		return new ResponseEntity<Sale>(saleService.findById(id), HttpStatus.OK);
	}

	@GetMapping(value="/sale/findByClient/{name}")
	public ResponseEntity<List<Sale>> findByClient(@PathVariable String name) {
		return new ResponseEntity<List<Sale>>(saleService.findByClient(name), HttpStatus.OK);
	}
}
