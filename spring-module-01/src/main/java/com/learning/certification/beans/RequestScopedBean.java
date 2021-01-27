package com.learning.certification.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("request")
public class RequestScopedBean {

	public RequestScopedBean() {
		System.out.println("jai shree ram says request bean");
	}

	@PostConstruct
	public void initialze() {
		System.out.println("post construct called for request bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroy called for request bean");
	}
}
