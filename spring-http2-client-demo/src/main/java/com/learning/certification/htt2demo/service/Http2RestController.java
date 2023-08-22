package com.learning.certification.htt2demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.certification.htt2demo.service.dto.Kbhatt23ApiResponse;

@RestController
@RequestMapping("/http2-client")
public class Http2RestController {

	@Autowired
	private Http2Service http2Service;
	
	@GetMapping
	public String sampleHttp2GetApi() {
		return http2Service.makeHttp2Request();
	}
	
	@GetMapping("/okhttp")
	public Kbhatt23ApiResponse sampleHttp2GetApiOkHttp() {
		return http2Service.makeHttp2RequestOkHttp();
	}
	@GetMapping("/okhttp/string")
	public String sampleHttp2GetApiOkHttpString() {
		return http2Service.makeHttp2RequestOkHttpString();
	}
}
