package com.learning.certification.configProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sample-config", ignoreInvalidFields = false, ignoreUnknownFields = true)
@Component
//if value is set wrongly, it gives exception
//is some field are not set it dont trow exception
public class SampleConfigProperty {

	private String stringProperty;

	private Integer intProperty;

	private String unknownProperty;

	private InnerConfigProperty innerConfigProperty;

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

	public String getUnknownProperty() {
		return unknownProperty;
	}

	public void setUnknownProperty(String unknownProperty) {
		this.unknownProperty = unknownProperty;
	}

	public InnerConfigProperty getInnerConfigProperty() {
		return innerConfigProperty;
	}

	public void setInnerConfigProperty(InnerConfigProperty innerConfigProperty) {
		this.innerConfigProperty = innerConfigProperty;
	}

	@Override
	public String toString() {
		return "SampleConfigProperty [stringProperty=" + stringProperty + ", intProperty=" + intProperty
				+ ", unknownProperty=" + unknownProperty + ", innerConfigProperty=" + innerConfigProperty + "]";
	}

}
