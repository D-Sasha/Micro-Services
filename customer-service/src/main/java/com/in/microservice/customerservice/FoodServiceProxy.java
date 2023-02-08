package com.in.microservice.customerservice;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Component
@FeignClient(name="food-service", url="localhost:8100")
public interface FoodServiceProxy {

	@GetMapping("/food-service/listfood")
	public List<FoodList> retrieveFoodList();
	
	@GetMapping("/food-service/foodslessthan/price/{price}")
	public FoodList[] retrieveFoodsLessThan(@PathVariable double price);
	
}
