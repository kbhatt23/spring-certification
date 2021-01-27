package com.learning.certification.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//we can load the proeprty file key value pair to either environement/@value
//but @value makes it mandaotry to be present otherwise server do not starts
@Configuration
@PropertySources({
	@PropertySource("classpath:/classpathProperties.properties")
	,@PropertySource("file:C:/Kanishk/learning/spring-certification/documents/files/filesystem.properties")
	
})
public class PropertySourceConfig {

}
