package com.in.microservice.customerservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {
	
	@Autowired
	private FoodServiceProxy proxy;
	
	@Autowired
	private CustomerServiceRepository repository;
	
	@GetMapping("/customer-service/listcustorder")
	public List<CustomerOrders> retrieveCustomerOrder() {
		return repository.findAll();
	}
	
	@GetMapping("/customer-service/listfood")
	public Object[] retrieveFoodList() {
		
		List<FoodList> foodList = proxy.retrieveFoodList();
		
		return foodList.toArray();
	}
	
	@GetMapping("/customer-service/foodslessthan/price/{price}")
	public FoodList[] retrieveFoodsLessThan(@PathVariable double price) {
		
		FoodList[] foodList = proxy.retrieveFoodsLessThan(price);
		
		return foodList;
		
	}
	
	@GetMapping("/customer-service/topthreefoods")
	public List<String> retrieveTopThreeFoods(){
		
		HashMap<String, Integer> topThree = new HashMap<>();
		
		String[] rst = repository.getListFood();
		String str = String.join(",", rst);
		str = str.replaceAll("\\s+","");
		String[] foods = str.split(",");
		
		for(String food : foods) {
			
			Integer integer = topThree.get(food);
			 
            if (integer == null)
            	topThree.put(food, 1);
            else
            	topThree.put(food, integer + 1);
            
		}
		
		List<String> keys = topThree.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
		
		return keys;
		
	}

}
