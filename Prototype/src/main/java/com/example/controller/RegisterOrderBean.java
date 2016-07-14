package com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.example.model.DeliverAddress;
import com.example.model.Order;
import com.example.service.BusinessRuleExpection;

@ManagedBean
@ViewScoped
public class RegisterOrderBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Order order;
	
	private List<Integer> itens;
	
	public RegisterOrderBean(){
		order = new Order();
		order.setDeliverAddress(new DeliverAddress());
		itens = new ArrayList<>();
		itens.add(1);
	}

	public List<Integer> getItens() {
		return itens;
	}
	
	public void save(){
		//throw new BusinessRuleExpection("testing123");
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
