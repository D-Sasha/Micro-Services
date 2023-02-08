package com.in.microservice.foodservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodServiceRepository 
	extends JpaRepository<FoodList, Long>{

	FoodList[] findByPriceLessThan(double price);

}
