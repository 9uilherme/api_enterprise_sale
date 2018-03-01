package br.com.enterprise.apiEnterprise.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sale {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional=false)
	private Client client;

	@OneToMany(mappedBy="sale", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<SaleProduct> products;

	// Variavel para controle interno
	@JsonIgnore
	private Calendar dataCriacao;

	// Variavel para controle interno
	@JsonIgnore
	private Calendar dataAlteracao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SaleProduct> getProducts() {
		return products;
	}

	public void setProducts(List<SaleProduct> products) {
		this.products = products;
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
