package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date createDate;
	private String notes;
	private Date deliveredDate;
	private Double shipimentValue;
	private Double descountValue;
	private Double totalValue;
	private StatusOrder status;
	private PaymentForm paymentForm;
	private User seller;
	private Client client;
	private DeliverAddress deliverAddress;
	private List<OrderItem> itens = new ArrayList<>();
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date", nullable=false)
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Column(columnDefinition="text")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="delivered_date", nullable=false)	
	public Date getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	
	@Column(name="ship_value", nullable=false, precision=10, scale=2)
	public Double getShipimentValue() {
		return shipimentValue;
	}
	public void setShipimentValue(Double shipimentValue) {
		this.shipimentValue = shipimentValue;
	}
	
	@Column(name="desc_value", nullable=false, precision=10, scale=2)
	public Double getDescountValue() {
		return descountValue;
	}
	public void setDescountValue(Double descountValue) {
		this.descountValue = descountValue;
	}
	
	@Column(name="total_value", nullable=false, precision=10, scale=2)
	public Double getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false, length=15)
	public StatusOrder getStatus() {
		return status;
	}
	public void setStatus(StatusOrder status) {
		this.status = status;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name="pay_form", nullable=false, length=20)
	public PaymentForm getPaymentForm() {
		return paymentForm;
	}
	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}
	
	@ManyToOne
	@JoinColumn(name="seller_id", nullable=false)
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Embedded
	public DeliverAddress getDeliverAddress() {
		return deliverAddress;
	}
	public void setDeliverAddress(DeliverAddress deliverAddress) {
		this.deliverAddress = deliverAddress;
	}
	
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
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
