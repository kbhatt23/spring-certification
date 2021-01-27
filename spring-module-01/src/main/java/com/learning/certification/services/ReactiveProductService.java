package com.learning.certification.services;

import org.springframework.stereotype.Service;

@Service
public class ReactiveProductService implements IProductService{

	@Override
	public double priceProduct(String productId) {
		System.out.println("Reactive product service called");
		return 23;
	}

	
}
