package com.in.microservice.customerservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerOrders {
	
	@Id
	private int orderId;
	private String custName;
	private String[] listFood;
	
	public CustomerOrders() {
		
	}
	
	public CustomerOrders(int i, String custName, String[] listFood) {
		super();
		this.orderId = i;
		this.custName = custName;
		this.listFood = listFood;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public String[] getListFood() {
		return listFood;
	}


	public void setListFood(String[] listFood) {
		this.listFood = listFood;
	}
	
	
	
}
