package com.learning.certification.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SimpleBean {
	//forcing private constuctor
	//still gets it using setAccesible to true in reflection API methods
	private SimpleBean() {
	}

	public double genrateRandom() {
		return new Random().nextDouble();
		
	}
}
