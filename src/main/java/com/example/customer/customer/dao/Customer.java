package com.example.customer.customer.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "customer")
public class Customer {
	
	@Id
	@Column(name = "Customer_Id")
	private int customerId;
	
	@Column(name = "Customer_Name")
	private String  customerName;
	
	@Column(name = "Customer_Entrolled_Date")
	private Date customerEnrolledDate;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Customer(int customerId, String customerName, int avaliableRewards) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	public Customer() {}
	public Date getCustomerEnrolledDate() {
		return customerEnrolledDate;
	}
	public void setCustomerEnrolledDate(Date customerEnrolledDate) {
		this.customerEnrolledDate = customerEnrolledDate;
	}

}
