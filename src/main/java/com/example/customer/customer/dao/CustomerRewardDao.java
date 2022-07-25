package com.example.customer.customer.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Customer_Rewards")
public class CustomerRewardDao {

	
	@Override
	public String toString() {
		return "CustomerRewardDao [transactionDate=" + transactionDate + ", earnedRewards=" + earnedRewards
				+ ", transcationAmount=" + transcationAmount + ", customerId=" + customerId + "]";
	}

	@Id
	@Column(name = "Transaction_Date")
	private Date transactionDate;
	
	@Column(name = "Earned_Rewards")
	private int earnedRewards;
	
	@Column(name = "Transcation_Amount")
	private double transcationAmount;
	
	
	@Column(name = "Customer_Id")
	private int customerId;



	public CustomerRewardDao(Date transactionDate, int earnedRewards, double transcationAmount, int customerId) {
		super();
		this.transactionDate = transactionDate;
		this.earnedRewards = earnedRewards;
		this.transcationAmount = transcationAmount;
		this.customerId = customerId;
	}


	public CustomerRewardDao() {
	}


	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getTranscationAmount() {
		return transcationAmount;
	}

	public void setTranscationAmount(double transcationAmount) {
		this.transcationAmount = transcationAmount;
	}

	public int getEarnedRewards() {
		return earnedRewards;
	}

	public void setEarnedRewards(int earnedRewards) {
		this.earnedRewards = earnedRewards;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
