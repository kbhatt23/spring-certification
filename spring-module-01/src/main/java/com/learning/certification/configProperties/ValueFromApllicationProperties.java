package com.learning.certification.configProperties;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//use @value which makes it mandatory to be present
public class ValueFromApllicationProperties {
	//no env variable needed
	@Value("jai shree ram")
	private String hardcodedString;

	//@value is madnatory means if property file do not contain variable
	//server will not start sucessfully
	@Value("${basicVariable}")
	//mandatory to be present in application.proeprties
	private String basicVariable;
	
	@Value("${propertyWithDefaultValue:jai radha madhav}")
	private String propertyWithDefaultValue;
	
	//we can even use SPEL to transform data from proeprty file
	@Value("#{123*10}")
	private int transformedInteger;
	
	@Value("#{'${transformedString:jai shiva shankar}'.length()}")
	private int transformedInteger2;
	
	
	@Value("#{'${transformedString:jai shiva shankar}'.toUpperCase()}")
	private String transformedString;
	
	@Value("${listString}")
	private List<String> listString;
	
	@Value("${uniqueString}")
	private Set<String> uniqueString;

	@Override
	public String toString() {
		return "ValueFromApllicationProperties [hardcodedString=" + hardcodedString + ", basicVariable=" + basicVariable
				+ ", propertyWithDefaultValue=" + propertyWithDefaultValue + ", transformedInteger="
				+ transformedInteger + ", transformedInteger2=" + transformedInteger2 + ", transformedString="
				+ transformedString + ", listString=" + listString + ", uniqueString=" + uniqueString + "]";
	}


	

	
	
}
