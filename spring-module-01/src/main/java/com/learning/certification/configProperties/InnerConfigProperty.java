package com.learning.certification.configProperties;

public class InnerConfigProperty {
	private String stringProperty;

	private Integer intProperty;

	public String getStringProperty() {
		return stringProperty;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}

	public Integer getIntProperty() {
		return intProperty;
	}

	public void setIntProperty(Integer intProperty) {
		this.intProperty = intProperty;
	}

	@Override
	public String toString() {
		return "InnerConfigProperty [stringProperty=" + stringProperty + ", intProperty=" + intProperty + "]";
	}
	
	
	
	
}
