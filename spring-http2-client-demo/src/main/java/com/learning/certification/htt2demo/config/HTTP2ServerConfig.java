package com.learning.certification.htt2demo.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http2.Http2Protocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HTTP2ServerConfig {

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
