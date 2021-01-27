package com.learning.certification.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("defaultProductService")
public class SequentialProductService implements IProductService{

	//way more costly than reactive
	@Override
	public double priceProduct(String productId) {
		System.out.println("sequential product service called");
		return 99;
	}

	
}
