package com.example.customer.customer.pojo;

import java.util.Date;

public class CustomerInfo {
	  
	private String customerName;
	private int customerId;
	private double purchaseAmount;
	private Date transactionDate;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	@Override
	public String toString() {
		return "CustomerInfo [customerName=" + customerName + ", customerId=" + customerId + ", purchaseAmount="
				+ purchaseAmount + "]";
	}
	public CustomerInfo(String customerName, int customerId, double purchaseAmount, Date transactionDate) {
		super();
		this.customerName = customerName;
		this.customerId = customerId;
		this.purchaseAmount = purchaseAmount;
		this.transactionDate = transactionDate;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	

	
}
