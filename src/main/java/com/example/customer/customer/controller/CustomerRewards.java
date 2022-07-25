/**
 * 
 */
package com.example.customer.customer.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.customer.dao.Customer;
import com.example.customer.customer.dao.CustomerRewardDao;
import com.example.customer.customer.pojo.CustomerInfo;
import com.example.customer.customer.pojo.CustomerRewardsPoints;
import com.example.customer.customer.repository.CustomerRepo;
import com.example.customer.customer.repository.CustomerRewardRepo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 15125
 *
 */
@RestController
@Slf4j
public class CustomerRewards {
	
	private static Log log = LogFactory.getLog(CustomerRewards.class);
	
	@Value("${customer.minimum.transaction.amount}")
	private int minimumAmount;
	
	@Value("${customer.transaction.amount.fortwopoints}")
	private int afterMininumAmount;
	
	@Value("${customer.transaction.afterMininumRewardPoint}")
	private int afterMininumRewardPoint;
	
	@Value("${customer.transaction.mini.rewards}")
	private int minimumRewards;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CustomerRewardRepo customerRewardRepo;

	@PostMapping("/getCustomerRewards-db")
	public ResponseEntity<List<CustomerRewardsPoints>> getCustomerRewards(@RequestBody CustomerInfo customerInfo) {
		System.out.println("customerInfo: "+customerInfo.toString());
		double purchasedAmount = customerInfo.getPurchaseAmount();
		Optional<Customer> customer = customerRepo.findById(customerInfo.getCustomerId());
		
		if(customer.isPresent()) {
			int rewardPoints = 0;
			if(purchasedAmount > minimumAmount) {
				rewardPoints = rewardPoints+ minimumAmount*minimumRewards;
			}
			if(purchasedAmount>afterMininumAmount) {
				log.info(Math.round(purchasedAmount)-afterMininumAmount);
				rewardPoints = (int) (rewardPoints+ (Math.round(purchasedAmount)-afterMininumAmount)*afterMininumRewardPoint);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			
			log.info("Earned rewards {} "+rewardPoints);
			List<CustomerRewardsPoints> customerList = new ArrayList<>();

			//Update DB with new rewards.
			try {
				customerRewardRepo.save(new CustomerRewardDao(new Date(), rewardPoints, purchasedAmount, customerInfo.getCustomerId()) );
				
				List<CustomerRewardDao> customerRewards = customerRewardRepo.getBycustomerId(customerInfo.getCustomerId());
				
				
				 customerRewards.forEach(cr ->
				 {
					 customerList. add(new CustomerRewardsPoints(customerInfo.getCustomerName(),customerInfo.getCustomerId(),cr.getEarnedRewards(), cr.getTranscationAmount()));
			 });
				 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error while saving Customer Rewards {}");
			}
			
			
			return new ResponseEntity<List<CustomerRewardsPoints>>(customerList,HttpStatus.OK);
		}
		return new ResponseEntity("Customer Not found "+customerInfo.getCustomerId(), HttpStatus.NOT_FOUND);
		
		
	}
	
	@PostMapping("/getCustomerRewards")
	public ResponseEntity<CustomerRewardsPoints> getCustomerRewardsWithoutDB(@RequestBody CustomerInfo customerInfo) {
		System.out.println("customerInfo: "+customerInfo.toString());
		double purchasedAmount = customerInfo.getPurchaseAmount();
		List<CustomerRewardDao> customerRewards = customerRewardRepo.getBycustomerId(customerInfo.getCustomerId());
		int totalRewards = 0;
		for(final CustomerRewardDao cr : customerRewards) {
			totalRewards = totalRewards+cr.getEarnedRewards();
		}
		
		int rewardPoints = 0;
		if(purchasedAmount > minimumAmount) {
			rewardPoints = minimumAmount*minimumRewards;
		}

		if(purchasedAmount>afterMininumAmount) {
			log.info(Math.round(purchasedAmount-afterMininumAmount));
			rewardPoints =(int) (rewardPoints + (Math.round(purchasedAmount)-afterMininumAmount)*afterMininumRewardPoint);
		}
		customerRewardRepo.save(new CustomerRewardDao(new Date(), rewardPoints, purchasedAmount, customerInfo.getCustomerId()) );
		log.info("total rewards {} "+totalRewards+rewardPoints);
		return new ResponseEntity<CustomerRewardsPoints>(new CustomerRewardsPoints(customerInfo.getCustomerName(),customerInfo.getCustomerId(),+totalRewards+rewardPoints,purchasedAmount),HttpStatus.OK);



	}
}
