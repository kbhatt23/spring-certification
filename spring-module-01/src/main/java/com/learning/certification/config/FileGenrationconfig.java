package com.learning.certification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.certification.services.FileGenerator;
import com.learning.certification.services.IProductService;

@Configuration
public class FileGenrationconfig {
	
	//just for showing autowiring , otherwise cpould have taken from method param
	@Autowired
	//default qualifier is the class name with small char at the begininig
	//@Qualifier("reactiveProductService")
	@Qualifier("defaultProductService")
	private IProductService productService;

	//no need to autowier, for @congif beans we get it automatically
	@Bean
	public CommandLineRunner commandLineRunner(FileGenerator fileGenerator) {
		System.out.println("Config Bean started for file generation");
		fileGenerator.generate("/jai-shree-ram");
		return this::runTask;
	}
	
	void runTask(String... args) throws Exception{
		productService.priceProduct("product123");
	}
	
}
