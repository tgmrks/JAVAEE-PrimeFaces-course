package com.example.service;

public class BusinessRuleExpection extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusinessRuleExpection(String msg) {
		super(msg);
	}
	
}