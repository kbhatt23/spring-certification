package com.learning.certification.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertySourceLoader implements CommandLineRunner{

	@Autowired
	private Environment environment;
	
	@Value("${fileProperty}")
	private String fileProperty;
	
	@Value("${fileUsage}")
	private String fileUsage;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("==================Loading custom proeprty soruces====================");
		System.out.println("values from classpath system : classPathProperty-> "+environment.getProperty("classPathProperty")+
				" classPathEntry-> "+environment.getProperty("classPathEntry")
				);
		
		System.out.println("values from file system : fileProperty-> "+fileProperty+
				" fileUsage-> "+fileUsage
				);
		
	}

}
