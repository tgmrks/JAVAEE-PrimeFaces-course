package com.example.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
public class DeliverAddress implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String address;
	private String num;
	private String complement;
	private String city;
	private String state;
	private String zip;
	
	@NotBlank @Size(max=150)
	@Column(name="del_address", nullable=false, length=150)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@NotBlank @Size(max=20)
	@Column(name="del_num", nullable=false, length=20)
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Size(max=150)
	@Column(name="del_complement",  length=150)
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	@NotBlank @Size(max=60)
	@Column(name="del_city", nullable=false, length=60)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@NotBlank @Size(max=60)
	@Column(name="del_state", nullable=false, length=60)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@NotBlank @Size(max=9)
	@Column(name="del_zip", nullable=false, length=9)
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
