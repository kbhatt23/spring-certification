package com.learning.certification.htt2demo.config;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

@Configuration
public class OkHttpConfig {

    @Bean
    public OkHttpClient okHttpClient() {
//    	 HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//         loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY); // Set log level
        ConnectionPool connectionPool = connectionPool();
		return new OkHttpClient.Builder()
                .connectionPool(connectionPool)
                .protocols(List.of(Protocol.HTTP_2, Protocol.HTTP_1_1)) // Enable HTTP/2 and HTTP/1.1
                //.protocols(List.of(Protocol.H2_PRIOR_KNOWLEDGE))
                //.protocols(List.of(Protocol.HTTP_1_1))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Bean
    public RestTemplate restTemplate(OkHttpClient okHttpClient) {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        return new RestTemplate(factory);
    }
    
	@Bean
	public ConnectionPool connectionPool() {
		return new ConnectionPool(5, 30, TimeUnit.SECONDS);
	}
}
