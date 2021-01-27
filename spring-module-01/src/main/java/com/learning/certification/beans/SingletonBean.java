package com.learning.certification.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
//default scope is global
@Component
//this is needed only for singleton to wait until that bean is needed in cotnroller flow
@Lazy
public class SingletonBean {

	//eagerly called even at server startup as application context puts in cache
	public SingletonBean() {
		System.out.println("jai shree ram says singleton bean");
	}
	
	@PostConstruct
	public void initialze() {
		System.out.println("post construct called for singleton bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy called for singleton bean");
	}
}
