package com.in.microservice.foodservice;

import java.util.HashMap;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;


@Component
@FeignClient(name="customer-service", url="localhost:8000")
public interface CustomerServiceProxy {
	
	@GetMapping("/customer-service/listcustorder")
	public List<CustomerOrders> retrieveCustomerOrder();
	
	@GetMapping("/customer-service/topthreefoods")
	public List<String> retrieveTopThreeFoods();

}
