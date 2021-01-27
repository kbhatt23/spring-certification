package com.learning.certification.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.certification.beans.PrototypeScopedBean;
import com.learning.certification.beans.RequestScopedBean;
import com.learning.certification.beans.SessionScopedBean;
import com.learning.certification.beans.SingletonBean;
import com.learning.certification.services.ScopeManagerService;

@RestController
@RequestMapping("/test-beans")
@Scope("prototype")
public class TestBeanScopeController {

	@Autowired
	private SingletonBean singletonBean;
//
	@Autowired
	private PrototypeScopedBean prototypeScopedBean;
	
	@Autowired
	private RequestScopedBean requestScopedBean;
	@Autowired
	private SessionScopedBean sessionScopedBean;
	
	@Autowired
	private ScopeManagerService scopeManagerService; 
	
	@GetMapping
	public String validateAll() {
		scopeManagerService.printSessions();
		return new StringBuilder()
					.append("singletonBean: ").append(singletonBean).append(" , ")
					.append("prototypeScopedBean: ").append(prototypeScopedBean).append(" , ")
					.append("requestScopedBean: ").append(requestScopedBean).append(" , ")
					.append("sessionScopedBean: ").append(sessionScopedBean).append(" , ")
					.toString();
					
	}

}
