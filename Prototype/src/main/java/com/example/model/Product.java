package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.example.validation.SKU;

@Entity
@Table(name="t_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String sku;
	private Double unitValue;
	private Integer qtdStock;
	private Category category;
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank @Size(max=80) 
	@Column(nullable = false, length = 80)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank @SKU
	@Column(nullable = false, length = 20, unique = true)
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@NotNull(message="must be filled")
	@Column(name="unit_value", nullable = false, precision = 10, scale = 2)
	public Double getUnitValue() {
		return unitValue;
	}
	public void setUnitValue(Double unitValue) {
		this.unitValue = unitValue;
	}
	
	//bc of this annotation, it won't be necessary to add 'required' to the component 'InputText'
	@NotNull @Min(0) @Max(9999)
	@Column(name="qtd_stock", nullable = false, length = 5)
	public Integer getQtdStock() {
		return qtdStock;
	}
	public void setQtdStock(Integer qtdStock) {
		this.qtdStock = qtdStock;
	}
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
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
