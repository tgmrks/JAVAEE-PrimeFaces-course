package com.example.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterProductBean {
	
	public void save(){
		throw new RuntimeException("testing");
	}
}
