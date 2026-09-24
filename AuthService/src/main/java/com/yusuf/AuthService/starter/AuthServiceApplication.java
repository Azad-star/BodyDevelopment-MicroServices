package com.yusuf.AuthService.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = { "com.yusuf" })
@ComponentScan(basePackages = { "com.yusuf" })
@EnableFeignClients(basePackages = { "com.yusuf" })
@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
