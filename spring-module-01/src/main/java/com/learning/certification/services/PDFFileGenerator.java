package com.learning.certification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.learning.certification.beans.SimpleBean;

@Service
@Profile("uat")
public class PDFFileGenerator implements FileGenerator{
	@Autowired
	private SimpleBean simpleBean;
	@Override
	public void generate(String path) {
		System.out.println("PDF file generated at path "+path);
		System.out.println("Random Generated Instance "+simpleBean.genrateRandom());
	}
}
