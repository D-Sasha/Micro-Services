package com.in.microservice.customerservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories 
public interface CustomerServiceRepository 
extends JpaRepository<CustomerOrders, Long>{
	
	@Query(value="SELECT list_food FROM CUSTOMER_ORDERS", nativeQuery=true)
	String[] getListFood();
	
}
