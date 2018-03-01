package br.com.enterprise.apiEnterprise.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String name;
	
	private String description;

	@Column(nullable=false)
	private BigDecimal price;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
