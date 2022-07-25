package com.example.customer.customer.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class CustomerRewardsPoints {


	private String CustomerName;
	private int customerId;
	private int earnedRewardPoint;
	private double transcationAmount;
	
	public CustomerRewardsPoints() {};
	
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "CustomerRewardsPoints [CustomerName=" + CustomerName + ", customerId=" + customerId
				+ ", earnedRewardPoint=" + earnedRewardPoint + "]";
	}

	public double getTranscationAmount() {
		return transcationAmount;
	}

	public void setTranscationAmount(double transcationAmount) {
		this.transcationAmount = transcationAmount;
	}

	public CustomerRewardsPoints(String customerName, int customerId, int earnedRewardPoint, double transcationAmount) {
		super();
		CustomerName = customerName;
		this.customerId = customerId;
		this.earnedRewardPoint = earnedRewardPoint;
		this.transcationAmount = transcationAmount;
	}

	public int getEarnedRewardPoint() {
		return earnedRewardPoint;
	}

	public void setEarnedRewardPoint(int earnedRewardPoint) {
		this.earnedRewardPoint = earnedRewardPoint;
	}

	
	
	
}
