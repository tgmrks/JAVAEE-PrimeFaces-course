package com.example.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SearchOrderBean implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private List<Integer> filteredOrders;
	
	public SearchOrderBean() {
		filteredOrders = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			filteredOrders.add(i);
		}
	}

	public List<Integer> getFilteredOrders() {
		return filteredOrders;
	}

}
