package com.learning.certification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.learning.certification.beans.PlugInPlugOutFunctionality;

@Configuration
public class PlugInPlugOutFunctionalityConfig {

	//if need to plugout do not provide this bean and hence heavy object wont be created
	@Bean
	public PlugInPlugOutFunctionality plugInPlugOutFunctionality() {
		//can not auw=towire adn spring D.I is not added to allow flexiblity of plug in plug out
		return new PlugInPlugOutFunctionality();
	}
	//the bean id is the method name
	//now we have 2 beans of same class , 2 objects with different bean id
	@Bean
	public PlugInPlugOutFunctionality plugInPlugOutFunctionalityRandom() {
		//can not auw=towire adn spring D.I is not added to allow flexiblity of plug in plug out
		return new PlugInPlugOutFunctionality();
	}
}
