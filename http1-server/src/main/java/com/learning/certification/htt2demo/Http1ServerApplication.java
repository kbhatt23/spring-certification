package com.learning.certification.htt2demo;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Http1ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Http1ServerApplication.class, args);
	}
	
	@Bean
	public TomcatServletWebServerFactory tomcatFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected void customizeConnector(Connector connector) {
				super.customizeConnector(connector);
				// Enable HTTP/2
				connector.addUpgradeProtocol(new Http2Protocol());
				//((Http2Protocol) connector.getProtocolHandler()).setMaxConcurrentStreams(256); // Customize as
			}
		};
	}

}
