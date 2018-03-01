package br.com.enterprise.apiEnterprise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enterprise.apiEnterprise.model.Client;
import br.com.enterprise.apiEnterprise.model.Product;
import br.com.enterprise.apiEnterprise.model.Sale;
import br.com.enterprise.apiEnterprise.model.SaleProduct;
import br.com.enterprise.apiEnterprise.repository.ClientRepository;
import br.com.enterprise.apiEnterprise.repository.ProductRepository;
import br.com.enterprise.apiEnterprise.repository.SaleProductRepository;
import br.com.enterprise.apiEnterprise.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	SaleRepository saleRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	SaleProductRepository saleProductRepository;

	public List<Sale> findAll(){
		return saleRepository.findAll();

	}

	public Sale save(Sale sale) {

		//Tratar exceção para cliente null
		setClient(sale);
		setProducts(sale);

		return saleRepository.save(sale);

	}

	public Sale update(Sale sale) {
		Sale saleSaved = saleRepository.findById(sale.getId());

		updateSale(saleSaved, sale);

		return saleRepository.save(saleSaved);

	}

	public void delete(Sale sale) {
		saleRepository.delete(sale.getId());
	}

	public Sale findById(Long id) {
		return saleRepository.findById(id);
	}

	public List<Sale> findByClient(String name){
		return saleRepository.findByClientNameContainingIgnoreCase(name);
	}

	private void updateSale(Sale saleSaved, Sale sale) {
		saleSaved.setClient(sale.getClient());
		setProducts(sale);

		compareToRemove(saleSaved.getProducts(),  sale.getProducts());

		saleSaved.setProducts(sale.getProducts());

	}
	private void compareToRemove(List<SaleProduct> saved, List<SaleProduct> current) {
		List<SaleProduct> toRemove = new ArrayList<SaleProduct>();
		for(SaleProduct saleProductSaved : saved) {
			Boolean toRemoveFlag = Boolean.TRUE;
			for(SaleProduct saleProduct : current) {
				if(saleProduct.getId() == null) {
					continue;
				}
				if(saleProduct.getId().compareTo(saleProductSaved.getId()) == 0) {
					toRemoveFlag = Boolean.FALSE;
				}
			}
			if(toRemoveFlag)
				toRemove.add(saleProductSaved);
		}
		if(toRemove.size() > 0)
			saleProductRepository.deleteInBatch(toRemove);
	}

	private void setClient(Sale sale) {
		if(sale.getClient() != null && sale.getClient().getId() != null) {
			Client client = clientRepository.findOne(sale.getClient().getId());
			sale.setClient(client);
		}
	}

	private void setProducts(Sale sale) {
		if(sale.getProducts() != null && sale.getProducts().size() > 0) {
			for(SaleProduct saleProduct : sale.getProducts()) {
				Product product = productRepository.findOne(saleProduct.getProduct().getId());
				saleProduct.setProduct(product);
				saleProduct.setSale(sale);
				saleProduct.setQuantity(saleProduct.getQuantity());
			}
		}
	}
}
