package com.learning.certification.htt2demo.service;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.certification.htt2demo.service.dto.Kbhatt23ApiResponse;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class Http2Service {

    private final RestTemplate restTemplate;
    
    private final OkHttpClient okHttpClient;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public Http2Service(RestTemplate restTemplate ,OkHttpClient okHttpClient ) {
        this.restTemplate = restTemplate;
        this.okHttpClient=okHttpClient;
    }

    public String makeHttp2Request() {
    	System.out.println("restTemplate.getRequestFactory(): "+restTemplate.getRequestFactory());
        ResponseEntity<String> response = restTemplate.getForEntity("https://kbhatt23.free.beeceptor.com/api/health", String.class);
        
        return response.getBody();
    }
    
    public Kbhatt23ApiResponse makeHttp2RequestOkHttp() {
        String url = "https://kbhatt23.free.beeceptor.com/api/health";
        //String url = "https://kbhatt23.free.beeceptor.com/api/health";
        
    
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        Kbhatt23ApiResponse apiResponse = null;
        try {
			Response response = call.execute();
			if (response.isSuccessful()) {
				System.out.println("response protocol used: "+response.protocol().name());
				apiResponse = objectMapper.readValue(response.body().string(), Kbhatt23ApiResponse.class);

	            System.out.println("apiResponse: " + apiResponse);
	        } else {
	            System.out.println("Request failed: " + response.code());
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        return apiResponse;
        }
    
    public String makeHttp2RequestOkHttpString() {
        String url = "https://kbhatt23.free.beeceptor.com/api/health";
        //String url = "http://localhost:8081/http1";
        
    
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = okHttpClient.newCall(request);
        String apiResponse = null;
        try {
			Response response = call.execute();
			if (response.isSuccessful()) {
				System.out.println("response protocol used: "+response.protocol().name());
				apiResponse= response.body().string();
	            
	        } else {
	            System.out.println("Request failed: " + response.code());
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        return apiResponse;
        }
}
