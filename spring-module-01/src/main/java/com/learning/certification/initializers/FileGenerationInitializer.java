package com.learning.certification.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.learning.certification.services.FileGenerator;

//using @bean way using lamba
//@Service
public class FileGenerationInitializer implements CommandLineRunner{

	@Autowired
	private FileGenerator fileGenerator;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("File generator init started");
		fileGenerator.generate("/jai-shree-ram");
	}

}
