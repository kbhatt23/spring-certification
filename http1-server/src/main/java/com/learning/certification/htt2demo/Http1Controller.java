package com.learning.certification.htt2demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/http1")
public class Http1Controller {

	@GetMapping
	public String getHttp1() {
		return "jai shree ram";
	}
}
