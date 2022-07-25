package com.example.customer.customer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.customer.customer.dao.CustomerRewardDao;


public interface CustomerRewardRepo extends CrudRepository<CustomerRewardDao, Integer> {
	
	/*
	 * @Query("select  CustomerRewardDao from Customer_Rewards where customer_id= :customerid and Transaction_Date >= current_date - :fromDate"
	 * ) List<CustomerRewardDao> getBytransactionDateandcustomerId( @Param("fromDate") Date fromDate,@Param("customerid") int
	 * customerId) ;
	 */
	
	List<CustomerRewardDao> getBycustomerId(int customerId);
}
