package com.example.customer.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.customer.customer.dao.Customer;


public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	

}
