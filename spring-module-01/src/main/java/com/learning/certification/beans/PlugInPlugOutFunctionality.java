package com.learning.certification.beans;

import javax.annotation.PostConstruct;

//we just create functionality here
//if needed by developer they can use @bean and cretae this
public class PlugInPlugOutFunctionality {

	@PostConstruct
	public void init() {
		System.out.println("PlugInPlugOutFunctionality: Init called for singleton plugin plugout bean");
	}
	
	public void printUSage() {
		System.out.println("PlugInPlugOutFunctionality: print usage called");
	}
}
