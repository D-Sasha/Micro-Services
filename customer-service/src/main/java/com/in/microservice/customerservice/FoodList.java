package com.in.microservice.customerservice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FoodList {

	@Id
	private int foodId;
	private String desc;
	private double price;
	
	public FoodList() {
		
	}
	
	public FoodList(int foodId, String desc, double price) {
		super();
		this.foodId = foodId;
		this.desc = desc;
		this.price = price;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
