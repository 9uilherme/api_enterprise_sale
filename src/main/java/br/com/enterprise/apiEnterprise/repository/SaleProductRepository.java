package br.com.enterprise.apiEnterprise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.enterprise.apiEnterprise.model.Sale;
import br.com.enterprise.apiEnterprise.model.SaleProduct;

public interface SaleProductRepository extends JpaRepository<SaleProduct, Long>{

	public List<SaleProduct> findBySaleId(Long saleId);
	
}
