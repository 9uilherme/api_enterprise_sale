package br.com.enterprise.apiEnterprise.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="sale_product")
public class SaleProduct {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	@JsonIgnore
	private Sale sale;
	
	@OneToOne
	private Product product;
	
	private BigDecimal quantity;

	// Variavel para controle interno
	@JsonIgnore
	private Calendar dataCriacao;

	// Variavel para controle interno
	@JsonIgnore
	private Calendar dataAlteracao;

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	@PrePersist
	public void setDataCriacao() {
		if(this.dataCriacao == null) {
			this.dataCriacao = Calendar.getInstance();
		}
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	@PreUpdate
	public void setDataAlteracao() {
		this.dataAlteracao = Calendar.getInstance();
	}
}
