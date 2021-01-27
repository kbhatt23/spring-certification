package com.learning.certification.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class CSVFileGenerator implements FileGenerator{

	@Override
	public void generate(String path) {
		System.out.println("CSV file generated at path "+path);
	}

}
