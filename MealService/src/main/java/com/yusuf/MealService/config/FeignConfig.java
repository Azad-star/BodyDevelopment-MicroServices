package com.yusuf.MealService.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {
	
	@Value("${internal.secret}")
	private String internalSecret;
	
	@Bean
	public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-Internal-Secret", internalSecret);
        };
	}

}
