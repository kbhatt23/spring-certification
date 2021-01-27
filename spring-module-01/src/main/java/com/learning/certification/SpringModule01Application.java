package com.learning.certification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.learning.certification.beans.SimpleBean;

@SpringBootApplication
public class SpringModule01Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringModule01Application.class, args);
		
		SimpleBean bean1 = context.getBean(SimpleBean.class);
		System.out.println("application context provided bean "+bean1);
		
	}

}
