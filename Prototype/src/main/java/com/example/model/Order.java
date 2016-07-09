package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date createDate;
	private String notes;
	private Double shipimentValue;
	private Double descountValue;
	private Double totalValue;
	private StatusOrder status;
	private PaymentForm paymentForm;
	private User seller;
	private Client client;
	private DeliverAddress deliverAddress;
	private List<OrderItem> itens = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Double getShipimentValue() {
		return shipimentValue;
	}
	public void setShipimentValue(Double shipimentValue) {
		this.shipimentValue = shipimentValue;
	}
	public Double getDescountValue() {
		return descountValue;
	}
	public void setDescountValue(Double descountValue) {
		this.descountValue = descountValue;
	}
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	public StatusOrder getStatus() {
		return status;
	}
	public void setStatus(StatusOrder status) {
		this.status = status;
	}
	public PaymentForm getPaymentForm() {
		return paymentForm;
	}
	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public DeliverAddress getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(DeliverAddress deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	public List<OrderItem> getItens() {
		return itens;
	}
	public void setItens(List<OrderItem> itens) {
		this.itens = itens;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
		
}
