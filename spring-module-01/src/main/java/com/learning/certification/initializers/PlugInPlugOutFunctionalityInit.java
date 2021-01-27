package com.learning.certification.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.learning.certification.beans.PlugInPlugOutFunctionality;
import com.learning.certification.configProperties.SampleConfigProperty;
import com.learning.certification.configProperties.ValueFromApllicationProperties;
@Service
public class PlugInPlugOutFunctionalityInit implements CommandLineRunner{

	//will look for beanId func
	//but in case only one bean of type PlugInPlugOutFunctionality exists no issue happens
	@Autowired
	//will look for this bean id as the variable name
	private PlugInPlugOutFunctionality /*func*/ /*plugInPlugOutFunctionality*/ plugInPlugOutFunctionalityRandom;
	
	@Autowired
	private SampleConfigProperty sampleConfigProperty;
	
	@Autowired
	private ValueFromApllicationProperties valueFromApllicationProperties;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("PlugInPlugOutFunctionalityInit: Initl called");
//		func.printUSage();
		//plugInPlugOutFunctionality.printUSage();
		plugInPlugOutFunctionalityRandom.printUSage();
		
		System.out.println("PlugInPlugOutFunctionalityInit: printing sampleConfigProperty "+sampleConfigProperty );
		
		System.out.println("PlugInPlugOutFunctionalityInit: printing valueFromApllicationProperties "+valueFromApllicationProperties );
	}

}
