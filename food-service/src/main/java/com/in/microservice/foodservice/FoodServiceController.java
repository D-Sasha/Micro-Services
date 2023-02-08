package com.in.microservice.foodservice;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodServiceController {
	
	@Autowired
	private CustomerServiceProxy proxy;
	
	@Autowired
	private FoodServiceRepository repository;
	
	@GetMapping("/food-service/listcustorder")
	public Object[] retrieveCustomerOrder() {
	
		List<CustomerOrders> customerOrders = proxy.retrieveCustomerOrder();
	
		return customerOrders.toArray();
	}
	
	@GetMapping("/food-service/topthreefoods")
	public List<String> retireveTopThreeFoods(){
		
		
		List<String> topThree = proxy.retrieveTopThreeFoods();
		
		return topThree;
	}
	
	
	@GetMapping("/food-service/listfood")
	public List<FoodList> retrieveFoodList() {
		return repository.findAll();
	}
	
	@GetMapping("/food-service/foodslessthan/price/{price}")
	public FoodList[] retrieveFoodsLessThan(@PathVariable double price) {
		
	FoodList[] foodList = repository.findByPriceLessThan(price);
		
	return foodList;
	}
	
}


