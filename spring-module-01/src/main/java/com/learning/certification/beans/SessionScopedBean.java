package com.learning.certification.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("session")
public class SessionScopedBean {

	public SessionScopedBean() {
		System.out.println("jai shree ram says session bean");
	}
	
	@PostConstruct
	public void initialze() {
		System.out.println("post construct called for session bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy called for session bean");
	}
}
