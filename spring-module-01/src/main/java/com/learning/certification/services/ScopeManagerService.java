package com.learning.certification.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.learning.certification.beans.PrototypeScopedBean;
import com.learning.certification.beans.RequestScopedBean;
import com.learning.certification.beans.SessionScopedBean;
import com.learning.certification.beans.SingletonBean;

@Service
@Scope("prototype")
public class ScopeManagerService {
	@Autowired
	private SingletonBean singletonBean;

	@Autowired
	private PrototypeScopedBean prototypeScopedBean;
	
	@Autowired
	private RequestScopedBean requestScopedBean;
	@Autowired
	private SessionScopedBean sessionScopedBean;
	
	public void printSessions() {
		System.out.println("ScopeManagerService: singleton: "+singletonBean);
		System.out.println("ScopeManagerService: prototypeScopedBean: "+prototypeScopedBean);
		System.out.println("ScopeManagerService: requestScopedBean: "+requestScopedBean);
		System.out.println("ScopeManagerService: sessionScopedBean: "+sessionScopedBean);
	}
}
