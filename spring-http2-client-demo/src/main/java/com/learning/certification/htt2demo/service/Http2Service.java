package com.learning.certification.htt2demo.service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import okhttp3.ResponseBody;

@Service
public class Http2Service {

	private static final String TIME_CONSUMING_API_URL = "https://kbhatt23.free.beeceptor.com/api/time-consuming";

	private final RestTemplate restTemplate;

	private final OkHttpClient okHttpClient;
	private ObjectMapper objectMapper = new ObjectMapper();

	private static final Logger LOG = LoggerFactory.getLogger(Http2Service.class);

	public static final Consumer<String> FIRE_FORGET_CONSUMER = response -> {
		LOG.info("Callback Task started by Thread: "+Thread.currentThread().getName());
		
		//mimicking some task
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LOG.info("Callback Task completed by Thread: "+Thread.currentThread().getName());
	};

	@Autowired
	public Http2Service(RestTemplate restTemplate, OkHttpClient okHttpClient) {
		this.restTemplate = restTemplate;
		this.okHttpClient = okHttpClient;
	}

	public String makeHttp2Request() {
		System.out.println("restTemplate.getRequestFactory(): " + restTemplate.getRequestFactory());
		ResponseEntity<String> response = restTemplate.getForEntity("https://kbhatt23.free.beeceptor.com/api/health",
				String.class);

		return response.getBody();
	}

	public Kbhatt23ApiResponse makeHttp2RequestOkHttp() {
		String url = "https://kbhatt23.free.beeceptor.com/api/health";
		// String url = "https://kbhatt23.free.beeceptor.com/api/health";

		Request request = new Request.Builder().url(url).build();

		Call call = okHttpClient.newCall(request);
		Kbhatt23ApiResponse apiResponse = null;
		try {
			Response response = call.execute();
			if (response.isSuccessful()) {
				System.out.println("response protocol used: " + response.protocol().name());
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
		// String url = "http://localhost:8081/http1";

		Request request = new Request.Builder().url(url).build();

		Call call = okHttpClient.newCall(request);
		String apiResponse = null;
		try {

			Response response = call.execute();
			if (response.isSuccessful()) {
				System.out.println("response protocol used: " + response.protocol().name());
				apiResponse = response.body().string();

			} else {
				System.out.println("Request failed: " + response.code());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	public CompletableFuture<String> timeConsumingAsync() {
		String url = TIME_CONSUMING_API_URL;
		// String url = "http://localhost:8081/http1";

		Request request = new Request.Builder().url(url).build();

		CompletableFuture<String> future = new CompletableFuture<>();

		Call call = okHttpClient.newCall(request);

		call.enqueue(new okhttp3.Callback() {
			@Override
			public void onResponse(Call call, Response response) {
				try {
					if (response.isSuccessful()) {
						ResponseBody responseBody = response.body();
						if (responseBody != null) {
							String result = responseBody.string();
							future.complete(result);
						} else {
							future.completeExceptionally(new IOException("Response body is null"));
						}
					} else {
						future.completeExceptionally(new IOException("Request failed with code " + response.code()));
					}
				} catch (IOException e) {
					future.completeExceptionally(e);
				}
			}

			@Override
			public void onFailure(Call call, IOException e) {
				future.completeExceptionally(e);
			}
		});

		LOG.info("timeConsumingAsync: okhttp2 task submitted");
		return future;
	}

	public String makeHttp2Request(String url) {
		System.out.println("restTemplate.getRequestFactory(): " + restTemplate.getRequestFactory());
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		return response.getBody();
	}

	public String makeHttp2RequestOkHttpString(String url) {
		// String url = "http://localhost:9000/expose-http2";
		// String url = "http://localhost:8081/http1";

		Request request = new Request.Builder().url(url).build();

		Call call = okHttpClient.newCall(request);
		String apiResponse = null;
		try {

			Response response = call.execute();
			if (response.isSuccessful()) {
				LOG.info("response protocol used: " + response.protocol().name());
				apiResponse = response.body().string();

			} else {
				LOG.info("Request failed: " + response.code());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return apiResponse;
	}

	public void timeConsumingFireAndForget(Consumer<String> callBackFunction) {
		Request request = new Request.Builder().url(TIME_CONSUMING_API_URL).build();

		Call call = okHttpClient.newCall(request);

		call.enqueue(new okhttp3.Callback() {
			@Override
			public void onResponse(Call call, Response response) {
				try {
					if (response.isSuccessful()) {
						ResponseBody responseBody = response.body();
						if (responseBody != null) {
							String result = responseBody.string();
							LOG.info("timeConsumingFireAndForget: success response recieved, executing callback");
							callBackFunction.accept(result);
						} else {
							LOG.info("timeConsumingFireAndForget: empty response recieved, skipping callback");
						}
					} else {
						LOG.info("timeConsumingFireAndForget: failure response recieved, skipping callback");
					}
				} catch (IOException e) {
					LOG.error("timeConsumingFireAndForget: execption response recieved, skipping callback");
				}
			}

			@Override
			public void onFailure(Call call, IOException e) {
				LOG.error("timeConsumingFireAndForget: onFailure response recieved : {} ", e.getMessage());
			}
		});

		LOG.info("timeConsumingFireAndForget: okhttp2 task submitted");
	}
}