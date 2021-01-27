package com.learning.certification.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class PrototypeScopedBean {
	public PrototypeScopedBean() {
		System.out.println("jai shree ram says prototype bean");
	}
	@PostConstruct
	public void initialze() {
		System.out.println("post construct called for prototype bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy called for prototype bean");
	}
}
