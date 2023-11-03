package com.learning.certification.htt2demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expose-http2")
public class ExposeHttp2Controller {
	
	@Autowired
	private Http2Service service;
	
	@GetMapping
	public String exposeHttp2() {
		return "jai shree sita rama lakshman hanuman";
	}
	
	@GetMapping("/validate")
	public String validateHTTP2() {
		return service.makeHttp2RequestOkHttpString("http://localhost:8081/http1");
	}
	
	@GetMapping("/fire-forget1")
	public String fireAndForget1() {
		service.timeConsumingFireAndForget1(service :: fireForgetConsumer);
		return "SUCCESS";
	}
	
	@GetMapping("/fire-forget2")
	public String fireAndForget2() {
		service.timeConsumingAsync()
		  .thenAccept(service :: fireForgetConsumer)
		;
		return "SUCCESS";
	}
}
