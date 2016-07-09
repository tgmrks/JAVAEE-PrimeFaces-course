package com.example.model;

import java.io.Serializable;

public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String sku;
	private Double unitValue;
	private Integer qtdStock;
	private Category category;
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
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Double getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}
	public Integer getQtdStock() {
		return qtdStock;
	}
	public void setQtdStock(Integer qtdStock) {
		this.qtdStock = qtdStock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
