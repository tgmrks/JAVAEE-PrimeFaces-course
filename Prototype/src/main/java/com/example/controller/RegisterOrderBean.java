package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.example.service.BusinessRuleExpection;

@ManagedBean
@RequestScoped
public class RegisterOrderBean {
	
	private List<Integer> itens;
	
	public RegisterOrderBean(){
		itens = new ArrayList<>();
		itens.add(1);
	}

	public List<Integer> getItens() {
		return itens;
	}
	
	public void save(){
		throw new BusinessRuleExpection("testing123");
	}
	
}
